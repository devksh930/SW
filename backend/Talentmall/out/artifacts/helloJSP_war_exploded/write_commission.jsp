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
    <title>재능상점</title>

    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link href="css/write_commission.css" rel="stylesheet" type="text/css">

</head>
<body>
<h2 class="mt-5 mb-5" style="text-align: center;">재능 등록</h2>

<form action="/talentinsert" method="post" target="_self">
    <div class="container mt-5 mb-5 col-6 form">

        <table class="table table-hover">

            <!-- 카테고리 -->
            <tr>
                <td style="width: 25%;">카테고리</td>
                <td style="width: 75%;">
                    <div class="container group">
                        <c:forEach var="category" items="${categoryList}" >

                        <c:if test="${category.name ne '전체'}">
                        <section class="section section--maa">
                            <div class="toggle-button toggle-button--maa mr-4" style="float: left;">
                                <input id="${category.idx}" name="category" type="radio" value="${category.idx}">
                                <label for="${category.idx}" data-text="${category.name}"></label>
                                <div class="toggle-button__icon"></div>
                            </div>
                            </c:if>
                            </c:forEach>
                        </section>

                    </div>

                </td>
            </tr>

            <!-- 제목 -->
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" class="form-control" placeholder="제목 입력" name="title">
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" class="form-control" placeholder="작성자" name="id" value="${loginUser.id}"
                           readonly="readonly">
                </td>
            </tr>
            <tr>
                <td style="border-bottom: none;">내용</td>
                <td style="border-bottom: none;">
                    <textarea class="form-control" rows="15" placeholder="내용 입력" name=content></textarea>
                </td>
            </tr>

        </table>

        <!-- 이전, 재능 등록, 초기화 버튼 -->
        <div class="container text-center mt-5" style="display: table;">
            <div style="display: table-cell; text-align: center; vertical-align: middle;">
                <div style="display: inline-block; width: 60%">
                    <button type="button" class="button buttonBlue rounded-pill mr-sm-1 ml-sm-2"
                            style="width: 32%; float: left">이전
                        <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
                    </button>
                    <button type="submit" class="button buttonBlue rounded-pill mr-sm-1"
                            style="width: 32%; float: left;">재능등록
                        <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
                    </button>
                    <button type="reset" class="button buttonBlue rounded-pill" style="width: 32%; float: left;">초기화
                        <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
                    </button>
                </div>
            </div>
        </div>

    </div>
</form>


</body>
</html>