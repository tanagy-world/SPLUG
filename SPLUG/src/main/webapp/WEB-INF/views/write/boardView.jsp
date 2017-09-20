<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 보기</title>
<%@ include file="../naviBar.jsp"%>
<%@ include file="wHeader.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<script>
	$(document).ready(function() {

		$("a[name='file']").on("click", function(e) { //파일 이름
			e.preventDefault();
			var bno = document.form.bno.value;

			document.form.method = "POST";
			document.form.action = "downloadFile";
			document.form.submit();
		});
	});

	function fn_downloadFile(bno) {
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='downloadFile'/>");
		comSubmit.addParam("bno", bno);
		comSubmit.submit();
		alert(bno);

	}
	
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 100, // 에디터의 높이 
			minHeight : null,
			maxHeight : null,
			focus : false,
			lang : 'ko-KR' // 기본 메뉴언어 US->KR로 변경				
		});
	});
</script>



<script>
	$(document)
			.ready(
					function() {

						listReply();

						$("#btnDelete").click(function() {
							if (confirm("삭제 하시겠습니까?")) {
								var where = document.form.where.value;

								document.form.method = "POST";
								document.form.action = "Contentdelete";
								document.form.submit();
							}
						});

						$("#btnUpdate").click(function() {
							if (confirm("수정하시겠습니까?")) {
								var where = document.form.where.value;

								document.form.method = "POST";
								document.form.action = "ContentUpdateView";
								document.form.submit();
							}
						});

						$("#btnList")
								.click(
										function() {

											document.form.method = "GET";

											var where = document.form.where.value;
											var curPage = document.form.curPage.value;

											if (where == "<자유게시판>")
												document.form.action = "agora?curPage="
														+ curPage;
											else if (where == "<공지사항>")
												document.form.action = "notification?curPage="
														+ curPage;
											else if (where == "<회의록>")
												document.form.action = "log?curPage="
														+ curPage;
											else if (where == "<선배의 잡담>")
												document.form.action = "recruit?curPage="
														+ curPage;
											else if (where == "<자료실>")
												document.form.action = "data?curPage="
														+ curPage;

											document.form.submit();

										});

						$("#btnReply")
								.click(
										function() {
											var where = "${where}"
											var bno = "${dto.bno}"
											var replytext = $("#summernote")
													.val();

											var param = "replytext="
													+ replytext + "&bno=" + bno
													+ "&where=" + where;

											$('#summernote')
													.summernote('reset');

											$.ajax({
												type : "post",
												url : "insertReply",
												data : param,
												complete : function() {
													alert("댓글이 등록되었습니다.");
													listReply();
												}
											});
										});

					});
	function listReply() {
		$.ajax({
			type : "get",
			url : "listReply?bno=${dto.bno}&where=${where}",
			success : function(result) {
				// responseText가 result에 저장됨.

				$("#listReply").html(result);
			}
		});
	}
</script>


</head>
<body>
	<div id="wrapper">
		<div id="page-wrapper">

			<br> <br> <br> <br>

			<div class="alert alert-info">${where}게시물</div>
			<!-- /.row -->
			<br>

			<form name="form">
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

						<tr>
							<td><c:if test="${file_info.oriname eq null}">첨부파일이 없습니다.</c:if>
								<c:if test="${file_info.oriname ne null}">
									<a href="#this" name="file">${file_info.oriname }</a>
                        			(${file_info.file_size }kb)
								</c:if></td>
							<td>첨부파일</td>
						</tr>



					</tbody>
				</table>


				<input type="hidden" name="bno" id="bno" value="${dto.bno}" /> <input
					type="hidden" name="writer" id="writer" value="${dto.writer}" /> <input
					type="hidden" name="title" id="title" value="${dto.title}" /> <input
					type="hidden" name="content" id="content" value="${dto.content}" />
				<input type="hidden" name="regdate" id="regdate"
					value="${dto.regdate}" /> <input type="hidden" name="viewcnt"
					id="viewcnt" value="${dto.viewcnt}" /> <input type="hidden"
					name="where" id="where" value="${where}" /> <input type="hidden"
					name="curPage" id="curPage" value="${curPage}" /> <br>




				<!-- 댓글 들어감 -->

				<div id="listReply"></div>

				<!-- 댓글작성 -->

				<table cellspacing="0" id="tech-companies-1"
					class="table table-bordered table-striped">
					<thead>
						<tr>
							<th width="100%" data-priority="1" id="tech-companies-1-col-0"
								id="title" colspan="3" style="text-align: left;">코멘트 남기기</th>
						</tr>
					</thead>
					<tbody>
						<tr style="height: 100px;">
							<td><textarea name="replyContent" id="summernote"></textarea>
								<br>
								<button type="button" id="btnReply" class="btn btn-primary">작성완료</button>
							</td>
						</tr>
					</tbody>
				</table>

				<br> <br> <br>

				<button type="button" id="btnList" class="btn btn-primary">
					<i class="fa fa-list"> 목록으로</i>
				</button>
				<button type="button" id="btnDelete" class="btn btn-primary">
					<i class="fa fa-times"> 삭제</i>
				</button>
				<button type="button" id="btnUpdate" class="btn btn-primary">
					<i class="fa fa-pencil"> 수정</i>
				</button>

			</form>

			<br> <br> <br>



		</div>
	</div>


</body>
</html>
