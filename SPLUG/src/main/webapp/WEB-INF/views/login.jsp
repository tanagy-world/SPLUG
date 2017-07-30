<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>로그인</title>
</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<%@ include file="naviBar.jsp"%>
		<!-- /Navigation -->

		<div id="page-wrapper">

			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="login-panel panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">로그인</h3>
							</div>
							<div class="panel-body">
								<form action="loginCheck" method="post">
									<fieldset>
										<div class="form-group">
											<input class="form-control" placeholder="아이디" name="id"
												type="text" autofocus>
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="비밀번호"
												name="password" type="password" value="">
										</div>
										<div class="checkbox">
											<label> <input name="remember" type="checkbox"
												value="Remember Me">아이디 기억하기
											</label>
										</div>
										<!-- Change this to a button or input when using this as a form -->
										<input type="submit" value="Login" class="btn btn-lg btn-primary btn-block" />
										<a href="signup">회원가입</a>
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
