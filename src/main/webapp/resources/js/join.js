$(document).ready(function(){
   var email_flag = false;
   var name_flag = false;
   var pw_flag = false;
   
   $('#emailCheckBtn').click(function() {
      var user_email = $('#user_email').val();
      $.ajax({
         type : 'GET',
         url    : './emailCheck',
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
   
   $('#nameCheckBtn').click(function() {
      var user_name = $('#user_name').val();
      $.ajax({
         type : 'GET',
         url    : './nameCheck',
         data : {
            user_email : user_email
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
         alert('비밀번호가 서로 다릅니다.');
         event.preventDefault();
         return;
      }
   });
   
});