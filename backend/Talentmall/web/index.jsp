<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: devksh930
  Date: 2019/11/12
  Info:
  Time: 9:02 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>TEST</title>
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
        <p><c:out value="${loginUser.id}"/>관리자로그인</p>
    </c:when>
    <c:otherwise>
        <p><c:out value="${loginUser.id}"/>님 <c:out value="${loginUser.name}"/></p>
    </c:otherwise>
</c:choose>

<%--<c:forEach var="cat" items="${list}">--%>
<%--    <p><c:out value="${cat.idx}"/>:<c:out value="${cat.name}"/></p>--%>
<%--</c:forEach>--%>
<select id="section_sel">

    <c:forEach var="section" items="${sectionlist}" >
        <c:if test="${section.category_idx eq 0}">
        <option value="<c:out value="${section.idx}"/>">
            <c:out value="${section.name}"/>
        </option>
        </c:if>
    </c:forEach>
</select>

<c:forEach var="list" items="${talentlist}">
   <p><c:out value="${list.title}"/> ----<c:out value="${list.contents}"/>----<c:out value="${list.start_date}"/>----<c:out value="${list.end_date}"/>----<c:out value="${list.member_id}"/>----<c:out value="${list.category_id}"/></p>
</c:forEach>


</body>

</html>
