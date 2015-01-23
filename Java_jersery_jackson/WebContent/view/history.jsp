<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ordermanagement.*"%>
<%@page import="com.mongo.*"%>

<%
	UserOrders uo = new UserOrders();
	ArrayList<OrderDetails> rs = uo.getAllOrders((String) session
			.getAttribute("uname"));
	try {
		for (OrderDetails s : rs) {

			int productid = Integer.parseInt(s.getProductid());
			double dbint = productid / 1.0;
			Product p = (new ProductDetails()).getProduct(dbint);

			out.print("<tr>");
			out.print("<td \">" + "<img src=" + p.getImg()
					+ " height=\"200\" width=\"300\" >" + " "
					+ p.getBrand() + "</td>");
			out.print("<td \">" + p.getDescription()
					+ "</td>");
			out.print("<td \">" + p.getWarranty_period()
					+ "</td>");
			out.print("<td \">" + p.getPrice() + "</td>");

			out.print("<td>");
			out.print(s.getStatus() +"</td>");
			out.print("<td>");
			DateCheck dc = new DateCheck();
			
			if (s.getStatus().equals("Processing")) {


				out.print("<form action=\"CancelOrder\" method=post> <input type=\"hidden\" name=\"orderid\" value=\"");
				out.print(s.getOrderid());
				out.print("\"><button type=\"submit\" class=\"btn btn-default\">Cancel Order</button> </form>");

			} else {
				out.print("N/A");
			}

			out.print("</tr>");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>