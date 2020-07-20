<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<h1>구구단</h1>	
	<form action="/portpolio/gugu/result">	
	단수 입력 : <input type="text" name="number">
	<button>전송</button> <br>
	결과 : <br>
	${requestScope.result }
	</form>
</body>
</html>