<!-- 动态跳转 -->
<jsp:include page='<%=request.getParameter("includedpage") %>'></jsp:include>
<jsp:include page="4.jsp">
	<jsp:param value="1221212121" name="kk"/>
</jsp:include>

<jsp:forward page="4.jsp"></jsp:forward>
<!-- 跳转页面来传参  -->
<jsp:forward page="4.jsp">
	<jsp:param value="3333333" name="kk"/>
</jsp:forward>