<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" flush="false"/>
<link rel="stylesheet" href="${path}/resources/css/sign.css">


<div class="container">
<div class="row justify-content-center h-100">
<div class="col-md-6 col-lg-4">
	
	<c:if test="${not empty message}">
    <div class="alert alert-danger">
        ${message}
    </div>
</c:if>

<form method="post" class="card mt-5 p-4 px-3">
	<div class="form-group d-flex justify-content-center">
		<input type="text" name="userId" placeholder="아이디" class="form-control mb-3">
	</div>
	<div class="form-group d-flex justify-content-center">
		<input type="password" name="userPw" placeholder="비밀번호" class="form-control mb-5">
	</div>
	<div class="form-group d-flex justify-content-evenly">
		<a href="${path}/users/signup" class="custom-link">회원가입</a>
		<a href="${path}/users/findid" class="custom-link">아이디 찾기</a>
		<a href="${path}/users/findpw" class="custom-link">비밀번호 찾기</a>
	</div>
	<div class="d-flex justify-content-end">
		<input type="submit" value="로그인" class="btn btn-outline-primary mt-5 mb-3 me-3">
	</div>
</form>
<script>

</script>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>