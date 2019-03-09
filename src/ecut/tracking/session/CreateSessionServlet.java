package ecut.tracking.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/session/create" )
public class CreateSessionServlet  extends HttpServlet {

	private static final long serialVersionUID = 5091680185727017396L;

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
		String sessionId = session.getId();
		
		PrintWriter w = response.getWriter();
		w.println( "<h1 style='text-align:center;color:blue;'> id : " + sessionId + "</h1>" );
		w.println( "<h3 style='text-align:center;color:green;'> is new : " + isNew + "</h3>" );
		
	}

}
