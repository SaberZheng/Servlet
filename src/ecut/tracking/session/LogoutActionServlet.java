package ecut.tracking.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/session/action/logout" )
public class LogoutActionServlet extends HttpServlet {

	private static final long serialVersionUID = 6162020347616177699L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute( "user" );
		
		response.sendRedirect(  request.getContextPath() + "/pages/tracking/index.html" );
		
	}
	
	

}
