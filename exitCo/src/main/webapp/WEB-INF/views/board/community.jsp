<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<body class="d-flex flex-column min-vh-100 ">

		<div class="container d-flex"  style="height:500px">

			<table class="table table-striped align-self-end">
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
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
		

				</tbody>

			</table>
		
		</div>
			<button type="button" onclick="location.href='/board/saveForm'" class="btn bg-dark text-white align-self-center">글 쓰기</button>


</body>
<script src="/js/board/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

</html>


