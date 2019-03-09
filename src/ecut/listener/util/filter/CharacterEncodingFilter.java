package ecut.listener.util.filter;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ecut.listener.util.StringHelper;



/**
 * 字符编码过滤器，适用于 Web 环境
 */
public class CharacterEncodingFilter implements Filter {
	
	/** 初始化参数的名称，设置初始化参数时必须指定为 encoding  */
	public static final String PARAM_NAME = "encoding" ;
	/** 默认的字符编码是 UTF-8 */
	public static final String DEFAULT_CHARSET = "UTF-8" ;
	
	private String encoding ;

	/***
	 * 读取初始化参数，如果是有效编码则采用初始化参数指定的编码，如果是无效编码则采用默认编码(默认编码是UTF-8)
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter( PARAM_NAME );
		encoding = StringHelper.empty( encoding ) ? DEFAULT_CHARSET : encoding ;
		encoding = Charset.isSupported( encoding ) ? encoding : DEFAULT_CHARSET ;
	}

	/**
	 * 对请求和响应进行过滤，并设置 请求对象 ( request ) 和 响应对象 ( response ) 编码 ( 通过初始化参数配置 )
	 */
	@Override
	public void doFilter(ServletRequest req , ServletResponse resp , FilterChain chain )
			throws IOException, ServletException {
		req.setCharacterEncoding( encoding );
		resp.setCharacterEncoding( encoding );
		chain.doFilter( req , resp );
	}
	
	/**
	 * 本类中的 destory 不做任何操作
	 */
	@Override
	public void destroy() {
	}

	

}
