<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="../include/header.jsp" flush="false"/>

<div>글 번호</div>
<div>${qnaView.qna_no}</div>
<div>글 작성 날짜</div>
<div><fmt:formatDate type="date" value="${qnaView.qna_date}"/></div>
<div>글 제목</div>
<div>${qnaView.qna_title}</div>
<div>내용</div>
<div>${qnaView.qna_content}</div>
<div>작성자</div>
<div>${qnaView.qna_writer}</div>

<c:if test="${userinfo.verify==9}">
<div><a href="#">답하기</a></div>
</c:if>

<c:if test="${userinfo.userId==qnaView.qna_writer}">
<div>
	<a href="${path}/qna/qnaDelete?qna_no=${qnaView.qna_no}">삭제</a>
	<a href="${path}/qna/qnaModify?qna_no=${qnaView.qna_no}">수정</a>
</div>
</c:if>
<jsp:include page="../include/footer.jsp" flush="false"/>