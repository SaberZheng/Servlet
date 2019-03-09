package ecut.dispatch.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 徐庶 */
@WebServlet( "/xushu" )
public class XuShuServlet extends HttpServlet {

	private static final long serialVersionUID = -4740536310110994996L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		
		System.out.println( "老夫本想尽心尽力辅佐刘先生，但是老母被曹先生请去做客了，所以我得走了" );
		
		System.out.println( "老刘啊，你可以取 南阳 寻找一个茅草屋，里面如果住的时人，那可能就是你要找的诸葛亮" );
		
		/*
		response.setStatus( 302 );
		response.setHeader( "location" ,  request.getContextPath() + "/nanyang/maocaowu/liangliang" );
		*/
		
		response.sendRedirect( request.getContextPath() + "/nanyang/maocaowu/liangliang" );
		
	}
	
	

}
