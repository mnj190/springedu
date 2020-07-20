<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<!-- 요청 URL: http://localhost:9080/portpolio/rtest/11/{num} -->
<!-- 요청파라미터 : 찾고자하는 사람의 번호 문자(4) -->
<!-- 응답포맷 :  
				응답코드 2자리
				응답메세지: 	이름 10자리
									나이 3자리
-->
<!-- 데이터 포맷 : json -->
<!--  -->
<script>

	window.addEventListener("load", init);	
	function init() {
		const findBtn = document.getElementById('findBtn');
		findBtn.addEventListener("click", find_f);
	}
	function find_f(event) {
		console.log(event.target.id)
		const numTag = document.getElementById('num').value;
		console.log(numTag)
		if (!numTag.value) {			
			const errmsg = document.getElementById('errmsg');
			errmsg.textContent = "번호를 입력바랍니다!!";
			errmsg.style.color = "red";
			<!-- num.select(); -->
			return false;
		}
	}

	//AJAX 호출
	var xhttp = new XMLHttpRequest();	
	xhttp.addEventListener("readystatechange", ajaxCall);
	function ajaxCall(event) {
		if (this.readyState == 4) {
			console.log(this.responseText);

			const jsonObj = JSON.parse(this.responseText);

			if (this.status == 200 || this.status == 400)
				switch (jsonObj.rtcode) {
				case "00":
					document.getEelementById('name').textContent = jsonObj.result.name;
					document.getEelementById('age').textContent = jsonObj.result.age;
					document.getEelementById('errmsg').textContent = jsonObj.msg;
					break;
				case "01":
					document.getEelementById('errmsg').textContent = jsonObj.msg;
					break;
				}
		}
	}
	
	const num = document.getElementById('num').value;
	xhttp.open("GET", "http://localhost:9080/portpolio/rtest/11/" + num);
	xhttp.send();
</script>
</head>
<body>
	<h3>사람을 찾습니다.</h3>
	<input type="text" name="num" id="num">
	<button id="findBtn">찾기</button>
	<div id="name"></div>
	<div id="age"></div>
	<div id="errmsg"></div>
	<div></div>
</body>
</html>