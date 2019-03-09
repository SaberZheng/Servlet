package ecut.response;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/image/down" )
public class DownloadImageServlet extends HttpServlet {

	private static final long serialVersionUID = 448136179136896451L;

	@Override
	protected void service(HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		
		String name = "Koala.jpg" ;
		
		Path source = Paths.get( "D:/" ,  name );
		
		response.setHeader( "content-type" , "image/jpeg" );
		
		// 响应报头 content-disposition 用来设置 响应正文中的二进制数据是 在浏览器显示 还是 由浏览器下载
		name = URLEncoder.encode( name , "UTF-8" ); // 如果文件名中含有汉字，则需要对汉字进行编码
		System.out.println( "编码后:" + name  );
		response.setHeader( "content-disposition" , "attachment;filename='" + name + "'" );
		
		// 获得可以向客户端发送二进制数据的字节输出流
		ServletOutputStream out = response.getOutputStream();
		// 将 source 中的内容 "复制" 到 out 对应的输出流，实际上就完成了输出操作
		Files.copy( source, out ) ;
		
	}
	
	

}
