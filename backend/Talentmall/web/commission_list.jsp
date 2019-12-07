<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: devksh930
  Date: 2019/11/12
  Time: 9:02 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${loginUser eq null}">
    <jsp:include page="logoutHeader.jsp" flush="true"/>
</c:if>
<c:if test="${loginUser ne null}">
    <jsp:include page="loginHeader.jsp" flush="true"/>
</c:if>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>재능상점</title>

    <!-- 순서 꼭 이거여야 함 -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link href="../../font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../../css/commission_list.css" rel="stylesheet" type="text/css">

</head>
<body>

<div class="container p-5" style="margin-top: 150px;">

    <!-- bar -->
    <nav class="main-nav d-none d-lg-block mb-5 p-3 ml-sm-2">
        <ul>
            <li class="drop-down mr-sm-5"><a id="category">카테고리</a>
                <ul>
                    <li><a href="/talent/all" target="_self">전체</a></li>
                    <li><a href="/talent/design">디자인</a></li>
                    <li><a href="/talent/it">IT개발</a></li>
                    <li><a href="/talent/business">비즈니스문서</a></li>
                    <li><a href="/talent/text">창작&작문</a></li>
                    <li><a href="/talent/trans">번역&통역</a></li>
                    <li><a href="/talent/tutor">튜터링</a></li>
                    <li><a href="/talent/etc">기타</a></li>
                </ul>
            </li>
            <li class="sch">
                <input type="text" name="" class="mr-sm-1"/>
                <button type="button" class="fa fa-search rounded-circle" style="color: #fff;"></button>
            </li>
            <li class="mr-sm-2" style="float: right"><a href="/write_commission.html">재능 등록</a></li>
        </ul>
    </nav>



    <c:forEach var="list" items="${talentlist}">

    <div class="container row rounded-lg p-4 form">

        <!-- 썸네일 이미지 -->
        <div class="col-3 selector">
            <img src="../../img/bootstrap.jpg" class="rounded" alt="" style="position: relative;">
        </div>

        <!-- 제목 + 내용 -->
        <div class="col-6 form-head">
            <h1 class="mt-3 h1"><c:out value="${list.title}"/></h1>
            <h4><c:out value="${list.contents}"/></h4>
            <h1 class="position-absolute" style="bottom: 0;">10,000원</h1>
        </div>

        <!-- 작가 설명 -->
        <div class="col-3">
            <div class="container producer">
                <!-- 작가 프로필 사진 -->
                <div class="row selector pt-4" style="padding: 20%;">
                    <img src="../../img/kong1.png" class="rounded-circle" alt="">
                </div>

                <!-- 작가 이름 -->
                <div class="row">
                    <h4 style="margin:0 auto;"><c:out value="${list.member_id}"/></h4>
                </div>
            </div>
        </div>

    </div>
    </c:forEach>


    <!--    &lt;!&ndash; 나의 혼이 담긴 페이징. . . &ndash;&gt;-->
    <!--    <div class="pagination p2 justify-content-center mt-5">-->
    <!--        <ul>-->
    <!--            <a href="#"><li> ❮ </li></a>-->
    <!--            <a href="#" class="is-active"><li>1</li></a>-->
    <!--            <a href="#"><li>2</li></a>-->
    <!--            <a href="#"><li>3</li></a>-->
    <!--            <a href="#"><li>4</li></a>-->
    <!--            <a href="#"><li>5</li></a>-->
    <!--            <a href="#"><li>6</li></a>-->
    <!--            <a href="#"><li> ❯ </li></a>-->
    <!--        </ul>-->
    <!--    </div>-->

</div>

</body>
</html>