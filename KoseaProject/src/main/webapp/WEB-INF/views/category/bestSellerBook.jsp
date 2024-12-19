<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="../include/header.jsp"/>

<!-- メインコンテンツ -->
<main class="container mt-4">
    <h1>도서 인키 상품</h1>
    <p>다양한 도서를 확인하고, 마음에 드는 도서를 장바구니에 추가하세요.</p>

    <!-- 商品リスト -->
    <div class="row">
        <c:forEach var="books" items="${books}">
            <div class="col-md-3 mb-4">
                <div class="card shadow-sm border-light">
                    <!-- 商品画像 -->
                    <img src="${path}/resources/images/${books.filename}" class="card-img-top" alt="${books.name}">
                    <div class="card-body">
                        <!-- 商品名 -->
                        <h5 class="card-title">${books.name}</h5>
                        <!-- 著者 -->
                        <p class="card-text text-muted">${books.author}</p>
                        <!-- 価格 -->
                        <p class="card-text font-weight-bold">${books.unitPrice / 1000},000 원</p>
                        
                        <!-- カートに追加フォーム -->
                        <form action="${path}/cart/add" method="post">
                            <input type="hidden" name="bookId" value="${books.bookId}">
                            <input type="number" name="quantity" value="1" min="1" max="10" class="form-control mb-2">
                            <button type="submit" class="btn btn-primary btn-block">장바구니에 추가</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <p>다른 상품보기↓</p>
    <a href="${path}/category/booksList" class="btn btn-primary">도서 페이지 가기</a> | <a href="${path}/" class="btn btn-primary">홈으로 가기</a>
    
</main>

<jsp:include page="../include/footer.jsp"/>
