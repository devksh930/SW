<%--
  Created by IntelliJ IDEA.
  User: devksh930
  Date: 2019/11/12
  Info: commission list
  Time: 9:02 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>재능상점</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body style="height: 100%; margin: 0px; padding-top: 180px;">
<c:if test="${loginUser eq null}">
    <jsp:include page="./logoutHeader.jsp" flush="true"/>
</c:if>
<c:if test="${loginUser ne null}">
    <jsp:include page="./loginHeader.jsp" flush="true"/>
</c:if>

<jsp:include page="./section.jsp" flush="true"/>
<jsp:include page="./footer.jsp" flush="true"/>
</body>
</html>