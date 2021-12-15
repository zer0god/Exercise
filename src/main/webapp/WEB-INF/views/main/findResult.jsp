<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZERO GOD</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${path}/resources/css/find.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 메인 네비게이션 -->
	<!-- nav : 네비게이션 리스트 HTML 태그 -->
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#">Active</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li>
		</ul>
	</nav>

	<!-- 메인 컨텐츠 -->
	<div class="container">

		<div class="row">
			<div class="col-lg-3"></div>
			<!-- 안쓰는 옆 가로 공간 배정 -->

			<div class="col-lg-6">
				<!-- 화면의 6/12 사용 -->
				<c:if test="${resultType eq 'email'}">
				<h3>이메일 찾기</h3>
				
				<c:if test="${result eq true}">
				<p>해당 닉네임으로 등록된 이메일 : </p>
				<h2>${resultMsg}</h2>
				</c:if>
				<c:if test="${result eq false}">
				<p>해당 닉네임으로 등록된 이메일이 존재하지 않습니다.</p>
				<a href="./findEmail">이메일 찾기로 돌아가기</a>
				</c:if>
				</c:if>
				
				<c:if test="${resultType eq 'email'}">
				<h3>비밀번호 찾기</h3>
				
				<c:if test="${result eq true}">
				<p>해당 닉네임으로 등록된 이메일로 임시비밀번호를 전송했습니다.</p>
				<p>전송된 비밀번호로 로그인 후 비밀번호를 변경해 주세요.</p>
				</c:if>
				<c:if test="${result eq false}">
				<p>해당 닉네임과 이메일로 등록된 정보를 찾을수 없습니다.</p>
				<a href="./findPw">비밀번호 찾기로 돌아가기</a>
				</c:if>
				</c:if>
												
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>

</body>
</html>