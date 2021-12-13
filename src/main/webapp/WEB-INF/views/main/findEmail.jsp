<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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

a {
	font-size: 12px;
  	color: #cfcfcf;
	font-family: 'Open Sans', Helvetica, Arial, sans-serif;
}

h3 {
	 text-align: center;
}

.row > div {
	text-align: center;
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

form {
 margin-top: 150px;
}

span {
  margin-top: 15px;
  font-size: 12px;
  color: #cfcfcf;
}

.forgot-pass {
  margin-top: 15px;
  margin-bottom: 15px;
  text-align: center;
  font-size: 12px;
  color: #cfcfcf;
}

.forgot-item {
  display: inline-block;
  vertical-align: middle;
  position: relative;
  margin-top: 4px;
  margin-left: 4px;
  margin-right: 4px;
}

.nickname {
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
				<form method="POST" action="./findEmailAction">
					<h3>이메일 찾기</h3>

					<!-- 닉네임 입력 -->
					<label> 
						<p class="nickname">닉네임</p>
					</label>
					<div class="form-group">
						<input type="text" class="custominput"> 
					</div>
					
					<div class="row">
						<div class="col-lg-3"></div>
						<div class="col-lg-6">
							<button type="submit" class="submit btn btn-lg btn-block">찾기</button>
						</div>
						<div class="col-lg-3"></div>
					</div>
					
					<div class="float-center">
						<a href="./findPw">비밀번호 찾기</a>
					</div>
								
				</form>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>

</body>
</html>