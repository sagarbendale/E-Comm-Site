<%@page import="com.mongo.*"%>
<%
				 
					Product p = (Product) session.getAttribute("product");
			
out.print("<tr>");
			out.print("<td \">" + "<img src=" + p.getImg()
					+ " height=\"200\" width=\"300\" >" + " "
					+ p.getBrand() + "</td>");
			out.print("<td \">" + p.getDescription()
					+ "</td>");
			out.print("<td \">" + p.getWarranty_period()
					+ "</td>");
			out.print("<td \">" + p.getPrice() + "</td>");
%>