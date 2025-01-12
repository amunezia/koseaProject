<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row justify-content-center">
<div class="col-md-6">
<form method="post">
	<div class="form-group mb-3">
		<input type="text" name="useerId" value="${come.userId}" readonly class="form-control">
	</div>
	<div class="form-group mb-3">
		<textarea name="qna_rcontent" class="form-control">${come.qna_rcontent}</textarea>
	</div>
	<div class="form-group d-flex justify-content-end">
		<input type="submit" value="수정" class="btn btn-success">
		<a href="${path}/qna/viewQna?qna_no=${come.qna_no}" class="btn btn-secondary">돌아가기</a>
	</div>
</form>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>