package ecut.context.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import ecut.context.util.JdbcHelper;

@WebServlet( value = "/prepared" , loadOnStartup = 1 )//数字代表加载优先级，默认值-1访问再加载 ，1容器启动就加载，必须要有value否则loaderOnStartup不起作用

public class PreparedServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		ServletContext application = config.getServletContext() ;
		
		ClassLoader loader = application.getClassLoader();//servlet加载所使用的加载器
		
		final JdbcHelper helper = new JdbcHelper();
		
		helper.load( loader );//加载数据驱动
		System.out.println(loader);
		
		application.setAttribute( "jdbcHelper" ,  helper );
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

}
