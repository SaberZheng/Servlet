package ecut.tracking.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/cookie/action/login" )
public class LoginActionServlet extends HttpServlet {

	private static final long serialVersionUID = 6978052887387276476L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		
		String autologin = request.getParameter( "autologin" );
		
		System.out.println( "username : " + username + " , password : " + password );
		
		if( "zhangsanfeng".equals( username ) && "hello2017".equals( password ) ){
			
			if( autologin != null && autologin.trim().equalsIgnoreCase( "auto" ) ) {
				System.out.println( "需要保存用户名和密码 : " + autologin );
				
				String contextPath = request.getContextPath();
				
				int expiry = 60 * 60 * 24 * 14 ;
				//Cookie 由服务器创建  
				Cookie usernameCookie = new Cookie( "username" ,  username );
				usernameCookie.setPath( contextPath );
				usernameCookie.setMaxAge( expiry );
				
				response.addCookie( usernameCookie );
				
				Cookie passwordCookie = new Cookie( "password" ,  password );
				// 设置 Path(只有和其相同路径的请求才可以获得cookie), 这个工程下的所有的请求的都将可以接收到这个cookie，否则只有/cookie/action下的才可以获得这个cookie
				passwordCookie.setPath( contextPath );
				// 设置 Cookie 的有效期 ( 单位是 秒 )
				// max-age 的默认值是 -1 ，表示 浏览器关闭 即删除相应的 Cookie
				// 如果 max-age 的取值 是 0 表示 浏览器需要立即删除 该 Cookie
				passwordCookie.setMaxAge( expiry );
				// 通过 响应报头 将 Cookie 发送到 客户端进行保存 
				response.addCookie( passwordCookie );
				
			}
			
			response.sendRedirect(  request.getContextPath() + "/cookie/login/success" );
			return ;
		} else {
			response.sendRedirect(  request.getContextPath() + "/cookie/page/login" );
			return ;
		}
		
	}
	
	

}
