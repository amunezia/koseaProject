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
	<div class="d-flex mb-3">
		<a href="${path}/qna/qnaList" class="me-auto btn btn-secondary">목록으로</a>
		<c:if test="${userinfo.userId==qnaView.qna_writer}">
			<a href="${path}/qna/qnaDelete?qna_no=${qnaView.qna_no}" class="btn btn-danger">삭제</a>
			<a href="${path}/qna/qnaModify?qna_no=${qnaView.qna_no}" class="btn btn-warning">수정</a>
		</c:if>
	</div>
<table class="table table-borderless mb-3">
	<tr>
		<td class="d-flex justify-content-center">${qnaView.qna_title}</td>
	</tr>
	<tr>
		<td class="d-flex justify-content-end">작성자 : ${qnaView.qna_writer}</td>
	</tr>
	<tr>
		<td class="d-flex justify-content-end">작성 날짜 : <fmt:formatDate type="date" value="${qnaView.qna_date}"/></td>
	</tr>
	<tr>
		<td class="d-flexx justify-content-start">${qnaView.qna_content}</td>
	</tr>
	<tr>
		<td>
			<c:if test="${userinfo.verify==9}">
			<form action="${path}/qna/qnaRe"method="post">
				<input type="hidden" name="qna_no" value="${qnaView.qna_no}">
				<div class="form-group d-flex">
					<input type="hidden" name="userId" value="${userinfo.userId}">
					<textarea name="qna_rcontent" placeholder="답변내용" class="form-control"></textarea>
					<input type="submit" value="작성" class="btn btn-success">
				</div>
			</form>
			</c:if>
		</td>
	</tr>
</table>



<!-- 답글 -->
<table class="table">
	<c:forEach var="come" items="${come}">
	<tr>
		<td>
			<div class="d-flex">
			<span class="me-auto">담당자 : ${come.userId}</span>
			<span>작성 날짜 : <fmt:formatDate type="date" value="${come.qna_date}"/></span>
			<c:if test="${userinfo.verify==9}">
				<span>
					<a href="${path}/qna/qnaReModify?qna_no=${come.qna_no}&qna_rno=${come.qna_rno}">수정</a> /
					<a href="${path}/qna/qnaReDelete?qna_no=${come.qna_no}&qna_rno=${come.qna_rno}">삭제</a>
				</span>
			</c:if>
			</div>
			<span class="d-flex mt-3">${come.qna_rcontent}</span>
		</td>
		
	</tr>
	</c:forEach>
</table>

</div>
</div>
</div>


<jsp:include page="../include/footer.jsp" flush="false"/>