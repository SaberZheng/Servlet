package ecut.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns= { "/header/first" , "/f" } )

public class FirstHeaderServlet extends HttpServlet {

	private static final long serialVersionUID = -5880198269462470756L;

	@Override
	protected void service( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" ); //设置响应的字符编码 (在服务器上起作用)
				
		// 获得可以向客户端发送数据的输出流之前，就需要设置响应报头
		//response.setHeader( "content-type" ,  "text/html;charset=UTF-8" ); // 设置响应正文的 MIME（多任务因特网邮件扩充） 类型
		response.setContentType( "text/html;charset=UTF-8" ); // 设置响应正文的 MIME 类型
		// 这里的 charset=UTF-8 用来告知 WEB 客户端 以何种编码处理接受到的 字符
		
		System.out.println( response.containsHeader( "content-type" ) );
		
		PrintWriter w = response.getWriter();
		// 发送响应正文
		w.println( "<div style='text-align:center ; border : 1px solid blue ; height : 400px ; width : 500px ; margin : auto auto ; '>" );
		w.println( "天天向上" );
		w.println( "</div>" );
		
	}
	
	

}
