package ecut.request;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstUploadServlet extends HttpServlet {

	private static final long serialVersionUID = -7777691027208490971L;

	@Override
	protected void doGet( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		throw new RuntimeException( "不支持GET方式上传" );
	}

	@Override
	protected void doPost( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		
		request.setCharacterEncoding( "UTF-8" );
		
		// 上传文件时，只考虑文本文件，不考虑其它文件
		BufferedReader reader = request.getReader();
		//InputStream in = request.getInputStream();

		String s ; 
		while( ( s = reader.readLine() ) != null ){
			System.out.println( s );
		}
		
	}
	
	

}
