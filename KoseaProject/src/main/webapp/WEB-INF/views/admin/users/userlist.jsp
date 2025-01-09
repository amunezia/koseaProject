<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />

<div class="container-fluid">
<div class="row">
<div class="col-md-2">
<div class="py-3">
<h3 class="text-center">관리자메뉴</h3>
<jsp:include page="/WEB-INF/views/admin/include/buttonPage.jsp" flush="false" />
</div>
</div>

<div class="col-md-10">
	<div class="container my-4">
	<h2>회원목록</h2>
	
	<!-- 테이블 스타일 적용 -->
	<table class="table table-bordered">
		<thead class="thead-light">
			<tr>
				<th>이름</th>
				<th>이메일</th>
				<th>생년월일</th>
				<th>회원강제삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.email}</td>
				<td>${user.birthDate}</td>
				<td>
				<form action="${pageContext.request.contextPath}/admin/users/delete" method="post">
				<input type="hidden" name="userId" value="${user.userId}">
					<button type="submit" class="btn btn-danger btn-sm">삭제</button>
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${not empty userList}">
					<div class="d-flex justify-content-center align-items-center my-4">
						<div>
							<!-- 이전 페이지 버튼 -->
							<c:if test="${currentPage > 1}">
								<form
									action="${pageContext.request.contextPath}/admin/users/userlist"
									method="get" style="display: inline;">
									<input type="hidden" name="currentPage"
										value="${currentPage - 1}" /> <input type="hidden"
										name="search" value="${param.search}" /> <input type="hidden"
										name="pageSize" value="${pageSize}" />
									<button type="submit" class="btn btn-secondary">이전</button>
								</form>
							</c:if>
	
	<!-- 페이지 번호 -->
							<c:forEach var="i" begin="1" end="${totalPages}">
								<c:if test="${i >= currentPage - 2 && i <= currentPage + 2}">
									<form
										action="${pageContext.request.contextPath}/admin/users/userlist"
										method="get" style="display: inline;">
										<input type="hidden" name="currentPage" value="${i}" /> <input
											type="hidden" name="search" value="${param.search}" /> <input
											type="hidden" name="pageSize" value="${pageSize}" />
										<button type="submit"
											class="btn ${i == currentPage ? 'btn-primary' : 'btn-outline-primary'}">${i}</button>
									</form>
								</c:if>
							</c:forEach>
							
							<!-- 다음 페이지 버튼 -->
							<c:if test="${currentPage < totalPages}">
								<form
									action="${pageContext.request.contextPath}/admin/users/userlist"
									method="get" style="display: inline;">
									<input type="hidden" name="currentPage"
										value="${currentPage + 1}" /> <input type="hidden"
										name="search" value="${param.search}" /> <input type="hidden"
										name="pageSize" value="${pageSize}" />
									<button type="submit" class="btn btn-secondary">다음</button>
								</form>
							</c:if>
	
	
	</div>
	</div>
	</c:if>
	
	</div>
</div>

</div>
</div>

<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="false" />
