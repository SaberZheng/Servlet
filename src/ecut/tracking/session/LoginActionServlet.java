package ecut.tracking.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecut.tracking.entity.User;

@WebServlet( "/session/action/login" )
public class LoginActionServlet extends HttpServlet {

	private static final long serialVersionUID = 6978052887387276476L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		// 通过 request 对象来获得 与当前的 客户端关联的 session 对象
		// 通过 获取 请求报头 中的 cookie 然后获得 jsessionid 对应的值，再根据 jsessionid 来寻找相应的 session 对象
		// 如果没有找到 jsessionid 对应的 session 对象，则 容器会创建一个 新的 session 对象
		HttpSession session = request.getSession();
		// 如果是新创建的 session 对象，则通过 响应报头 向客户端发送一个 cookie ( 其中包含了 session id )
		boolean isNew = session.isNew(); // 如果是新创建的 session 对象，则返回 true
		System.out.println( "is new: "+isNew );
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		
		System.out.println( "username : " + username + " , password : " + password );
		
		if( "zhangsanfeng".equals( username ) && "hello2017".equals( password ) ){
			User user = new User(); // 构造用户对应的对象
			user.setUsername( username ); // 将 用户名 设置到 用户对象中
			user.setPassword( password ); 
			session.setAttribute( "user" , user ); // 把 session 当作 Map< String , Object >
			response.sendRedirect(  request.getContextPath() + "/session/login/success" );
			return ;
		} else {
			response.sendRedirect(  request.getContextPath() + "/session/page/login" );
			return ;
		}
		
	}
}
