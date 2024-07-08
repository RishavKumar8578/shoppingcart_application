<%@page import="com.jsp.shoppingcart_application.dto.Orders"%>
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
    margin: 0;
    padding: 0;
    background-color: #f2f2f2;
}

form {
    max-width: 400px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
    text-align: center;
    color: #333;
}

input[type="text"],
input[type="number"],
input[type="date"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type="submit"] {
    background-color: #4caf50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

a {
    text-decoration: none;
    background-color: #007bff;
    color: #fff;
    padding: 10px 20px;
    border-radius: 4px;
}

a:hover {
    background-color: #0056b3;
}

</style>
</head>
<body>
<%
    // Assuming you have properly set the attributes in the servlet before forwarding to this JSP page
    Orders o = (Orders) request.getAttribute("ordersobj");
    double totalprice = (double) request.getAttribute("totalprice");
%>

<form action="saveorder" method="post">
    <h1>Payment</h1>
    <input type="hidden" name="name" value="<%= o != null ? o.getName() : "" %>">
    <input type="hidden" name="mobilenumber" value="<%= o != null ? o.getMobilenumber() : "" %>">
    <input type="hidden" name="addresss" value="<%= o != null ? o.getAddresss() : "" %>">
    
    Enter Name: <input type="text" name="cardName" required> <br>
    Enter CardNumber: <input type="number" name="cardNumber" required> <br>
    Enter Expiry: <input type="date" name="expiry" required> <br>
    Enter CCV: <input type="text" name="ccv" required> <br>
    Price: <input value="<%= totalprice %>" disabled> <br>
    
    <input type="submit" value="Payment Now">
</form></body>
</html>