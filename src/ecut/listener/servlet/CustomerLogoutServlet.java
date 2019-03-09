package ecut.listener.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/customer/logout" )
public class CustomerLogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1376263177132417940L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute( "customer" ); // ---> Customer # valueUnbound
		
		response.sendRedirect( request.getContextPath() + "/pages/listener/index.jsp" );
	
	}

}
