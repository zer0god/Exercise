<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${path}/resources/css/login.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
				<form method="POST" action="./loginAction">
					<h3>로그인</h3>

					<!-- 이메일 입력 -->
					<label> 
						이메일
					</label>
					<div class="form-group">
						<input type="Email" class="custominput"> 
					</div>
	
					<!-- 비밀번호 입력 -->
					<label>
					      비밀번호
				    </label>
					<div class="form-group">
						<input type="password" class="custominput">
					</div>
					

					<!-- 로그인 정보 저장 -->
					<div class="forgot-pass">
						<span class="forgot-item">아이디 저장</span> 
						<input class="forgot-item" type="checkbox">
					</div>
					
					<div class="row">
						<div class="col-lg-4 find_div">
							<a href="./findEmail">이메일 찾기</a>
						</div>
						<div class="col-lg-4 find_div">
							<a href="./findPw">비밀번호 찾기</a>
						</div>
						<div class="col-lg-4">
							<a href="./join">회원가입</a>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-3"></div>
						<div class="col-lg-6">
							<button type="submit" class="btn btn-submit btn-lg btn-block">로그인</button>
						</div>
						<div class="col-lg-3"></div>
					</div>
								
				</form>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>

</body>
</html>