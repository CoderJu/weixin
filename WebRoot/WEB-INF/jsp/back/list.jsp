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
	<title>内容列表页面</title>
	<link href="<%=basePath%>resources/css/all.css" rel="stylesheet" type="text/css" />
	<script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
	<script src="<%=basePath%>resources/js/back/list.js"></script>
	<script src="<%=basePath%>resources/js/back/delete.js"></script>
  </head>
  
  <body style="background: #e1e9eb;">
  <form id="createForm" method="post">
  <input type="hidden" id="operation" name="operation" value="transfer"/>
  </form>
		<form action="<%=basePath%>QueryServlet.action" id="mainForm" method="post">	
			 <input type="hidden" id="operation" name="operation" value="deleteBatch"/>
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 <a class="btn03" href="javascript:createNew('<%=basePath%>');">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn03" href="javascript:deleteBatch('<%=basePath%>');">删 除</a></p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">指令名称：</td>
								<td>
									<input type="text" name="command" class="allInput" value="${command }"/>
								</td>
								<td width="90" align="right">描述：</td>
								<td>
									<input type="text" name="description" class="allInput" value="${des }"/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all" onclick=""/></th>
								    <th>序号</th>
								    <th>指令名称</th>
								    <th>描述</th>
								    <th>操作</th>
								</tr>
								<c:forEach items="${messagelist }" var="message" varStatus="status">
								<tr <c:if test="${status.index%2 !=0 }">
								 style="background-color:#ECF6EE;"</c:if>>								
									<td><input type="checkbox" name="id" value="${message.id }"/></td>
									<td>${status.index+1 }</td>
									<td>${message.command }</td>
									<td>${message.description }</td>
									<td>
										<a href="${basepath }EditServlet.action?operation=editPage&id=${message.id }">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="${basepath }DeleteServlet.action?operation=deleteone&id=${message.id }">删除</a>
									</td>
								</c:forEach>
							</tbody>
						</table>
						<!--  <div class='page fix'>
							共 <b>4</b> 条
							<a href='###' class='first'>首页</a>
							<a href='###' class='pre'>上一页</a>
							当前第<span>1/1</span>页
							<a href='###' class='next'>下一页</a>
							<a href='###' class='last'>末页</a>
							跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='###' class='go'>GO</a>
						</div>-->
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>
