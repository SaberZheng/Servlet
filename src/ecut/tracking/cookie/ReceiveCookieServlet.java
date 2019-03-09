package ecut.tracking.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/cookie/receive" )
public class ReceiveCookieServlet  extends HttpServlet {

	private static final long serialVersionUID = -7977116006670776871L;
	
	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		PrintWriter w = response.getWriter();
		
		/** 所有的 Cookie 都是通过 请求报头 "回传" 给服务器 */
		//String cookies = request.getHeader( "cookie" );
		Cookie[] cookies = request.getCookies();
		if( cookies != null ) {
			for( Cookie ck : cookies ) {
				w.println( "<div>" + ck.getName() + " , " + ck.getValue() + " , " + ck.getMaxAge() + " , " + ck.getPath()  + "</div>" );
			}
		}
		
		/*
		Enumeration<String> headerNames = request.getHeaderNames();
		
		PrintWriter w = response.getWriter();
		while( headerNames.hasMoreElements() ) {
			String name = headerNames.nextElement();
			String value = request.getHeader( name ) ;
			w.println( "<div>" + name + " : " + value  + "</div>" );
		}
		*/
		
		
	}

}
