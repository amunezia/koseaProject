<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 등록</title>
    <link href="${path}/resources/css/seller.css" rel="stylesheet">
</head>
<body>
    <div class="container my-5">
        <h1 class="text-center mb-4">상품 등록</h1>
        <form action="${path}/seller/registerProduct" method="post">
            <!-- 商品名 -->
            <div class="mb-3">
                <label for="productName" class="form-label">상품 이름</label>
                <input type="text" class="form-control" id="productName" name="productName" required>
            </div>

            <!-- 価格 -->
            <div class="mb-3">
                <label for="price" class="form-label">상품 가격</label>
                <input type="number" class="form-control" id="price" name="price" required>
            </div>

            <!-- 商品説明 -->
            <div class="mb-3">
                <label for="description" class="form-label">상품 설명</label>
                <textarea class="form-control" id="description" name="description" rows="3"></textarea>
            </div>

            <!-- カテゴリー -->
            <div class="mb-3">
                <label for="category" class="form-label">카테고리</label>
                <select class="form-select" id="category" name="categoryId" required>
                    <option value="1">스포츠</option>
                    <option value="2">의류</option>
                    <option value="3">가전제품</option>
                    <option value="4">도서</option>
                </select>
            </div>

            <!-- 在庫数 -->
            <div class="mb-3">
                <label for="stock" class="form-label">재고 수</label>
                <input type="number" class="form-control" id="stock" name="stock" required>
            </div>

            <button type="submit" class="btn btn-primary">등록</button>
        </form>
    </div>

    <jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>
