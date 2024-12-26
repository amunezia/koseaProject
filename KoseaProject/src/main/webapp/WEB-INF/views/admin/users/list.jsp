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
			<tr>
				<td>${userinfo.userId}</td>
				<td>${userinfo.email}</td>
				<td>${userinfo.birthDate}</td>
				<td>
					<button type="submit" class="btn btn-danger btn-sm">삭제</button>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
</div>

</div>
</div>

<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="false" />
