<%--
  Created by IntelliJ IDEA.
  User: devksh930
  Date: 2019/12/06
  Time: 8:51 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<html>
<head>
    <title>로그아웃 처리</title>
</head>
<body>
<%
    session.invalidate(); // 모든세션정보 삭제
    response.sendRedirect("../mainPage.jsp"); // 로그인 화면으로 다시 돌아간다.
%>
</body>
</html>
</body>
</html>
