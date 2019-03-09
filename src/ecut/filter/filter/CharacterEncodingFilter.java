package ecut.filter.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharacterEncodingFilter implements Filter{
	
	private static final String ENCODING_PARAM = "encoding" ; 
	
	private static final String DEFAULT_ENCODING = "UTF-8" ;
	
	private String encoding ;

	@Override
	public void init( FilterConfig filterConfig ) throws ServletException {
		System.out.println( "CharacterEncodingFilter 初始化" );
		// 获取 Filter 的初始化参数
		encoding = filterConfig.getInitParameter( ENCODING_PARAM );
		// 如果 未指定初始化参数 或 初始化参数值是 空串 则采用默认编码
		encoding = ( encoding == null || encoding.trim().isEmpty() ) ? DEFAULT_ENCODING : encoding ;
		// 如果指定的编码名称不被JVM所支持，则采用默认编码
//		encoding = Charset.isSupported( encoding ) ? encoding : DEFAULT_ENCODING ;
		/*
		if( ! Charset.isSupported( encoding ) ) { // 如果指定的字符集名称是不支持的
			encoding = DEFAULT_ENCODING ;
		}
		*/
	}

	@Override
	public void doFilter( ServletRequest req , ServletResponse resp , FilterChain chain )
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req ;
		String uri = request.getRequestURI();
		DispatcherType type = request.getDispatcherType();
		System.out.println( "CharacterEncodingFilter ::: DispatcherType : " + type  + " , URI : " + uri  );
		// place your code here
		req.setCharacterEncoding( encoding );
		resp.setCharacterEncoding( encoding );
		// pass the request along the filter chain
		chain.doFilter( req , resp );
	}

	@Override
	public void destroy() {
		System.out.println( "CharacterEncodingFilter 销毁" );
	}

}
