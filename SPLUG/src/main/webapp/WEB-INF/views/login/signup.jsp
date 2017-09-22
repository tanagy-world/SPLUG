<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<script src="resources/js/registerCheck.js?ver=1"></script>
<script src="resources/js/jquery-3.2.0.min.js"></script> 
<title>회원가입</title>
<script type="text/javascript">

	$(function() {//아이디 중복 확인
		$("#id_check").bind("click",function() {
					var id = $("#user_id").val();
					alert(id);
					$.ajax({
						type : "POST",
						data : {
							"id" : id
						},
						dataType : "json",
						url : "/splug/idCheck",
						success : function(data) {

							if (data == false) {
								alert("사용 할 수 있는 아이디 입니다.");
								$("#dupCheck").val("true");
							} else
								alert("사용 할 수 없는 아이디 입니다.");
						},
						error : function(request, status, error) {
							alert("code = " + request.status + "아이디체크 "+ " error = "
									+ error); // 실패 시 처리

						}
					});
				});
	});
	

	$(function(){//이메일 전송
		$("#send_mail").bind("click",function(){
	   		
			var email= $("#email").val();
			$.ajax({
	        type:"POST",
	        dataType:"json",
	        data:{ "email" : email  },
	        url :"/splug/regiMail",
	        success : function(data){
	        	
	        	if(data==true)
	        	alert("이메일이 성공적으로 전송되었습니다.");
	        	else
	        		alert("이메일 전송 실패");
	        	
	        },
	        error : function(request, status, error) {
				alert("code = " + request.status + "메일보내기" + " error = "
						+ error); // 실패 시 처리

			}
	    });
	});
	});
	
	$(function(){//이메일 인증번호 확인
		$("#check_mail").bind("click",function(){
	   
			var code=$("#input_code").val();
			
			$.ajax({
	        type:"POST",
	        dataType:"json",
	        data:{ "code" : code  },
	        url :"/splug/regiMail_check",
	        success : function(data){
	        	
	        	if(data==true){
	        		alert("이메일 인증이 완료 되었습니다.");
	        		$("#authCheck").val("true");

	        	}
	        	else
	        		alert("인증번호가 다릅니다.");
	        	
	        },
	        error : function(request, status, error) {
				alert("code = " + request.status + " 인증확인3 "
						+  " error = "
						+ error); // 실패 시 처리

			}
	    });
	});
	});
	

</script>
</head>
<body>

	<div id="wrapper">

		<!-- Navigation -->
		<%@ include file="../naviBar.jsp"%>
		<!-- /Navigation -->


		<div id="page-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="login-panel panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">회원가입</h3>
							</div>
							<div class="panel-body">
								<form name="regiform" action="registration" method="post">
									<input type="hidden" id="dupCheck" name="dupCheck" value="false"> 
									<input type="hidden" id="authCheck" name="authCheck" value="false">
									<fieldset>
										<div class="form-group">
											<input class="form-control" placeholder="아이디" value
												autocomplete="off" maxlength="20" id="user_id" name="user_id"
												type="text" autofocus> 
												<input class="form-control" type="button" id="id_check" name="id_check" value="중복확인">
											<p id="id_check_text"></p>
										</div>
										<div id="idMsg" class="error" style="display: block;">필수
											정보입니다.</div>
										<div class="form-group">
											<input class="form-control" placeholder="비밀번호" maxlength="20"
												name="user_pwd" id="user_pwd" type="password" value="">
										</div>
											<div class="form-group">
											<input class="form-control" placeholder="비밀번호 확인" maxlength="20"
												name="user_pwd2" id="user_pwd2" type="password" value="">
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="이름" maxlength="4"
												name="user_name" id="user_name" type="text" value="">
										</div>
									
										<div class="form-group">
											<input class="form-control" placeholder="전화번호('-' 포함)"
												maxlength="13" name="user_phone" id="user_phone" type="text" value="">
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="학번(ex. 12)"
												maxlength="2" name="stdid" type="text" value="">
										</div>
										
										<div class="form-group">
											<input class="form-control" placeholder="이메일" maxlength="40"
												name="email" id="email" type="text" value="">
											<input class="form-control" type="button" id="send_mail" name="send_mail" value="인증받기">
										</div>
										
										<div class="form-group">
											<input class="form-control" placeholder="코드 입력"
												maxlength="10" id="input_code" name="input_code" type="text" value="">
											<input type="button" class="form-control" value="확인" id="check_mail" name="check_mail">
												
										</div>
										<!-- Change this to a button or input when using this as a form -->
										<input type="submit" value="회원가입" class="btn btn-lg btn-primary btn-block" onclick="return checkfield()" />
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.row -->
		</div>

		<!-- /#page-wrapper -->

	</div>

</body>

</html>