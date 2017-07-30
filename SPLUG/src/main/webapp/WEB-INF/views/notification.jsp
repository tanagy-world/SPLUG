<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<title>공지사항</title>
</head>
<body>


	<div id="wrapper">

		<!-- Navigation -->
		<%@ include file="naviBar.jsp"%>
		<!-- /Navigation -->

		<div id="page-wrapper">
		<br><br>
			<h1>공지사항</h1>
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
							<th width="5%" data-priority="3" id=tech-companies-1-col-3">조회수</th>

						</tr>

					</thead>
					<tbody>

						<c:forEach var="i" begin="1" end="20" step="1">

							<tr>
								<td data-org-colspan="1" data-priority="3"
									data-columns="tech-companies-1-col-1"><c:out value="${i}" /></td>
								<td data-org-colspan="1" data-priority="1"
									data-columns="tech-companies-1-col-2">제목으아아아아아 아이패드 언제와아아</td>
								<td data-org-colspan="1" data-priority="1"
									data-columns="tech-companies-1-col-3">조비퀏터스</td>
								<td data-org-colspan="1" data-priority="3"
									data-columns="tech-companies-1-col-4">12/7/8</td>
								<td data-org-colspan="1" data-priority="3"
									data-columns="tech-companies-1-col-4">582</td>

							</tr>

						</c:forEach>

					</tbody>
				</table>

			</div>
			<br>
			<br>
			<c:set var="where" value="notification" />
			<c:url value='write?where=${where}' var="writeUrl" />
			<a href="${writeUrl}"><button type="button"
					class="btn btn-primary">글쓰기</button></a> <br>
			<br>
			<br>
			<br>


			<!-- /#page-wrapper -->
		</div>
</body>
</html>
