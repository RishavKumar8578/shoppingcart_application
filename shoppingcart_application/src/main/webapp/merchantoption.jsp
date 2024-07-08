<%@page import="com.jsp.shoppingcart_application.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${msg}
	<%
	Merchant m = (Merchant)session.getAttribute("merchantinfo");
	
	if(m!=null){
		%>
		<h1>
			<a href="addproduct">Add Product</a>
		</h1>
		<h1>
			<a href="viewallproducts">viewallproduct</a>
		</h1>
		<% 
	}else {
		%>
		
		<a href="merchantloginform.jsp">login first</a>
	
	<% 
	}
	%>

</body>
</html>