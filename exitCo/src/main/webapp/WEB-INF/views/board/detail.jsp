<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<body class="d-flex flex-column min-vh-100 ">
	<div class="container d-flex justify-content-center"
		style="height: 1000px;">
		<div class="align-self-center" style="width: 100%;">
			작성자 : <span id="id"><i>${board.user.username}
			</i></span>
			<div class="form-group">
				<h3>${board.title}</h3>
			</div>
			<div class="form-group">
				<h3>${board.content}</h3>
			</div>
			<hr />
			<div class="card">
				<form>
					<input type="hidden" id="boardId" value="${board.id }" /> <input
						type="hidden" id="userId" value="${principal.user.id }" />
					<c:choose>
						<c:when test="${empty principal}">
							<div class="card-body">
								<textarea id="reply-content" class="form-control" rows="1" placeholder="로그인하셔야 댓글작성이 가능합니다."></textarea>
							</div>
							<div class="card-footer">
							</div>
						</c:when>
						<c:otherwise>
							<div class="card-body">
								<textarea id="reply-content" class="form-control" rows="1"></textarea>
							</div>
							<div class="card-footer">
								<button type="button" id="btn-reply-save"
									class="btn btn-primary">등록</button>
							</div>
						</c:otherwise>
					</c:choose>
				</form>
			</div>

			<div class="card">
				<div class="card-header">댓글 리스트</div>
				<ul id="reply-box" class="list-group">
					<c:forEach var="reply" items="${board.replys }">
						<li id="reply-${reply.id}"
							class="list-group-item d-flex justify-content-between">
							<div>${reply.content }</div>
							<div class="d-flex">
								<div class="font-italic">작성자 : ${reply.user.username}
									&nbsp</div>
								<c:if test="${board.user.id == principal.user.id}">
									<button onclick="index.replyDelete(${board.id} ,${reply.id})"
										class="badge">삭제</button>
								</c:if>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>

	</div>

	<script src="/js/board/board.js"></script>
	<%@ include file="../layout/footer.jsp"%>

</body>
</html>


