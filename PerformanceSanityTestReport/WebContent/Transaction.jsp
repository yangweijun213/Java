<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<title>Performacne Sanity Test Report</title>
		
		<!-- jqGrid -->
		<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui.theme.min.css" />
		<link rel="stylesheet" type="text/css" href="css/ui.jqgrid-bootstrap-ui.css" />
		<link rel="stylesheet" type="text/css" href="css/ui.jqgrid.css" />
	</head>

	<body>
		<div class="main" id="main">
			<!--jqGrid所在-->
			<table id="grid-table"></table>
			<!--jqGrid 浏览导航栏所在-->
			<div id="grid-pager"></div>

		</div>
		<!-- jqGrid -->
		<script src="js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/i18n/grid.locale-cn.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery.jqGrid.min.js" type="text/javascript" charset="utf-8"></script>
		
		

		<script type="text/javascript">
			//当 datatype 为"local" 时需填写   
			
			var grid_selector = "#grid-table";
			var pager_selector = "#grid-pager";
			$(document).ready(function() {

				$("#grid-table").jqGrid({
				    //用于检索的Servlet URL
				    url:"<%=basePath%>"+"TransactionResultServlet", 
				    //用于添加、修改、删除的Servlet URL
				    editurl: "<%=basePath%>"+"IterationResultchangeServlet",
					//data: grid_data, //当 datatype 为"local" 时需填写  
					datatype:"json", //数据来源，本地数据（local，json,jsonp,xml等）
					height: 150, //高度，表格高度。可为数值、百分比或'auto'
					mtype:"GET",//提交方式
					colNames: ['Transaction Name', 'Start Time', 'Average Response'],
					colModel: [{
						name: 'transactionName',
						index: 'transaction_name', //索引。其和后台交互的参数为sidx
						key: true, //当从服务器端返回的数据中没有id时，将此作为唯一rowid使用只有一个列可以做这项设置。如果设置多于一个，那么只选取第一个，其他被忽略
						width: 100,
						editable: false,
						editoptions: {
							size: "20",
							maxlength: "30"
						}
					}, {
						name: 'startTime',
						index: 'start_date', //与数据库字段名字一样
						width: 200, //宽度
						editable: true, //是否可编辑
						edittype: "select", //可以编辑的类型。可选值：text, textarea, select, checkbox, password, button, image and file.s
						editoptions: {
							value: "1:采购入库;2:退用入库"
						}
					}, {
						name: 'averageResponseTime',
						index: 'average_response',
						width: 60,
						sorttype: "textarea",
						editable: true
					}, ],
					
					
					viewrecords: true, //是否在浏览导航栏显示记录总数
					rowNum: 10, //每页显示记录数
					rowList: [10, 20, 30], //用于改变显示行数的下拉列表框的元素数组。
					pager: pager_selector, //分页、按钮所在的浏览导航栏
					altRows: true, //设置为交替行表格,默认为false
					//toppager: true,//是否在上面显示浏览导航栏
					multiselect: true, //是否多选
					//multikey: "ctrlKey",//是否只能用Ctrl按键多选
					multiboxonly: true, //是否只能点击复选框多选
					// subGrid : true, 
					//sortname:'id',//默认的排序列名
					//sortorder:'asc',//默认的排序方式（asc升序，desc降序）
					caption: "Iteration table", //表名
					autowidth: true //自动宽
					
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
			});
		</script>
	</body>

</html>
