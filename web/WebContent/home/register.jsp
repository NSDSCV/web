<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>注册 账号</title>

<link rel="stylesheet" type="text/css" href="../css/signin.css" />
<!-- Bootstrap -->
<link href="../js/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<h2 class="form-signin-heading">注册账号</h2>
		<form action="/web/user/user.do" method="post" class="form-signin">
			<h4 class="form-signin-heading">请输入</h4>
			<label for="name" class="sr-only">昵称</label> <input type="text"
				value="" name="name" id="name" class="form-control" placeholder="昵称"
				required autofocus><br> <label for="inputEmail"
				class="sr-only">账号</label> <input type="text" value=""
				name="username" id="inputEmail" class="form-control"
				placeholder="账号" required autofocus><br> <label
				for="inputPassword" class="sr-only">密码</label> <input
				type="password" name="password" id="inputPassword"
				class="form-control" placeholder="密码" required><br> <input
				type="hidden" name="op" value="reg"> <label> <input
				name="regUser" type="checkbox" value="root"> 管理员账户
			</label>
			<div class="checkbox"></div>
			<button id="log" class="btn btn-lg btn-primary btn-block"
				type="submit">登录</button>
		</form>

	</div>
	<div id="lo"></div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="../js/js/bootstrap.min.js"></script>
</body>
</html>
