<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%--
  Created by IntelliJ IDEA.
  User: bpolak28
  Date: 2018-05-19
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Witaj ${name}!</h1>
<br>
<p><a href="newgame">Stwórz nową grę</a></p>
<p>
        Każdy może stworzyć tylko jedną grę.
</p>
<br>
<h2>Dostępna lista gier:</h2>
<br>
<c:forEach items="${games}" var="game">
    <h3><a href="game/${game.host.name}">Gra stworzona przez: ${game.host.name}</a></h3>
    <br>
</c:forEach>
</body>
</html>
