<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="login.title"/></title>
</head>
<body>
<form action="submit.do" method="post">
<p>
	<label><spring:message code="email"/>:<br>
	<input type="email" name="email" id="email">
	<form:errors path="email"/>
	</label>
	</p>
	<p>
	<label><spring:message code="password"/><br>
	<input type="password" name="pw" id="pw">
	<form:errors path="pw"/>
	</label>
	</p>
	<input type="submit" value="<spring:message code="login.btn"/>">
	</form>

</body>
</html>