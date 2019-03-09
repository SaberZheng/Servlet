package ecut.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(  "/redirect" )
public class MyRedirectServlet extends HttpServlet {

	private static final long serialVersionUID = -6205011155467276976L;

	@Override
	protected void service( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" ); 
		
		try {
			Thread.sleep( 5000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 设置响应状态代码
		response.setStatus( 302 ); // 通知 WEB 客户端 需要打开另外的一个 "位置"
		// 设置 响应报头
		//response.setHeader( "location" ,  request.getContextPath() + "/pages/request/index.html" );
		 response.setHeader( "location" ,  "http://www.baidu.com" );
		 //request.getContextPath() :applicationPath : /Servlet
		
		 
		// response.sendRedirect( request.getContextPath() + "/index.html"  );
		
	}

}
