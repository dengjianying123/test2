package com.fy.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fy.model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		List<User> dateUser = new ArrayList<User>();
		dateUser.add(new User(1, "张三", "111"));
		dateUser.add(new User(2, "李四", "222"));
		dateUser.add(new User(3, "王五", "333"));
		
		boolean loginState=false;
		User sessionUser= new User();
		for (User u : dateUser) {
			if (u.getUsername().equals(name) && u.getPassword().equals(pwd)) {
				loginState=true;
				sessionUser=u;
			}
			
		}
		if (loginState) {
			HttpSession hs=request.getSession();
			hs.setAttribute("user", sessionUser);
			hs.setAttribute("item", "商品列表");
			hs.setMaxInactiveInterval(3600);
			Cookie cookie = new Cookie("user",hs.getId());
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
			//重定向
			response.sendRedirect(request.getContextPath()+"/getLoginSession.jsp");			
		}else{
			response.getWriter().println("用户名密码不正确，");
		}
	}

}
