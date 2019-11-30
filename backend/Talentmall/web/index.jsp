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
    <p>ID<input type="text" name="id"></p>
    <p>PW<input type="text" name="pw"></p>
    <input type="submit" value="로그인">
  <p>${message}</p>

</form>
</body>
</html>
