package ecut.listener.util.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ecut.listener.util.StringHelper;

/**
 * 为 当前 Web 应用做好准备工作：
 * 1、在 ServletContext 中放入当前Web应用的路径 (在 init 方法完成) ；
 * 2、在 service 方法中向Web客户端的发送当前Web应用的路径 ( 绑定到 window 对象上 )
 */
public class PreparedServlet extends GenericServlet {
	
	private static final long serialVersionUID = 7277937011725399106L;
	
	/** 约定初始化参数的名称: 确定在 application 中存储的那个表示 当前 Web 应用的变量的名称 */
	public static final String SERVER_CONTEXT_PATH_NAME = "contextPathName" ; 
	/** 约定初始化参数的名称: 确定在Web客户端中，通过JavaScript代码访问当前Web应用的路径时对应的变量名称( 绑定在 window 对象上) */
	public static final String FRONT_CONTEXT_PATH_NAME = "frontPathName" ;
	/** 如果没有指定初始化参数，则依赖采用默认名称，默认名称都是 path */
	private static final String DEFAULT_NAME = "path" ;
	
	/** 在 application 对象中存储的当前Web应用的路径的那个变量的名称 */
	private String contextPathName ;
	/** 在Web前端的 JavaScript 代码中，在 window. 之后跟的那个 变量的名称*/
	private String frontPathName; // 
	
	/** 当前Web应用的路径 */
	private String contextPath ;
	
	/** 准备向Web客户端发送的 JavaScript 代码 */
	private String scriptCode ;

	/**
	 * 1、读取初始化参数 contextPathName 和 frontPathName 。<br>
	 * 2、将当前 Web 应用的路径存储到 ServletContext 对象中 ( application.setAttribute( contextPathName , contextPath ) )。
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// 读取初始化参数 
		contextPathName = config.getInitParameter( SERVER_CONTEXT_PATH_NAME ) ; 
		contextPathName = StringHelper.empty( contextPathName ) ? DEFAULT_NAME : contextPathName.trim() ;
		
		frontPathName = config.getInitParameter( FRONT_CONTEXT_PATH_NAME ) ; 
		frontPathName = StringHelper.empty( frontPathName ) ? DEFAULT_NAME : frontPathName.trim() ;
		
		ServletContext application =  config.getServletContext() ; 
		contextPath = application.getContextPath() ;
		application.setAttribute( contextPathName , contextPath );
		
		scriptCode = "window." + frontPathName + "=\"" +  contextPath + "\"";
		
	}

	/***
	 * 向前端返回一段 JavaScript 代码，形如:<br>
	 * window.path = '/yourWebAppName' <br>
	 */
	@Override
	public void service(ServletRequest req , ServletResponse resp) 
			throws ServletException, IOException {
		
		// 设置 MIME 类型 ( 响应类型 )
		resp.setContentType( "text/javascript" );
		
		PrintWriter w = resp.getWriter();
		// 向客户端发送 JavaScript 脚本代码
		w.println( scriptCode );
		
	}

}
