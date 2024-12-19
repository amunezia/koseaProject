<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<jsp:include page="../include/header.jsp" />

<main class="container mt-4">
    <h1>장바구니 내용</h1>

    <!-- カートが空の場合の表示 -->
    <c:if test="${empty cartItems}">
        <p>장바구니에 상품이 없습니다.</p>
    </c:if>

    <c:if test="${not empty cartItems}">
        <!-- カートを空にするボタン -->
        <form action="${path}/cart/clear" method="post">
            <button type="submit" class="btn btn-danger btn-sm">카트 비우기</button>
        </form>

        <!-- 合計金額用変数を初期化 -->
        <c:set var="totalAmount" value="0" />

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>상품명</th>
                    <th>단가</th>
                    <th>수량</th>
                    <th>합계</th>
                    <th>작업</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cartItems}">
                    <tr>
                        <!-- 商品名 -->
                        <td>${item.productName}</td>
                        <!-- 単価 -->
                        <td>${item.unitPrice}원</td>
                        <!-- 数量変更フォーム -->
                        <td>
                            <form action="${path}/cart/update" method="post" style="display: flex; gap: 5px;">
                                <input type="hidden" name="cartId" value="${item.cartId}" />
                                <input type="number" name="quantity" value="${item.quantity}" min="1" class="form-control" style="width: 60px;" />
                                <button type="submit" class="btn btn-primary btn-sm">수정</button>
                            </form>
                        </td>
                        <!-- 合計金額（単価×数量） -->
                        <td>
                            <c:set var="itemTotal" value="${item.unitPrice * item.quantity}" />
                            ${itemTotal}원
                        </td>
                        <!-- 削除ボタン -->
                        <td>
                            <form action="${path}/cart/remove" method="post">
                                <input type="hidden" name="cartId" value="${item.cartId}" />
                                <button type="submit" class="btn btn-danger btn-sm">삭제</button>
                            </form>
                        </td>
                        <!-- 合計金額に加算 -->
                        <c:set var="totalAmount" value="${totalAmount + itemTotal}" />
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- 合計金額の表示 -->
        <div class="text-right mt-3">
            <h3>총 결제금액: <span style="color: green;">${totalAmount}원</span></h3>
        </div>

        <!-- 購入リンク -->
        <div class="text-right mt-4">
            <a href="${path}/checkout" class="btn btn-success btn-lg">결제하기</a>
        </div>
    </c:if>
</main>

<jsp:include page="../include/footer.jsp" />
