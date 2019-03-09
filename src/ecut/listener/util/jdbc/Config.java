package ecut.listener.util.jdbc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 与 JDBC 配置文件 ( jdbc.xml ) 中的 &lt;config&gt; 标记对应的 Java 类。<br>
 * 适用与 JAXB 方式解析 jdbc.xml 文件
 */
public class Config {

	private String id ;
	private boolean use ;
	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	private boolean autoCommit ;
	
	private String isolation ;
	
	/**
	 * 当前的 config 的编号，要求在整个 xml 文件中是唯一的
	 * @return
	 */
	@XmlAttribute
	public String getId() {
		return id;
	}

	/**
	 * 设置 config 的编号
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute
	public boolean isUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	@XmlElement( name = "auto-commit" )
	public boolean isAutoCommit() {
		return autoCommit;
	}

	public void setAutoCommit(boolean autoCommit) {
		this.autoCommit = autoCommit;
	}

	public String getIsolation() {
		return isolation;
	}

	public void setIsolation(String isolation) {
		this.isolation = isolation;
	}

}
