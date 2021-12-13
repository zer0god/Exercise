<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
form {
	 margin-top: 200px;
}
</style>
</head>
<body>
<!-- 메인 네비게이션 -->
<!-- nav : 네비게이션 리스트 HTML 태그 -->
<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#">Active</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link</a>
    </li>
    <li class="nav-item">
      <a class="nav-link disabled" href="#">Disabled</a>
    </li>
  </ul>
</nav>

<!-- 메인 컨텐츠 -->
<div class ="container">
	
	<div class="row">
		<div class="col-lg-3"></div> <!-- 안쓰는 옆 가로 공간 배정 -->
		
		<div class="col-lg-6"> <!-- 화연의 6/12 사용 -->
			<form action="./joinAction" method="POST">
			  
			  <!-- 이메일 입력에 대한 공간 할당 -->
			  <div class="row mb-2">
			  	<!-- 이메일 입력 -->
			  	<div class="text-center align-self-center col-lg-3">Email</div>
			  	<div class="col-lg-6">
			    	<input type="email" class="form-control" placeholder="Email" id="user_email">
			  	</div>
			  	<div class="col-lg-3">
			    	<button type="button" class="btn btn-outline-primary btn-block">Check</button>
			  	</div>
			  </div>
			  
			  <!-- 비밀번호 입력에 대한 공간 할당 -->
			  <div class="row mb-2">
			  	<!-- 비밀번호 입력 -->
			  	<div class="text-center align-self-center col-lg-3">Password</div>
			  	<div class="col-lg-6">
			    	<input type="password" class="form-control" placeholder="Password" id="user_pw">
			  	</div>
			  </div>
			  
			  <!-- 비밀번호 확인에 대한 공간 할당 -->
			  <div class="row mb-2">
			  	<!-- 비밀번호 입력 -->
			  	<div class="text-center align-self-center col-lg-3">Password check</div>
			  	<div class="col-lg-6">
			    	<input type="password" class="form-control" placeholder="Password Check" id="user_pw2">
			  	</div>
			  </div>
			
			  <!-- 닉네임 입력에 대한 공간 할당 -->
			  <div class="row mb-2">
			  	<!-- 닉네임 입력 -->
			  	<div class="text-center align-self-center col-lg-3">Nickname</div>
			  	<div class="col-lg-6">
			    	<input type="text" class="form-control" placeholder="Nickname" id="user_name">
			  	</div>
			  	<div class="col-lg-3">
			    	<button type="button" class="btn btn-outline-primary btn-block">Check</button>
			  	</div>
			  </div>
			  
			  <!-- 성별 선택에 대한 공간 할당 -->
			  <div class="row mb-2">
			  	<!-- 성별 입력 -->
			  	<div class="text-center align-self-center col-lg-3">Gender</div>
			  		<div class="btn-group col-lg-6">
					  <button type="button" class="btn btn-outline-primary">W</button>
					  <button type="button" class="btn btn-outline-primary">M</button>
					</div>
			  	</div>
			  		
			 <!-- 휴대폰 입력에 대한 공간 할당 --> 		
			 <div class="row mb-2">
			 	<!-- 휴대폰 입력 --> 		
			  	<div class="text-center align-self-center col-lg-3">Phone Number</div>
					<div class="col-lg-6">
					   <input type="text" class="form-control" placeholder="PhoneNumber" id="user_phone">
					 </div>
			  </div>
			  
			  <!-- 이전, 가입 버튼에 대한 공간 할당 -->
			  <div class="float-right">
			  		<input type="submit" class="btn btn-outline-secondary" value="이전">
			  		<input type="submit" class="btn btn-outline-primary" value="회원가입">
			   </div>
	  
			</form>
		</div>
		<div class="col-lg-3"></div>
	</div>
</div>

</body>
</html>