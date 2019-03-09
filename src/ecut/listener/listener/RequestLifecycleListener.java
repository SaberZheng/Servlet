package ecut.listener.listener;

import javax.servlet.DispatcherType;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestLifecycleListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		ServletRequest req = event.getServletRequest();
		HttpServletRequest request = (HttpServletRequest) req ;
		String uri = request.getRequestURI();
		DispatcherType type = request.getDispatcherType();
		String name = req.getLocalName();
		System.out.println(  "来自"+name+"请求类型为"+type + " ,请求路径是 " + uri +"的请求结束");
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		ServletRequest req = event.getServletRequest();
		HttpServletRequest request = (HttpServletRequest) req ;
		String uri = request.getRequestURI();
		DispatcherType type = request.getDispatcherType();
		String name = req.getLocalName();
		System.out.println( "接收到请求：来自" +name+"的请求，请求类型为"+type + " ,请求路径是 " + uri );
		
	}

}
