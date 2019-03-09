package ecut.listener.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ApplicationAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded( ServletContextAttributeEvent event ) {
		ServletContext application = event.getServletContext();
		String name = event.getName() ; 
		Object value = event.getValue() ; 
		System.out.print( "向 " + application.getContextPath() + " 的 ServletContext 中添加属性: " );
		System.out.println(  name + " ，取值: " + value );
	}

	@Override
	public void attributeReplaced( ServletContextAttributeEvent event ) {
		
		ServletContext application = event.getServletContext();
		String name = event.getName() ; 
		Object value = event.getValue() ; // 原来的值
		
		System.out.print( application.getContextPath() + " 的 ServletContext 中的属性: " );
		System.out.print( name );
		System.out.print( " 的取值从 [ ");
		System.out.print( value );
		System.out.println( " ] 替换成 [ " + application.getAttribute( name )  +" ]" );

	}
	
	@Override
	public void attributeRemoved( ServletContextAttributeEvent event ) {
		ServletContext application = event.getServletContext();
		String name = event.getName() ; 
		Object value = event.getValue() ; 
		System.out.print( "从 " + application.getContextPath() + " 的 ServletContext 中移除属性: " );
		System.out.println(  name + " ，取值: " + value );
	}

}
