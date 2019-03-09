package ecut.listener.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/application/remove" )
public class ApplicationRemoveServlet extends HttpServlet {

	private static final long serialVersionUID = -6802388429975749293L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		String name = request.getParameter( "name" );
		
		ServletContext application = this.getServletContext();
		
		application.removeAttribute( name ); // ----> ApplicationAttributeListener # attributeRemoved
		
		response.sendRedirect( request.getContextPath() + "/pages/listener/index.jsp" );
		
	}
	
	

}
