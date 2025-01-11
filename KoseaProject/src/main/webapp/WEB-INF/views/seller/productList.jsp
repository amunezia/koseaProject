<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 목록</title>
    <link href="${pageContext.request.contextPath}/resources/css/seller.css" rel="stylesheet">
</head>
<body>
    <div class="container my-5">
        <h1 class="text-center mb-4">상품 목록</h1>

        <!-- 商品リストテーブル -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">상품 이름</th>
                    <th scope="col">가격</th>
                    <th scope="col">재고</th>
                    <th scope="col">카테고리</th>
                    <th scope="col">상태</th>
                    <th scope="col">작업</th>
                </tr>
            </thead>
            <tbody>
                <!-- 商品リストをループで表示 -->
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>${product.productName}</td> <!-- 商品名 -->
                        <td>${product.price}</td> <!-- 価格 -->
                        <td>${product.stock}</td> <!-- 在庫 -->
                        <td>
                            <c:choose>
                                <c:when test="${product.categoryId == 1}">스포츠</c:when>
                                <c:when test="${product.categoryId == 2}">의류</c:when>
                                <c:when test="${product.categoryId == 3}">가전제품</c:when>
                                <c:when test="${product.categoryId == 4}">도서</c:when>
                            </c:choose>
                        </td> <!-- カテゴリ -->
                        <td>
                            <c:choose>
                                <c:when test="${product.stock > 0}">판매중</c:when>
                                <c:otherwise>품절</c:otherwise>
                            </c:choose>
                        </td> <!-- 商品の状態 -->
                        <td>
                            <!-- 商品編集と削除のリンク -->
                            <a href="${pageContext.request.contextPath}/seller/editProduct/${product.productId}"
                                class="btn btn-warning btn-sm">수정</a>
                            <a href="${pageContext.request.contextPath}/seller/deleteProduct/${product.productId}"
                                class="btn btn-danger btn-sm" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- 商品登録ボタン -->
        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/seller/productRegister" class="btn btn-primary">상품 등록</a>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>
