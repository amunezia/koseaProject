<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="../include/header.jsp" flush="false"/>

<form method="post">
<div>
	<input type="text" name="useerId" value="${come.userId}" readonly>
</div>
<div>
	<textarea name="qna_rcontent">${come.qna_rcontent}</textarea>
</div>
<input type="submit" value="수정">
</form>

<jsp:include page="../include/footer.jsp" flush="false"/>