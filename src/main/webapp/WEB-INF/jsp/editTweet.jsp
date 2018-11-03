<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style> body {text-align: center;} </style>
</head>
<body>


<h1>Hello, <c:out value="${ses.username}"/></h1>
<button name="signout"><a href="/user/login">Sign Out</a></button>
<br><br>


<h2>Now you can edit your tweet</h2> <br>


<form:form method="post" modelAttribute="edit">

    tweet: <form:input path="text"/>
    <form:errors path="text" cssClass="error"/> <input type="submit" value="edit the tweet">

</form:form> <br><br><br><br><br><br>



<c:forEach items="${listOfTweets}" var="tweet">

    <table border="1" align="center">
        <tr>
            <th>User</th>
            <th>Tweet</th>
            <th>Options</th>
        </tr>
        <tr>
            <td>${tweet.user.username}</td>
            <td>${tweet.text}</td>
            <td>
                <a href="/tweet/delete/${tweet.getId()}/${tweet.user.getId()}"> Delete </a>
                <a href="/tweet/edit/${tweet.getId()}"> Edit </a>
            </td>
        </tr>
    </table>

</c:forEach>


</body>
</html>