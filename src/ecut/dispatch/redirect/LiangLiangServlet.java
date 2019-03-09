package ecut.dispatch.redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( { "/liangliang" , "/nanyang/maocaowu/liangliang" } )
public class LiangLiangServlet extends HttpServlet {

	private static final long serialVersionUID = 8952475907224330677L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		System.out.println( "老曹家的郭嘉已经挂了，我可以出山了. . . " );
		
		PrintWriter w = response.getWriter();
		
		w.println( "<h2>咱诸葛家个个都是道士...</h2>" );
		
		
	}
	
	

}
