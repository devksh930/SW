<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>재능 상점</title>

    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="./css/login.css" rel="stylesheet" type="text/css">


</head>
<body>

<hgroup>
    <h1>로그인</h1>
</hgroup>

<div class="rounded">
    <form class="form" action="login" target="_self" method="post">
        <div class="group">
            <input type="text" name="id"><span class="highlight"></span><span class="bar"></span>
            <label>ID</label>
        </div>
        <div class="group">
            <input type="password" name="pw"><span class="highlight"></span><span class="bar"></span>
            <label>Password</label>
        </div>

        <button type="submit" class="button buttonBlue rounded-pill">로그인
            <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
        </button>
    </form>
</div>


</body>
</html>