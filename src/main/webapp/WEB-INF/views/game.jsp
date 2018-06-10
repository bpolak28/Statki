<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            width: 20px;
            height: 20px;
            background-color: floralwhite;
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
            background-color: lightblue;
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
<h3>${wrongNumberOfChecks}</h3>
<br>
<form:form method="POST" commandName="fieldsForm">
<table style="text-align: center; border: solid 1px black;">
    <tr>
        <td>X</td><td>A</td><td>B</td><td>C</td><td>D</td><td>E</td><td>F</td><td>G</td><td>H</td><td>I</td><td>J</td>
    </tr>
    <tr>
        <td>1</td><td><form:checkbox path="positions" value="a1" class="checkfield"/></td><td><form:checkbox path="positions" value="b1" class="checkfield"/></td><td><form:checkbox path="positions" value="c1" class="checkfield"/></td><td><form:checkbox path="positions" value="d1" class="checkfield"/></td><td><form:checkbox path="positions" value="e1" class="checkfield"/></td><td><form:checkbox path="positions" value="f1" class="checkfield"/></td><td><form:checkbox path="positions" value="g1" class="checkfield"/></td><td><form:checkbox path="positions" value="h1" class="checkfield"/></td><td><form:checkbox path="positions" value="i1" class="checkfield"/></td><td><form:checkbox path="positions" value="j1" class="checkfield"/></td>
    </tr>
    <tr>
        <td>2</td><td><form:checkbox path="positions" value="a2" class="checkfield"/></td><td><form:checkbox path="positions" value="b2" class="checkfield"/></td><td><form:checkbox path="positions" value="c2" class="checkfield"/></td><td><form:checkbox path="positions" value="d2" class="checkfield"/></td><td><form:checkbox path="positions" value="e2" class="checkfield"/></td><td><form:checkbox path="positions" value="f2" class="checkfield"/></td><td><form:checkbox path="positions" value="g2" class="checkfield"/></td><td><form:checkbox path="positions" value="h2" class="checkfield"/></td><td><form:checkbox path="positions" value="i2" class="checkfield"/></td><td><form:checkbox path="positions" value="j2" class="checkfield"/></td>
    </tr>
    <tr>
        <td>3</td><td><form:checkbox path="positions" value="a3" class="checkfield"/></td><td><form:checkbox path="positions" value="b3" class="checkfield"/></td><td><form:checkbox path="positions" value="c3" class="checkfield"/></td><td><form:checkbox path="positions" value="d3" class="checkfield"/></td><td><form:checkbox path="positions" value="e3" class="checkfield"/></td><td><form:checkbox path="positions" value="f3" class="checkfield"/></td><td><form:checkbox path="positions" value="g3" class="checkfield"/></td><td><form:checkbox path="positions" value="h3" class="checkfield"/></td><td><form:checkbox path="positions" value="i3" class="checkfield"/></td><td><form:checkbox path="positions" value="j3" class="checkfield"/></td>
    </tr>
    <tr>
        <td>4</td><td><form:checkbox path="positions" value="a4" class="checkfield"/></td><td><form:checkbox path="positions" value="b4" class="checkfield"/></td><td><form:checkbox path="positions" value="c4" class="checkfield"/></td><td><form:checkbox path="positions" value="d4" class="checkfield"/></td><td><form:checkbox path="positions" value="e4" class="checkfield"/></td><td><form:checkbox path="positions" value="f4" class="checkfield"/></td><td><form:checkbox path="positions" value="g4" class="checkfield"/></td><td><form:checkbox path="positions" value="h4" class="checkfield"/></td><td><form:checkbox path="positions" value="i4" class="checkfield"/></td><td><form:checkbox path="positions" value="j4" class="checkfield"/></td>
    </tr>
    <tr>
        <td>5</td><td><form:checkbox path="positions" value="a5" class="checkfield"/></td><td><form:checkbox path="positions" value="b5" class="checkfield"/></td><td><form:checkbox path="positions" value="c5" class="checkfield"/></td><td><form:checkbox path="positions" value="d5" class="checkfield"/></td><td><form:checkbox path="positions" value="e5" class="checkfield"/></td><td><form:checkbox path="positions" value="f5" class="checkfield"/></td><td><form:checkbox path="positions" value="g5" class="checkfield"/></td><td><form:checkbox path="positions" value="h5" class="checkfield"/></td><td><form:checkbox path="positions" value="i5" class="checkfield"/></td><td><form:checkbox path="positions" value="j5" class="checkfield"/></td>
    </tr>
    <tr>
        <td>6</td><td><form:checkbox path="positions" value="a6" class="checkfield"/></td><td><form:checkbox path="positions" value="b6" class="checkfield"/></td><td><form:checkbox path="positions" value="c6" class="checkfield"/></td><td><form:checkbox path="positions" value="d6" class="checkfield"/></td><td><form:checkbox path="positions" value="e6" class="checkfield"/></td><td><form:checkbox path="positions" value="f6" class="checkfield"/></td><td><form:checkbox path="positions" value="g6" class="checkfield"/></td><td><form:checkbox path="positions" value="h6" class="checkfield"/></td><td><form:checkbox path="positions" value="i6" class="checkfield"/></td><td><form:checkbox path="positions" value="j6" class="checkfield"/></td>
    </tr>
    <tr>
        <td>7</td><td><form:checkbox path="positions" value="a7" class="checkfield"/></td><td><form:checkbox path="positions" value="b7" class="checkfield"/></td><td><form:checkbox path="positions" value="c7" class="checkfield"/></td><td><form:checkbox path="positions" value="d7" class="checkfield"/></td><td><form:checkbox path="positions" value="e7" class="checkfield"/></td><td><form:checkbox path="positions" value="f7" class="checkfield"/></td><td><form:checkbox path="positions" value="g7" class="checkfield"/></td><td><form:checkbox path="positions" value="h7" class="checkfield"/></td><td><form:checkbox path="positions" value="i7" class="checkfield"/></td><td><form:checkbox path="positions" value="j7" class="checkfield"/></td>
    </tr>
    <tr>
        <td>8</td><td><form:checkbox path="positions" value="a8" class="checkfield"/></td><td><form:checkbox path="positions" value="b8" class="checkfield"/></td><td><form:checkbox path="positions" value="c8" class="checkfield"/></td><td><form:checkbox path="positions" value="d8" class="checkfield"/></td><td><form:checkbox path="positions" value="e8" class="checkfield"/></td><td><form:checkbox path="positions" value="f8" class="checkfield"/></td><td><form:checkbox path="positions" value="g8" class="checkfield"/></td><td><form:checkbox path="positions" value="h8" class="checkfield"/></td><td><form:checkbox path="positions" value="i8" class="checkfield"/></td><td><form:checkbox path="positions" value="j8" class="checkfield"/></td>
    </tr>
    <tr>
        <td>9</td><td><form:checkbox path="positions" value="a9" class="checkfield"/></td><td><form:checkbox path="positions" value="b9" class="checkfield"/></td><td><form:checkbox path="positions" value="c9" class="checkfield"/></td><td><form:checkbox path="positions" value="d9" class="checkfield"/></td><td><form:checkbox path="positions" value="e9" class="checkfield"/></td><td><form:checkbox path="positions" value="f9" class="checkfield"/></td><td><form:checkbox path="positions" value="g9" class="checkfield"/></td><td><form:checkbox path="positions" value="h9" class="checkfield"/></td><td><form:checkbox path="positions" value="i9" class="checkfield"/></td><td><form:checkbox path="positions" value="j9" class="checkfield"/></td>
    </tr>
    <tr>
        <td>10</td><td><form:checkbox path="positions" value="a10" class="checkfield"/></td><td><form:checkbox path="positions" value="b10" class="checkfield"/></td><td><form:checkbox path="positions" value="c10" class="checkfield"/></td><td><form:checkbox path="positions" value="d10" class="checkfield"/></td><td><form:checkbox path="positions" value="e10" class="checkfield"/></td><td><form:checkbox path="positions" value="f10" class="checkfield"/></td><td><form:checkbox path="positions" value="g10" class="checkfield"/></td><td><form:checkbox path="positions" value="h10" class="checkfield"/></td><td><form:checkbox path="positions" value="i10" class="checkfield"/></td><td><form:checkbox path="positions" value="j10" class="checkfield"/></td>
    </tr>
</table>
    <p><input type="submit"></p>
</form:form>
</body>
</html>
