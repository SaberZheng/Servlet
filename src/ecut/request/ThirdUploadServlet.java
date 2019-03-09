package ecut.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class ThirdUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 4485463572490572537L;

	@Override
	protected void doGet( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		throw new RuntimeException( "不支持GET方式上传" );
	}

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
			upfile("upfile1",request);
			upfile("upfile2",request);
			upfile("upfile3",request);
			upfile("upfile4",request);
	}
	
	void upfile(String upfile,HttpServletRequest request) throws ServletException, IOException{
		Part part = request.getPart( upfile) ; 
		String filename = part.getSubmittedFileName(); 
		part.write( filename );
	}
	

}
