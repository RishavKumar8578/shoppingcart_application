<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
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
    
}

form {
    max-width: 400px;
    margin: 50px auto;
    padding: 20px;
    background-color: #ffffff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

form input[type="text"],
form input[type="email"],
form input[type="password"],
form input[type="tel"] {
    width: calc(100% - 22px);
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}


form input[type="submit"],
form a {
    display: inline-block;
    padding: 10px 20px;
    margin-top: 10px;
    background-color: #007bff;
    color: #fff;
    text-decoration: none;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

form input[type="submit"]:hover,
form a:hover {
    background-color: #0056b3;
}

</style>
</head>
<body>
	<form:form action="savecustomer" modelAttribute="customerobj">
	Enter name:  <form:input path="name" /> <br>
	Enter email:  <form:input path="email" /> <br>
	Enter password:  <form:input path="password" /> <br>
	Enter mobile:  <form:input path="mobile" /> <br>
	
	<a href="addcustomer">New Customer Registration</a> 
	<a href="customerloginform.jsp">Already Login</a>  <br>
	
	<input type="submit">
	</form:form>
</body>
</html>