<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="../include/header.jsp" flush="false"/>

<table>
	<thead>
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>글쓴이</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${qnaList}" var="list">
		<tr>
			<td>${list.qna_no}</td>
			<td><a href="${path}/qna/viewQna?qna_no=${list.qna_no}">${list.qna_title}</a></td>
			<td>${list.qna_writer}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="../include/footer.jsp" flush="false"/>