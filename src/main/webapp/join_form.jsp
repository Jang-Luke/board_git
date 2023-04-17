<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
    <title>회원가입</title>
    <style>
        .create-account-form {
            display: flex;
            flex-flow: column nowrap;
        }
    </style>
</head>
<body>
<main class="container">
    <div class="row">
        <header class="col-12 d-flex justify-content-center">
            <h3>회원가입</h3>
        </header>
        <form action="/createAccount.member">
            <article class="col-12 d-flex create-account-form">
                <input type="text" class="form-control" name="joinId" placeholder="아이디를 입력해주세요.">
                <input type="text" class="form-control" name="joinPw" placeholder="비밀번호를 입력해주세요.">
                <input type="text" class="form-control" placeholder="비밀번호를 다시 입력해주세요.">
                <input type="text" class="form-control" name="joinName" placeholder="성함을 입력해주세요.">
                <input type="text" class="form-control" name="joinPhone" placeholder="전화번호를 입력해주세요.">
                <input type="text" class="form-control" name="joinEmail" placeholder="이메일을 입력해주세요.">
                <input type="text" class="form-control" name="joinZipcode" readonly>
                <input type="text" class="form-control" name="joinAddress1" readonly>
                <input type="text" class="form-control" name="joinAddress2" placeholder="상세 주소를 입력해주세요.">
            </article>
            <div class="col-12 d-flex justify-content-space-around">
                <button type="button" class="btn btn-outline-primary">회원가입</button>
                <button type="reset" class="btn btn-outline-danger">다시입력</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>
