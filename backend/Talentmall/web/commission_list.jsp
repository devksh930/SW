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
            <c:if test="${loginUser.kind eq '생산자'}">
                <li class="mr-sm-2" style="float: right"><a href="/talentinsert">재능 등록</a></li>
            </c:if>
        </ul>
    </nav>


    <c:forEach var="list" items="${talentlist}">

        <div class="container row rounded-lg p-2 form">

            <!-- 썸네일 이미지 -->
            <div class="col-3 selector">
                <img src="../../img/bootstrap.jpg" class="rounded" alt="" style="position: relative;">
            </div>

            <!-- 제목 + 내용 -->
            <div class="col-6 form-head">
                <h1 class="mt-3 h1"> <a href="../detailview?idx=${list.idx}"><c:out value="${list.title}"/></a></h1>
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
        <c:if test="${list.member_id eq loginUser.id || list.member_id eq 'admin'}">
        <button type="button" class="ml-5 mr-3 mb-3"
                style="position: relative; display: inline-block; padding: 12px 24px; margin: .3em 0 1em 0; width: 80px; vertical-align: middle; color: #fff; font-size: 15px; line-height: 17px; -webkit-font-smoothing: antialiased; text-align: center; letter-spacing: 1px; background-color: #9d7566; border: 0; border-bottom: 2px solid #88472F; cursor: pointer; transition: all 0.15s ease; border-radius: 50rem;">
            수정
        </button>
        <button type="button" class="mb-3"
                style="position: relative; display: inline-block; padding: 12px 24px; margin: .3em 0 1em 0; width: 80px; vertical-align: middle; color: #fff; font-size: 15px; line-height: 17px; -webkit-font-smoothing: antialiased; text-align: center; letter-spacing: 1px; background-color: #9d7566; border: 0; border-bottom: 2px solid #88472F; cursor: pointer; transition: all 0.15s ease; border-radius: 50rem;">
            삭제
        </button>
        </c:if>
    </c:forEach>


</div>

</body>
</html>