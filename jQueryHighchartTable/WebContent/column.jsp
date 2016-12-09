<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>首页</title>
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

<table class="highchart" data-graph-container-before="1" data-graph-type="column">
	<thead>
		<tr>
			<th>城市</th>
			<th>男</th>
			<th>女</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>重庆</td> 
			<td>2000</td>
			<td>3000</td>
		</tr>
		<tr>
			<td>上海</td> 
			<td>6000</td>
			<td>5000</td>
		</tr>
		<tr>
			<td>北京</td> 
			<td>5000</td>
			<td>8000</td>
		</tr>
		
	</tbody>
</table>

</body>
</html>