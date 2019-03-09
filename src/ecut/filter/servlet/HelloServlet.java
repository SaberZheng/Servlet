package ecut.filter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -8731391727918781480L;

	@Override
	protected void service( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		
		System.out.println( "service" );
		
		response.setContentType( "text/html" );
		
		PrintWriter w = response.getWriter();
		
		w.println( "<h2 style='text-align:center;'>你好 , Servlet</h2>" );
		
	}
	
	

}
