<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>테스트</title>
</head>
<body>
 반갑습니다.<br>
 이름 : ${name } |${requestScope.name } |${SessionScope.name } |${ApplicationScope.name }
 나이 : ${age }
</body>
</html>