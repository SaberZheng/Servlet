package ecut.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet{

	private static final long serialVersionUID = -2575698410270033395L;

	@Override
	public void service(ServletRequest req , ServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding( "UTF-8" );
		resp.setCharacterEncoding( "UTF-8" );
		
		// 接受来自客户端的数据
		String username = req.getParameter( "username" );
		System.out.println( "username : " + username );
		String password = req.getParameter( "password" );
		System.out.println( "password : " + password );
		
		// 向客户端生成响应数据
		resp.setContentType( "text/html;charset=UTF-8" );
		PrintWriter w = resp.getWriter();
		w.println( "<h1 style='text-align:center;color:blue;'>你好 , " + username + " !</h1>" );
		
	}

}
