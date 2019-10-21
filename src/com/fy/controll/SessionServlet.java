package com.fy.controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fy.model.User;


@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession hs = request.getSession();
		if (hs.getId()!=null) {
			User user=(User) hs.getAttribute("user");
			response.getWriter().println(user.getId()+"\n"+user.getUsername()+"\n"+user.getPassword());
		}else{
			response.getWriter().print("没有session会话");
		}
	}

}
