<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="include/header.jsp"/>



<!-- メインコンテンツ -->
<main class="container mt-4">
    <h1>쇼핑몰에 오신 것을 환영합니다!</h1>
    <p>다양한 카테고리별 상품과 추천 상품을 확인해보세요.</p>

    <!-- カテゴリ別の人気商品 -->
    <section>
        <h2>카테고리별 인기 상품</h2>
        <div class="row">
            <!-- カテゴリ商品カード -->
            <div class="col-md-3">
                <div class="card">
                    <img src="${path}/resources/images/sports.jpg" class="card-img-top" alt="스포츠">
                    <div class="card-body">
                        <h5 class="card-title">스포츠 용품</h5>
                        <a href="${path}/category/sports" class="btn btn-primary">상세 보기</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card">
                    <img src="${path}/resources/images/clothes.jpg" class="card-img-top" alt="의류">
                    <div class="card-body">
                        <h5 class="card-title">의류</h5>
                        <a href="${path}/category/clothes" class="btn btn-primary">상세 보기</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card">
                    <img src="${path}/resources/images/electronics.jpg" class="card-img-top" alt="가전 제품">
                    <div class="card-body">
                        <h5 class="card-title">가전 제품</h5>
                        <a href="${path}/category/electronics" class="btn btn-primary">상세 보기</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card">
                    <img src="${path}/resources/images/books.jpg" class="card-img-top" alt="도서">
                    <div class="card-body">
                        <h5 class="card-title">도서</h5>
                        <a href="${path}/category/bestSellerBook" class="btn btn-primary">상세 보기</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
    
<jsp:include page="include/footer.jsp"/>