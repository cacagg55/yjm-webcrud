<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset==utf-8">
<title>Insert title here</title>
</head>
<%--保存和编辑操作的jsp页面 --%>
<body>
<h3>新增商品</h3>
<form action="/product/servlet?flag=update" method="post">
	<table >
		<c:choose>
			<c:when test="${!empty product}">
				商品编号：<input type="text" name="id" value="${product.id}"/><br/>
				商品名称:<input type="text" name="productName" value="${product.productName}"/><br/>
				商品类型:<input type="text" name="dir_id" value="${product.dir_id}"/><br/>
				零售价:<input type="text" name="salePrice" value="${product.salePrice}"/><br/>
				商品属性:<input type="text" name="supplier" value="${product.supplier}"/><br/>
				商品品牌:<input type="text" name="brand" value="${product.brand}"/><br/>
				折扣:<input type="text" name="cutoff" value="${product.cutoff}"/><br/>
				批发价:<input type="text" name="costPrice" value="${product.costPrice}"/><br/>
				
				<input type="submit" value="朕要修改"/>
			</c:when>
			<c:otherwise>
				商品名称:<input type="text" placeholder="String" name="productName"/><br/>
				商品类型:<input type="text" placeholder="Long" name="dir_id"/><br/>
				零售价:<input type="text" placeholder="Double" name="salePrice"/><br/>
				商品属性:<input type="text" placeholder="String" name="supplier"/><br/>
				商品品牌:<input type="text" placeholder="String" name="brand"/><br/>
				折扣:<input type="text" placeholder="Double" name="cutoff"/><br/>
				批发价:<input type="text" placeholder="Double" name="costPrice"/><br/>
				<input type="submit" value="朕要提交"/>
			</c:otherwise>
		</c:choose>
	</table>
</form>
</body>
</html>