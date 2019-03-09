package ecut.listener.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationLifecycleListener implements ServletContextListener {

    public ApplicationLifecycleListener() {
    	//System.out.println( "WebApplicationLifecycleListener" );
    }
    
    public void contextInitialized( ServletContextEvent sce )  { 
    	ServletContext application = sce.getServletContext();
    	String name = application.getServletContextName();
    	String contextPath = application.getContextPath();
    	System.out.println( "正在加载: " + name + " , 它相应的路径为: " + contextPath );
    }

    public void contextDestroyed( ServletContextEvent sce )  { 
    	ServletContext application = sce.getServletContext();
    	String name = application.getServletContextName();
    	System.out.println( "正在卸载: " + name  + " 。");
    }
	
}
