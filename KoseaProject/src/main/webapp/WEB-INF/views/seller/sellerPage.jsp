<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>판매자 관리 화면</title>
    <link href="${path}/resources/css/seller.css" rel="stylesheet">
</head>
<body>
    <div class="container my-5">
        <h1 class="text-center mb-4">판매자 관리 화면</h1>
        <div class="row">
            <!-- 商品登録リンク -->
            <div class="col-md-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h5 class="card-title">상품 등록</h5>
                        <p class="card-text">새로운 상품을 등록하세요.</p>
                        <a href="${path}/seller/productRegister" class="btn btn-primary">등록하기</a>
                    </div>
                </div>
            </div>

            <!-- 商品リストリンク -->
            <div class="col-md-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h5 class="card-title">상품 목록</h5>
                        <p class="card-text">등록된 상품을 관리하세요.</p>
                        <a href="${path}/seller/productList" class="btn btn-success">목록 보기</a>
                    </div>
                </div>
            </div>

            <!-- 売上データリンク -->
            <div class="col-md-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h5 class="card-title">매출 데이터</h5>
                        <p class="card-text">매출 현황을 확인하세요.</p>
                        <a href="${path}/seller/salesData" class="btn btn-info">확인하기</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- 簡易統計情報 -->
        <div class="mt-5">
            <h2>현재 상태</h2>
            <ul>
                <li>등록된 상품 수: <strong>${productCount}</strong></li>
                <li>금월 매출: <strong>${monthlySales}</strong>원</li>
                <li>금일 주문 수: <strong>${dailyOrders}</strong></li>
            </ul>
        </div>
    </div>
</body>
</html>

<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="false" />
