<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../include/header.jsp"/>

<div class="container">
<div class="row justify-content-center">
<div class="col-md-6 col-lg-4">
<form method="post" class="card mt-5 p-4 px-3">
<div class="form-group d-flex justify-content-center">
	<input type="text" name="userId" id="userId" placeholder="아이디" class="form-control me-3 mb-3 w-75">
	<button type="button" id="idcheck" class="btn btn-secondary mb-3 ms-3 text-nowrap">아이디확인</button>
</div>
<div id="checkResult" class="text-danger d-flex justify-content-end mb-3"></div>
<div class="form-group d-flex">
	<input type="password" name="userPw" placeholder="비밀번호" class="form-control mb-3 me-3 w-100">
	<input type="password" name="userPwRe" placeholder="비밀번호확인" class="form-control mb-3 ms-3 w-100">
</div>
<div class="form-group">
	<input type="text" name="userName" placeholder="이름" class="form-control mb-3">
</div>
<div class="form-group">
	<input type="text" name="phoneNum" placeholder="전화번호" class="form-control mb-3">
</div>
<div class="form-goup">
	<input type="email" name="email" placeholder="이메일" class="form-control mb-3">
</div>
<div class="form-goup">
	<input type="text" id="datepicker" name="birthDate" class="form-control mb-3" placeholder="생년월일" readonly>
</div>
<div class="d-flex justify-content-end">
	<input type="submit" value="회원가입" class="btn btn-outline-primary">
</div>
</form>
</div>
</div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/signup.js"></script>


<jsp:include page="../include/footer.jsp"/>