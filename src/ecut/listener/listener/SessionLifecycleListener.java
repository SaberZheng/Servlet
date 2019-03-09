package ecut.listener.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLifecycleListener implements HttpSessionListener {

	@Override
	public void sessionCreated( HttpSessionEvent event ) {
		HttpSession session = event.getSession();
		System.out.println( new Date()+"会话[ " + session.getId() + " ]创建成功" );
	}

	@Override
	public void sessionDestroyed( HttpSessionEvent event ) {
		HttpSession session = event.getSession();
		System.out.println( new Date()+ "准备销毁[ " + session.getId() + " ]会话" );
	}

}
