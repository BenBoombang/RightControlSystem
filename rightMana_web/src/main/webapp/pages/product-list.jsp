<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>管理系统|商品展示页</title>

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<!-- Font Awesome -->
<!-- Ionicons -->
<!-- iCheck -->
<!-- Morris chart -->
<!-- jvectormap -->
<!-- Date Picker -->
<!-- Daterange picker -->
<!-- Bootstrap time Picker -->
<!--<link rel="stylesheet" href="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.css">-->
<!-- bootstrap wysihtml5 - text editor -->
<!--数据表格-->
<!-- 表格树 -->
<!-- select2 -->
<!-- Bootstrap Color Picker -->
<!-- bootstrap wysihtml5 - text editor -->
<!--bootstrap-markdown-->
<!-- Theme style -->
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<!-- Ion Slider -->
<!-- ion slider Nice -->
<!-- bootstrap slider -->
<!-- bootstrap-datetimepicker -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->








<!-- jQuery 2.2.3 -->
<!-- jQuery UI 1.11.4 -->
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<!-- Bootstrap 3.3.6 -->
<!-- Morris.js charts -->
<!-- Sparkline -->
<!-- jvectormap -->
<!-- jQuery Knob Chart -->
<!-- daterangepicker -->
<!-- datepicker -->
<!-- Bootstrap WYSIHTML5 -->
<!-- Slimscroll -->
<!-- FastClick -->
<!-- iCheck -->
<!-- AdminLTE App -->
<!-- 表格树 -->
<!-- select2 -->
<!-- bootstrap color picker -->
<!-- bootstrap time picker -->
<!--<script src="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
<!-- Bootstrap WYSIHTML5 -->
<!--bootstrap-markdown-->
<!-- CK Editor -->
<!-- InputMask -->
<!-- DataTables -->
<!-- ChartJS 1.0.1 -->
<!-- FLOT CHARTS -->
<!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
<!-- FLOT PIE PLUGIN - also used to draw donut charts -->
<!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
<!-- jQuery Knob -->
<!-- Sparkline -->
<!-- Morris.js charts -->
<!-- Ion Slider -->
<!-- Bootstrap slider -->
<!-- bootstrap-datetimepicker -->
<!-- 页面meta /-->

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

