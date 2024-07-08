
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
form input[type="number"] {
    width: calc(100% - 20px);
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

form input[type="submit"] {
    display: block;
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

form input[type="submit"]:hover {
    background-color: #0056b3;
}

form input[readonly="true"] {
    background-color: #f2f2f2;
    cursor: not-allowed;
}

</style>
</head>
<body>
	
	
	
	<form:form action="additemtocart" modelAttribute="itemsobj">
	 		 <form:hidden path="pid" />
	 brand:  <form:input path="brand"  readonly="true"/> <br>
	 Category:  <form:input path="category" readonly="true" /> <br>
	 price:  <form:input path="price" readonly="true" /> <br>
	Enter quantity:  <form:input path="quantity" /> <br>
	
	
	<input type="submit">
	</form:form>

</body>
</html>