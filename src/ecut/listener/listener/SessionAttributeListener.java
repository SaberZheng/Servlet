package ecut.listener.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		String name = event.getName() ; 
		Object value = event.getValue() ; 
		System.out.print( "向 会话[" + session.getId() + " ]中添加属性: " );
		System.out.println(  name + " ，取值: " + value );
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		String name = event.getName() ; 
		Object value = event.getValue() ; 
		System.out.print( "从会话[ " + session.getId() + "] 中移除属性: " );
		System.out.println(  name + " ，取值: " + value );

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		

		HttpSession session = event.getSession();
		String name = event.getName() ; 
		Object value = event.getValue() ; // 原来的值
		
		System.out.print("会话[" + session.getId() + "] 中的属性: " );
		System.out.print( name );
		System.out.print( " 的取值从 [ ");
		System.out.print( value );
		System.out.println( " ] 替换成 [ " + session.getAttribute( name )  +" ]" );

	}

}
