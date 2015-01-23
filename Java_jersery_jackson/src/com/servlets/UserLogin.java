package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.authorize.Login;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("User Login :"+username);
		String password = request.getParameter("password");
		System.out.println("User Login pass :"+password);
		HttpSession session = request.getSession();

		System.out.println("User Login Received Data :"+session.getAttribute("receivedData"));
		Login login = new Login();
		boolean check = login.checkDetails(username, password);
		

	if (check == true) {
		session.setAttribute("id", session.getId());
		session.setAttribute("uname", username);
		response.sendRedirect("Confirmation.jsp");

	} else {
		response.sendRedirect("UserLogin.jsp");

	}
}
}
