<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: devksh930
  Date: 2019/11/12
  Time: 9:02 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>HelloWorld</title>
</head>
<body>

<form action="login" method="post">
    <p><c:out value="${permission}"/></p>
    <p>ID<input type="text" name="id"></p>
    <p>PW<input type="text" name="pw"></p>
    <input type="submit" value="로그인">
    <p>${message}</p>
</form>

<p>
    <form action="join" method="post">
<p>ID <input type="text" name="id"></p>
<p>PW <input type="text" name="pw"></p>
<p>NAME <input type="text" name="name"></p>
<p>PHONE <input type="text" name="phone"></p>
<p>소비자<input type="radio" name="role" value=1> 생산자<input type="radio" name="role" value=2></p>
<input type="submit" value="회원가입">
<p>${message}</p>
</form>
<c:choose>
    <c:when test="${loginUser.id eq admin}">
        <p><c:out value="${loginUsers.id}"/>관리자로그인</p>
    </c:when>
    <c:otherwise>
        <p><c:out value="${loginUsers.id}"/>님 <c:out value="${loginUsers.name}"/></p>
    </c:otherwise>
</c:choose>
</body>
</html>