<body class="hold-transition skin-purple sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->
		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<!-- @@master = admin-layout.html-->
		<!-- @@block = content -->

		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
				<h1>
					产品管理 <small>产品列表</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="#">基础数据</a></li>
					<li class="active">产品管理</li>
				</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content">

				<!-- .box-body -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">产品列表</h3>
					</div>

					<div class="box-body">

						<!-- 数据表格 -->
						<div class="table-box">

							<!--工具栏-->
							<div class="pull-left">
								<div class="form-group form-inline">
									<div class="btn-group">
										<button type="button" class="btn btn-default" title="新建"
											onclick="window.location.href='${pageContext.request.contextPath}/pages/product-add.jsp'">
											<i class="fa fa-file-o"></i> 新建
										</button>
										<button type="button" class="btn btn-default" onclick="deleteProducts()" title="删除">
											<i class="fa fa-trash-o"></i> 删除
										</button>
										<button type="button" class="btn btn-default" onclick="openStatus()" title="开启">
											<i class="fa fa-check"></i> 开启
										</button>
										<button type="button" class="btn btn-default" onclick="closeStatus()" title="屏蔽">
											<i class="fa fa-ban"></i> 屏蔽
										</button>
										<button type="button" class="btn btn-default" onclick="window.location.reload();" title="刷新">
											<i class="fa fa-refresh"></i> 刷新
										</button>
										<button type="button" class="btn btn-default" onclick="productExportToExcel()" title="刷新">
											<i class="fa fa-download"></i> 导出
										</button>
									</div>
								</div>
							</div>
							<div class="box-tools pull-right col-md-2">
								<div class="has-feedback input-group">
									<span class="input-group-btn">
										<button class="btn btn-primary btn-sm" type="button" onclick="productPageQuery(1)">搜索</button>
									</span>
									<input type="text" class="form-control input-sm"
										placeholder="产品编号" name="queryText" id="queryText" />
								</div>
							</div>
							<!--工具栏/-->

							<%-- 隐藏域，用来存储 pageSize --%>
							<input type="hidden" name="currentPageSize" id="currentPageSize">

							<!--数据列表-->
							<form id="productForm">
							<table id="dataList"
								class="table table-bordered table-striped table-hover dataTable">
								<thead>
									<tr>
										<th class="" style="padding-right: 0px;"><input
											id="selall" type="checkbox" class="icheckbox_square-blue">
										</th>
										<th class="sorting_asc">ID</th>
										<th class="sorting_desc">编号</th>
										<th class="sorting_asc sorting_asc_disabled">产品名称</th>
										<th class="sorting_desc sorting_desc_disabled">出发城市</th>
										<th class="sorting">出发时间</th>
										<th class="text-center sorting">产品价格</th>
										<th class="sorting">产品描述</th>
										<th class="text-center sorting">状态</th>
										<th class="text-center">操作</th>
									</tr>
								</thead>
								<tbody id="productData">

								</tbody>

							</table>
							</form>
							<!--数据列表/-->

						</div>
						<!-- 数据表格 /-->


					</div>
					<!-- /.box-body -->

					<!-- .box-footer-->
					<div class="box-footer">
						<div class="pull-left">
							<div class="form-group form-inline" id="footData" >
				
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
			</strong> All rights reserved.
		</footer>
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
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/layer/layer.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jqPage/jqPaginator.js"></script>
	<script>
		$(document).ready(function() {
			// // 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});

			productPageQuery(1);

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

		});

		// 导出到Excel
		function productExportToExcel() {
			// 首先获取筛选框中的条件
			var qryText = $("#queryText").val();
			window.location.href="${pageContext.request.contextPath}/product/export?queryText=" + qryText;
		}


		// 批量屏蔽商品
		function closeStatus() {
			// 首先判断你有没有选中某行数据
			var closeBoxs = $("input[name='ids']:checked");
			if (closeBoxs.length == 0) {
				layer.msg("请至少选择一条数据", {time:2000, icon:5, shift:6}, function () {
					// 回调方法
				});
			}else {
				layer.confirm("是否要屏蔽所选商品",  {icon: 3, title:'提示'}, function(cindex){
					layer.close(cindex);

					$.ajax({
						type : "post",
						url : "${pageContext.request.contextPath}/product/closes",
						data : $("#productForm").serialize(),
						success : function (result) {
							if (result.succ) {

								productPageQuery(1);
							}else {
								layer.msg("屏蔽商品失败", {time:2000, icon:5, shift:6}, function () {
									// 回调方法
								});
							}
						}
					})

				}, function(cindex){
					layer.close(cindex);
				});
			}
		}


		// 批量开启商品
		function openStatus() {
			// 首先判断你有没有选中某行数据
			var openBoxs = $("input[name='ids']:checked");
			if (openBoxs.length == 0) {
				layer.msg("请至少选择一条数据", {time:2000, icon:5, shift:6}, function () {
					// 回调方法
				});
			}else {
				layer.confirm("是否要开启所选商品",  {icon: 3, title:'提示'}, function(cindex){
					layer.close(cindex);

					$.ajax({
						type : "post",
						url : "${pageContext.request.contextPath}/product/opens",
						data : $("#productForm").serialize(),
						success : function (result) {
							if (result.succ) {

								productPageQuery(1);
							}else {
								layer.msg("开启商品失败", {time:2000, icon:5, shift:6}, function () {
									// 回调方法
								});
							}
						}
					})

				}, function(cindex){
					layer.close(cindex);
				});
			}
		}


		// 批量删除商品
		function deleteProducts() {
			// 首先判断你有没有选中某行数据
			var boxs =  $("input[name='ids']:checked");
			if (boxs.length == 0) {
				layer.msg("请至少选择一条数据", {time:2000, icon:5, shift:6}, function () {
					// 回调方法
				});
			}else {
				layer.confirm("是否要删除所选商品",  {icon: 3, title:'提示'}, function(cindex){
					layer.close(cindex);

					$.ajax({
						type : "post",
						url : "${pageContext.request.contextPath}/product/deletes",
						data : $("#productForm").serialize(),
						success : function (result) {
							if (result.succ) {

								productPageQuery(1);
							}else {
								layer.msg("删除商品失败", {time:2000, icon:5, shift:6}, function () {
									// 回调方法
								});
							}
						}
					})

				}, function(cindex){
					layer.close(cindex);
				});
			}
		}


		// 修改商品函数
		function editProduct(productId) {
			window.location.href = "${pageContext.request.contextPath}/product/edit?productId=" + productId;
		}

		
		// 删除商品函数
		function deleteProduct(productId,productName) {

			layer.confirm("是否要删除商品【" + productName + "】",  {icon: 3, title:'提示'}, function(cindex){
				layer.close(cindex);

				$.ajax({
					type : "post",
					url : "${pageContext.request.contextPath}/product/delete",
					data : {
						"productId" : productId
					},
					success : function (result) {
						if (result.succ) {

							productPageQuery(1);
						}else {
							layer.msg("删除商品失败", {time:2000, icon:5, shift:6}, function () {
								// 回调方法
							});
						}
					}
				})

			}, function(cindex){
				layer.close(cindex);
			});


		}
		

		// 创建异步分页查询语句
		function productPageQuery(pageno) {

			var productLoading = null;

			// 首先尝试从 隐藏域 pageSize 中获取值
			var pagesize = $("#currentPageSize").val();
			if (pagesize == "") {
				pagesize = 3;
			}

			// 创建初始筛选条件
			var ajaxData = {
				"pageno" : pageno,
				"pagesize" : pagesize
			};

			// 尝试从筛选条件框中获取数据
			var text= $("#queryText").val();
			if (text != ""){
				ajaxData.queryText = text;
			}


			// 构建ajax请求
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/product/pageQuery",
				dataType : "json",
				data : JSON.stringify(ajaxData),
				contentType : "application/json;charset=utf-8",
				beforeSend : function () {
					productLoading = layer.msg("数据加载中",{icon:16});
				},
				success : function (result) {
					layer.close(productLoading);

					if (result.succ){

						var dataContent = "";

						var footContent = "";

						var pageInfo = result.data;
						var productList = pageInfo.list;


						$.each(productList,function (i, product) {
							dataContent += '<tr>';
							dataContent += '<td><input class="itemBox" name="ids" type="checkbox" value="' + product.id +'"></td>';
							dataContent += '<td>' + product.id + '</td>';
							dataContent += '<td>' + product.productNum + '</td>';
							dataContent += '<td>' + product.productName + '</td>';
							dataContent += '<td>' + product.cityName + '</td>';
							dataContent += '<td>' + product.departureTimeStr + '</td>';
							dataContent += '<td class="text-center">' + product.productPrice + '</td>';
							dataContent += '<td>' + product.productDesc + '</td>';
							dataContent += '<td class="text-center">' + product.productStatusStr + '</td>';
							dataContent += '<td class="text-center">';
							dataContent += '	<button type="button" class="btn bg-olive btn-xs" onclick="editProduct('+ product.id +')">编辑</button>';
							dataContent += '	<button type="button" class="btn bg-olive btn-xs" onclick="deleteProduct('+ product.id +',\''+product.productName +'\')">删除</button>';
							dataContent += '</td>';
							dataContent += '</tr>';
						});


						$("#productData").html(dataContent);

						// 给 pageSize 隐藏域赋值
						$("#currentPageSize").val(pagesize);

						footContent += '总共 <strong> ' +pageInfo.pages + ' </strong> 页，共 <strong> ' + pageInfo.total + ' </strong> 条数据。每页 <select class="form-control" id="selectPageSize" onchange="productChangePageSize()">';
						footContent += '<option value="1">1</option>';
						footContent += '<option value="2">2</option>';
						footContent += '<option value="3">3</option>';
						footContent += '<option value="4">4</option>';
						footContent += '<option value="5">5</option>';
						footContent += '</select> 条';

						// 构建左下角内容
						$("#footData").html(footContent);

						$("#selectPageSize option[value='"+ pageInfo.pageSize +"']").attr("selected", true);

						$.jqPaginator('.pagination', {
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
									productPageQuery(num);//当前页码
								}
							}
						});

					}else {
						layer.msg("数据加载失败", {time:2000, icon:5, shift:6}, function () {
							// 回调方法
						});
					}
				}
			})
		}


		function productChangePageSize() {
			//获取下拉框的值
			var pageSize = $("#selectPageSize").val();

			// 将这个放到隐藏域中
			$("#currentPageSize").val(pageSize);

			// 然后立刻进行一次分页查询
			productPageQuery(1);

		}

	</script>
</body>

</html>