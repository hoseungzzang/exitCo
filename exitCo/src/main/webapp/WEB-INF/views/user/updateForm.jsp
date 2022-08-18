<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<body class="d-flex flex-column min-vh-100">
<div class="container d-flex justify-content-center" style="height:1000px;">
	<form class=" align-self-center" style="width:65%;">
	<input type="hidden" id="id" value="${principal.user.id }"/>
		<div class="form-group">
			<label for="username">Username</label> <input type="username" value="${principal.user.username}"
				class="form-control" placeholder="Enter username" id="username" readonly>
		</div>

		<div class="form-group">
			<label for="password">Password:</label> <input type="password" value=""
				class="form-control" placeholder="Enter password" id="password" >
		</div>

		
		<div class="form-group">
			<label for="email">Email address:</label> <input type="email" value="${principal.user.email}"
				class="form-control" placeholder="Enter email" id="email" >
		</div>
	<button id="btn-update" class="btn btn-primary">수정완료</button>
	</form>

</div>
<script src="/js/user/user.js"></script>

</body>
<%@ include file="../layout/footer.jsp"%>
</html>


