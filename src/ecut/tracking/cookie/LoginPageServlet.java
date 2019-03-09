package ecut.tracking.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/cookie/page/login" )
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
		
		String un = "" ;
		String pwd = "" ;
		
		// 尝试 从 请求报头中获取 Cookie,所有的 Cookie 都是通过 请求报头 "回传" 给服务器 
		Cookie[] cookies = request.getCookies();
		System.out.println( "cookies : " + cookies  );
		if ( cookies != null ){
			for( Cookie c : cookies ){
				String name = c.getName() ;
				if( "username".equals( name ) ){
					un = c.getValue() ;
					continue;
				}
				if( "password".equals( name ) ){
					pwd = c.getValue() ;
					continue ;
				}
			}
		}
		
		w.println( "    <form action='" + request.getContextPath() + "/cookie/action/login' method='post' >" );
		w.println( "        <input type='text' name='username' value='" + un + "' placeholder='用户名'>" ); 
		w.println( "        <br>" );
		w.println( "        <input type='password' name='password' value='" + pwd + "' placeholder='输入密码'>" );
		w.println( "        <br>" );
		w.println( "        <input type='checkbox' name='autologin' value='auto'>两周内自动登录" );
		w.println( "        <br>" );
		w.println( "        <input type='submit' value='登录'>" );
		w.println( "    </form>" );
		
		w.println( "</body>" );
		w.println( "</html>" );
		
	}
	
	

}
