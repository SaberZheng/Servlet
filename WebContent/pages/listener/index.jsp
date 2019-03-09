<%@ page language="java"   pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listener</title>
		<style type="text/css">
			ol li {
				list-style-type: lower-roman ;
			}
			
			.lifecycle , .application , .session {
				border: 1px solid #dedede ;
				width: 90% ;
				margin: 20px auto ;
				box-shadow: 0px 0px 5px 4px #dfdfdf ;
				padding: 10px 10px ;
			}
		</style>
	</head>
	<body>
	
		<div class="lifecycle">
			<a href="<%= request.getContextPath() %>/session/show" >显示 Session Id </a>
		</div>
		
		<div class="application">
			Application
			<form action="<%= request.getContextPath() %>/application/add" method="post" >
				添加或替换属性:<input type="text" name="name" placeholder="请输入属性名">
				<input type="text" name="value" placeholder="请输入属性值">
				<input type="submit" value="添加" >
			</form>
			
			<hr>
			
			<form action="<%= request.getContextPath() %>/application/remove" method="post" >
				删除属性:<input type="text" name="name" placeholder="请输入属性名">
				<input type="submit" value="删除" >
			</form>
		
		</div>
		
		<div class="session">
		
			Session:
			<form action="<%= request.getContextPath() %>/session/add" method="post" >
				添加或替换属性:<input type="text" name="name" placeholder="请输入属性名">
				<input type="text" name="value" placeholder="请输入属性值">
				<input type="submit" value="添加" >
			</form>
			
			<hr>
			
			<form action="<%= request.getContextPath() %>/session/remove" method="post" >
				删除属性:<input type="text" name="name" placeholder="请输入属性名">
				<input type="submit" value="删除" >
			</form>
		
		</div>
		
		<div class="session">
		
			<form action="<%= request.getContextPath() %>/customer/login" method="post" >
				<input type="text" name="username" placeholder="请输入用户名">
				<input type="password" name="password" placeholder="请输入密码">
				<input type="submit" value="登录" >
			</form>
		
		</div>
		
		
	
	</body>
</html>