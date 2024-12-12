<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" flush="false"/>

<form method="post">
	<div>
		<input type="text" name="qna_title" placeholder="제목">
	</div>
	<div>
		<textarea name="qna_content" placeholder="내용"></textarea>
	</div>
	<div>
		<input type="submit" value="제출">
	</div>
</form>

<jsp:include page="../include/footer.jsp" flush="false"/>