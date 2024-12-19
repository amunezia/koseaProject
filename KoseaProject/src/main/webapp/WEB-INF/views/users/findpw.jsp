<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" flush="false"/>
<link rel="stylesheet" href="${path}/resources/css/sign.css">


<div class="container">
    <div class="row justify-content-center h-100">
       <h1 class="text-center">비밀번호 찾기</h1>
        
        <div class="col-md-6 col-lg-4">
            <form method="post" class="card mt-5 p-4 px-3">
               <h2 class="text-center">아이디를 입력하세요</h2>
                <div class="form-group d-flex justify-content-center">
                    <input type="text" name="userId" class="form-control mb-3">
                </div>
                <div class="d-flex justify-content-end">
                    <input type="submit" value="찾기" class="btn btn-outline-primary mt-5 mb-3 me-3">
                </div>
            </form>
        </div>
    </div>
</div>


<jsp:include page="../include/footer.jsp" flush="false"/>