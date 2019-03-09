package ecut.context.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/web/counter" )
public class CounterServlet extends HttpServlet {

	private static final long serialVersionUID = 1963063933334411177L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response  ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		PrintWriter w = response.getWriter();
		
		HttpSession session = request.getSession();
		// 1、先尝试从 session 中获取一个名称是 counter 的属性值
		Integer sessionCounter = (Integer)session.getAttribute( "counter" );
		// 2、判断 sessionCounter 是否是不存在的
		if( sessionCounter == null ){
			sessionCounter = Integer.valueOf( 0 );
		}
		// 3、将数值增加后重新放回到 session 中，以备下次继续累加
		sessionCounter++ ;
		session.setAttribute( "counter" , sessionCounter );
		
		w.println( "<h3 align='center'>SessionCounter : " + sessionCounter + "</h3>" );
		
		ServletContext application = this.getServletContext() ;
		
		// 1、先尝试从 application 中获取一个名称是 counter 的属性值
		Integer applicationCounter = (Integer)application.getAttribute( "counter" );
		// 2、判断 applicationCounter 是否是不存在的
		if( applicationCounter == null ){
			applicationCounter = Integer.valueOf( 0 );
		}
		// 3、将数值增加后重新放回到 application 中，以备下次继续累加
		applicationCounter++ ;
		application.setAttribute( "counter" , applicationCounter );
		
		w.println( "<h3 align='center'>ApplicationCounter : " + applicationCounter + "</h3>" );
		
	}
	
}
