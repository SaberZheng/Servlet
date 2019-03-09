package ecut.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet{

	private static final long serialVersionUID = -1117957788110702968L;

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		System.out.println( "GET" );
		
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		
		// 接受来自客户端的数据
		String username = request.getParameter( "username" );
		System.out.println( "username : " + username );
		String password = request.getParameter( "password" );
		System.out.println( "password : " + password );
		
		// 向客户端生成响应数据
		response.setContentType( "text/html;charset=UTF-8" );
		PrintWriter w = response.getWriter();
		w.println( "<h1 style='text-align:center;color:blue;'>你好 , " + username + " !</h1>" );
	}

	@Override
	protected void doPost( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		System.out.println( "POST" );
		
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		
		// 接受来自客户端的数据
		String username = request.getParameter( "username" );
		System.out.println( "username : " + username );
		String password = request.getParameter( "password" );
		System.out.println( "password : " + password );
		
		// 向客户端生成响应数据
		response.setContentType( "text/html;charset=UTF-8" );
		PrintWriter w = response.getWriter();
		w.println( "<h1 style='text-align:center;color:blue;'>你好 , " + username + " !</h1>" );
	}
	
	

}
