package ecut.filter.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/filter/action/login" )
public class LoginActionServlet extends HttpServlet {

	private static final long serialVersionUID = -7857947923197325636L;

	@Override
	protected void service( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		
		System.out.println( "username : " + username +  " , password : " + password  );
		
		request.setAttribute( "username" ,  username );
		
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/filter/success/login" );
		
		dispatcher.forward( request , response );
		
	}
	
	

}
