<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>판매자 회원가입</title>
</head>
<body>
	<p><strong>${user.name}님</strong> 
		회원 가입을 완료했습니다.</p>
	<p><a href="<c:url value='/view/index.do'/>">[첫 화면 이동]</a></p>
</body>
</html>