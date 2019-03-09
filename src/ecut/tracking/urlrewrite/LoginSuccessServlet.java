package ecut.tracking.urlrewrite;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecut.tracking.entity.User;

@WebServlet( "/urlrewrite/login/success" )
public class LoginSuccessServlet extends HttpServlet {

	private static final long serialVersionUID = -7565331422887485255L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		PrintWriter w = response.getWriter();
		
		// 通过 request 对象来获得 与当前的 客户端关联的 session 对象
		HttpSession session = request.getSession();
		// 尝试从 session 中获取 名称是 user 的属性 ( attribute )
		Object o = session.getAttribute( "user" );
		
		// 如果获取到的 属性值 存在 且 是 User 类型，说明用户已经登陆
		if( o instanceof User ) { // o 所引用的对象 是 User 类型吗 ?
			User u = (User) o ;
			w.println( "<h2>欢迎 " + u.getUsername() + " 登录.</h2>" );
			String url = request.getContextPath() + "/urlrewrite/action/logout" ;
			System.out.println( "login success , before encode : " + url );
			url = response.encodeURL( url );
			System.out.println( "login success , after encode : " + url );
			w.println( "<a href='" + url + "' >注销</a>" );
		} else {
			response.sendRedirect( request.getContextPath() +  "/pages/tracking/index.html" );
			return ;
		}
		
	}
	
	

}
