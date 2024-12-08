<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<link href="${path}/resources/css/header.css" rel="stylesheet">
    <title>메인 페이지</title>
</head>
<body>
	<div class="container">
	<div class="row">
	<div class="col-md-12">
	<a class="main" href="${path}/">홈</a>
	<a class="main" href="${path}/qna/qna">Q&A </a>
	<c:if test="${userinfo==null}">
	<a class="main" href="${path}/users/signin">로그인</a>
	<a class="main" href="${path}/users/signup">회원가입</a>
</c:if>
	<c:if test="${userinfo!=null}">
	<a href="/mypage" class="main">마이페이지</a>
	<a href="/logout" class="main">로그아웃</a>
	<span class="fw-bold">${userinfo.userId}&nbsp;님 환영합니다</span>
</c:if>
	</div>
	</div>
	</div>