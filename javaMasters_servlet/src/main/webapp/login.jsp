<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>멍프렌즈 홈페이지 :: LOGIN</title>
</head>
<body>
	<div style="width: 50%;height: auto; border:1px solid lightgray; border-radius: 5px; padding: 20px; margin: 0 auto;">
		<form action="front.do?command=login" method="post">
			ID <input type="text" name="userId" id="userId" required="required" class="form-control" placeholder="id"><br>
			PASSWORD <input type="password" name="Password" id="Password"
				required="required" class="form-control" placeholder="password"><br> 
			<input type="submit" value="LOGIN" class="btn btn-primary">
		</form>
	</div>
</body>
</html>