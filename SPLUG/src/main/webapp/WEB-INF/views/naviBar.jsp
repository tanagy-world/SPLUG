<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" href="resources/resTable/css/rwd-table.min.css">

<!-- Bootstrap Core CSS -->
<link href="resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="resources/bootstrap/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/bootstrap/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="resources/bootstrap/vendor/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="resources/bootstrap/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="home">SPLUG</a>
	</div>
	<!-- /.navbar-header -->


	<ul class="nav navbar-top-links navbar-right">




		<!-- /.dropdown -->
		<li><c:choose>
				<c:when test="${sessionScope.userId == null}">
					<a href="login">로그인<i class="fa fa-user fa-fw"></i>
					</a>
					<!-- /.dropdown-user -->
				</c:when>
				<c:otherwise>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown">${sessionScope.userName} <i
							class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="#"><i class="fa fa-user fa-fw"></i> 회원 정보</a></li>
							<li><a href="#"><i class="fa fa-gear fa-fw"></i> 설정</a></li>
							<li class="divider"></li>
							<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>로그아웃</a>
							</li>
						</ul> <!-- /.dropdown-user --></li>
				</c:otherwise>
			</c:choose></li>
 
 
			
			
	</ul>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">

				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="검색...">
						<span class="input-group-btn">
							<button class="btn btn-primary" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div> <!-- /input-group -->
				</li>

				<li><a href="notification"><i class="fa fa-dashboard fa-fw"></i>공지사항</a></li>
				<li><a href="agora"><i class="fa fa-bar-chart-o fa-fw"></i>자유게시판</a></li>
				<li><a href="galary"><i class="fa fa-table fa-fw"></i>갤러리</a></li>
				<li><a href="data"><i class="fa fa-edit fa-fw"></i>자료실</a></li>
				<li><a href="log"><i class="fa fa-wrench fa-fw"></i>회의록</a></li>
				<li><a href="recruit"><i class="fa fa-wrench fa-fw"></i>선배의
						잡담</a></li>

			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>


<!-- /#wrapper -->

<!-- jQuery -->
<script src="resources/bootstrap/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/bootstrap/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="resources/bootstrap/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="resources/bootstrap/vendor/raphael/raphael.min.js"></script>
<script src="resources/bootstrap/vendor/morrisjs/morris.min.js"></script>
<script src="resources/bootstrap/data/morris-data.js"></script>

<!-- Custom Theme JavaScript -->
<script src="resources/bootstrap/dist/js/sb-admin-2.js"></script>

<script src="resources/resTable/js/rwd-table.js"></script>


<script>
   $(function() {
      $('.table-responsive').responsiveTable({data-pattern=""});
   });
</script>

</html>
