<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="change.pwd.title"/></title>
</head>
<body>
	<form action="changePwd.do" method="post">
	<p>
		<label><spring:message code="currentPassword" />:<br>
		<input type="password" name="currentPassword" id="currentPassword">
		<form:errors path="currentPassword"/>
		</label>
	</p>
	<p>
		<label><spring:message code ="newPassword" />:<br>
		<input type="password" name="newPassword" id="newPassword">
		<form:errors path="currentPassword"/>
		</label>
	</p>
	
		<input type="submit" value="<spring:message code="change.btn"/>">
	</form>
</body>
</html>