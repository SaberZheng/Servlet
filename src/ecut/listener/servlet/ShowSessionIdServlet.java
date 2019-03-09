package ecut.listener.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/session/show" )
public class ShowSessionIdServlet extends HttpServlet {

	private static final long serialVersionUID = 3683961647674453725L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// 通过代码来设置 会话的有效期 ( 时间单位是 秒 )
		session.setMaxInactiveInterval( 30); // 最长发呆时间 ( 从客户端最后一次访问 session 开始持续30秒 )
		
		response.setContentType( "text/html" );
		
		response.getWriter().println( "<h1>" + session.getId() + "</h1>" );
		
	}
	
	

}
