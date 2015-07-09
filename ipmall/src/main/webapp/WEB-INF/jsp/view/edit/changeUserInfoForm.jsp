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
	<form action="submitChangeUserInfo.do" method="post">
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
	
		<input type="submit" value="<spring:message code="change.btn"/>">
	</form>
</body>
</html>