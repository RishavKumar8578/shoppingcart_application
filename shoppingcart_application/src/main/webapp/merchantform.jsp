<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
form {
    margin: 0 auto;
    width: 300px;
}
input[type="text"], input[type="password"] {
    width: 100%;
    padding: 10px;
    margin: 5px 0;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
}
input[type="submit"] {
    background-color: #4CAF50;
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
</style>
<link rel="stylesheet" type="text/css" href="merchantform.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="savemerchant" modelAttribute="merchantobj">
	Enter name:       <form:input path="name" />
	Enter email:      <form:input path="email" />
	Enter password:   <form:input path="password" />
	
	    <input type="submit">
	</form:form>
</body>
</html>