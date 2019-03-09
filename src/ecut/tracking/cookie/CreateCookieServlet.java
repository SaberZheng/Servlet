package ecut.tracking.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/cookie/create" )
public class CreateCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 7794199230188083290L;
	
	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		String contextPath = request.getContextPath() ;
		
		/** Cookie 由服务器创建  */
		Cookie c = new Cookie( "username" , "zhangsanfeng" ); // Cookie( String name , String value )
		
		// 设置 Path(只有和其相同路径的请求才可以获得cookie), 这个工程下的所有的请求的都将可以接收到这个cookie，否则只有/cookie下的才可以获得这个cookie
		c.setPath( contextPath ); 
		
		int expiry = 60 * 60 * 24 ;
		c.setMaxAge( expiry ); // 设置 Cookie 的有效期 ( 单位是 秒 )
		// max-age 的默认值是 -1 ，表示 浏览器关闭 即删除相应的 Cookie
		// 如果 max-age 的取值 是 0 表示 浏览器需要立即删除 该 Cookie
		
		/** 通过 响应报头 将 Cookie 发送到 客户端进行保存 */
		response.addCookie( c );
		
		PrintWriter w = response.getWriter();
		
		w.println( "<h1>你可以在浏览器中查看 Cookie 了</h1>" ) ;
		
	}

}
