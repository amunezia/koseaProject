<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" flush="false"/>
<link rel="stylesheet" href="${path}/resources/css/sign.css">


<div class="container">
    <div class="row justify-content-center h-100">
       <h1 class="text-center">아이디 찾기</h1>
        
        <div class="col-md-6 col-lg-4">
            <form method="post" class="card mt-5 p-4 px-3" action="/users/findid/phone">
               <h2 class="text-center">휴대폰번호로 찾기</h2>
                <div class="form-group d-flex justify-content-center">
                    <input type="text" name="userName" placeholder="이름" class="form-control mb-3">
                </div>
                <div class="form-group d-flex justify-content-center">
                    <input type="text" name="phoneNum" placeholder="휴대폰번호" class="form-control mb-5">
                </div>
                <div class="d-flex justify-content-end">
                    <input type="submit" value="찾기" class="btn btn-outline-primary mt-5 mb-3 me-3">
                </div>
            </form>
        </div>

        <div class="col-md-6 col-lg-4">
            <form method="post" class="card mt-5 p-4 px-3" action="/users/findid/email">
       	     <h2 class="text-center">이메일로 찾기</h2>
                <div class="d-flex justify-content-center">
                    <input type="text" name="email" placeholder="이메일주소" class="form-control mb-3">
                </div>
                <div class="d-flex justify-content-end">
                    <input type="submit" value="찾기" class="btn btn-outline-primary mt-5 mb-3 me-3">
                </div>
            </form>
        </div>
        
    </div>
</div>


<jsp:include page="../include/footer.jsp" flush="false"/>