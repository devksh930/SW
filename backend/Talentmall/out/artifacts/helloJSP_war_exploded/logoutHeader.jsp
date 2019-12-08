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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/headerStyle.css">
</head>

<body>
    <div class="fixed-top">
        <div class="logo" style="height: 120px; padding-top: 15px">
            <a href="/mainPage.jsp" style="color: #000; text-decoration: none;">
                <h1 class="font_st">재능상점</h1>
                <h5 class="font_st" style="font-weight: bold">자신의 재능을 판매하고 다양한 재능을 구매하세요!</h5>
            </a>
        </div>
        <div class="menubar">
            <ul>
                <li><a href="#">홍보게시판</a>
                    <ul>
                        <li><a href="/talent/all">전체</a></li>
                        <li><a href="/talent/design">디자인</a></li>
                        <li><a href="/talent/it">IT개발</a></li>
                        <li><a href="/talent/business">비지니스문서</a></li>
                        <li><a href="/talent/text">창작&작문</a></li>
                        <li><a href="/talent/trans">번역&통역</a></li>
                        <li><a href="/talent/tutor">튜터링</a></li>
                        <li><a href="/talent/etc">기타</a></li>
                    </ul>
                </li>

                <li><a href="#">의뢰게시판</a></li>

                <li><a href="#">이용안내</a>
                    <ul>
                        <li><a href="#">생산자 이용안내</a></li>
                        <li><a href="#">소비자 이용안내</a></li>
                        <li><a href="#">환불규정 및 유의사항</a></li>
                    </ul>
                </li>

                <li><a href="#">고객센터</a>
                    <ul>
                        <li><a href="#">문의사항</a></li>
                        <li><a href="#">자주하는 질문</a></li>
                    </ul>
                </li>

                <li><a href="../login">로그인</a></li>

                <li><a href="../join">회원가입</a></li>



            </ul>
        </div>
    </div>
</body>
</html>