package ecut.dispatch.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/forward/login/success" )
public class LoginSuccessServlet extends HttpServlet {

	private static final long serialVersionUID = -7565331422887485255L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		//这个页面不能被直接访问
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/dispatch/login_success.html" );
		dispatcher.forward( request , response );
		
	}
	
	

}
