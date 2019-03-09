package ecut.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(  "/status" )
public class ResponseStatusServlet extends HttpServlet {

	private static final long serialVersionUID = -7904861099406918294L;

	@Override
	protected void service( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" ); 
		
		int statusCode = 404 ;
		String statusMessage = "这个Servlet是存在的，但是就是不让你访问" ;
		response.sendError( statusCode , statusMessage );
		//response.setStatus(statusCode); //效果不明显

		
		response.setContentType( "text/html;charset=UTF-8" ); 
		
		PrintWriter w = response.getWriter();
		w.println( "<div style='text-align:center ; border : 1px solid blue ; height : 400px ; width : 500px ; margin : auto auto ; '>" );
		w.println( "天天向上" );
		w.println( "</div>" );
		
	}

}
