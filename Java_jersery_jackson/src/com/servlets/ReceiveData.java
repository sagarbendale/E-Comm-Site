package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongo.Product;
import com.mongo.ProductDetails;
import com.ordermanagement.DateCheck;

/**
 * Servlet implementation class receiveData
 */
public class receiveData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public receiveData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDetails pd=new ProductDetails();

		String sentData = request.getParameter("sentData");
		HttpSession session = request.getSession();
		session.removeAttribute("receivedData");
		session.setAttribute("receivedData", sentData);
		System.out.println(session.getAttribute("receivedData"));

		if(session.getAttribute("receivedData")!=null)
		{   Product p= pd.getProduct(Double.parseDouble((String) session.getAttribute("receivedData")));
		
			DateCheck dc=new DateCheck();
			Date sdate=p.getSdate();
			Date edate=p.getEdate();
			session.setAttribute("product", p);
			if(dc.check(sdate, edate))
			{
				session.setAttribute("checkDate", "true");
				System.out.println(session.getAttribute("checkDate"));
			}
			else
			{
				session.setAttribute("checkDate", "false");

			}
			
		}

		response.sendRedirect("UserLogin.jsp");
	}

}
