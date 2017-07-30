<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>회원가입</title>
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
								<form action="registration" method="post">
									<fieldset>
										<div class="form-group">
											<input class="form-control" placeholder="아이디" value autocomplete="off"
											maxlength="20" name="id" type="text" autofocus>
										</div>
										<div id="idMsg" class="error" style="display: block;">필수 정보입니다.</div>
										<div class="form-group">
											<input class="form-control" placeholder="비밀번호"
												maxlength="20" name="password" type="password" value="">
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="이름"
												maxlength="4" name="name" type="text" value="">
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="이메일"
												maxlength="40" name="email" type="text" value="">
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="전화번호('-' 포함)"
												maxlength="13" name="phone" type="text" value="">
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="학번(ex. 12)"
												maxlength="2" name="stdid" type="text" value="">
										</div>
										<!-- Change this to a button or input when using this as a form -->
										<input type="submit" value="회원가입"
											class="btn btn-lg btn-primary btn-block" />
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