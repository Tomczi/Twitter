<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style> body {text-align: center;}
            .error { color: red; }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


</head>
<body>

<h1> Register Form </h1> <br><br>


<form:form method="post" modelAttribute="user">

    username <br> <form:input path="username"/>
    <form:errors path="username" cssClass="error"/> <br><br>

    password <br> <form:password path="password"/>
    <form:errors path="password" cssClass="error"/> <br><br>

    email <br> <form:input path="email"/> <br>
    <form:errors path="email" cssClass="error"/> <br><br>

    <input type="submit" value="add an User" onclick="alert">

    <script>
        function alert() {
            alert("success");
        }
    </script>
</form:form>

</body>
</html>