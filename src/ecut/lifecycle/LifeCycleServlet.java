package ecut.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeCycleServlet  implements Servlet {
	
	static { 
		System.out.println( "加载并初始化LifeCycleServlet类" );
	}
	
	public LifeCycleServlet(){
		System.out.println( "创建 LifeCycleServlet 类的实例" );
	}

	@Override
	public void init( ServletConfig config ) throws ServletException {
		System.out.println( "对 LifeCycleServlet 实例进行初始化" );
	}

	@Override
	public void service( ServletRequest req , ServletResponse resp ) throws ServletException, IOException {
		System.out.println( "LifeCycleServlet 的实例对外提供服务" );
		
		resp.setCharacterEncoding( "UTF-8" );
		resp.setContentType( "text/html;charset=UTF-8" );
		
		// 向客户端生成响应数据
		PrintWriter w = resp.getWriter();
		w.println( "<h1 style='text-align:center;color:blue;'>Hello !</h1>" );
		
	} 
	
	@Override
	public void destroy() {
		System.out.println( "准备销毁 LifeCycleServlet 的实例" );
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

}
