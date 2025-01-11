<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>판매 데이터</title>
    <link href="${path}/resources/css/seller.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <div class="container my-5">
        <h1 class="text-center mb-4">판매 데이터</h1>

        <!-- 売上グラフ（Chart.jsを使用）-->
        <div class="mb-4">
            <canvas id="salesChart" width="400" height="200"></canvas>
        </div>

        <!-- 売上リスト -->
        <h3>판매 내역</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">날짜</th>
                    <th scope="col">상품명</th>
                    <th scope="col">판매 수량</th>
                    <th scope="col">판매 금액</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sale" items="${sales}">
                    <tr>
                        <td>${sale.saleDate}</td>
                        <td>${sale.productName}</td>
                        <td>${sale.quantity}</td>
                        <td>${sale.totalPrice}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- 売上合計 -->
        <div class="text-end">
            <h4 class="fw-bold">총 판매 금액: ${totalSales}</h4>
        </div>
    </div>

    <script>
        // 売上データをグラフとして表示
        var ctx = document.getElementById('salesChart').getContext('2d');
        var salesChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ${chartLabels}, // グラフのラベル
                datasets: [{
                    label: '판매 금액',
                    data: ${chartData}, // グラフに表示するデータ
                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>

</body>
</html>

<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="false" />
