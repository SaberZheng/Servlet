package ecut.context.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecut.context.util.JdbcHelper;

@WebServlet( "/web/regist" )
public class RegistServlet  extends HttpServlet {

	private static final long serialVersionUID = 6187481716992686659L;

	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response  ) 
			throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );
		
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		
		String location = request.getContextPath() + "/pages/context/index.html" ;
		
		if( username == null || username.trim().isEmpty() ){
			response.sendRedirect( location );
			return ;
		}
		
		if( password == null || password.trim().isEmpty() ){
			response.sendRedirect( location );
			return ;
		}
		
		ServletContext application = this.getServletContext();
		
		JdbcHelper jdbcHelper = (JdbcHelper)application.getAttribute( "jdbcHelper" );
		
		if( jdbcHelper != null ) {
			String SQL = "INSERT INTO user ( name , password ) VALUES ( ? , ? )" ;
			PreparedStatement ps = jdbcHelper.prepare(SQL);
			try {
				ps.setString( 1 , username );
				ps.setString( 2 ,  password );
				
				int count = ps.executeUpdate();
				System.out.println( "count : " + count );
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			jdbcHelper.release( ps );
			
		}
		
		/*
		try{
			// 使用 JDBC 将数据存储到数据库中
			// 1、加载数据库驱动
			Class<?> c = Class.forName( "com.mysql.jdbc.Driver" );//web环境下必须主动加载驱动，因为和servlet不是同一个类加载器
			System.out.println( "ClassLoader : " + c.getClassLoader() );
			
			String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8" ;
			String dbUsername = "root" ;
			String dbPassword = "123456" ;
			
			// 2、建立数据库连接
			Connection conn = DriverManager.getConnection( url, dbUsername, dbPassword );
			
			conn.setAutoCommit( false ); // 关闭事务的自动提交改为手动提交
			
			String SQL = "INSERT INTO user ( name , password ) VALUES ( ? , ? )" ;
			// 3、创建可以 "执行" SQL 语句的对象
			// Statement stmt = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement( SQL );
			
			ps.setString( 1 , username );
			ps.setString( 2 ,  password );
			
			// 4、执行 SQL 语句
			int count = ps.executeUpdate();//受影响的条数
			System.out.println( "count : " + count );
			// 5、处理事务
			conn.commit(); 
			
			// 6、释放资源
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println( "你指定的驱动类不存在 : " + e.getMessage() );
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

	}
	
}
