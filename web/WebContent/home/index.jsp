<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>数据表后台</title>
<!-- Bootstrap core CSS -->
<link href="../js/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" href="../js/layui/css/layui.css" media="all">
</head>
<body>
	<!--  navbar-fixed-top 浮动 -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">项目后台</a>
			</div>
			<div id="navbar " class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#myModal" data-toggle="modal">修改账号</a></li>
					<li><a href="register.jsp">注册账号</a></li>
					<li><a href="#">个人信息</a></li>
					<li><a href="#">帮助</a></li>
				</ul>
				<form action="/web/userajax" class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="请输入">
					<button id="button1" type="submit" class="blockquote-reverse">搜索</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="index.jsp">用户管理<span
							class="sr-only">(current)</span></a></li>
					<li><a href="#"></a></li>
					<li><a href="#">控制面板</a></li>
					<li><a href="#">数据展示</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">选项1</a></li>
					<li><a href="">选项2</a></li>
					<li><a href="">选项3</a></li>
					<li><a href="">选项4</a></li>
					<li><a href="">选项5</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">选项A</a></li>
					<li><a href="">选项B</a></li>
					<li><a href="">选项C</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<table id="demo" lay-filter="test"></table>
				<script src="../js/layui/layui.js"></script>
				<script>
					layui.use('table', function() {
						var table = layui.table;
						//第一个实例
						table.render({
							elem : '#demo',
							height : 'full',
							method : 'post',
							url : '/web/userajax' //数据接口
							,
							cellMinWidth : 120 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
							/* 	page : { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
									layout : [ 'limit', 'count', 'prev', 'page',
											'next', 'skip' ] //自定义分页布局
									//,curr: 5 //设定初始在第 5 页
									,
									groups : 20 //只显示 5 个连续页码
									,
									first : true //显示首页
									,
									last : true
								//显示尾页
								} */

							,
							groups : 20,
							request : {
								pageName : 'pageNum' //页码的参数名称，默认：page
								,
								limitName : 'pageSize' //每页数据量的参数名，默认：limit
							},
							response : {
								pageName : 'pageNum' //页码的参数名称，默认：page
								,
								limitName : 'pageSize' //每页数据量的参数名，默认：limit
							}

							,
							page : true //开启分页

							,
							
							cols : [ [ //表头
							/* {
								field : 'id',
								title : 'id',
								width : 400,
								sort : true,
								fixed : 'left'
							},  */{
								field : 'name',
								title : 'name',
								sort : true,
								width : 150
							}, {
								field : 'username',
								title : 'username',
								sort : true,
								width : 200,
								sort : true
							}, {
								field : 'password',
								title : 'password',
								width : 200
							}, {
								field : 'text',
								title : 'text',
								width : 200
							}, {
								field : 'rc',
								title : 'rc',
								width : 80,
								sort : true,
								
							} , {
								field : '',
								title : '操作',
								width : 180,
								sort : true,
								toolbar: '#barDemo'
							}] ]
						});
						
						
						
						//监听头工具栏事件
						  table.on('toolbar(test)', function(obj){
						    var checkStatus = table.checkStatus(obj.config.id)
						    ,data = checkStatus.data; //获取选中的数据
						    switch(obj.event){
						      case 'add':
						        layer.msg('添加');
						      break;
						      case 'update':
						        if(data.length === 0){
						          layer.msg('请选择一行');
						        } else if(data.length > 1){
						          layer.msg('只能同时编辑一个');
						        } else {
						          layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
						        }
						      break;
						      case 'delete':
						        if(data.length === 0){
						          layer.msg('请选择一行');
						        } else {
						          layer.msg('删除');
						        }
						      break;
						    };
						  });
						  
						  //监听行工具事件
						  table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
						    var data = obj.data //获得当前行数据
						    ,layEvent = obj.event; //获得 lay-event 对应的值
						    if(layEvent === 'detail'){
						      layer.msg('查看操作');
						    } else if(layEvent === 'del'){
						      layer.confirm('真的删除行么', function(index){
						        obj.del(); //删除对应行（tr）的DOM结构
						        layer.close(index);
						        //向服务端发送删除指令
						      });
						    } else if(layEvent === 'edit'){
						      layer.msg('编辑操作');
						    }
						  });
						
					});
				</script>
			</div>
		</div>
	</div>

	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

  <!-- 这里同样支持 laytpl 语法，如： -->
  {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
  {{#  } }}
</script>

	<!-- 修改模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改用户帐号信息</h4>
				</div>
				<div class="modal-body">
					<form class=""
						action="${pageContext.request.contextPath}/home/index.do"
						method="post" enctype="multipart/form-data">
						<div class="form-group col-sm-12">
							<label for="firstname" class="col-sm-2 control-label">昵称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="firstname"
									placeholder="昵称">
							</div>
						</div>

						<div class="form-group col-sm-12">
							<label for="lastname" class="col-sm-2 control-label">帐号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="lastname"
									placeholder="请输入帐号">
							</div>
						</div>

						<div class="form-group col-sm-12">
							<label for="lastname" class="col-sm-2 control-label">帐号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="lastname"
									placeholder="请输入密码">
							</div>
						</div>


						<br> <input type="hidden" name="op" value="add" />

						<div class="col-sm-2 ">
							<!-- 上传  -->
							<label for="file" class="btn btn-info">上传</label> <input
								id="file" name="myfile" type="file" style="display: none">


						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-primary" value="提交" />
						</div>
					</form>

				</div>


			</div>
		</div>
	</div>


	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		
	</script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="../js/js/bootstrap.min.js"></script>
</body>
</html>
