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

__btn {
    overflow: hidden;
    z-index: 2;
    position: relative;
    width: 100px;
    height: $btnH;
    margin: 0 auto;
    background: transparent;
    color: #fff;
    text-transform: uppercase;
    font-size: 15px;
    cursor: pointer;
    }

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

span {
  margin-top: 15px;
  text-align: center;
  font-size: 12px;
  color: #cfcfcf;
}

.forgot-pass {
  margin-top: 15px;
  text-align: center;
  font-size: 12px;
  color: #cfcfcf;
}

.forgot-item {
  display: inline-block;
  vertical-align: middle;
}

.email {
  margin-top: 15px;
  text-align: center;
  font-size: 15px;
  color: #cfcfcf;
}

.submit {
  margin-top: 40px;
  margin-bottom: 20px;
  background: #d4af7a;
  text-transform: uppercase;
}

button {
  display: block;
  margin: 0 auto;
  border-radius: 30px;
  color: #fff;
  font-size: 15px;
  cursor: pointer;
}



label {
  display: block;
  margin: 25px auto 0;
  text-align: center;

  span {
    color: #cfcfcf;
	text-align: center;
  }
 }
}

.sign-in {
  transition-timing-function: ease-out;

  @include signUpActive {
    transition-timing-function: ease-in-out;
    transition-duration: $switchAT;
    transform: translate3d($formW,0,0);
  }
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
						<p class="email">Email</p>
					</label>
					<div class="form-group">
						<input type="Email" class="custominput"> 
					</div>

					<!-- 비밀번호 입력 -->
					 <label>
					      <p class="email">Password</p>
				    </label>
					<div class="form-group">
						<input type="password" class="custominput">
					</div>
					
					<!-- 비밀번호 찾기 -->
					<p class="forgot-pass">Forgot password?</p>
					

					<!-- 로그인 정보 저장 -->
					<div class="forgot-pass">
						<div>Remember me</div> 
						<input class="forgot-item" type="checkbox">
					</div>
					
					<!-- 제출 버튼 -->
					<button type="submit" class="submit btn-lg">Sign In</button>
								
				</form>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>

</body>
</html>