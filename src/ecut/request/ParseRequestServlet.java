package ecut.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParseRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 5473447295646845596L;

	@Override
	protected void service( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		PrintWriter p =response.getWriter();		
		// 获取 HTTP HTTP 请求行中的相关信息
		String method = request.getMethod();
		String uri = request.getRequestURI() ; 
		String protocol = request.getProtocol() ;
		System.out.println( "HTTP 请求行:");
		System.out.println("\t请求方式 = " + method);
		System.out.println("\tURI = " + uri);
		System.out.println("\t协议/版本号= " + protocol);
		p.println("<p>HTTP 请求行:</p>");
		p.println("<p style='text-indent:2em;'>请求方式 = " + method+"</p>");
		p.println("<p style='text-indent:2em;'>URI = " + uri+"</p>");
		p.println("<p style='text-indent:2em;'>协议/版本号 = " + protocol+"</p>");
		// 获取HTTP 请求报头
		Enumeration<String> headerNames = request.getHeaderNames();
		System.out.println( "HTTP 请求报头:" );
		p.println( "<p>HTTP 请求报头:"+"</p>" );
		while( headerNames.hasMoreElements() ) {
			String name = headerNames.nextElement(); // 获取单个的HTTP 请求报头的名称
			String value = request.getHeader( name ) ; // 获得指定名称对应的HTTP 请求报头的值
			System.out.println( "\t" + name + " = " + value );
			p.println("<p style='text-indent:2em;'>" + name + " = " + value +"</p>");
		}
		
		// 获取HTTP 请求参数
		Map<String,String[]> paramMap = request.getParameterMap();
		
		Set< Entry<String, String[]> >  entrySet = paramMap.entrySet();
		System.out.println( "HTTP 请求参数:" );
		p.println( "<p>HTTP 请求参数:" );
		for( Entry<String, String[]> e : entrySet ){
			String name = e.getKey() ;
			String[] value = e.getValue() ;
			System.out.println( "\t" + name + " : " + Arrays.toString( value ) );
			p.println( "<p style='text-indent:2em;'>" + name + " : " + Arrays.toString( value ) +"</p>");
		}
		
	}
	
	

}
