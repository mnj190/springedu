<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<form action="/portpolio/gugu" method="post">
		<label for="dansu">단수입력</label> <input type="text" id="dansu"
			name="dansu" />
		<button>확인</button>
	</form>
	<br>

	<c:set var="dansu" value="3" scope="page" />
	<c:forEach var="i" begin="1" end="9">
		<c:if test="${i % 2 == 0 }">
		<p>${requestScope.dansu } * ${i } = ${requestScope.dansu * i }  </p>
		</c:if>
		<c:if test="${!(i % 2 == 0) }">
		<p>${requestScope.dansu } * ${i } = ${requestScope.dansu * i }  </p>
		</c:if>
	</c:forEach>
</body>
</html>