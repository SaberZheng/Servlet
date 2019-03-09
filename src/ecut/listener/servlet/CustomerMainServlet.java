package ecut.listener.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecut.listener.entity.Customer;

@WebServlet( "/customer/main" )
public class CustomerMainServlet  extends HttpServlet {

	private static final long serialVersionUID = 154588398950897364L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		response.setContentType( "text/html" );
		
		PrintWriter w = response.getWriter();
		
		ServletContext application = this.getServletContext() ;
		HttpSession session = request.getSession();
		
		Object o = session.getAttribute( "customer" );
		
		if( o instanceof Customer ){
			Customer c = (Customer) o ;
			w.println( "<h1>欢迎" + c.getUsername() + " 登录</h1>" );
			w.println( "<h1>当前登陆人数:" + application.getAttribute( "loginCounter" ) + " </h1>" );
			w.println( "<a href='" + request.getContextPath() + "/customer/logout'>注销</a>");
		} else {
			
			response.sendRedirect( request.getContextPath() + "/pages/listener/index.jsp" );
		}
	
	}

}
