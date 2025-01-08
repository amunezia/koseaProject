<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<jsp:include page="../include/header.jsp" flush="false"/>
<div class="container">
<div class="row justify-content-center">
<div class="col-md-6">

<form method="post" class="form-group">
	<div class="form-floating col-2 mb-5">
		<select name="qna_tag" class="form-select" id="selectTag">
			<option value="구매">구매</option>
			<option value="환불">환불</option>
			<option value="제품">제품</option>
		</select>
		<label class="form-label" for="selectTag">QnA 분류</label>
	</div>
	<div class="from-group mb-5">
		<input type="text" name="qna_title" placeholder="제목" class="form-control">
	</div>
	<div class="from-group mb-5">
		<textarea name="qna_content" placeholder="내용" class="form-control"></textarea>
	</div>
	<div class="form-group d-flex justify-content-end">
		<input type="submit" value="제출" class="btn btn-success">
		<a href="${path}/qna/qnaList" class="btn btn-secondary">뒤로가기</a>
	</div>
</form>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>