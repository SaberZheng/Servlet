package ecut.listener.util.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet {

	private static final long serialVersionUID = 1731799694888378644L;

	@Override
	protected void service(  HttpServletRequest request , HttpServletResponse response ) 
			throws ServletException, IOException {
		// 约定 最后一个 /  之后 .do 之前 就是一个方法的名称
		// /customer/login.do ----> login ---> login( HttpServletRequest request , HttpServletResponse response )
		// /customer/logout.do  ----> logout ---> logout ( HttpServletRequest request , HttpServletResponse response ) 
		// /customer/main.do  ---->  main ---> main( HttpServletRequest request , HttpServletResponse response )
		
		final String uri = request.getRequestURI();
		//System.out.println( "uri : " + uri );
		
		int last = uri.lastIndexOf( "/" ) ; 
		
		final String s = uri.substring( last + 1 ) ;
		//System.out.println( "s : " + s );
		
		int index = s.indexOf( ".do" );
		String methodName = s.substring( 0 ,  index );
		//System.out.println( "m : " + methodName );
		
		Class<?> c = this.getClass();
		try {
			Method m = c.getDeclaredMethod( methodName , HttpServletRequest.class , HttpServletResponse.class );
			m.setAccessible( true );
			m.invoke( this , request , response );
		} catch (NoSuchMethodException e) {
			System.out.println( "根据URI未找到相应的方法，请检查URI是否正确 : " + e.getMessage()  );
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

}
