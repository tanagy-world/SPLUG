<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<title>선배의 잡담</title>
	
<script>
    function list(page){
        location.href="notification?curPage="+page+"&searchOption-${map.searchOption}"+"&keyword=${map.keyword}";
    }
</script>

	
</head>
<body>

	<div id="wrapper">

		<!-- Navigation -->
		<%@ include file="naviBar.jsp"%>
		<!-- /Navigation -->

		<div id="page-wrapper">
		<br><br>
			<h1>선배의 잡담</h1>
			<!-- /.row -->
			<br> <br> <br> <br>
			<!-- 제목 / 작성자 / 작성일자  -->

			<div class="table-responsive fixed-solution"
				data-pattern="priority-columns">
				<div class="sticky-table-header"
					style="height: 36px; top: 49px; visibility: hidden; width: auto;"></div>



				<!-- bootstrap.min 2584번째 줄 .... table-bordered : 2634줄 -->
				<table cellspacing="0" id="tech-companies-1"
					class="table table-bordered table-striped">
					<thead>

						<tr>
							<th width="5%" data-priority="3" id="tech-companies-1-col-0">글번호</th>
							<th width="70%" data-priority="1" id="tech-companies-1-col-1">제목</th>
							<th width="10%" data-priority="1" id="tech-companies-1-col-2">작성자</th>
							<th width="10%" data-priority="3" id=tech-companies-1-col-3">작성일자</th>
							<th width="5%" data-priority="3" id=tech-companies-1-col-3"><i class="fa fa-eye"></i></th>

						</tr>

					</thead>
					<tbody>

						<c:forEach var="row" items="${map.list}">
							<tr>

								<td data-org-colspan="1" data-priority="3"
									data-columns="tech-companies-1-col-1"><center>${row.bno}
									</center></td>
								<td class="ellip" data-org-colspan="1" data-priority="1"
									data-columns="tech-companies-1-col-2"><a
									href="boardView?bno=${row.bno}&where=recruit&curPage=${map.boardPager.curPage}">${row.title}</a>
									<span style="color: red;">(${row.recnt}) </span></td>
								<td class="ellip" data-org-colspan="1" data-priority="1"
									data-columns="tech-companies-1-col-3"><center>${row.writer}
									</center></td>
								<td data-org-colspan="1" data-priority="3"
									data-columns="tech-companies-1-col-4"><center>${row.regdate}
									</center></td>
								<td data-org-colspan="1" data-priority="3"
									data-columns="tech-companies-1-col-4"><center>${row.viewcnt}</center></td>

							</tr>
						</c:forEach>


					</tbody>
				</table>
				

			</div>
			<br>
			
			<center>

				<div class="dataTables_paginate paging_simple_numbers">
					<ul class="pagination">
						<c:if test="${map.boardPager.curBlock > 1}">
							<li class="paginate_button previous " tabindex="0"><a
								href="javascript:list('1')">처음</a></li>
						</c:if>
						<c:if test="${map.boardPager.curBlock > 1}">
							<li class="paginate_button previous " tabindex="0"><a
								href="javascript:list('${map.boardPager.prevPage}')">이전</a></li>
						</c:if>


						<c:forEach var="num" begin="${map.boardPager.blockBegin}"
							end="${map.boardPager.blockEnd}">
							<!-- **현재페이지이면 하이퍼링크 제거 -->
							<c:choose>
								<c:when test="${num == map.boardPager.curPage}">
									<li class="paginate_button active"
										aria-controls="dataTables-example" tabindex="0"><a
										href="#">${num}</a></li>
								</c:when>
								<c:otherwise>
									<li class="paginate_button " tabindex="0"><a
										href="javascript:list('${num}')">${num}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>


						<c:if test="${map.boardPager.curBlock <= map.boardPager.totBlock}">
							<li class="paginate_button next" tabindex="0"><a href="javascript:list('${map.boardPager.nextPage}')">다음</a></li>
						</c:if>

						<c:if test="${map.boardPager.curPage <= map.boardPager.totPage}">
							<li class="paginate_button next" tabindex="0"><a href="javascript:list('${map.boardPager.totPage}')">끝</a></li>
						</c:if>

					</ul>

				</div>

			</center>
			
			<br> <br>

			<c:set var="where" value="recruit" />
			<c:url value='boardWrite?where=${where}' var="writeUrl" />
			<a href="${writeUrl}"><button type="button"
					class="btn btn-primary">글쓰기</button></a> <br> <br> <br>
			<br>


			<!-- /#page-wrapper -->
		</div>
</body>
</html>
