package ecut.listener.entity;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Customer implements Serializable , HttpSessionBindingListener {

	private static final long serialVersionUID = 7499870485797565944L;
	
	private Integer id ;
	private String username ;
	private String password ;
	private String nickname ;
	private char gender ;
	private Date birthdate ;

	@Override
	public void valueBound( HttpSessionBindingEvent event ) {
		System.out.println( "绑定到 [ " + event.getSession().getId() + " ]" );
		ServletContext application = event.getSession().getServletContext();
		// 1、先尝试从 ServletContext 获取名称是 loginCounter 的属性
		Integer loginCounter = (Integer)application.getAttribute( "loginCounter" );
		// 2、判断 loginCounter 是否不存在
		if( loginCounter == null ){
			loginCounter = Integer.valueOf( 0 ) ;
		}
		// 3、将 loginCounter 增加 1  以后 再 放入到 ServletContext 中
		application.setAttribute( "loginCounter" , ++loginCounter );
	}

	@Override
	public void valueUnbound( HttpSessionBindingEvent event ) {
		System.out.println( "从 [ " + event.getSession().getId() + " ] 解除绑定" );
		ServletContext application = event.getSession().getServletContext();
		// 1、先尝试从 ServletContext 获取名称是 loginCounter 的属性
		Integer loginCounter = (Integer)application.getAttribute( "loginCounter" );
		// 2、判断 loginCounter 是否不存在
		if( loginCounter == null ){
			application.setAttribute( "loginCounter" , 0 );
		} else {
			// 3、将 loginCounter 减去 1  以后 再 放入到 ServletContext 中
			--loginCounter;
			loginCounter = loginCounter < 0 ? 0 : loginCounter ;
			application.setAttribute( "loginCounter" , loginCounter );
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
