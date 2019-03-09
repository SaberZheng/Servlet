package ecut.filter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/filter/success/login" )
public class LoginSuccessServlet extends HttpServlet {

	private static final long serialVersionUID = 2707448998600792264L;

	@Override
	protected void service( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		
		//String username = (String)request.getAttribute( "username" );
		
		String username = request.getParameter( "username" );
		System.out.println( "success : " + username );
		
		response.setContentType( "text/html" );
		
		response.getWriter().println( "<h1>" + username + " </h1>" );
		
	}

}
