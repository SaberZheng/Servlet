package ecut.dispatch.include;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/include/second" )
public class SecondServlet extends HttpServlet {

	private static final long serialVersionUID = 3984166560156790204L;
	
	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/pages/dispatch/header.jsp" );
		dispatcher.include( request , response );
		
		PrintWriter w = response.getWriter() ; 
		
		w.println( "<h1 style='text-align:center;'>Second Servlet</h1>" );
		
		dispatcher = request.getRequestDispatcher( "/pages/dispatch/header.jsp" );
		dispatcher.include( request , response );
		
	}

}
