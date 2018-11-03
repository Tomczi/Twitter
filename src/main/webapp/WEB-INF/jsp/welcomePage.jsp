<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style> body {text-align: center;}</style>

</head>
<body>

<h1 class="jumbotron text-center"> Welcome Page </h1> <br><br>


<button name="signUp"><a href="/user/add">Sign Up</a></button>
<button name="signIn"><a href="/user/login">Sign In</a></button>

</body>

</html>