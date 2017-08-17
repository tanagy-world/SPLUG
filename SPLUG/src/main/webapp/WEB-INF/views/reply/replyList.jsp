<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
%>
</head>
<body>

				<div class="panel panel-primary" style="width: 200px">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-comments fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div class="huge">${recnt}</div>
								<div>개의 댓글</div>
							</div>
						</div>
					</div>

				</div>



	<c:forEach var="row" items="${list}">
		<table cellspacing="0" id="tech-companies-1"
			class="table table-bordered table-striped">

			<tbody>

				<tr>
					<td data-org-colspan="1" data-priority="1" width="85%" id="writer"
						data-columns="tech-companies-1-col-1"><span
						class="glyphicon glyphicon-user"></span> ${row.replyer}</td>
					<td data-org-colspan="1" data-priority="1" width="10%" id="regdate"
						data-columns="tech-companies-1-col-1">${row.regdate}</td>

				</tr>
				<tr style="height: 100px;">
					<td data-org-colspan="1" data-priority="1" colspan="3" id="content"
						data-columns="tech-companies-1-col-1">${row.replytext}</td>
				</tr>

			</tbody>
		</table>
	</c:forEach>




</body>
</html>
