<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%--负责显示查询结果的jsp页面 --%>
<body>
	<h2 align="center">商品信息</h3>
	<table align="center" border="1" width="70%">
		<thead>
			<tr>
				<td><a href="/product/servlet?flag=savejsp">新增</a></td>
			</tr>
			<tr>
				<th>id</th>
				<th>商品名称</th>
				<th>商品类型</th>
				<th>零售价</th>
				<th>商品属性</th>
				<th>商品品牌</th>
				<th>折扣</th>
				<th>批发价</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="list" items="${lists}">
			<tr>
				<td>${list.id}</td>
				<td>${list.productName}</td>
				<td>${list.dir_id}</td>
				<td>${list.salePrice}</td>
				<td>${list.supplier}</td>
				<td>${list.brand}</td>
				<td>${list.cutoff}</td>
				<td>${list.costPrice}</td>
				<td align="center">
					<a href="/product/servlet?flag=delete&id=${list.id}">删除</a>
					<a href="/product/servlet?flag=updatejsp&id=${list.id}">编辑</a>
				</td>
			</tr>
			</c:forEach>
				
			
		</tbody>
		
	</table>
</body>
</html>