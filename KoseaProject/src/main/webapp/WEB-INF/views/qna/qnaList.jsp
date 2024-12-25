<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<jsp:include page="../include/header.jsp" flush="false"/>

<div class="col-md-12">
<div class="container">
<div class="row">
	<div class="table-responsive">
	<table class="table">
		<colgroup>
			<col width="10%">
			<col width="80%">
			<col width="10%">
		</colgroup>
		<thead>
			<tr>
				<td class="text-center">글번호</td>
				<td class="text-center">제목</td>
				<td class="text-center">글쓴이</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${qnaList}" var="list">
			<tr>
				<td class="text-center">${list.qna_no}</td>
				<td class="text-center"><a href="${path}/qna/viewQna?qna_no=${list.qna_no}" class="link-underline link-underline-opacity-0">${list.qna_title}</a></td>
				<td class="text-center">${list.qna_writer}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	<nav class="d-flex justify-content-center">
		<ul class="pagination">
			<c:if test="${page.prev}"><a href="${path}/qna/qnaList?num=${page.startPageNum-1}" class="page-link">[이전]</a></c:if>
			<c:forEach begin='${page.startPageNum}' end="${page.endPageNum}" var="num">
	        	<li class="page-item">
		            <a href="${path}/qna/qnaList?num=${num}" class="page-link">
			            <c:if test="${select == num}"><b>${num}</b></c:if>
			            <c:if test="${select != num}">${num}</c:if>
		            </a>
	            </li>
			</c:forEach>
			<c:if test="${page.next}"><a href="${path}/qna/qnaList?num=${page.endPageNum+1}" class="page-link">[다음]</a></c:if>
		</ul>
	</nav>

</div>
</div>
</div>
<jsp:include page="../include/footer.jsp" flush="false"/>