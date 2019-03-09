package ecut.dispatch.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatch/regist")
public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = -4191840660711521199L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("regist");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// PrintWriter w = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");

		// 判断用户名是否为空 ( 页面上可能根本就没有提交username 、页面提交了空串)
		if (username == null || username.trim().isEmpty()) {
			// 不能注册
			// w.println("<h3>用户名不能为空,3秒后返回首页</h3>");//刷新存在表单再次提交问题，因为地址没有改变还是当前URL，刷新就会再次请求
			// response.setHeader("refresh", "3,URL=" +request.getContextPath() + "/pages/dispatch/index.html"); // 定时跳转
			response.sendRedirect(request.getContextPath() + "/pages/dispatch/index.html");//重定向到了另一个页面解决了表单提交的问题
			return;
		} else {
			// 用户名可能使用，但是需要检查密码是否为空且两次密码输入是否一致
			if (password != null && password.length() != 0 && password.equals(confirm)) {
				// 可以注册
				// w.println( "<h3>注册成功</h3>" );
				response.sendRedirect(request.getContextPath() + "/pages/dispatch/success.html");
				return;
			} else {
				// 没有密码 或 密码输入不一致 不能注册
				// w.println( "<h3>密码输入不正确</h3>" );
				 response.sendRedirect(request.getContextPath() + "/pages/dispatch/index.html");
				return;//响应结束了
			}
		}

	}

}
