package ecut.listener.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/application/add" )
public class ApplicationAddServlet extends HttpServlet {

	private static final long serialVersionUID = -1218970600318038715L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		String name = request.getParameter( "name" );
		String value = request.getParameter( "value" );
		
		ServletContext application = this.getServletContext();
		
		application.setAttribute( name , value ); // ----> ApplicationAttributeListener # attributeAdded
		
		response.sendRedirect( request.getContextPath() + "/pages/listener/index.jsp" );
		
	}
	
	

}
