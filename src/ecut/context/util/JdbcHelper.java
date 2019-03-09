package ecut.context.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class JdbcHelper {
	//final修饰不被继承
	//非静态的方法构造方法放出来，也可以使用静态的，构造方法私有
	public JdbcHelper(){}
	
	private String driver = "com.mysql.jdbc.Driver" ;
	private String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8" ;
	private String user = "root" ;
	private String password = "123456" ;
	
	private boolean unload = true ;
	
	/**
	 * 专门加载数据库驱动的方法
	 * @param loader
	 */
	public void load( ClassLoader loader ) {
		if( unload ) {
			try {
				if( loader == null ) {
					Class.forName( driver );
				} else {
					Class.forName( driver , true , loader);
				}
				unload = false ;
			} catch (ClassNotFoundException e) {
				System.out.println( "加载数据库驱动失败: " + e.getMessage() );
			}
		}
	}
	
	/**
	 * 获取数据库连接的方法
	 * @return
	 */
	public Connection connect(){
		Connection conn = null ;
		try {
			conn = DriverManager.getConnection( url, user, password );
		} catch (SQLException e) {
			System.out.println( "获取数据库连接失败: " + e.getMessage() );
		}
		return conn ;
	}
	
	/**
	 * 根据带有参数占位符的SQL语句创建一个相应的 PreparedStatement 对象
	 * @param SQL
	 * @return
	 */
	public PreparedStatement prepare( String SQL ) {
		PreparedStatement ps = null ;
		
		Connection conn = connect();
		
		if( conn != null ){
			try {
				ps = conn.prepareStatement( SQL );
			} catch (SQLException e) {
				System.out.println( "创建 PreparedStatement 时发生错误: " + e.getMessage()  );
			}
		}
		
		return ps ;
	}

	/**
	 * 专门用来释放资源的方法 ( 可以是 Connection 、Statement 、PrepredStarement 、ResultSet 等 )
	 * @param c
	 */
	public void release( AutoCloseable c ) {
		// 从jdk1.7开始Connection 、Statement 、PrepredStarement 、ResultSet实现了AutoCloseable接口
		if( c != null ){
			try {
				c.close();
			} catch (Exception e) {
				System.out.println( "关闭资源时发生错误: " + e.getMessage() );
			}
		}
	}
}
