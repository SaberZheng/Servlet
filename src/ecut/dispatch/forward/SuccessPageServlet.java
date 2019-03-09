package ecut.dispatch.forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//登陆页面
@WebServlet( "/page/success" )
public class SuccessPageServlet extends HttpServlet {

	private static final long serialVersionUID = 2075180219363356668L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		Object value=request.getAttribute("counter");//可以将request当做Map<String , Object>来使用，map.get("counter")
		System.out.println(value);//用的是同一个请求
		System.out.println(response.getHeader("suibian"));//用的是同一个响应
		PrintWriter w = response.getWriter();
		
		w.println( "<!DOCTYPE html>" );
		w.println( "<html>" );
		w.println( "<head>" );
		w.println( "<meta charset='UTF-8'>" );
		w.println( "<title>登录</title>" );
		w.println( "</head>" );
		w.println( "<body>" );
		w.println( "    <h1>登录成功</h1>" );
		w.println( "</body>" );
		w.println( "</html>" );
		
	}
	
	

}
