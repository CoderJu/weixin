<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>新增页面</title>
	<link href="<%=basePath%>resources/css/all.css" rel="stylesheet" type="text/css" />
	<script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
	<script src="<%=basePath%>resources/js/back/add.js"></script>
  </head>
  
  <body style="background: #e1e9eb;">
  <form id="cleanForm" method="post"><input type="hidden" name="operation" value="clean"/></form>
		<form  id="addForm" method="post" action="<%=basePath%>EditServlet.action">
					<table class="tab1">
						<tbody>
						<input type="hidden" name="operation" value="edit"/>
							<tr>
								<td width="90" align="right"> 指令名称：</td>
								<td>
									<input id="command" type="text" name="command" class="allInput"  style="width:100%" value="${message.command }"/>
									<input id="command" type="hidden" name="id" class="allInput"  style="width:100%" value="${message.id }"/>
								</td>
								</tr>
								<tr>
								<td width="90" align="right">描述：</td>
								<td>
									<input id="description" type="text" name="description" class="allInput" style="width:100%"  value="${message.description }"/>
								</td>
								</tr>
								<tr>
								<td width="90" align="right" >内容：</td>
								<td>
									<textarea  id ="content" type="text" name="content"  rows="3" cols="60"  >${message.content }</textarea>
								</td>
								</tr>
	                			<tr>
	                				<td width="90" align="right"><input type="submit" class="tabSub" value="修改" /></td>
	                			</tr>
						</tbody>
					</table>
				</div>
			</div>
	    </form>
	</body>
</html>
