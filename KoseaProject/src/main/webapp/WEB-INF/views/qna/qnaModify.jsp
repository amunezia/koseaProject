<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="../include/header.jsp" flush="false"/>

<form method="post">
	<div>
		<input type="text" name="qna_title" value="${qnaModify.qna_title}">
	</div>
	<div>
		<textarea name="qna_content">${qnaModify.qna_content}</textarea>
	</div>
	<div>
		<input type="submit" value="제출">
	</div>
</form>

<jsp:include page="../include/footer.jsp" flush="false"/>