<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: devksh930
  Date: 2019/12/05
  Time: 3:39 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>category test</title>
</head>
<body>
    <c:forEach var="cat" items="${sectionlist}">
        <p><c:out value="${cat.idx}"/>:<c:out value="${cat.name}"/></p>
    </c:forEach>
</body>
</html>
