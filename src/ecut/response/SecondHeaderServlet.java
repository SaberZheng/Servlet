package ecut.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( value = { "/header/second" , "/s" , "/refresh" } )
public class SecondHeaderServlet extends HttpServlet {

	private static final long serialVersionUID = -5880198269462470756L;
	
	private Date date = new Date();//只创建一次不要反复创建
	private DateFormat df = new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss.SSS" );

	@Override
	protected void service( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" ); // 设置 响应 的字符编码 (在服务器上起作用)
		
		// 动态获得当前 WEB 应用 的 路径 ( context path )
		String applicationPath = request.getContextPath() ;
		
		System.out.println( "applicationPath : " + applicationPath );
		//每3秒刷新一次
		//response.setHeader( "refresh" ,  "3,URL=" + applicationPath + "/refresh" );
		
		// response.setHeader( "refresh" ,  "3,URL=/Servlet/refresh" ); // 定时刷新
		
		 response.setHeader( "refresh" , "3,URL=/Servlet/header/first"); // 定时跳转
		
		response.setContentType( "text/html;charset=UTF-8" ); // 设置响应正文的 MIME 类型
		
		PrintWriter w = response.getWriter();
		w.println( "<div style='text-align:center ; border : 1px solid blue ; height : 400px ; width : 500px ; margin : auto auto ; '>" );
		
		date.setTime( System.currentTimeMillis() );
		w.println( df.format( date ) );
		
		w.println( "</div>" );
		
	}
	
	

}
