package ecut.response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/image/show" )
public class ShowImageServlet extends HttpServlet {

	private static final long serialVersionUID = 1376233444161496825L;

	@Override
	protected void service(HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		
		response.setHeader( "content-type" , "image/jpeg" );
		
		// 响应报头 content-disposition 用来设置 响应正文中的二进制数据是 在浏览器显示 还是 由浏览器下载
		response.setHeader( "content-disposition" , "inline" );
		//Path接口表示一个目录或一个文件对应的路径(它可以定位本地系统中的一个文件或目录)
		//Paths类是一个工具类，其中定义了两个静态方法，专门用来返回Path对象：		
		//static Path 	get(String first, String... more)转换的路径字符串,或一个字符串序列,当加入形成一个路径字符串, Path。 
		Path source = Paths.get( "D:/Koala.jpg" );
		//FileInputStream in = new FileInputStream( "D:/Koala.jpg" );
		
		// 获得可以向客户端发送二进制数据的字节输出流
		ServletOutputStream out = response.getOutputStream();
		// nio将 source 中的内容 "复制" 到 out 对应的输出流，实际上就完成了输出操作
		Files.copy( source, out ) ;
		
		/*
		byte[] bytes = new byte[32] ;
		int n ;
		while( ( n = in.read( bytes ) ) != -1 ){
			out.write( bytes ,  0 ,  n );
		}
		*/
		
	}
	
	

}
