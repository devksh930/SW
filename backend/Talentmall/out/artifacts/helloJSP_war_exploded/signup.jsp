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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>재능 상점</title>

    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link href="css/signup.css" rel="stylesheet" type="text/css">

</head>
<body>


   <c:if test="${loginUser eq null}">
       <hgroup>
           <h1>회원가입</h1>
       </hgroup>

       <div class="rounded">
    <form class="form" action="join" method="post" target="_self">
        <!-- 생산자 & 소비자 선택 -->

        <div class="container group">

            <section class="section section--maa ml-sm-4">
                <div class="toggle-button toggle-button--maa">
                    <input id="producer" name="role" type="radio" value="1">
                    <label for="producer" data-text="생산자"></label>
                    <div class="toggle-button__icon"></div>
                </div>
                <div class="toggle-button toggle-button--maa">
                    <input id="consumer" name="role" type="radio" value="2">
                    <label for="consumer" data-text="소비자"></label>
                    <div class="toggle-button__icon"></div>
                </div>
            </section>

        </div>

        <!-- 아이디 -->
        <div class="group">
            <input type="text" class="input" name="id"><span class="highlight"></span><span class="bar"></span>
            <label class="label">ID</label>
        </div>

        <!-- 비밀번호 -->
        <div class="group">
            <input type="password" class="input" name="pw"><span class="highlight"></span><span class="bar"></span>
            <label class="label">Password</label>
        </div>

        <!-- 이름 -->
        <div class="group">
            <input type="text" class="input" name="name"><span class="highlight"></span><span class="bar"></span>
            <label class="label">Name</label>
        </div>

        <!-- 전화번호 -->
        <div class="group">
            <input type="text" class="input" name="phone"><span class="highlight"></span><span class="bar"></span>
            <label class="label">Phone</label>
        </div>
        <p>${message}</p>
        <!-- 회원가입 버튼 -->
        <button type="submit" class="button buttonBlue2 rounded-pill">회원가입
            <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
        </button>
    </form>
   </c:if>
    <c:if test="${loginUser ne null}">
           <hgroup>
               <h1>회원정보수정</h1>
           </hgroup>

           <div class="rounded">
               <form class="form" action="/updatemember" method="post" target="_self">

           <div class="group">
            <p>ID</p>
            <input type="text" class="input" name="id" value="${loginUser.id}" readonly="readonly"/><span class="highlight"/><span class="bar"></span>
            <label class="label"></label>
        </div>

        <!-- 비밀번호 -->
        <div class="group">
            <p>PW</p>
            <input type="password" class="input" name="pw" value="${loginUser.pw}"/><span class="highlight"></span><span class="bar"></span>
            <label class="label"></label>
        </div>

        <!-- 이름 -->
        <div class="group">
            <p>name</p>
            <input type="text" class="input" name="name" value="${loginUser.name}" readonly="readonly"/><span class="highlight"></span><span class="bar"></span>
            <label class="label"></label>
        </div>

        <!-- 전화번호 -->
        <div class="group">
            <p>phone</p>
            <input type="text" class="input" name="phone" value="${loginUser.phone}"/><span class="highlight"></span><span class="bar"></span>
            <label class="label"></label>
        </div>

        <!-- 회원가입 버튼 -->
                   <button type="submit" class="button buttonBlue2 rounded-pill">회원정보수정
            <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
        </button>
        </form>
    </c:if>
</div>

</body>
</html>