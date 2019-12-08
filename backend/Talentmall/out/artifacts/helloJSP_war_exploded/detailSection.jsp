<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>재능상점</title>
</head>

<link href="./css/detailSectionStyle.css" rel="stylesheet" type="text/css">
<body>

<div class="section">
    <div class="section2">
        <div class="contents_form">
            <p class="title_st"><c:out value="${detailview.title}"/></p>
            <hr>
            <br>
            <c:out value="${detailview.contents}"/>
        </div>

        <button class="btn2_st" onclick="location.href='#'">목록으로</button>
    </div>

    <div class="pro_btn_con_st">
        <div class="profile_form">
            <div class="pro_info">
                <img class="img-st" src="img/01.png">
                <p class="name_st"><c:out value="${detailview.member_id}"/>
                </p>
                <p class="intro_txt" style="padding: 5px; text-align: left;">
                    소개 여기
                    구하지 못할 바이며 청춘에서만 구할 수 발휘하기 위하여 이 황금
                    <br> 우리는 이 황금시대의 가치를 충분히 발휘하기 위하여 이 황금
                </p>
            </div>
        </div>

        <button class="btn_st" onclick="location.href='#'">문의하기</button>
        <button class="btn_st" onclick="location.href='#'">주문하기</button>
    </div>
</div>

<div style="clear: both;"></div>
<div>

</div>

</body>
</html>