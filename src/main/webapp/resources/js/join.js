$(document).ready(function(){
	var email_flag = false;
	var name_flag = false;
	var pw_flag = false;
	var same_flag = false;
	
	$('#user_pw').keyup(function() {
		var user_pw = $('#user_pw').val();
		var msg = '';
		var color = '';
		var checkPoint = 0;
		
		if(user_pw.length) {
			if(user_pw.length < 8 || user_pw.length > 16) {
				msg = '8~16자 영문 대소문자, 숫자, 특수문자를 사용하세요.';
				color = '#A23E48';
				pw_flag = false;
			}
			else {
				var ptn1 = /[0-9]/;
				var ptn2 = /[a-z]/;
				var ptn3 = /[A-Z]/;
				var ptn4 = /[~!@#$%^&*()_+|<>?:{}]/;
				
				if(ptn1.test(user_pw) == false) {
					checkPoint++;
				}
				if(ptn2.test(user_pw) == false) {
					checkPoint++;
				}
				if(ptn3.test(user_pw) == false) {
					checkPoint++;
				}
				if(ptn4.test(user_pw) == false) {
					checkPoint++;
				}
				
				if(checkPoint == 0) {
					msg = '사용가능한 비밀번호입니다.';
					color = '#0000CD';
					pw_flag = true;
				}
				else {
					msg = '사용할 수 없는 비밀번호입니다.';
					color = '#A23E48';
					pw_flag = false;
				}
			}
		}
		
		else {
			msg = '비밀번호를 입력하세요.';
			color = '#000000';
			pw_flag = false;
		}
		$('#msg1').text(msg);
		$('#msg1').css('color', color);
	});
	
	$('#user_pw2').keyup(function() {
		var user_pw = $('#user_pw').val();
		var user_pw2 = $('#user_pw2').val();
		
		if(user_pw != '' && user_pw != '') {
			if(user_pw == user_pw2) {
				$('#msg2').text('비밀번호가 일치합니다.');
				$('#msg2').css('color', 'green');
				same_flag = true;
			}
			else {
				$('#msg2').text('비밀번호가 서로 다릅니다.');
				$('#msg2').css('color', 'red');
				same_flag = false;
			}
		}
	});
		
	$('#nameCheck').click(function() {
		var user_name = $('#user_name').val();
		$.ajax({
			type : 'GET',
			url	 : './nameCheck',
			data : {
				user_name : user_name
			},
			dataType : 'TEXT',
			success : function(result) {
				if(result == 0) {
					alert('사용가능한 닉네임입니다.');
					$('#user_name').attr('readonly', true);
					name_flag = true;
				}
				else if(result == 1) {
					alert('이미 사용중인 닉네임입니다.');
					$('#user_name').val('');
				}
			}
		});
	});
	
	$('#emailCheckBtn').click(function() {
		var user_email = $('#user_email').val();
		$.ajax({
			type : 'GET',
			url	 : './emailCheck',
			data : {
				user_email : user_email
			},
			dataType : 'TEXT',
			success : function(result) {
				if(result == 0) {
					alert('사용가능한 이메일입니다.');
					$('#user_email').attr('readonly', true);
					email_flag = true;
				}
				else if(result == 1) {
					alert('이미 사용중인 이메일입니다.');
					$('#user_email').val('');
				}
			}
		});
	});

	
	$('form').submit(function(event) {
		var user_email  = $('#user_email').val();
		var user_pw     = $('#user_pw').val();
		var user_pw2    = $('#user_pw2').val();
		var user_name   = $('#user_name').val();
		var user_phone  = $('#user_phone').val();
		var user_gender = $('#input[name=user_gender]').val();
		
		if(user_email == "" || user_pw == "" || user_pw2 == "" || 
				user_name == "" || user_phone == "" || user_gender == ""){
			alert('모든 값을 입력하세요.');
			event.preventDefault();
			return;
		}
		
		if(!email_flag){
			alert('이메일 중복확인을 해주세요.');
			event.preventDefault();
			return;
		}
		if(!name_flag){
			alert('닉네임 중복확인을 해주세요.');
			event.preventDefault();
			return;
		}
		if(!pw_flag){
			alert('사용할 수 없는 비밀번호입니다.');
			event.preventDefault();
			return;
		}
		if(!same_flag){
			alert('비밀번호가 서로 다릅니다.');
			event.preventDefault();
			return;
		}
	});
	
});