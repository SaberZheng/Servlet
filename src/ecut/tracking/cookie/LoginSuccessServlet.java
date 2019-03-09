package ecut.tracking.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/cookie/login/success" )
public class LoginSuccessServlet extends HttpServlet {

	private static final long serialVersionUID = -7565331422887485255L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		PrintWriter w = response.getWriter();
		
		w.println( "<h2>登录成功</h2>" );
		
		w.println( "<a href='" + request.getContextPath() + "/cookie/page/login'>重新登录</a>" );
		
	}
	
	

}
