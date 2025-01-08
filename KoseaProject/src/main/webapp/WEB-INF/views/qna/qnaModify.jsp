<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row justify-content-center">
<div class="col-md-6">
<form method="post" class="form-group">
	<div class="form-group">
		<input type="text" name="qna_title" value="${qnaModify.qna_title}" class="form-control mb-3">
	</div>
	<div class="form-group">
		<textarea name="qna_content" class="form-control mb-3">${qnaModify.qna_content}</textarea>
	</div>
	<div class="form-group d-flex">
		<input type="submit" value="제출" class="btn btn-primary justify-content-end">
	</div>
	<a href=""
</form>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>