<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<%
	String path = request.getContextPath();
%>

<!-- Bootstrap -->
<link href="<%=path%>/css/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function() {
		fun();
		$("button").click(function() {
			fun();
		});
	});
	function fun() {
		$("#t tr:not(:first)").empty("");
		var str = "";
		$.ajax({
			url : "/web/BlogAjax",
			type : "post",
			dataType : "JSON",
			success : function(result) {
				// console.log(result); 开始填充
				$.each(result, function(i, item) {
					
					str += "<tr>";
					str += "<td>" + item.id + "</td>"
					str += "<td>" + item.name + "</td>"
					str += "<td>" + item.username + "</td>"
					str += "<td>" + item.password + "</td>"
					str += "<td>" + item.text + "</td>"
					str += "<td>" + item.rc + "</td>"
					str += "</tr>"
					
				});
				$("#t").append(str);
			}
		});
	}
</script>

</head>
<body>
	<div id="" class="row">
		<div id="" class="col-md-12">
			<nav class="navbar navbar-inverse" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">信息测试</a>
					</div>
					
					<div>
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">iOS</a></li>
							<li><a href="#">导航a</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> 导航b <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<!-- 分割线 -->
									<li class="divider"></li>

									<li><a href="#">4</a></li>
									<!-- 分割线 -->
									<li class="divider"></li>
									<li><a href="#">5</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>

	<div class="row">

		<div class="col-md-12">
			<table id="t" class="table table-bordered text-center">
				<tr>
					<th>id</th>
					<th>name</th>
					<th>username</th>
					<th>passwowrd</th>
					<th>text</th>
					<th>rc</th>
					<th>操作</th>
				</tr>
			
			</table>

		</div>
		<div class="col-md-12">
			<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
			<button type="button" class="btn btn-danger center-block">刷新</button>
		</div>
	</div>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="<%=path%>/js/js/bootstrap.min.js"></script>
	
</body>
</html>