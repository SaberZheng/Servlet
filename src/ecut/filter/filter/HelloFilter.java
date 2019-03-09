package ecut.filter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {
	
	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// place your code here
		System.out.println( "hello" );
		
		// pass the request along the filter chain
		chain.doFilter( req, resp ); 
		
		System.out.println( "world" );
	}

	public void destroy() {
	}

}
