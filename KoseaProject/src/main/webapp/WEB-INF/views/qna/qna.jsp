<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="../include/header.jsp"/>

<div class="col-md-12">
<div class="container">
<div class="row">
	<div class="d-flex justify-content-center">
		<h1>QNA페이지입니다</h1>
	</div>
	<div>
	<a href="${path}/qna/qnaList" class="btn btn-secondary">QNA리스트</a>
	<c:if test="${userinfo!=null}">
		<a href="${path}/qna/writeQna" class="btn btn-secondary">QNA작성</a>
	</c:if>
	</div>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp"/>