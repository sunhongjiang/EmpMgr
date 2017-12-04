<!-- pageEncoding是jsp文件本身的编码格式，因为容器把jsp文件转化成java文件前，必须要知道jsp文件的编码格式 -->
<!-- contentType是服务端相应客户端的编码格式 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<title>hello.jsp</title>
<style type="text/css">

</style>
<script type="text/javascript" src="./scripts/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {

	})
</script>
</head>
<body>

	<div class="msg">
		<table>
			<tr>
				<td>会话的状态:</td>
				<td><%=session.isNew() ? "新的会话" : "旧的会话"%></td>
			</tr>
			<tr>
				<td>会话id：</td>
				<td><%=session.getId()%></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td><%=new Date(session.getCreationTime())%></td>
			</tr>
			<tr>
				<td>上次访问时间：</td>
				<td><%=new Date(session.getLastAccessedTime())%></td>
			</tr>
			<tr>
				<td>最大不活动时间间隔（s）：</td>
				<td><%=session.getMaxInactiveInterval()%></td>
			</tr>
		</table>

	</div>

	<div class="container">
		<%-- 
		<%
			Object value = session.getAttribute("isLogin");
			if(value == null)
			{
			    response.sendRedirect("login.jsp");
			}else
			{
			    if (!(Boolean)value)
			    {
			        response.sendRedirect("login.jsp");
			    }
			}

		%>--%>
		欢迎您，<%=session.getAttribute("username") %><br/>
		欢迎您，${sessionScope.username}<br/>
		<a href="login.jsp">重新登录</a>&nbsp;&nbsp;<a href="servlet/logout">注销</a>
	</div>
</body>
</html>