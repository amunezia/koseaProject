<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<jsp:include page="../include/header.jsp" flush="false"/>

<form method="post">
	<div>
		<select name="qna_tag">
			<option value="구매">구매</option>
			<option value="환불">환불</option>
			<option value="제품">제품</option>
		</select>
	</div>
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