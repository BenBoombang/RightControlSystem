<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>管理系统|权限列表</title>

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
				资源权限管理 <small>全部权限</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/permission/queryAll">权限管理</a></li>

				<li class="active">全部权限</li>
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
										<button type="button" class="btn btn-default" title="新建" onclick="location.href='${pageContext.request.contextPath}/pages/permission-add.jsp'">
											<i class="fa fa-file-o"></i> 新建
										</button>
										
										<button type="button" class="btn btn-default" onclick="window.location.reload();" title="刷新">
											<i class="fa fa-refresh"></i> 刷新
										</button>
									</div>
								</div>
							</div>
							<div class="box-tools pull-right col-md-2">
								<div class="has-feedback input-group">
									<span class="input-group-btn">
										<button class="btn btn-primary btn-sm" type="button" onclick="permissionPageQuery(1)">搜索</button>
									</span>
									<input type="text" class="form-control input-sm"
										   placeholder="权限名称" name="queryText" id="queryText" />
								</div>
							</div>
							<!--工具栏/-->

							<!--数据列表-->
							<table id="dataList"
								class="table table-bordered table-striped table-hover dataTable">
								<thead>
									<tr>
										<th class="" style="padding-right: 0px"><input
											id="selall" type="checkbox" class="icheckbox_square-blue">
										</th>
										<th class="sorting_asc">ID</th>
										<th class="sorting_desc">权限名称</th>
										<th class="sorting_asc sorting_asc_disabled">描述</th>										
										<th class="text-center">操作</th>
									</tr>
								</thead>
								<tbody id="permissionData">


								</tbody>

							</table>

							<%-- 隐藏域 pagesize --%>
							<input type="hidden" id="hiddenPageSize">

							<!--数据列表/-->

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
			<!-- @@close -->
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

		<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
		<script>
			$.widget.bridge('uibutton', $.ui.button);
		</script>
		<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
		<script
			src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
		<script
			src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
		<script
			src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
		<script
			src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/layer/layer.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/jqPage/jqPaginator.js"></script>
		<script>
			$(document).ready(function() {
				// 选择框
				$(".select2").select2();

				// WYSIHTML5编辑器
				$(".textarea").wysihtml5({
					locale : 'zh-CN'
				});
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
				setSidebarActive("admin-datalist");

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

				permissionPageQuery(1);
				
			});

			// 修改权限
			function permissionEdit(id) {
				window.location.href="${pageContext.request.contextPath}/permission/editPermission?id=" + id;
			}

			function permissionChangePageSize() {
				//获取下拉框的值
				var pageSize = $("#selectPageSize").val();

				// 将这个放到隐藏域中
				$("#hiddenPageSize").val(pageSize);

				// 然后立刻进行一次分页查询
				permissionPageQuery(1);
			}


			// 创建权限分页查询
			function permissionPageQuery(pageno) {
				var permissionLoading = null;

				var permissionContent = "";

				var footContent = "";

				var pagesize = $("#hiddenPageSize").val();
				if (pagesize == "") {
					pagesize = 3;
				}

				var ajaxData = {
					"pageno" : pageno,
					"pagesize" : pagesize
				};

				var text = $("#queryText").val();
				if (text != "") {
					ajaxData.queryText = text;
				}

				$.ajax({
					type : "post",
					url : "${pageContext.request.contextPath}/permission/pageQuery",
					data : ajaxData,
					beforeSend : function () {
						permissionLoading = layer.msg('数据加载中',{icon:16});
					},
					success : function (result) {
						layer.close(permissionLoading);

						if (result.succ) {

							var pageInfo = result.data;

							$.each(pageInfo.list,function (i,permission) {
								permissionContent += '<tr>';
								permissionContent += '<td><input name="ids" type="checkbox"></td>';
								permissionContent += '<td>' + permission.id + '</td>';
								permissionContent += '<td>' + permission.permissionName + '</td>';
								permissionContent += '<td>' + permission.url + '</td>';
								permissionContent += '<td class="text-center">';
								permissionContent += '	<a href="#" onclick="permissionEdit('+ permission.id +')" class="btn bg-olive btn-xs">权限编辑</a>';
								permissionContent += '</td>';
								permissionContent += '</tr>';
							});

							$("#permissionData").html(permissionContent);

							// 给隐藏域再次赋值
							$("#hiddenPageSize").val(pageInfo.pageSize);

							footContent += '总共 <strong> ' +pageInfo.pages + ' </strong> 页，共 <strong> ' + pageInfo.total + ' </strong> 条数据。每页 <select class="form-control" id="selectPageSize" onchange="permissionChangePageSize()">';
							footContent += '<option value="1">1</option>';
							footContent += '<option value="2">2</option>';
							footContent += '<option value="3">3</option>';
							footContent += '<option value="4">4</option>';
							footContent += '<option value="5">5</option>';
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
										permissionPageQuery(num);//当前页码
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