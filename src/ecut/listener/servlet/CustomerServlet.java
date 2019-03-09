package ecut.listener.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecut.listener.entity.Customer;
import ecut.listener.util.servlet.DispatchServlet;

@WebServlet( "/customer/*" )
public class CustomerServlet extends DispatchServlet {

	private static final long serialVersionUID = -1762408392742705530L;

	// 登录
	protected void login( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		// 从 页面获得用户输入的 验证码内容
		String identifyCode = request.getParameter( "identifyCode" );
		
		HttpSession session = request.getSession() ;
		
		// 从 session 中获取 已经保存的 验证码内容
		String loginIdentifyCode = (String) session.getAttribute( "loginIdentifyCode" );
		
		// 比较 session 中存储的 验证码 跟 用户输入的 是否一致
		if( loginIdentifyCode.equals( identifyCode ) ) { 
			Customer c = new Customer();
			c.setUsername( username );
			c.setPassword( password );
			session.setAttribute( "customer" ,  c ); 
			
			response.sendRedirect( request.getContextPath() + "/customer/main.do" );
			return ;
		} else {
			response.sendRedirect( request.getContextPath() + "/pages/listener/login.jsp" );
			return ;
		}
	}

	// 注销
	protected void logout ( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute( "customer" ); // ---> Customer # valueUnbound
		
		response.sendRedirect( request.getContextPath() + "/pages/listener/login.jsp" );
	
	}

	// Main
	protected void main( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		response.setContentType( "text/html" );
		
		PrintWriter w = response.getWriter();
		
		HttpSession session = request.getSession();
		
		Object o = session.getAttribute( "customer" );
		
		if( o instanceof Customer ){
			Customer c = (Customer) o ;
			w.println( "<h1>欢迎" + c.getUsername() + " 登录</h1>" );
			w.println( "<a href='" + request.getContextPath() + "/customer/logout.do'>注销</a>");
		} else {
			
			response.sendRedirect( request.getContextPath() + "/pages/listener/login.jsp" );
		}
	
	}

}
