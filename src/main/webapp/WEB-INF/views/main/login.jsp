<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
input, button {
	border: none;
	outline: none;
	background: none;
	font-family: 'Open Sans', Helvetica, Arial, sans-serif;
}

.custominput {
	display: block;
	width: 100%;
	margin-top: 5px;
	padding-bottom: 5px;
	font-size: 16px;
	border-bottom: 1px solid rgba(0, 0, 0, 0.4);
	text-align: center;
}
.submit {
  margin-top: 40px;
  margin-bottom: 20px;
  background: #d4af7a;
  text-transform: uppercase;
}
</style>
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
					<h3 style="text-align: center;">로그인</h3>

					<!-- 이메일 입력 -->
					<label> 
						<span>Email</span>
						<input type="email">
					</label>
					<div class="form-group">
						<input type="Email" class="custominput"> 
					</div>

					<!-- 비밀번호 입력 -->
					 <label>
				      <span>Password</span>
				      <input type="password">
				    </label>
					<div class="form-group">
						<input type="password" class="custominput">
					</div>
					
					<!-- 비밀번호 찾기 -->
					<label>
				      <span>Forget password?</span>
				      <input type="password">
				    </label>
					

					<!-- 로그인 정보 저장 -->
					<div class="remember">
						<label class="custom-checkbox">Remember me</label> 
						<input type="checkbox"> <span class="checkmark"></span>
					</div>
					
					<!-- 제출 버튼 -->
					<div class="form-group">
						<button type="submit" class="submit">Sign In</button>
					</div>
					
					

				</form>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>

</body>
</html>