<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 보기</title>
<%@ include file="../naviBar.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

</head>
<body>
	<div id="wrapper">
		<div id="page-wrapper">

			<br> <br> <br> <br>

			<div class="alert alert-info">${where}게시물</div>
			<!-- /.row -->
			<br>



			<form name="form" >
				<table cellspacing="0" id="tech-companies-1"
					class="table table-bordered table-striped">
					<thead>
						<tr>
							<th width="100%" data-priority="1" id="tech-companies-1-col-0"
								id="title" colspan="3" style="text-align: left;">${dto.title }</th>
						</tr>

					</thead>
					<tbody>

						<tr>
							<td data-org-colspan="1" data-priority="1" width="85%"
								id="writer" data-columns="tech-companies-1-col-1"><span
								class="glyphicon glyphicon-user"></span> ${dto.writer}</td>
							<td data-org-colspan="1" data-priority="1" width="10%"
								id="regdate" data-columns="tech-companies-1-col-1">${dto.regdate}</td>
							<td data-org-colspan="1" data-priority="1" width="5%"
								id="viewcnt" data-columns="tech-companies-1-col-1"><center>${dto.viewcnt}</center></td>
						</tr>

						<tr style="height: 500px;">
							<td data-org-colspan="1" data-priority="1" colspan="3"
								id="content" data-columns="tech-companies-1-col-1">${dto.content}</td>
						</tr>


					</tbody>
				</table>


				<br> <br> <br> <input type="hidden" name="bno"
					value="${dto.bno}">
					<input type="hidden" name="where"
					value="${where}">
				<button type="button" id="btnList" class="btn btn-primary"><i class="fa fa-list"> 목록으로</i></button>
				<button type="button" id="btnDelete" class="btn btn-primary"><i class="fa fa-times"> 삭제</i></button>
				<button type="button" id="btnUpdate" class="btn btn-primary"><i class="fa fa-times"> 삭제</i></button>
				
			</form>

			<br> <br> <br>



		</div>
	</div>



	<script>
	$(document).ready(function() {
		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
		
				document.form.method="POST";
				document.form.action = "delete";
				document.form.submit();
			}
		});

		$("#btnList").click(function() {

			document.form.method="GET";
			
			var where = document.form.where.value;
			
			if(where="<자유게시판>")
				document.form.action = "agora";

			document.form.submit();

		});

	});
</script>


</body>
</html>
