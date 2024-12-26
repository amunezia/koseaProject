<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" defer></script>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/resources/css/header.css" rel="stylesheet">
<link href="${path}/resources/css/index.css" rel="stylesheet">
<link href="${path}/resources/css/footer.css" rel="stylesheet">

<script type="module" defer src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule defer src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>


<title>메인 페이지</title>
</head>
<body>

 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
   <a class="navbar-brand" href="${path}/" aria-label="홈">
     <span class="icon"><ion-icon name="home-outline"></ion-icon></span>
   </a>
   <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
    <span class="navbar-toggler-icon"></span>
   </button>
   <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
     <li class="nav-item"><a class="nav-link" href="${path}/qna/qna">Q&A</a></li>
     <!-- 상품보기 ホバードロップダウン -->
     <li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle" href="#" id="productDropdown" role="button" aria-haspopup="true" aria-expanded="false">
       상품보기
      </a>
      <ul class="dropdown-menu" aria-labelledby="productDropdown">
       <li><a class="dropdown-item" href="${path}/category/sports">스포츠</a></li>
       <li><a class="dropdown-item" href="${path}/category/clothing">의류</a></li>
       <li><a class="dropdown-item" href="${path}/category/electronics">가전 제품</a></li>
       <li><a class="dropdown-item" href="${path}/category/booksList">도서</a></li>
      </ul>
     </li>
    </ul>
    
    <form class="d-flex">
        <input class="form-control me-0" type="search" placeholder="검색" aria-label="Search">
        <button class="btn btn-outline-success d-flex align-items-center me-2" type="submit">
            <ion-icon name="search-outline" class="icon-size"></ion-icon>
        </button>
    </form>

	<div class="d-flex justify-content-between align-items-center gap-3">
    <c:if test="${userinfo != null}">
        <c:if test="${userinfo.verify == 9}">

                <a class="nav-link" href="${path}/admin/index">관리자 화면</a>

        </c:if>
    </c:if>
    
    <div class="d-flex justify-content-between align-items-center gap-3">
    <c:if test="${userinfo != null}">
        <c:if test="${userinfo.verify == 5}">

                <a class="nav-link" href="${path}/seller/sellerPage">판매자 화면</a>

        </c:if>
    </c:if>

    <c:choose>
     <c:when test="${userinfo != null}">
            <span class="fw-bold">${userinfo.userId}&nbsp;님 환영합니다</span>
            <a href="${path}/logout" class="btn btn-outline-danger ms-2">로그아웃</a>
        </c:when>
        <c:otherwise>
            <a href="${path}/users/signin" class="btn btn-outline-primary me-2">로그인</a>
            <a href="${path}/users/signup" class="btn btn-outline-success me-2">회원가입</a>
            <a href="${path}/users/signup" class="btn btn-outline-success">판매자 가입</a>
        </c:otherwise>
    </c:choose>
   
    
    <a href="${path}/cart/cart" class="btn btn-outline-secondary ms-3 position-relative">
        <ion-icon name="cart" style="font-size: 1.5rem;"></ion-icon>
        <span>장바구니</span>
        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
            <c:out value="${cartCount}" default="0" />
        </span>
    </a>
   </div>
  </div>
 </nav>
</body>
</html>

