<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" flush="false"/>
<link rel="stylesheet" href="${path}/resources/css/sign.css">


<div class="container">
    <div class="row justify-content-center h-100" >
       <h1 class="text-center">아이디 찾기</h1>
        
        	 <div class="col-md-6 col-lg-6">
        	   <div  class="card mt-5 p-4 px-3">
                <div class="d-flex justify-content-center">
                <c:if test="${userId != null}">
                    <h3>아이디는 <a class="resultid">${userId}</a> 입니다 </h3>
                </c:if>
                 <c:if test="${userId == null}">
                    <h3>회원정보를 찾을 수 없습니다 </h3>
                </c:if>
                </div>
                <div class="d-flex justify-content-end">
                    <a href="${path}/users/signin" class="btn btn-outline-primary mt-5 mb-3 me-3"> 로그인페이지로</a>
                </div>
                
            </div>
        </div>      
    </div>
</div>


<jsp:include page="../include/footer.jsp" flush="false"/>