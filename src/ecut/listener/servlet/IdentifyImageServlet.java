package ecut.listener.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecut.listener.util.GraphicHelper;

@WebServlet( "/identify/image/*" )
public class IdentifyImageServlet extends HttpServlet {

	private static final long serialVersionUID = -4219257759191069535L;
	
	@Override
	protected void service(  HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setHeader( "content-type" , "image/jpeg" );
		// 响应报头 content-disposition 用来设置 响应正文中的二进制数据是 在浏览器显示 还是 由浏览器下载
		response.setHeader( "content-disposition" , "inline" );
		
		ServletOutputStream out = response.getOutputStream();
		
		String code = GraphicHelper.create( 4 , true , 180 , 50 , out , 50 );
		
		final String uri = request.getRequestURI();
		int last = uri.lastIndexOf( "/" ) ; 
		final String s = uri.substring( last + 1 ) ;
		
		int index = s.indexOf( ".do" );
		String operation = s.substring( 0 ,  index );
		
		session.setAttribute( operation + "IdentifyCode" , code );
		
	}

}
