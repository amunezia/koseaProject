<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="../include/header.jsp"/>
<h1>QNA페이지입니다</h1>
<a href="${path}/qna/qnaList">QNA리스트</a>
<c:if test="${userinfo!=null}">
	<a href="${path}/qna/writeQna">QNA작성</a>
</c:if>


<jsp:include page="../include/footer.jsp"/>