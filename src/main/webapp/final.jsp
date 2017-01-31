<%@page import="java.util.List"%>
<%@page import="domain.model.Account"%>
<%@page import="domain.model.Profile"%>
<%@ page import="domain.model.Account" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	Account account = (Account) session.getAttribute("account");
	Profile profile = (Profile) session.getAttribute("profile");

%>
<h1>User:</h1>
<h3><%=account.getUserName()%></h3>
<h3><%=account.getUserPassword()%></h3>
<h3><%=account.getUserEmail()%></h3>
<h1>PersonalUsnformations:</h1>
<h3><%=profile.getFirstName()%></h3>
<h3><%=profile.getLastName()%></h3>
<h3><%=profile.getCity()%></h3>
<h3><%=profile.getCountry()%></h3>
<h3><%=profile.getAge()%></h3>
<form action="DbServlet" method="get">
	<input type="submit" value="Create">
</form>
</body>
</html>