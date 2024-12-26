<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<jsp:include page="../include/header.jsp" flush="false"/>

<link rel="stylesheet" href="${path}/resources/css/sign.css">

<div class="container">
    <div class="row justify-content-center h-100">
        <h1 class="text-center">비밀번호 재설정</h1>
        
        <c:if test="${not empty message}">
    <div class="alert alert-danger">
        ${message}
    </div>
</c:if>
        
        <div class="col-md-6 col-lg-6">
            <div class="card mt-5 p-4 px-3">
				 <form method="post">
				    <input type="hidden" name="userId" value="${param.userId}"/>
				
				    <div class="form-group">
				        <label for="userPw">새 비밀번호</label>
				        <input type="password" name="userPw" class="form-control" required>
				    </div>
				
				    <div class="form-group">
				        <label for="userPwRe">비밀번호 확인</label>
				        <input type="password" name="userPwRe" class="form-control" required>
				    </div>
				
				    <div class="d-flex justify-content-end">
				        <button type="submit" class="btn btn-outline-primary mt-5 mb-3 me-3">비밀번호 변경</button>
				    </div>
				</form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>