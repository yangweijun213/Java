<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<title>DEMO</title>

		<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui.theme.min.css" />
		<link rel="stylesheet" type="text/css" href="css/ui.jqgrid-bootstrap-ui.css" />
		<link rel="stylesheet" type="text/css" href="css/ui.jqgrid.css" />
	</head>

	<body>
		<div class="main" id="main">
			<!--jqGrid 主表所在-->
			<table id="grid-table"></table>
			<!--jqGrid 主表浏览导航栏所在-->
			<div id="grid-pager"></div>
			<!--jqGrid 从表所在-->
			<table id="grid-tableo"></table>
			<!--jqGrid 从表浏览导航栏所在-->
			<div id="grid-pagero"></div>
		</div>

		<script src="js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/i18n/grid.locale-cn.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery.jqGrid.min.js" type="text/javascript" charset="utf-8"></script>

		<script type="text/javascript">
			//当 datatype 为"local" 时需填写   
			
			var grid_selector = "#grid-table";
			var pager_selector = "#grid-pager";
			var grid_selectoro = "#grid-tableo";
			var pager_selectoro = "#grid-pagero";
			$(document).ready(function() {
				$("#grid-table").jqGrid({
				    //用于检索的Servlet URL
				    url:"<%=basePath%>"+"demoServlet", 
				    //用于添加、修改、删除的Servlet URL
				    editurl: "<%=basePath%>"+"demochangeServlet",
					//data: grid_data, //当 datatype 为"local" 时需填写  
					datatype:"json", //数据来源，本地数据（local，json,jsonp,xml等）
					height: 150, //高度，表格高度。可为数值、百分比或'auto'
					mtype:"GET",//提交方式
					colNames: ['出库单号', '出库类型', '总金额', '申请人（单位）', '备注'],
					colModel: [{
						name: 'id',
						index: 'id', //索引。其和后台交互的参数为sidx
						key: true, //当从服务器端返回的数据中没有id时，将此作为唯一rowid使用只有一个列可以做这项设置。如果设置多于一个，那么只选取第一个，其他被忽略
						width: 100,
						editable: false,
						editoptions: {
							size: "20",
							maxlength: "30"
						}
					}, {
						name: 'type',
						index: 'type',
						width: 200, //宽度
						editable: true, //是否可编辑
						edittype: "select", //可以编辑的类型。可选值：text, textarea, select, checkbox, password, button, image and file.s
						editoptions: {
							value: "1:采购入库;2:退用入库"
						}
					}, {
						name: 'pay',
						index: 'pay',
						width: 60,
						sorttype: "double",
						editable: true
					}, {
						name: 'name',
						index: 'name',
						width: 150,
						editable: true,
						editoptions: {
							size: "20",
							maxlength: "30"
						}
					}, {
						name: 'text',
						index: 'text',
						width: 250,
						sortable: false,
						editable: true,
						edittype: "textarea",
						editoptions: {
							rows: "2",
							cols: "10"
						}
					}, ],
					viewrecords: true, //是否在浏览导航栏显示记录总数
					rowNum: 10, //每页显示记录数
					rowList: [10, 20, 30], //用于改变显示行数的下拉列表框的元素数组。
					pager: pager_selector, //分页、按钮所在的浏览导航栏
					altRows: true, //设置为交替行表格,默认为false
					//toppager: true,//是否在上面显示浏览导航栏
					multiselect: false, //是否多选
					//multikey: "ctrlKey",//是否只能用Ctrl按键多选
					multiboxonly: true, //是否只能点击复选框多选
					// subGrid : true, 
					//sortname:'id',//默认的排序列名
					//sortorder:'asc',//默认的排序方式（asc升序，desc降序）
					caption: "采购退货单列表", //表名
					autowidth: true, //自动宽
					onSelectRow : function(ids) {
		                jQuery(grid_selectoro).jqGrid('setGridParam', {
		                  url :"<%=basePath%>"+"goodlistServlet?flag=true&id=" + ids,
		                  page : 1
		                });
		                jQuery(grid_selectoro).jqGrid('setCaption',
		                    "物资详细类表" +" : " + ids).trigger(
		                    'reloadGrid');
		              }
				});
				//浏览导航栏添加功能部分代码
				$(grid_selector).navGrid(pager_selector, {
						search: true, // 检索
						add: true, //添加  （只有editable为true时才能显示属性）
						edit: true, //修改（只有editable为true时才能显示属性）
						del: true, //删除
						refresh: true //刷新
					}, {}, // edit options
					{}, // add options
					{}, // delete options
					{
						multipleSearch: true
					} // search options - define multiple search
				);
				
				
				$("#grid-tableo").jqGrid({
				    //用于检索的Servlet URL
				    url:"<%=basePath%>"+"goodlistServlet?flag=false&", 
			
					//data: grid_data, //当 datatype 为"local" 时需填写  
					datatype:"json", //数据来源，本地数据（local，json,jsonp,xml等）
					height: 150, //高度，表格高度。可为数值、百分比或'auto'
					mtype:"GET",//提交方式
					colNames: ['物资编号', '物质类型', '物资名称', '数量', ],
					colModel: [{
						name: 'g_id',
						index: 'g_id', //索引。其和后台交互的参数为sidx
						key: true, //当从服务器端返回的数据中没有id时，将此作为唯一rowid使用只有一个列可以做这项设置。如果设置多于一个，那么只选取第一个，其他被忽略
						width: 100,
						editable: false,
						editoptions: {
							size: "20",
							maxlength: "30"
						}
					}, {
						name: 'g_type',
						index: 'g_type',
						width: 200, //宽度
						editable: true, //是否可编辑
						edittype: "select", //可以编辑的类型。可选值：text, textarea, select, checkbox, password, button, image and file.s
						editoptions: {
							value: "1:试剂;2:日用品;3:其他"
						}
					}, {
						name: 'g_name',
						index: 'g_name',
						width: 150,
						editable: true,
						editoptions: {
							size: "20",
							maxlength: "30"
						}
					}, {
						name: 'd_num',
						index: 'd_num',
						width: 60,
						editable: true
					}
					],
					viewrecords: true, //是否在浏览导航栏显示记录总数
					rowNum: 10, //每页显示记录数
					rowList: [10, 20, 30], //用于改变显示行数的下拉列表框的元素数组。
					pager: pager_selectoro, //分页、按钮所在的浏览导航栏
					altRows: true, //设置为交替行表格,默认为false
					//toppager: true,//是否在上面显示浏览导航栏
					multiselect: false, //是否多选
					//multikey: "ctrlKey",//是否只能用Ctrl按键多选
					multiboxonly: true, //是否只能点击复选框多选
					// subGrid : true, 
					//sortname:'id',//默认的排序列名
					//sortorder:'asc',//默认的排序方式（asc升序，desc降序）
					caption: "物资详细列表", //表名
					autowidth: true //自动宽
					
				});
				//浏览导航栏添加功能部分代码
				$(grid_selectoro).navGrid(pager_selectoro, {
						search: true, // 检索
						add: false, //添加  （只有editable为true时才能显示属性）
						edit: false, //修改（只有editable为true时才能显示属性）
						del: false, //删除
						refresh: true //刷新
					}, {}, // edit options
					{}, // add options
					{}, // delete options
					{
						multipleSearch: true
					} // search options - define multiple search
				);
				
				
				
				
			});
		</script>
	</body>

</html>
