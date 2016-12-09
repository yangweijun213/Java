<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.po.Person, java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>遍历list集合数据,显示柱状图</title>
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

<% 

	List<Person> list = new ArrayList<Person>();
	Person cq = new Person();
	cq.setCityInfo("重庆");
	cq.setMamNum(500);
	cq.setWomanNum(450);
	list.add(cq);

	Person sk = new Person();
	sk.setCityInfo("四川");
	sk.setMamNum(600);
	sk.setWomanNum(350);
	list.add(sk);
	
	Person gz = new Person();
	gz.setCityInfo("贵州");
	gz.setMamNum(230);
	gz.setWomanNum(650);
	list.add(gz);
	
	request.setAttribute("list", list);
%>

<div style="width:400px">
<!-- 如果不需要显示数据表,可以在table中加  style="display:none;" -->
<table class="highchart" data-graph-container-before="1" data-graph-type="column">
	<thead>
		<tr>
			<th>城市</th>
			<th>男</th>
			<th>女</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="p">
			<tr>
				<td>${p.cityInfo}</td>
				<td>${p.mamNum}</td>
				<td>${p.womanNum}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>