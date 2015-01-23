package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.authorize.SignUp;
import com.datavalidater.EmailFormat;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		EmailFormat ef = new EmailFormat();
		String email = request.getParameter("email");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rpassword = request.getParameter("rpassword");

		if (password.equals(rpassword) && ef.validate(email)) {
			SignUp signup = new SignUp();
			signup.createUser(email, fname, lname, username, password);
			response.sendRedirect("UserLogin.jsp");
		} else
			response.sendRedirect("Register.jsp");

	}

}
