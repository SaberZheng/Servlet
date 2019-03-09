package ecut.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConfigurationServlet implements Servlet {
	
	@Override
	public String getServletInfo() {
		return this.config.getServletName() ;
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return this.config ;
	}
	
	private ServletConfig config ;
	
	@Override
	public void init( ServletConfig config ) throws ServletException {
		this.config = config ;//有重复的变量时要加上config进行区分
		System.out.println( "初始化" );
		System.out.println( config ); 
		System.out.println( "ServletName : " + config.getServletName() );//web.xm配置文件中的servlet名称
		/*
		String encoding = config.getInitParameter( "encoding" );
		System.out.println( "encoding : " + encoding );
		*/
		Enumeration<String> initParamNames = config.getInitParameterNames();
		while( initParamNames.hasMoreElements() ){
			String name = initParamNames.nextElement() ;
			String value = config.getInitParameter( name );
			System.out.println( name + " : " + value );
		} 
	}

	@Override
	public void service( ServletRequest req , ServletResponse resp ) throws ServletException, IOException {
		System.out.println( "对外提供服务" );
		
		String ct = config.getInitParameter( "content-type" ) ;
		String en = config.getInitParameter( "encoding" ) ;
		String contentType = ct + ";charset=" + en  ; //  "text/html;charset=UTF-8"
		resp.setContentType( contentType );
		PrintWriter w = resp.getWriter();
		w.println( "<h1 style='text-align:center;color:blue;'>欢迎 !</h1>" );
	} 
	
	@Override
	public void destroy() {
		System.out.println( "销毁" );
	}

}
