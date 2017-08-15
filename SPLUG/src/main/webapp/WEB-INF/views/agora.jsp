<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>

<script>
    function list(page){
        location.href="agora?curPage="+page+"&searchOption-${map.searchOption}"+"&keyword=${map.keyword}";
    }
</script>



<title>자유게시판</title>
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<%@ include file="naviBar.jsp"%>
		<!-- /Navigation -->

		<div id="page-wrapper">
			<br> <br>
			<h1>자유게시판</h1>
			<!-- /.row -->
			<br> <br> <br> <br>
			<!-- 제목 / 작성자 / 작성일자  -->

			<div class="table-responsive fixed-solution"
				data-pattern="priority-columns" id="dataTables-example_wrapper">
				<div class="sticky-table-header"
					style="height: 36px; top: 49px; visibility: hidden; width: auto;"></div>



				<!-- bootstrap.min 2584번째 줄 .... table-bordered : 2634줄 -->
				<table cellspacing="0" id="tech-companies-1"
					class="table table-bordered table-striped" id="dataTables-example">
					<thead>

						<!--   원래 값
                            <tr>
                                <th id="tech-companies-1-col-0">Company</th>
                                <th data-priority="1" id="tech-companies-1-col-1">Last Trade</th>
                                <th data-priority="3" id="tech-companies-1-col-2">Trade Time</th>
                                <th data-priority="1" id="tech-companies-1-col-3">Change</th>
                                <th data-priority="3" id="tech-companies-1-col-4">Prev Close</th>
                                <th data-priority="3" id="tech-companies-1-col-5">Open</th>
                                <th data-priority="6" id="tech-companies-1-col-6">Bid</th>
                                <th data-priority="6" id="tech-companies-1-col-7">Ask</th>
                                <th data-priority="6" id="tech-companies-1-col-8">1y Target Est</th>
                                <th data-priority="6" id="tech-companies-1-col-9">Lorem</th>
                                <th data-priority="6" id="tech-companies-1-col-10">Ipsum</th>
                            </tr>
                            -->

						<tr>
							<th width="5%" data-priority="3" id="tech-companies-1-col-0">글번호</th>
							<th width="70%" data-priority="1" id="tech-companies-1-col-1">제목</th>
							<th width="10%" data-priority="1" id="tech-companies-1-col-2">작성자</th>
							<th width="10%" data-priority="3" id=tech-companies-1-col-3">작성일자</th>
							<th width="5%" data-priority="3" id=tech-companies-1-col-3"><i
								class="fa fa-eye"></i></th>

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
									href="boardView?bno=${row.bno}&where=agora&curPage=${map.boardPager.curPage}">${row.title}</a></td>
								<td class="ellip" data-org-colspan="1" data-priority="1"
									data-columns="tech-companies-1-col-3"><center>${row.writer}
									</center></td>
								<td data-org-colspan="1" data-priority="3"
									data-columns="tech-companies-1-col-4"><center>${row.regdate}
									</center></td>
								<td data-org-colspan="1" data-priority="3"
									data-columns="tech-companies-1-col-4"><center>${row.viewcnt}</center></td>

								<!-- 
								<td>${row.bno}</td>
								<td><a href="${path}/board/view.do?bno=${row.bno}">${row.title}</a></td>
								<td>${row.writer}</td>
								<td>
									<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용  <fmt:formatDate
										value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td>${row.viewcnt}</td>
								
								 -->
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

			<c:set var="where" value="agora" />
			<c:url value='boardWrite?where=${where}' var="writeUrl" />
			<a href="${writeUrl}"><button type="button"
					class="btn btn-primary">글쓰기</button></a> <br> <br> <br>
			<br>


			<!-- /#page-wrapper -->
		</div>
</body>

</html>
