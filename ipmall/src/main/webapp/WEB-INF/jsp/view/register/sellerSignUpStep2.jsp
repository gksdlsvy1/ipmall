<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>회원가입</title>
</head>
<body>
	<h2>구매자 회원 정보 입력</h2>
	<form  action="sellerSignUpStep3.do"  method="post">
	<p>
		<label>이메일:<br>
		<input type="text" name="email" id="email">
		</label>
	</p>
	<p>
		<label>이름:<br>
		<input type="text" name="name" id="name">
		</label>
	</p>
	<p>
		<label>비밀번호:<br>
		<input type="password" name="password" id="password">
		</label>
	</p>
	<p>
		<label>비밀번호 확인:<br>
		<input type="password" name="confirmPassword" id="confirmPassword">
		</label>
	</p>
	<p>
		<label>전화번호:<br>
		<input type="text" name="phone" id="phone" >
		</label>
	</p>
	<p>
		<label>계좌번호:<br>
		<input type="text" name="account_num" id="account_num" >
		</label>
	</p>
	<p>
		<label>계좌 사용자 이름:<br>
		<input type="text" name="account_name" id="account_name" >
		</label>
	</p>
	<input type="submit" value="가입 완료">
	</form>
</body>
</html>