<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/form.css" media="screen" type="text/css" />

<title>Insert title here</title>
</head>
<body>
 <div class="login-card">
<h1>welcome <% out.print(session.getAttribute("uname")); %> </h1>
  <form action="Logout" method="post">
    
    <input type="submit" class="login login-submit" value="LOGOUT">
  </form>
</div>
</body>
</html>