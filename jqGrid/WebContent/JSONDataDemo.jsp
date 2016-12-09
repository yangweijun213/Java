<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- jqGrid -->
<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui.theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/ui.jqgrid-bootstrap-ui.css" />
<link rel="stylesheet" type="text/css" href="css/ui.jqgrid.css" />

<script src="js/jquery-1.11.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/i18n/grid.locale-cn.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"
	charset="utf-8"></script>

<!-- 实例：加载JSON数据， http://blog.mn886.net/jqGrid/,  -->

<script type="text/javascript">
	$(function() {
		pageInit();
	});
	function pageInit() {
		jQuery("#list2").jqGrid(
				{
					url:"<%=basePath%>"+"JSONData", 
					datatype : "json",
					mtype:"GET",//提交方式
					colNames : [ 'Inv No', 'Date', 'Client', 'Amount', 'Tax',
							'Total', 'Notes' ],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55
					}, {
						name : 'invdate',
						index : 'invdate',
						width : 90
					}, {
						name : 'name',
						index : 'name asc, invdate',
						width : 100
					}, {
						name : 'amount',
						index : 'amount',
						width : 80,
						align : "right"
					}, {
						name : 'tax',
						index : 'tax',
						width : 80,
						align : "right"
					}, {
						name : 'total',
						index : 'total',
						width : 80,
						align : "right"
					}, {
						name : 'note',
						index : 'note',
						width : 150,
						sortable : false
					} ],
					rowNum : 10,
					rowList : [ 10, 20, 30 ],
					pager : '#pager2',
					sortname : 'id',
					mtype : "post",
					viewrecords : true,
					sortorder : "desc",
					caption : "JSON 实例"
				});
		jQuery("#list2").jqGrid('navGrid', '#pager2', {
			edit : false,
			add : false,
			del : false
		});
	}
</script>

</head>
<body>
	<table id="list2"></table>
	<div id="pager2"></div>
</body>
</html>