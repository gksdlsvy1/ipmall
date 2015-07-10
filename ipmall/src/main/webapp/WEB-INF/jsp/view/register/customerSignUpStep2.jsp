<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title><spring:message code="member.register"/></title>
</head>
<body>
	<h2><spring:message code ="member.info"/></h2>
	<form  action="customerSignUpStep3.do"  method="post">
	<p>
		<label><spring:message code ="email"/>:<br>
		<input type="email" name="email" id="email">
		<form:errors name="email" id="email" path="email"/>
		</label>
	</p>
	<p>
		<label><spring:message code ="name"/>:<br>
		<input type="text" name="name" id="name">
		<form:errors path="name"/>
		</label>
	</p>
	<p>
		<label><spring:message code ="password"/>:<br>
		<input type="password" name="password" id="password">
		<form:errors path="password"/>
		</label>
	</p>
	<p>
		<label><spring:message code ="password.confirm"/>:<br>
		<input type="password" name="confirmPassword" id="confirmPassword">
		<form:errors path="confirmPassword"/>
		</label>
	</p>
	<p>
		<label><spring:message code ="phone"/>:<br>
		<input type="tel" name="phone" id="phone" >
		</label>
	</p>
	<p>
		<label><spring:message code ="accountNum"/>:<br>
		<input type="text" name="accountNum" id="accountNum" >
		</label>
	</p>
	<p>
		<label><spring:message code ="accountName"/>:<br>
		<input type="text" name="accountName" id="accountName" >
		</label>
	</p>
		<p>
		<label><spring:message code ="birthday"/>:<br>
		<input type="text" name="birthday" id="birthday" >
		</label>
	</p>
		<p>
		<label><spring:message code ="sex"/>:<br>
		남성
		<input type=radio name="sex" value='1' >
		여성
		<input type=radio name="sex" value='2' >
		</label>
	</p>
	<input type="submit" value="<spring:message code ="register.btn"/>">
	</form>
</body>
</html>