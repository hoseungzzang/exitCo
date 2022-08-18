<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<body class="d-flex flex-column min-vh-100 ">
		<div class="container d-flex justify-content-center"  style="height:200px">
		<div class="align-self-end"><h1>대피구역 :${title}</h1></div>
		</div>
		<div class="container d-flex"  style="height:300px">
			<table class="table table-striped align-self-center" style="margin-left: auto; margin-right: auto; text-align:center;">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
			<c:forEach items="${exitNameList.content}" var="exitNameList">
								<tr>
									<td><a href="/auth/board/${exitNameList.id}" >${exitNameList.id}</a></td>
									<td><a href="/auth/board/${exitNameList.id}" >${exitNameList.title}</a></td>
									<td>${exitNameList.user.username}</td>
									<td>${exitNameList.createDate}</td>
									<td>${exitNameList.count}</td>
								</tr>
							</c:forEach>
		

				</tbody>

			</table>
		
		</div>
			<ul class="pagination justify-content-center">
	<c:choose>
	<c:when test="${exitNameList.first }">
	  <li class="page-item disabled"><a class="page-link" href="?page=${exitNameList.number}">이전</a></li>
	</c:when>
	<c:otherwise>
	<li class="page-item"><a class="page-link" href="?page=${exitNameList.number-1}">이전</a></li>
	</c:otherwise>
	</c:choose>
	<c:choose>
	<c:when test="${exitNameList.last }">
  <li class="page-item disabled"><a class="page-link" href="?page=${exitNameList.number}">다음</a></li>
	</c:when>
	<c:otherwise>
  <li class="page-item"><a class="page-link" href="?page=${exitNameList.number+1}">다음</a></li>
	</c:otherwise>
	</c:choose>
</ul>
			<button type="button" onclick="location.href='/board/saveForm?exitName=${title}'" class="btn bg-dark text-white align-self-center">글 쓰기</button>


</body>
<script src="/js/board/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

</html>


