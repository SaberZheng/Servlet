package ecut.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class SecondUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 4485463572490572537L;

	@Override
	protected void doGet( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		throw new RuntimeException( "不支持GET方式上传" );
	}

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		// String username = request.getParameter( "username" ) ; // <input type="text" name="username" >
		
		Part part = request.getPart( "upfile" ) ; // <input type="file" name="upfile" >
		System.out.println( part );
		
		/* Servlet 3.0 中获得文件名的做法
		String cd = part.getHeader( "Content-Disposition" );
		System.out.println( cd );
		String s = "filename=\""; 
		int index = cd.indexOf( s );//找到filename的位置
		String name = cd.substring( index + s.length() , cd.length() - 1 );//获取文件名
		System.out.println( name );
		*/
		
		// part.getName() ; // name="upfile"
		String filename = part.getSubmittedFileName(); // Servlet 3.1 开始出现的方法
		
		part.write( filename );
		
	}
	
	

}
