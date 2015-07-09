<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
	<c:if test="${empty authInfo}">
	    <p>환영합니다.</p>
	    <a href="customerSignUpStep1.do">[구매자 회원 가입하기]</a>
	    <a href="sellerSignUpStep1.do">[판매자 회원 가입하기]</a>
	    <a href="login.do">[로그인하기]</a>
    </c:if>
    <c:if test="${!empty authInfo}">
    	<p>${authInfo.name}님, 환영합니다.</p>
    	<a href="changePwdForm.do">[비밀번호수정]</a>
    	<a href="changeUserInfo.do">[회원정보수정]</a>
    	<a href="logout.do">[로그아웃하기]</a>
    	<a href="deleteUser.do">[회원 탈퇴]</a>
	</c:if>
</body>
</html>