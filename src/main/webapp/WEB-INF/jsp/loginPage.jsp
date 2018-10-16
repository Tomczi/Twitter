<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student form</title>
    <style> body {text-align: center;}</style>
</head>
<body>

<h1> Login Page </h1> <br><br>

<form:form method="post" modelAttribute="login">

    username <br> <form:input path="username"/>
    <form:errors path="username" cssClass="error"/> <br><br>

    password <br> <form:password path="password"/>
    <form:errors path="password" cssClass="error"/> <br><br>


    <input type="submit" value="Log in">


</form:form>


</body>
</html>