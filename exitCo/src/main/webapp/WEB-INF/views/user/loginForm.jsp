<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<body class="d-flex flex-column min-vh-100">
<div class="container d-flex justify-content-center" style="height:1000px;">
	<form class=" align-self-center" style="width:65%;" action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">Username</label> <input type="username"
				class="form-control" placeholder="Enter username" id="username" name="username">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password" name="password">
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> <input
				class="form-check-input" type="checkbox" name="remember"> Remember me
			</label>
		</div>
		<button id="btn-login" class="btn btn-primary">로그인</button>
	</form>
	
</div>
</body>
<%@ include file="../layout/footer.jsp"%>
</html>


