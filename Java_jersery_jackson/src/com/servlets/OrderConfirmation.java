package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ordermanagement.Order;
import com.payment.CardDetail;

public class OrderConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		if(session.getAttribute("id")!=null)
		{
			Order o= new Order();
			o.setAddress1(request.getParameter("address1"));
			o.setAddress2(request.getParameter("address2"));
			o.setCity(request.getParameter("city"));
			o.setState(request.getParameter("state"));
			o.setZip(Integer.parseInt(request.getParameter("zip")));
			CardDetail c=new CardDetail(Integer.parseInt(request.getParameter("ccno")),Integer.parseInt(request.getParameter("ccsec")),request.getParameter("ccholder"),request.getParameter("cctype"));		
			System.out.println(c.getCctype());
			String uname= (String)session.getAttribute("uname");
			System.out.println(uname);
			double product_id=Double.parseDouble((String) session.getAttribute("receivedData"));
			session.removeAttribute("receivedData");
			System.out.println("from OC :"+product_id);
			o.placeorder(product_id, uname,c);
			response.sendRedirect("Cart.jsp");
			}
		}

}
