<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet" 	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="${path}/resources/css/header.css" rel="stylesheet">

<title>메인 페이지</title>
</head>
<body>
<<<<<<< HEAD
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
	<span class="fw-bold">${userinfo.userId}&nbsp;님</span>
</c:if>
	</div>
	</div>
	</div>
=======
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="${path}/">홈</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="${path}/qna/qna">Q&A</a></li>
					<!-- 상품보기 ホバードロップダウン -->
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="productDropdown" role="button">
							상품보기
						</a>
						<ul class="dropdown-menu" aria-labelledby="productDropdown">
							<li><a class="dropdown-item" href="${path}/category/sports">스포츠</a></li>
							<li><a class="dropdown-item" href="${path}/category/clothing">의류</a></li>
							<li><a class="dropdown-item" href="${path}/category/electronics">가전 제품</a></li>
							<li><a class="dropdown-item" href="${path}/category/books">도서</a></li>
						</ul>
					</li>
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="검색" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">🔍</button>
				</form>
				<c:choose>
					<c:when test="${userinfo != null}">
						<span class="fw-bold">${userinfo.userId}&nbsp;님 환영합니다</span>
						<a href="${path}/logout" class="btn btn-outline-danger ms-2">로그아웃</a>
					</c:when>
					<c:otherwise>
						<a href="${path}/users/signin" class="btn btn-outline-primary me-2">로그인</a>
						<a href="${path}/users/signup" class="btn btn-outline-success">회원가입</a>
					</c:otherwise>
				</c:choose>
				<a href="${path}/cart/cart" class="btn btn-outline-secondary ms-3 position-relative"> 🛒 <span>장바구니</span>
					<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
						<c:out value="${cartCount}" default="0" />
					</span>
				</a>
			</div>
		</div>
	</nav>
</body>
</html>
>>>>>>> origin/juyoul_branch
