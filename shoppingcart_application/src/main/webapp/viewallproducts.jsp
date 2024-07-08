

<%@page import="com.jsp.shoppingcart_application.dto.Product"%>
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
    text-decoration: none;
    color: #007bff;
    
}

a:hover {
    color: #0056b3;
}

.add-button {
    display: inline-block;
    padding: 8px 16px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.add-button:hover {
    background-color: #0056b3;
}

</style>
</head>
<body>

<%List<Product> products = (List<Product>) request.getAttribute("productslist"); %>

<table cellPadding="20px" border="1">
	
	<th>brand</th>
	<th>category</th>
	<th>price</th>
	<th>add</th>
	
	
	<% for(Product p: products){ %>
		<tr>
			<td><%=p.getBrand() %></td>
			<td><%=p.getCategory()%></td>
			<td><%=p.getPrice() %></td>
			<td><a href="additem?id=<%=p.getId()%>">Add items</a></td>
			
		</tr>
		<%
		}
		%>
	
</table>
<a href="fetchitemsfromcart">view cart</a>
</body>
</html>