package ecut.dispatch.include;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/include/first" )
public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = 3984166560156790204L;
	
	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		//斜杆表示从WebContent算起的路径
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/pages/dispatch/header.html" );
		//jsp就是servlet所以不会报错,因此可以包含多个
		//RequestDispatcher dispatcher = request.getRequestDispatcher( "/pages/dispatch/header.jsp" );

		dispatcher.include( request , response );
		//包含静态资源（HTML页面）的时候，页面输出完，流就结束意味着响应结束，再去输出流就会报错
		//getOutputStream() has already been called for this response,想获得输出流时候但是响应结束了
		PrintWriter w = response.getWriter() ; 
		
		w.println( "<h1>First Servlet</h1>" );
		
	}

}
