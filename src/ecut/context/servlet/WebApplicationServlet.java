package ecut.context.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebApplicationServlet  extends HttpServlet {

	private static final long serialVersionUID = 312349126067371625L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response  ) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		// WebApplicationServlet 继承了 HttpServlet ，HttpServlet 继承了 GenericServlet ，
		// GenericServlet 实现了 ServletConfig , ServletConfig 接口中提供了 getServletContext()
		ServletContext application = this.getServletContext();
		
		// request.getServletContext(); // 从 Servlet 3.0 开始 可以通过 请求对象 获取 ServletContext
		
		// request.getSession().getServletContext(); // 从 Servlet 2.3 开始就支持用 session 来获取 ServletContext
		
		PrintWriter w = response.getWriter();
		
		w.println( "<h2>当前WEB应用的路径</h2>" );
		w.println( "<div>" );
		w.println( "context path : " +  application.getContextPath() );
		w.println( "</div>" );
		
		Enumeration<String> paramNames = application.getInitParameterNames();
		w.println( "<h2>初始化参数</h2>" );
		while( paramNames.hasMoreElements() ){
			String name = paramNames.nextElement();
			String value = application.getInitParameter( name );
			w.println( "<div>" );
			w.println( "init parameter : " +  name + " : " + value );
			w.println( "</div>" );
		}
		
		w.println( "<h2>获得真实路径 ( getRealPath )</h2>" );
		
		String realPath = application.getRealPath( "/WEB-INF" );
		w.println( "<div>" );
		w.println( realPath );
		w.println( "</div>" );
		
		w.println( "<h2>获得指定的 path 对应的 ServletContext 对象</h2>" );
		
	}
	
	

}
