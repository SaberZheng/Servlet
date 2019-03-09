package ecut.listener.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecut.listener.entity.Customer;

@WebServlet( "/customer/login" )
public class CustomerLoginServlet  extends HttpServlet {

	private static final long serialVersionUID = 2694859066336538343L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		
		Customer c = new Customer();
		c.setUsername( username );
		c.setPassword( password );
		
		HttpSession session = request.getSession() ;
		
		session.setAttribute( "customer" ,  c ); // ---> Customer # valueBound
		
		response.sendRedirect( request.getContextPath() + "/customer/main" );
		return ;
	}

}
