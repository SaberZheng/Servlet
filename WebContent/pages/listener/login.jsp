<%@ page language="java"   pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>工具集</title>
		<style type="text/css">
			
			.suibian {
				border: 1px solid #dedede ;
				width: 90% ;
				margin: 20px auto ;
				box-shadow: 0px 0px 5px 4px #dfdfdf ;
				padding: 10px 10px ;
			}
			
		</style>
	</head>
	<body>
	
		<div class="suibian">
		
			<form action="<%= request.getContextPath() %>/customer/login.do" method="post" >
				<input type="text" name="username" placeholder="请输入用户名">
				<input type="password" name="password" placeholder="请输入密码">
				<input type="text" name="identifyCode" placeholder="验证码">
				<img src="<%= request.getContextPath() %>/identify/image/login.do">
				<input type="submit" value="登录" >
			</form>
		
		</div>
	
	</body>
</html>