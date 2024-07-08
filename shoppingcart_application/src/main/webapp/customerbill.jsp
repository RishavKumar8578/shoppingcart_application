
<%@page import="com.jsp.shoppingcart_application.dto.Orders"%>
<%@page import="com.jsp.shoppingcart_application.dto.Items"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
    }
     h1, h3 {
        color: #333;
        text-align: center; /* Center aligning heading tags */
    }
    h2{
        color: #333;
    }
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #f5f5f5;
    }
</style>
</head>
<body>

<%
	Orders o = (Orders) request.getAttribute("orderdetails");
	List<Items> items = (List<Items>) request.getAttribute("itemslist");

	%>

  <h1>Customer Bill</h1>
    <h2>Order Details</h2>
    <table cellPadding="20px" border="1">
		<th>Name</th>
		
		<th>Mobile</th>
		<th>Address</th>
		<th>T.Price</th>
		

		
		<tr>
			
			<td><%=o.getName()%></td>
			<td><%=o.getMobilenumber()%></td>
			<td><%=o.getAddresss()%></td>
			<td><%=o.getTotalprice()%></td>
			
		</tr>
		

	</table>
	
	<h2>Items Details</h2>
	
	 <table cellPadding="20px" border="1">
		<th>Brand</th>
		
		<th>Category</th>
		<th>Pid</th>
		<th>T.Price</th>
		<th>Quantity</th>
		

		<% for(Items i: items){ %>
		<tr>
			
			<td><%=i.getBrand()%></td>
			<td><%=i.getCategory()%></td>
			<td><%=i.getPid()%></td>
			<td><%=i.getPrice()%></td>
			<td><%=i.getQuantity()%></td>
			
		</tr>
			<%
		}
		%>

	</table>
    <h2>Total Price: ${orderdetails.totalprice}</h2>
    <h3>${msg}</h3>
    <h3>Thank you</h3>
</body>
</html>