<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<body class="d-flex flex-column min-vh-100">
<div class="container d-flex justify-content-center" id='wrapper' style="height:1000px;">
	<form class=" align-self-center" style="width:65%;" >
		<div class="form-group">
			<label for="username">Username</label> <input type="username"
				class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group">
			<label for="email">Email address:</label> <input type="email"
				class="form-control" placeholder="Enter email" id="email">
		</div>
	<button id="btn-save" class="btn btn-primary">회원가입</button>
	</form>
</div>
</body>
<script src="/js/user/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
</html>


