<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="../include/header.jsp"/>

<div class="container mt-4">
    <h1>책 목록</h1>

    <!-- 書籍リストのテーブル -->
    <table class="table table-bordered text-center align-middle">
        <thead>
            <tr>
                <th>책 ID</th>
                <th>책 이름</th>
                <th>가격</th>
                <th>저자</th>
                <th>출판사</th>
                <th>재고 수</th>
                <th>출판일</th>
                <th>파일명</th>
                <th>수량 입력</th>
                <th>작업</th>
            </tr>
        </thead>
        <tbody>
            <!-- booksリストをJSTLのc:forEachで繰り返し処理 -->
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.bookId}</td>
                    <td>${book.name}</td>
                    <td>${book.unitPrice}원</td>
                    <td>${book.author}</td>
                    <td>${book.publisher}</td>
                    <td>${book.unitsInStock}</td>
                    <td><fmt:formatDate value="${book.releaseDate}" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <img src="${pageContext.request.contextPath}/resources/images/${book.filename}" alt="${book.name}" width="50">
                    </td>
                    <!-- 数量入力フィールド -->
                    <td>
                        <form id="cartForm_${book.bookId}" action="${pageContext.request.contextPath}/cart/add" method="post">
                            <input type="hidden" name="productId" value="${book.bookId}" /> <!-- bookIdは文字列 -->
                            <input type="number" name="quantity" value="1" min="1" class="form-control" style="width: 80px; display: inline;" />
                        </form>
                    </td>
                    <!-- 「カートに追加」と「購入」ボタン -->
                    <td>
                        <!-- カートに追加ボタン -->
                        <form action="${pageContext.request.contextPath}/cart/add" method="post" style="display: inline;">
	                        <input type="hidden" name="productId" value="${book.bookId}" />
	                        <button type="submit" form="cartForm_${book.bookId}" class="btn btn-primary btn-sm">
	                            카트에 추가
	                        </button>
                        </form>
                        
                        <!-- 購入ボタン -->
                        <form action="${pageContext.request.contextPath}/buy" method="post" style="display: inline;">
                            <input type="hidden" name="bookId" value="${book.bookId}" />
                            <input type="hidden" name="quantity" value="1" />
                            <button type="submit" class="btn btn-primary btn-sm">
                                구매하기
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- ページネーション予定 -->
    <div class="pagination mt-4">
        <c:if test="${not empty books}">
            <c:forEach var="i" begin="1" end="10">
                <a href="?page=${i}" class="btn btn-light btn-sm mx-1">${i}</a>
            </c:forEach>
        </c:if>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>
