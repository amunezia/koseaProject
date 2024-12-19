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

<div>
	<ul>
    	<c:if test="${page.prev}">
			<li ><a href="${path}/qna/qnaList?num=${page.startPageNum - 1}">[이전]</a></li>
        </c:if>
        
		<c:forEach begin='${page.startPageNum}' end="${page.endPageNum}" var="num">
        	<li> <c:if test="${select == num}"></c:if>
	            <a href="${path}/qna/qnaList?num=${num}">
		            <c:if test="${select == num}"><b>${num}</b></c:if>
		            <c:if test="${select != num}">${num}</c:if>
	            </a>
            </li>
		</c:forEach>
            
         <c:if test="${page.next}">
        	<li ><a href="${path}/qna/qnaList?num=${page.endPageNum + 1}">[다음]</a></li>
    	</c:if>
	</ul>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>