<%--
  Created by IntelliJ IDEA.
  User: devksh930
  Date: 2019/11/12
  Info: commission list
  Time: 9:02 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>재능상점</title>
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="./css/sectionStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body class="mt-body">
<div class="size">
    <div class="intro_st font">
        <h3 style="text-align: center; margin-top: 13px;">사이트 소개</h3>
        <p style="padding-top: 5px;">
            방문해주셔서 감사합니다.
            <br>
            시들어 가는 노년에게서 구하지 못할 바이며 오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 황금시대다
            <br> 우리는 이 황금시대의 가치를 충분히 발휘하기 위하여 이 황금시대를 영원히 붙잡아 두기
        </p>
    </div>

    <div class="car_st">
        <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2500">
            <!-- Indicators 위치 나타내는 점 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <div class="carousel-inner">
                <div class="item active">
                    <img src="img/car1.png" alt="First slide">
                    <!-- alt : 이미지가 보이지 않을 때 대체 텍스트 -->
                </div>

                <div class="item">
                    <img src="img/car2.png" alt="Second slide">
                </div>

                <div class="item">
                    <img src="img/car3.png" alt="Third slide">
                </div>
            </div>

            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>
    </div>
</div>

<div class="btn_con_st">
    <button class="btn-st font" onclick="location.href='/talent/all'">전체</button>
    <button class="btn btn-st font" onclick="location.href='/talent/design'">디자인</button>
    <button class="btn btn-st font" onclick="location.href='/talent/it'">IT개발</button>
    <button class="btn btn-st font" onclick="location.href='/talent/business'">비즈니스 문서</button>
    <p></p>
    <button class="btn btn-st font" onclick="location.href='/talent/text'">창작&작문</button>
    <button class="btn btn-st font" onclick="location.href='/talent/trans'">번역&통역</button>
    <button class="btn btn-st font" onclick="location.href='/talent/tutor'">튜터링</button>
    <button class="btn btn-st font" onclick="location.href='/talent/etc'">기타</button>
</div>
</body>
</html>