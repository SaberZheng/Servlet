package ecut.tracking.urlrewrite;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecut.tracking.entity.User;

@WebServlet( "/urlrewrite/action/login" )
public class LoginActionServlet extends HttpServlet {

	private static final long serialVersionUID = 6978052887387276476L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		HttpSession session = request.getSession();
		
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		
		System.out.println( "username : " + username + " , password : " + password );
		
		if( "zhangsanfeng".equals( username ) && "hello2017".equals( password ) ){
			User user = new User(); // 构造用户对应的对象
			user.setUsername( username ); // 将 用户名 设置到 用户对象中
			user.setPassword( password ); 
			session.setAttribute( "user" , user ); // 把 session 当作 Map< String , Object >
			
			String url = request.getContextPath() + "/urlrewrite/login/success" ;
			System.out.println( "login action , before encode : " + url );
			url = response.encodeURL( url );
			System.out.println( "login action , after encode : " + url );
			response.sendRedirect(  url );
			return ;
		} else {
			String url = request.getContextPath() + "/urlrewrite/page/login" ;
			System.out.println( "login action , before encode : " + url );
			url = response.encodeRedirectURL( url );
			System.out.println( "login action , after encode : " + url );
			response.sendRedirect(  url );
			return ;
		}
		
	}
	
	

}
