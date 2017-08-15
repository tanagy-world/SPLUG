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

				
				<input type="hidden" name="bno" value="${dto.bno}"/>
				<input type="hidden" name="writer" value="${dto.writer}"/>
				<input type="hidden" name="title" value="${dto.title}"/>
				<input type="hidden" name="content" value="${dto.content}"/>
				<input type="hidden" name="regdate" value="${dto.regdate}"/>
				<input type="hidden" name="viewcnt" value="${dto.viewcnt}"/>
				<input type="hidden" name="where" value = "${where}" />
				<input type="hidden" name="curPage" value = "${curPage}" />
				
				
				<br> <br> <br> 
				
				<button type="button" id="btnList" class="btn btn-primary"><i class="fa fa-list"> 목록으로</i></button>
				<button type="button" id="btnDelete" class="btn btn-primary"><i class="fa fa-times"> 삭제</i></button>
				<button type="button" id="btnUpdate" class="btn btn-primary"><i class="fa fa-pencil"> 수정</i></button>
				
			</form>

			<br> <br> <br>



		</div>
	</div>



	<script>
	$(document).ready(function() {
		$("#btnDelete").click(function() {
			if (confirm("삭제 하시겠습니까?")) {
				var where = document.form.where.value;
				
				document.form.method="POST";
				document.form.action = "Contentdelete";
				document.form.submit();
			}
		});
		
		$("#btnUpdate").click(function() {
			if (confirm("수정하시겠습니까?")) {
				var where = document.form.where.value;

				document.form.method="POST";
				document.form.action = "ContentUpdateView";
				document.form.submit();
			}
		});


		$("#btnList").click(function() {

			document.form.method="GET";
			
			var where = document.form.where.value;
			var curPage = document.form.curPage.value;
						
			if(where=="<자유게시판>")
				document.form.action = "agora?curPage="+curPage;
			else if(where=="<공지사항>")
				document.form.action = "notification?curPage="+curPage;
			else if(where=="<회의록>")
				document.form.action = "log?curPage="+curPage;
			else if(where=="<선배의 잡담>")
				document.form.action = "recruit?curPage="+curPage;

			document.form.submit();

		});

	});
</script>


</body>
</html>
