
<%@page import="com.jsp.shoppingcart_application.dto.Items"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
    text-align: center;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

th, td {
    padding: 10px;
    border: 1px solid #ccc;
}

th {
    background-color: #f2f2f2;
}

tr:hover {
    background-color: #f5f5f5;
}

a {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    text-decoration: none;
    border-radius: 5px;
}

a:hover {
    background-color: #0056b3;
}

</style>
</head>
<body>
	<%
	List<Items> items = (List<Items>) request.getAttribute("itemslist");
	double totalprice = (double) request.getAttribute("totalprice");
	%>

	<table cellPadding="20px" border="1">
		<th>Brand</th>
		
		<th>Category</th>
		<th>Price</th>
		<th>Quantity</th>
		

		<%
		for (Items i : items) {
		%>
		<tr>
			<td><%=i.getBrand()%></td>
			<td><%=i.getCategory()%></td>
			<td><%=i.getPrice()%></td>
			<td><%=i.getQuantity()%></td>
			
		</tr>
		<%
		}
		%>

	</table>
	<h2>TotalPrice :<%=totalprice%> </h2>
	<br>

	<a href="addorder">Buy Now</a>

</body>
</html>