<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.perf.entity.Iterations"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Performacne Sanity Test Report</title>
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/highcharts.js" type="text/javascript"></script>
<script src="js/jquery.highchartTable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('table.highchart').highchartTable();
	});
</script>

</head>
<body>
	<table class="highchart" data-graph-container-before="1"
		data-graph-type="column" style="display: none" data-graph-subtitle-text="September 13th, 2016 00:00:00" data-graph-yaxis-1-opposite="1">
		<caption>CAL_ExecuteReview_01_login</caption>
		<thead>
			<tr>
				<th>Time</th>
				<th data-graph-yaxis="1">Response Time(sec)</th>
				<th data-graph-yaxis="1">Backend Time(sec)</th>
				<th data-graph-yaxis="1">Network Time(sec)</th>
				<th data-graph-type = "line" >pageSize</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${iterationsList}" var="iteration">
				<tr>
					<td>${iteration.time}</td>
					<td>${iteration.responseTime}</td>
					<td>${iteration.backendTime}</td>
					<td>${iteration.networkTime}</td>
					<td>${iteration.pageKb}</td>
				</tr>
			</c:forEach>
		</tbody>

		<table width="1000px" cellpadding="0px" cellspacing="0px" border="1px"
			style="broder: 1px solid gray; border-collapse: collapse;">
			<tr>
				<th>Iterations</th>
				<th>Time</th>
				<th>Response Time(sec)</th>
				<th>Backend Time(sec)</th>
				<th>Network Time(sec)</th>
				<th data-graph-skip="1">pageSize</th>
			</tr>

			<c:forEach items="${iterationsList}" var="iteration">
				<tr>
					<td>${iteration.resultId}</td>
					<td>${iteration.time}</td>
					<td>${iteration.responseTime}</td>
					<td>${iteration.backendTime}</td>
					<td>${iteration.networkTime}</td>
					<td>${iteration.pageKb}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6"><a href="NewsServlet?pageNumber=1">首页</a> <a
					href="NewsServlet?pageNumber=${pageNumber-1}">上一页</a> <a
					href="NewsServlet?pageNumber=${pageNumber+1}">下一页</a> <a
					href="NewsServlet?pageNumber=${pageCount}">尾页</a>
			</tr>
		</table>
</body>
</html>