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

form input[type="email"],
form input[type="password"] {
    width: calc(100% - 22px);
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

a {
    display: inline-block;
    margin-top: 10px;
    text-decoration: underline;
    color: #007bff;
}

a:hover {
    color: #0056b3;
}

</style>
</head>
<body>
		
	
	<form action="validatecustomer">
	Enter email:<input type="email" name="email"><br>
	Enter password:<input type="password" name="password"><br>
	  <input type="submit">
	  <a href="addcustomer">New Customer Registration</a> 
	<a href="customerloginform.jsp">Already Login</a>
	</form>
	
	${msg}
</body>
</html>