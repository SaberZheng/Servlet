package ecut.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegistServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	public void service( ServletRequest req , ServletResponse resp ) throws ServletException, IOException {
		req.setCharacterEncoding( "UTF-8" );
		resp.setCharacterEncoding( "UTF-8" ); // 设置响应体的编码
		resp.setContentType( "text/html;charset=UTF-8" );
		
		String username = req.getParameter( "username" );
		System.out.println( "username : " + username );
		
		PrintWriter w = resp.getWriter();
		w.println( "<h1 style='text-align:center' >恭喜" + username + ",你已注册成功！</h1>" );
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	
	@Override
	public String getServletInfo() {
		return null;
	}

}
