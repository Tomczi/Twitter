<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
<h1>Hello, <c:out value="${ses.username}"/></h1>
<button name="signout"><a href="/start">Sign Out</a></button>
</div>
<br><br>


<h2>Now you can add your tweet</h2> <br>


<form:form method="post" modelAttribute="tweet">


    tweet: <form:input path="text"/>
    <form:errors path="text" cssClass="error"/> <input type="submit" value="add a tweet">

</form:form> <br><br><br><br><br><br>

<div>

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
</div>

</body>
</html>