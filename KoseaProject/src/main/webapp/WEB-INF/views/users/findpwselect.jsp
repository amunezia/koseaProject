<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" flush="false"/>
<link rel="stylesheet" href="${path}/resources/css/sign.css">


<div class="container">
    <div class="row justify-content-center h-100">
       <h1 class="text-center">비밀번호 찾기</h1>
        
        <div class="col-md-6 col-lg-4 card mt-5 p-4 px-3">
        
            <form action="/users/findpw/email" method="post">
                <button type="submit" class="btn btn-outline-primary w-100 mt-3">이메일로 찾기</button>
            </form>

            <form action="" method="post">
                         <button type="submit" class="btn btn-outline-primary w-100 mt-3">휴대폰 번호로 찾기</button>
            </form>
            
        </div>
    </div>
</div>


<jsp:include page="../include/footer.jsp" flush="false"/>