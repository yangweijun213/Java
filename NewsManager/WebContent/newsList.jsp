<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>新闻列表</title>
</head>
<body>
	<table width="1000px" cellpadding="0px" cellspacing="0px" border="1px" style="broder:1px solid gray; border-collapse: collapse;">
	<tr>
		<th>文章ID</th>
		<th>文章标题</th>
		<th>所属栏目</th>
		<th>创建时间</th>
		<th>是否审核</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${newsList}" var="news" >
	<tr>
		<th>${news.newsId}</th>
		<th>${news.newsTitle}</th>
		<th>${news.newsType}</th>
		<th>${news.createTime}</th>
		<th>${news.newsStatus}</th>
		<th>编辑  | 删除</th>
	</tr>
	</c:forEach>
	<tr>
		<td colspan ="6">
			<a href = "NewsServlet?pageNumber=1">首页</a>
			<a href = "NewsServlet?pageNumber=${pageNumber-1}">上一页</a>
			<a href = "NewsServlet?pageNumber=${pageNumber+1}">下一页</a>
			<a href = "NewsServlet?pageNumber=${pageCount}">尾页</a>
	</tr>
	</table>
</body>
</html>