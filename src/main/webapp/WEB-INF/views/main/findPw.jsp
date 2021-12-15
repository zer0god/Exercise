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
				<!-- 화연의 6/12 사용 -->
				<form method="POST" action="./findPwAction">
					<h3>비밀번호 찾기</h3>

					<!-- 이메일 입력 -->
					<label>이메일</label>
					<div class="form-group">
						<input type="Email" class="custominput" id="user_email" name="user_email"> 
					</div>

					<!-- 닉네임 입력 -->
					 <label>닉네임</label>
					<div class="form-group">
						<input type="text" class="custominput" id="user_name" name="user_name">
					</div>
					
					<div class="row">
						<div class="col-lg-3"></div>
						<div class="col-lg-6">
							<button type="submit" class="btn btn-submit btn-lg btn-block">찾기</button>
						</div>
						<div class="col-lg-3"></div>
					</div>
					
					<div class="float-center">
						<a href="./findEmail">이메일 찾기</a>
					</div>
					
					<div class="float-center">
							<a href="./">로그인 페이지로</a>
					</div>
								
				</form>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>

<script src="${path}/resources/js/common.js"></script>
</body>
</html>