<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%--
  Created by IntelliJ IDEA.
  User: bpolak28
  Date: 2018-05-22
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rozmieszczenie</title>
    <style>
        td {
            text-align: center;
            border: solid 1px black;
        }
        .checkfield:checked{
            -webkit-appearance: none;
            -moz-appearance: none;
            background-color: red;
            width: 20px;
            height: 20px;
            margin: 0;
            padding: 0;
        }
        .checkfield{
            -webkit-appearance: none;
            -moz-appearance: none;
            background-color: green;
            width: 20px;
            height: 20px;
            margin: 0;
            padding: 0;

        }

    </style>
</head>
<body>
<h2>
    <c:if test = "${sessionScope.name==sessionScope.gameName}">
    <p>${sessionScope.name}, grasz jako gospodarz.<p>
    </c:if>
        <c:if test = "${sessionScope.name!=sessionScope.gameName}">
        <p>${sessionScope.name}, grasz jako gość.<p>
        </c:if>
</h2>
<br>
<form method="POST">
<table style="text-align: center; border: solid 1px black;">
    <tr>
        <td>X</td><td>A</td><td>B</td><td>C</td><td>D</td><td>E</td><td>F</td><td>G</td><td>H</td><td>I</td><td>J</td>
    </tr>
    <tr>
        <td>1</td><td><input type="checkbox" name="a1" class="checkfield"></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>2</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>3</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>4</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>5</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>6</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>7</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>8</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>9</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>10</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    </tr>
</table>
    <p><input type="submit"></p>
</form>
</body>
</html>
