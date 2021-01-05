<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>管理系统|访问日志</title>

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/morris/morris.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/select2/select2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->

		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				日志管理 <small>全部日志</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/log/queryAll">日志管理</a></li>

				<li class="active">全部日志</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content"> <!-- .box-body -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">列表</h3>
				</div>

				<div class="box-body">

					<!-- 数据表格 -->
					<div class="table-box">

						<!--工具栏-->
						<div class="pull-left">
							<div class="form-group form-inline">
								<div class="btn-group">
									<button type="button" class="btn btn-default" title="刷新"
										onclick="window.location.reload();">
										<i class="fa fa-refresh"></i> 刷新
									</button>
								</div>
							</div>
						</div>
						<div class="box-tools pull-right col-md-2">
							<div class="has-feedback input-group">
									<span class="input-group-btn">
										<button class="btn btn-primary btn-sm" type="button" onclick="logPageQuery(1)">搜索</button>
									</span>
								<input type="text" class="form-control input-sm"
									   placeholder="方法名" name="queryText" id="queryText" />
							</div>
						</div>
						<!--工具栏/-->

						<!--数据列表-->
						<table id="dataList"
							class="table table-bordered table-striped table-hover dataTable">
							<thead>
								<tr>
									<th class="" style="padding-right: 0px"><input id="selall"
										type="checkbox" class="icheckbox_square-blue"></th>
									<th class="sorting_asc">ID</th>
									<th class="sorting">访问时间</th>
									<th class="sorting">访问用户</th>
									<th class="sorting">访问IP</th>
									<th class="sorting">资源URL</th>
									<th class="sorting">执行时间</th>
									<th class="sorting">访问方法</th>
								</tr>
							</thead>
							<tbody id="logData">

							</tbody>

						</table>
						<!--数据列表/-->

						<%-- 隐藏域：pagesize --%>
						<input type="hidden" id="hiddenPageSize">

					</div>
					<!-- 数据表格 /-->

				</div>
				<!-- /.box-body -->

				<!-- .box-footer-->
				<div class="box-footer">
					<div class="pull-left">
						<div class="form-group form-inline" id="footData">

						</div>
					</div>

					<div class="box-tools pull-right">
						<ul class="pagination">

						</ul>
					</div>

				</div>
				<!-- /.box-footer-->

			</div>

			</section>
			<!-- 正文区域 /-->

		</div>
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.0
		</div>
		<strong>Copyright &copy; 2020-2021 <a
			href="#">BenBoy</a>.
		</strong> All rights reserved. </footer>
		<!-- 底部导航 /-->

	</div>

	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/layer/layer.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jqPage/jqPaginator.js"></script>

	<script>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});

			logPageQuery(1);
		});

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}

		$(document).ready(function() {

			// 激活导航位置
			setSidebarActive("order-manage");

			// 列表按钮 
			$("#dataList td input[type='checkbox']").iCheck({
				checkboxClass : 'icheckbox_square-blue',
				increaseArea : '20%'
			});
			// 全选操作 
			$("#selall").click(function() {
				var clicks = $(this).is(':checked');
				if (!clicks) {
					$("#dataList td input[type='checkbox']").iCheck("uncheck");
				} else {
					$("#dataList td input[type='checkbox']").iCheck("check");
				}
				$(this).data("clicks", !clicks);
			});
		});

		function logChangePageSize() {
			//获取下拉框的值
			var pageSize = $("#selectPageSize").val();

			// 将这个放到隐藏域中
			$("#hiddenPageSize").val(pageSize);

			// 然后立刻进行一次分页查询
			logPageQuery(1);
		}



		function logPageQuery(pageno) {
			var logLoading = null;

			// 从隐藏域中获取 pagesize
			var pagesize = $("#hiddenPageSize").val();
			if (pagesize == "") {
				pagesize = 10;
			}

			var ajaxData = {
				"pageno" : pageno,
				"pagesize" : pagesize
			};

			// 从搜索框中获取值
			var text = $("#queryText").val();
			if (text != "") {
				ajaxData.queryText = text;
			}

			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/log/pageQuery",
				data : ajaxData,
				beforeSend : function () {
					logLoading = layer.msg('数据加载中',{icon:16});
				},
				success : function (result) {
					layer.close(logLoading);

					if (result.succ) {

						var logContent = "";

						var footContent = "";

						var pageInfo = result.data;

						$.each(pageInfo.list,function (i,log) {
							logContent += '<tr>';
							logContent += '<td><input name="ids" type="checkbox"></td>';
							logContent += '<td>' + log.id + '</td>';
							logContent += '<td>' + log.visitTimeStr + '</td>';
							logContent += '<td>' + log.username + '</td>';
							logContent += '<td>' + log.ip + '</td>';
							logContent += '<td>' + log.url+ '</td>';
							logContent += '<td>' + log.executionTime + '毫秒</td>';
							logContent += '<td>' + log.method+ '</td>';
							logContent += '</tr>';
						});

						$("#logData").html(logContent);

						// 给 pageSize 隐藏域赋值
						$("#hiddenPageSize").val(pageInfo.pageSize);

						footContent += '总共 <strong> ' +pageInfo.pages + ' </strong> 页，共 <strong> ' + pageInfo.total + ' </strong> 条数据。每页 <select class="form-control" id="selectPageSize" onchange="logChangePageSize()">';
						footContent += '<option value="10">10</option>';
						footContent += '<option value="20">20</option>';
						footContent += '<option value="30">30</option>';
						footContent += '<option value="40">40</option>';
						footContent += '<option value="50">50</option>';
						footContent += '</select> 条';

						// 构建左下角内容
						$("#footData").html(footContent);

						$("#selectPageSize option[value='"+ pageInfo.pageSize +"']").attr("selected", true);

						$.jqPaginator(".pagination", {
							// totalPages: 100, //设置分页的总页数
							totalCounts: pageInfo.total, //设置分页的总条目数
							pageSize: pageInfo.pageSize,
							visiblePages: 5, //设置最多显示的页码数（例如有100也，当前第1页，则显示1 - 7页）
							currentPage: pageInfo.pageNum,//当前页
							first: '<li class="first"><a href="javascript:;">首页</a></li>',
							prev: '<li class="prev"><a href="javascript:;"><i class="arrow arrow2"></i>上一页</a></li>',
							next: '<li class="next"><a href="javascript:;">下一页<i class="arrow arrow3"></i></a></li>',
							last: '<li class="last"><a href="javascript:;">末页</a></li>',
							page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
							onPageChange: function (num, type) {
								//页面变化回调函数
								if (type == "change") {
									logPageQuery(num);//当前页码
								}
							}
						});

					}else {
						layer.msg("相关数据不存在", {time:2000, icon:5, shift:6},function () {
							// 回调函数
						});
					}
				}
			})
		}


	</script>
</body>

</html>