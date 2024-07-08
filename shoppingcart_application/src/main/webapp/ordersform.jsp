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
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        form {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin: 20px auto;
            width: 300px;
        }

        form input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
	<form:form action="paymentmode" modelAttribute="ordersobj">
	Enter name: <form:input path="name" />
	Enter mobilenumber: <form:input path="mobilenumber" />
	Enter address: <form:input path="addresss" />
	<h3>Payment Mode</h3>
	 <input type="radio" id="upi" name="paymentMode" value="UPI" required="required">
    <label for="upi">UPI</label><br>
    <input type="radio" id="gpay" name="paymentMode" value="GPay" required="required">
    <label for="debitcard">DebitCard</label><br>
	<input type="submit" value="payment">
	
	</form:form>
</body>
</html>