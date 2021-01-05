<%@page import="web.com.entity.Article"%>
<%@page import="java.util.List"%>
<%@page import="web.com.dao.ArticleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>博客首页</title>

<!-- Bootstrap core CSS -->
<link href="../js/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../js/layui/css/layui.css" media="all">
<link href="../css/blog.css" rel="stylesheet">

<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
<script src="../js/layui/layui.js"></script>
<!-- 配置文件 -->
<script type="text/javascript" src="../utf8-jsp/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="../utf8-jsp/ueditor.all.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
	var ue = UE.getEditor('container');
</script>

<style>
#box {
	width: 900px;
	margin: 0 auto;
}

#text {
	width: 900px;
	height: 400px;
	margin: 0 auto;
	background-color: #ffffff;
	margin-top: 60px;
	outline: none;
	border-radius: 8px;
	border: 2px solid #55ff7f;
	overflow: hidden;
}

#tup {
	float: right;
	margin-top: 10px;
	margin-left: 20px;
	width: 60px;
	height: 36px;
	background-color: #00a1e6;
	font-size: 18px;
	line-height: 36px;
	border-radius: 6px;
	text-align: center;
	color: #ffffff;
	cursor: pointer;
}

#wad {
	margin-top: 60px;
	width: 880px;
}

#wad p {
	background-color: #aaff7f;
	font-size: 18px;
	line-height: 30px;
	word-wrap: break-word;
}
</style>
</head>
<body>

	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav">
				<a class="blog-nav-item active" href="index.jsp">主页</a> <a
					class="blog-nav-item" href="#">科技</a> <a class="blog-nav-item"
					href="#">新闻</a> <a class="blog-nav-item" href="#">生活</a> <a
					class="blog-nav-item" href="#">脱发</a>
			</nav>
		</div>
	</div>

	<div class="container">

		<div class="blog-header">
			<h2 class="blog-title">-_-</h2>
			<p class="lead blog-description">向世界分享你刚编的故事</p>
		</div>

		<div class="row">

			<div class="col-sm-8 blog-main">

				<div class="blog-post">
					<h2 class="blog-post-title">文章列表</h2>
					<%
						ArticleDao dao = new ArticleDao();
						List<Article> list = (List) request.getAttribute("list");

						for (Article article : list) {
					%>
					<div
						style="border: 5px #000000 solid; font-size: 25px; border-color: red; color: red;">
						<label> 标题：</label>
						<%=article.getArtName()%>
					</div>

					<br> <br> <br> <label> 内容：</label>
					<div style="border: 1px #000000 solid;">
						<%=article.getArtText()%>
					</div>
					<br> <br> <br>
					<%
						}
					%>
				</div>
				<!-- /.blog-post -->
				<nav>
					<ul class="pager">

					</ul>
				</nav>


			</div>
			<!-- /.blog-main -->
			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>博客搜索</h4>

					<form action="/web/home/index.do" method="post">
						<!-- <input type="hidden" name="op" value="get"/> -->
						<input type="text" id="name" name="name" value="" /> <input
							type="submit" value="提交" />
					</form>
					<br>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary btn-lg"
						data-toggle="modal" data-target="#myModal">添加</button>

					<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h2 class="modal-title" id="myModalLabel">添加博客</h2>
								</div>
								<div class="modal-body">
									<form class="layui-form"
										action="${pageContext.request.contextPath}/home/index.do"
										method="post" enctype="multipart/form-data">
										<h4>标题</h4>
										<div class="layui-form-item">
											<input class="layui-input" type="text" id="name" name="name"
												value="" /><br> <br>
										</div>
										<h4>正文内容</h4>
										<textarea name="blogText" rows="10" cols="60"></textarea>
										<br> <input type="hidden" name="op" value="add" /> <input
											type="file" name="myfile" /> <input type="submit"
											class="btn btn-primary" value="提交" />
									</form>

								</div>


							</div>
						</div>
					</div>
				</div>

				<div class="sidebar-module">
					<h4>链接</h4>
					<ol class="list-unstyled">
						<li><a href="https://github.com/">GitHub</a></li>
						<br>
						<li><a href="https://www.baidu.com/">百度</a></li>
						<br>
						<li><a href="https://www.bilibili.com/">bilibili</a></li>
						<br>
					</ol>
				</div>
			</div>
			<!-- /.blog-sidebar -->


		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<footer class="blog-footer">
		<p>
			BLOG <a href="#">Bootstrap</a> by <a href="#">@mdo</a>.
		</p>
		<p>
			<a href="#">Back to top</a>
		</p>
	</footer>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- <script src="js/jquery-1.8.3.js"></script> -->
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
		<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-1.8.3.js"><\/script>')
	</script>
	<script src="../js/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

	<!-- 加载编辑器的容器 -->
	<script id="container" name="content" type="text/plain">
                                                这里写你的初始化内容
                                            </script>

	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var ue = UE.getEditor('container');
	</script>
</body>
</html>