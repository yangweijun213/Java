<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="java.awt.*" errorPage="error.jsp"%>
<!-- <b>asbcde</b> -->

<%
	//int i=1/0;
%>


<%-- <%@ include file ="included.jsp" %> --%>

<jsp:include page ="included.jsp"></jsp:include>

<%
	int dd=3;
	//System.out.println(dd);
	test();
%>

<%=dd %>

<%!
	int hh=4;
	void test() {
		System.out.println("tttt");
	}
%>