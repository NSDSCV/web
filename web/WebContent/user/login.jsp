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

		<title>登录后台</title>

<link rel="stylesheet" type="text/css" href="../css/signin.css"/>
		<!-- Bootstrap -->
		<link href="../js/css/bootstrap.min.css" rel="stylesheet">
		
	</head>

	<body>
	<% Cookie[] cookie = request.getCookies(); 
	String username = "";
	   for(Cookie cok : cookie){
		   if(cok.getName().equals("username")){
			   username = cok.getValue();
		   }
	   }
	%>

		<div class="container">

			<form action="/web/user/user.do" method="post" class="form-signin">
				<h2 class="form-signin-heading">请输入</h2>
				<label for="inputEmail" class="sr-only">账号</label>
				<input type="text" value="<%=username%>" name="username" id="inputEmail" class="form-control" placeholder="账号" required autofocus>
				<label for="inputPassword"  class="sr-only">密码</label>
				<input type="password" name="password" id="inputPassword" class="form-control" placeholder="密码" required>
				<input type="hidden" name="op" value="login">
				<div class="checkbox">
					<label>
						<input name="ck" type="checkbox" value="remember-me"> 记住账号
					</label>
				</div>
				<button id="log" class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
			</form>

		</div>
		<div id="lo">
		<% Object fage =request.getAttribute("fage"); 
		
		 %>
		</div>

		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="../js/js/bootstrap.min.js"></script>


		<script type="text/javascript">
			$("#log").click(function() {
				var name = $("#inputEmail").val();
				var password = $("#inputPassword").val();
				if (name =="" || password =="") {
					alert("不能为空");
				}
			})
		</script>
	</body>
</html>
