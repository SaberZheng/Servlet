package ecut.listener.util.jdbc;

import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 与 JDBC 配置文件 ( jdbc.xml ) 的根元素 &lt;jdbc-config&gt; 对应的  Java 类。<br>
 * 适用与 JAXB 方式解析 jdbc.xml 文件
 */
@XmlRootElement( name="jdbc-config" )
public class JdbcConfig {
	
	// 用来存放一组 Config 对象的集合 ( Config 是 <config> 对应的类型 )
	private Set<Config> configs ;

	@XmlElement( name = "config" )
	public Set<Config> getConfigs() {
		return configs;
	}

	public void setConfigs(Set<Config> configs) {
		this.configs = configs;
	}
	
	public Config getUseConfig(){
		
		Config config = null ;
		
		if( this.configs != null && this.configs.size() > 0 ){
			for( Config c : this.configs ){
				if( c != null && c.isUse() ){
					config = c ;
					break ;
				}
			}
		}
		
		return config ;
	}

}
