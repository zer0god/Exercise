<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZERO GOD</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="${path}/resources/css/join.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${path}/resources/js/join.js"></script>

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
				<h3>회원가입</h3>
				
				<!-- 이메일 입력 -->
				<label> 이메일</label>
				<div class="row form-group">
					<div class="col-lg-9">
						<input type="Email" class="custominput" id="user_email"  name="user_email">
					</div>
					<div class="col-lg-3">
						<button type="button" class="btn btn-check btn-block" id="emailCheckBtn">중복확인</button>
					</div>
				</div>

				<!-- 비밀번호 입력 -->
				<label>비밀번호<p id="msg1"></p></label>
				<div class="row form-group">
					<div class="col-lg-12">
						<input type="password" class="custominput" id="user_pw"  name="user_pw">
					</div>
				</div>

				<!-- 비밀번호 확인 입력 -->
				<label>비밀번호 확인<p id="msg2"></p></label>
			    
				<div class="row form-group">
					<div class="col-lg-12">
						<input type="password" class="custominput" id="user_pw2">
					</div>
				</div>

				<!-- 닉네임 입력 -->
				<label>닉네임</label>
				<div class="row form-group">
					<div class="col-lg-9">
						<input type="text" class="custominput" id="user_name"  name="user_name">
					</div>
					<div class="col-lg-3">
						<button type="button" class="btn btn-check btn-block" id="nameCheck">중복확인</button>
					</div>
				</div>

				<!-- 전화번호 입력 -->
				<label>휴대전화</label>
				<div class="row form-group">
					<div class="col-lg-12">
						<input type="text" class="custominput" id="user_phone" name="user_phone">
					</div>
				</div>
				
				<!-- 성별 입력 -->
				<label>성별</label>
				<div class="row form-group" data-toggle="buttons">
					<div class="col-lg-6">
						<label class="btn btn-outline-secondary btn-block">
							<input type="radio" id="user_gender_W" name="user_gender" value="W" style="display:none;">W
						</label>
					</div>
					<div class="col-lg-6">
						<label class="btn btn-outline-secondary btn-block">
							<input type="radio" id="user_gender_M" name="user_gender" value="M"style="display:none;">M
						</label>
					</div>
				</div>
				
			  	<!-- 이전, 가입 버튼에 대한 공간 할당 -->
			  	<div class="row form-group button-group">
					<div class="col-lg-2"></div>
					<div class="col-lg-8">
			  			<input type="submit" class="btn btn-check btn-block" value="회원가입">
					</div>
					<div class="col-lg-2"></div>
				</div>
				
			  	<div class="row form-group">
					<div class="col-lg-2"></div>
					<div class="col-lg-8">
						<a href="./">로그인 페이지로</a>
					</div>
					<div class="col-lg-2"></div>
				</div>

			</form>
		</div>
		<div class="col-lg-3"></div>
	</div>
</div>
<script>
$(document).ready(function() {
	var msg = '${msg}';
	if(msg != '') alert(msg); 
});
</script>
</body>
</html>