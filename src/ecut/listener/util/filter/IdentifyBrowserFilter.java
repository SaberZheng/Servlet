package ecut.listener.util.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecut.listener.util.StringHelper;


/**
 * 对Web客户端的浏览器进行检查的过滤器
 */
public class IdentifyBrowserFilter implements Filter {
	
	/** 初始化参数 allowedConfigLocation 用来指定 允许访问的浏览器 的配置信息的位置，比如 browser.properties */
	public static final String BROWSER_CONFIG_NAME = "allowedConfigLocation" ;
	/** 初始化参数 allowedAccess 用来设定 被禁止访问的那些浏览器 的跳转位置，比如指定为  /allowed ，则这些浏览器仅仅能访问这个目录中的内容 */
	public static final String ALLOWED_ACCESS_NAME = "allowedAccess" ;
	
	private String browserConfigFile ;
	private String allowedAccessPath ;
	
	private Properties props ;

	/**
	 * 1、读取初始化参数 allowedConfigLocation 和 allowedAccess 。<br>
	 * 2、加载 allowedConfigLocation 对应的 资源文件 ( 比如 browser.properties ) 。<br>
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		browserConfigFile = config.getInitParameter( BROWSER_CONFIG_NAME );
		browserConfigFile = StringHelper.empty(browserConfigFile) ? "browser.properties" : browserConfigFile ;
		browserConfigFile = "/" + browserConfigFile ;
		allowedAccessPath = config.getInitParameter( ALLOWED_ACCESS_NAME );
		allowedAccessPath = StringHelper.empty(allowedAccessPath) ? "/allowed" : allowedAccessPath ;
		
		props = new Properties();
		try {
			props.load( IdentifyBrowserFilter.class.getResourceAsStream( browserConfigFile ) );
		} catch (IOException e) {
			props = null ;
			throw new ServletException( "你没有提供浏览器配置文件，请在你的工程下的src下添加。" , e );
		}
	}

	/***
	 * 根据初始化参数 allowedConfigLocation 对应的资源文件的配置，对浏览器进行检查。<br>
	 * 仅当客户端采用的是 资源文件中被允许使用的浏览器，且浏览器的版本达到要求时，才能正常访问<br>
	 * 当客户端采用的浏览器是 资源文件中所不允许的，或者浏览器的版本未达到要求时，客户端仅能访问 初始化参数 allowedAccess 配置的路径对应的资源，不能访问其它资源
	 */
	@Override
	public void doFilter(ServletRequest req , ServletResponse resp , FilterChain chain )
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req ;
		
		String userAgent = request.getHeader( "user-agent" );
		userAgent = StringHelper.empty( userAgent ) ? allowedAccessPath : userAgent.toLowerCase();
		String uri = request.getRequestURI() ;
		uri = StringHelper.empty( uri ) ? allowedAccessPath : uri.toLowerCase();
		
		String contextPath = request.getContextPath() ;
		
		HttpServletResponse response = (HttpServletResponse)resp;
		
		if( allowedAccessPath.equals( userAgent ) && allowedAccessPath.equals( uri ) ) {
			// 说明 没有获取到 userAgent 和 uri ，那就直接让他去 allowedAccessPath 对应的路径下的 index.html 或 index.jsp
			response.sendRedirect( contextPath + allowedAccessPath );
			return ; // 让 doFilter 方法结束执行
		} else {
			// 解析 userAgent 查看是否符合 browserConfigFile 中配置的浏览器和版本
			if( check( userAgent ) ){
				// 浏览器 和 浏览器的版本符合要求，准予放行
				chain.doFilter( req , resp );
				return ; // 让 doFilter 方法结束执行
			} else {
				// 如果浏览器和浏览器的版本不符合要求，则只允许访问 allowedAccessPath 中指定的内容
				contextPath = StringHelper.empty( contextPath ) ? "" : contextPath.toLowerCase() ;
				int index = uri.indexOf( contextPath );
				if( index > -1 ){
					uri = uri.substring( index + contextPath.length() ) ;
					if( uri.indexOf( allowedAccessPath ) > -1 ){ 
						// 能到这里，说明是 不符合要求的那些浏览器，要访问我们特意为他们准备的页面了
						// 所以应该为他们放行
						chain.doFilter( req , resp );
						return ; // 让 doFilter 方法结束执行
					}
				}
			}
		}
		
		// 如果前面的调度都无效，一律去往 allowedAccessPath 下的那个 index.html 或 index.jsp
		response.sendRedirect( contextPath + allowedAccessPath ); 
	}
	
	@Override
	public void destroy() {
	}

	private boolean check( String ua ){
		boolean allowed = false ;
		
		if( props != null ) {
			for( Map.Entry<Object, Object> entry : props.entrySet() ){
				
				String browser = (String)entry.getKey() ;
				browser = StringHelper.empty( browser ) ? "" : browser.toLowerCase();
				String version = (String) entry.getValue() ;
				//System.out.println( "browser : " + browser +  " , version : " + version );
				int lowerVersion = StringHelper.empty( version ) ? 0 : Integer.parseInt( version ) ;
				
				int index = ua.indexOf(  browser ); // 获取 userAgent 中的 browser 的索引
				if( index > -1 ){ // 说明是我们所支持的浏览器
					String clientVersion ;
					if( "safari".equalsIgnoreCase( browser.trim() ) ){
						index = ua.indexOf( "version" ); // 查找 version 子串 在 ua 中的位置
						if( index > -1 ){
							String s = ua.substring( index + "version".length() + 1 );
							clientVersion = s.substring( 0 ,  s.indexOf( "." ) ) ;
						} else {
							clientVersion = "-1" ;
						}
					} else {
						String s = ua.substring( index + browser.length() + 1 );
						clientVersion = s.substring( 0 ,  s.indexOf( "." ) ) ;
					}
					//System.out.println( "Client Browser : " + browser + " , Client Version : " + clientVersion );
					int cv = StringHelper.empty( clientVersion ) ? -1 : Integer.parseInt( clientVersion );
					if( cv >= lowerVersion ){ // 说明版本符合我们要求
						allowed = true ;
						break ; // 跳出循环
					}
				}
				
			}
		}
		
		return allowed ;
	}

}
