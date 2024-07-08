

<%@page import="com.jsp.shoppingcart_application.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
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

</style>
</head>
<body>
<%List<Product> products = (List<Product>) request.getAttribute("productslist"); %>

<table cellPadding="20px" border="1">
	<th>id</th>
	<th>brand</th>
	<th>category</th>
	<th>price</th>
	<th>stock</th>
	<th>update</th>
	<th>delete</th>
	
	<%
	for(Product p: products){
		%>
		<tr>
			<td><%=p.getId() %></td>
			<td><%=p.getBrand() %></td>
			<td><%=p.getCategory()%></td>
			<td><%=p.getPrice() %></td>
			<td><%=p.getStock() %></td>
			<td><a href="update?id=<%=p.getId()%>">update</a></td>
			<td><a href="deleteproducts?id=<%=p.getId()%>">delete</a></td>
		</tr>
		<%
		}
		%>
	
</table>
</body>
</html>