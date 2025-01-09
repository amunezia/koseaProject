<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="../include/header.jsp" flush="false"/>

<div>글 번호</div>
<div>${qnaView.qna_no}</div>
<div>구분</div>
<div>${qnaView.qna_tag}</div>
<div>글 작성 날짜</div>
<div><fmt:formatDate type="date" value="${qnaView.qna_date}"/></div>
<div>글 제목</div>
<div>${qnaView.qna_title}</div>
<div>내용</div>
<div>${qnaView.qna_content}</div>
<div>작성자</div>
<div>${qnaView.qna_writer}</div>


<c:if test="${userinfo.userId==qnaView.qna_writer}">
<div>
	<a href="${path}/qna/qnaDelete?qna_no=${qnaView.qna_no}">삭제</a>
	<a href="${path}/qna/qnaModify?qna_no=${qnaView.qna_no}">수정</a>
</div>
</c:if>

<!-- 답글 -->
<c:forEach var="come" items="${come}">
<div>담당자</div>
<div>${come.userId}</div>
<div>답글내용</div>
<div>${come.qna_rcontent}</div>
<div>작성날짜</div>
<div><fmt:formatDate type="date" value="${come.qna_date}"/></div>
<c:if test="${userinfo.verify==9}">
	<a href="${path}/qna/qnaReModify?qna_no=${come.qna_no}&qna_rno=${come.qna_rno}">수정</a>
	<a href="${path}/qna/qnaReDelete?qna_no=${come.qna_no}&qna_rno=${come.qna_rno}">삭제</a>
</c:if>
</c:forEach>

<c:if test="${userinfo.verify==9}">
<form action="${path}/qna/qnaRe"method="post">
	<input type="hidden" name="qna_no" value="${qnaView.qna_no}">
	<div>
		<label>작성자</label>
		<input type="text" name="userId" value="${userinfo.userId}" readonly>
	</div>
	<div>
		<textarea name="qna_rcontent" placeholder="답변내용"></textarea>
	</div>
	<input type="submit" value="작성">
</form>
</c:if>

<jsp:include page="../include/footer.jsp" flush="false"/>