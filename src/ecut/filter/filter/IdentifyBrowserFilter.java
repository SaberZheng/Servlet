package ecut.filter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdentifyBrowserFilter implements Filter {

	@Override
	public void init( FilterConfig config ) throws ServletException {
	}

	@Override
	public void doFilter( ServletRequest req , ServletResponse resp , FilterChain chain )
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req ;
		HttpServletResponse response = (HttpServletResponse) resp ;
		
		String userAgent = request.getHeader( "user-agent" );
		
		userAgent = userAgent.toLowerCase();
		
		System.out.println( "IdentifyBrowserFilter ::: User Agent : " +  userAgent );
		
		// 如果在 userAgent 中找到了 trident 则说明目前正在使用 IE 访问
		if( userAgent.indexOf( "trident" ) != - 1 ) {
			String uri = request.getRequestURI();
			System.out.println( "uri : " + uri );
			int index = uri.lastIndexOf( "/" );
			uri = uri.substring( 0 , index ) ;
			System.out.println( "uri : " + uri );
			
			index = uri.lastIndexOf( "/" );
			uri = uri.substring( index ) ;
			System.out.println( "uri : " + uri );
			//解析字符串，如果访问的是IE目录下的就继续
			if( "/ie".equals( uri ) ) {
				chain.doFilter( req , resp );
			} else {//如果访问的不是IE目录下的就重定向到ie.html
				response.sendRedirect( request.getContextPath() +  "/pages/filter/ie/ie.html" );
			}
			
		} else { 
			// 如果是 非 IE 浏览器，则可以通过 FilterChain 向后传递 请求 和 响应 
			chain.doFilter( req , resp );
		}
		
	}

	@Override
	public void destroy() {
	}

}
