package ecut.listener.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/session/add" )
public class SessionAddServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7547888494941329407L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		String name = request.getParameter( "name" );
		String value = request.getParameter( "value" );
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute( name , value ); // ----> SesssionAttributeListener # attributeAdded
		
		response.sendRedirect( request.getContextPath() + "/pages/listener/index.jsp" );
		
	}
	
	

}
