<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false"/>

<div class="container-fluid">
<div class="row">
<div class="col-md-2">
<div class="py-3">
<h3 class="text-center">관리자메뉴</h3>
<jsp:include page="/WEB-INF/views/admin/include/buttonPage.jsp"
					flush="false" />
</div>
</div>


<div class="col-md-10">
	<div class="container">
		<div class="row">
			<div class="col-md-12 my-4">
			<h2>관리 정보</h2>
			<p>환영합니다,관리자님.</p>
			</div>
		</div>
	</div>
</div>



</div>
</div>


<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="false"/>