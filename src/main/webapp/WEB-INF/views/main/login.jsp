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
		<form action="/action_page.php">
		
		<!-- 마이페이지 메뉴 -->
		<!-- 로그인이 되어있지 않을 때 표시 -->
		  
		</form>
		</div>
		<div class="col-lg-3"></div>
	</div>
</div>

</body>
</html>