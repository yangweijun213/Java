<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<!-- Pivot Grid: 按日期分组显示  -->
<script type="text/javascript">
	$(function() {
		pageInit();
	});
	function pageInit() {
		jQuery("#list2").jqGrid('jqPivot', "<%=basePath%>"+"JSONData",
		// pivot options 
		{
			xDimension : [ {
				dataName : 'transactionName',
				width : 90
			}, {
				dataName : 'averageTime'
			} ],
			yDimension : [ {
				dataName : 'startTime'
			} ],
			aggregates : [ {
				member : 'averageTime',
				aggregator : 'sum',
				width : 80,
				label : 'Sum',
				formatter : 'number',
				align : 'right',
				summaryType : 'sum'
			} ]
		},
		// grid options 
		{
			width : 700,
			rowNum : 10,
			pager : "#pager2",
			caption : "Rows grouping"
		});
	}
</script>

</head>
<body>
	<table id="list2"></table>
	<div id="pager2"></div>
</body>
</html>