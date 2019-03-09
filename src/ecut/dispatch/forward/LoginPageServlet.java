package ecut.dispatch.forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//登陆页面
@WebServlet( "/page/login" )
public class LoginPageServlet extends HttpServlet {

	private static final long serialVersionUID = 2075180219363356668L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		PrintWriter w = response.getWriter();
		
		w.println( "<!DOCTYPE html>" );
		w.println( "<html>" );
		w.println( "<head>" );
		w.println( "<meta charset='UTF-8'>" );
		w.println( "<title>登录</title>" );
		w.println( "</head>" );
		w.println( "<body>" );
		w.println( "    <h5>登录</h5>" );
		
		w.println( "    <form action='" + request.getContextPath() + "/action/login' method='post' >" );
		w.println( "        <input type='text' name='username' placeholder='用户名'>" );
		w.println( "        <input type='password' name='password' placeholder='输入密码'>" );
		w.println( "        <input type='submit' value='登录'>" );
		w.println( "    </form>" );
		
		w.println( "</body>" );
		w.println( "</html>" );
		
	}
	
	

}
