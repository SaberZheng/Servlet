package ecut.dispatch.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//登陆操作
@WebServlet( "/action/login" )
public class LoginActionServlet extends HttpServlet {

	private static final long serialVersionUID = 6978052887387276476L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		
		System.out.println( "username : " + username + " , password : " + password );
		
		if( "AmyZheng".equals( username ) && "123".equals( password ) ){
			//RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/dispatch/login_success.html" );
			//dispatcher.forward( request , response );//转发到另一个页面，刷新页面存在表单重新提交的问题，因为地址没有改变还是当前URL，刷新就会再次请求再次提交表单
			response.setHeader("suibian", "suibianzhi");
			request.setAttribute("counter", 250);//可以将request当做Map<String , Object>来使用，map.put("counter",250)
			RequestDispatcher dispatcher = request.getRequestDispatcher( "/page/success" );
			dispatcher.forward( request , response );//转发到另一个页面Servlet，刷新页面存在表单重新提交的问题，因为地址没有改变还是当前URL，刷新就会再次请求再次提交表单
			
			//为了解决表单重复提交的问题，可以采取以下方法:
			// 1、重定向到另外的一个 Servlet ，比如 LoginSuccessServlet
			// 2、由 另外的一个 Servlet ，比如 LoginSuccessServlet 完成 转发操作
			//response.sendRedirect(  request.getContextPath() + "/forward/login/success" );//由LoginSuccessServlet去转发
			return ;
		} else {
			response.sendRedirect(  request.getContextPath() + "/page/login" );
			return ;
		}
		
	}
	
	

}
