<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<body class="d-flex flex-column min-vh-100 saveForm">
<div class="container">
	<form>
	<input type="hidden" id="id" value="${board.id }" />
		<div class="form-group">
			<label for="title">Title</label> <input type="title" value="${board.title}" 
				class="form-control" placeholder="Enter title" id="title"
				name="title">
		</div>
		<div class="form-group">
			<label for="comment">Content:</label>
			<textarea class="form-control summernote" rows="5" id="content">${board.content} </textarea>
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary">수정 완료</button>
</div>

<script>
      $('.summernote').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        height: 300
      });
    </script>
 <script src="/js/board/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

</body>
</html>


