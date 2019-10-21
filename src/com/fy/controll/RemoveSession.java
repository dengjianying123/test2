package com.fy.controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fy.model.User;


@WebServlet("/removeSession")
public class RemoveSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//清除会话
		HttpSession hs = request.getSession();
		User user=(User) hs.getAttribute("user");
		System.out.println("清除user之前"+user.getUsername());
		
		hs.removeAttribute("user");
		System.out.println(hs.getAttribute("item"));
		System.out.println("清除user之后"+user.getUsername());
		
		//hs.invalidate();//全部的session 会话清除
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
