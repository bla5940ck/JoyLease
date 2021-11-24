<%@page import="web.product.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="web.order.model.*"%>
<%
	OrderListVO olVO = (OrderListVO) request.getAttribute("OrderListVO");
	OrderListDAOImpl oldao = new OrderListDAOImpl();
	List<OrderListVO> list = oldao.findOrderListByStatus(olVO.getStatus());
	pageContext.setAttribute("list", list);
	
	ProdService prodSVC = new ProdService();
	ProdVO prodVO = prodSVC.findProductByPK(olVO.getProdID());

%>

<html>
<head>
<meta charset="BIG5">
<title>單筆訂單明細頁面</title>
</head>
<style>
* {
	box-sizing: border-box;
	text-decoration: none;
	list-style: none;
}

body {
	margin: 0;
	padding: 10px;
}

img {
	max-width: 100%;
}

button{
	border: none;
	outline-width: 100%;
	background-color: white;
}

header.header {
	background-color: #ddd;
	width: 100%;
	margin: 0 auto 10px auto;
	border: 1px solid #999;
}

@media all and (min-width:576px) and (max-width:767.98px) {
	header.header {
		width: 540px;
	}
}

@media ( max-width :575.98px) {
	header.header {
		width: 100%;
	}
}

div.main_content {
	width: 100%;
	margin: 0 auto;
	font-size: 0;
	/*   border:1px solid red; */
}

@media all and (min-width:576px) and (max-width:767.98px) {
	div.main_content {
		width: 540px;
	}
}

@media ( max-width :575.98px) {
	div.main_content {
		width: 100%;
	}
}

/*-------------------aside區域------------------- */
aside.aside {
	background-color: #ddd;
	width: 200px;
	display: inline-block;
	vertical-align: top;
	font-size: 1rem;
	margin-right: 10px;
	border: 1px solid #999;
}

/*--------------------main區域-------------------- */
main.main {
	background-color: #ddd;
	width: calc(100% - 200px - 10px);
	display: inline-block;
	vertical-align: top;
	font-size: 1rem;
	border: 1px solid #999;
	padding: 10px;
}

@media ( max-width : 575.98px) {
	aside.aside, main.main {
		display: block;
	}
	aside.aside {
		width: 100%;
		margin: 0 0 10px 0;
	}
	main.main {
		width: 100%;
	}
}

footer.footer {
	background-color: #ddd;
	width: 100%;
	margin: 10px auto 0 auto;
	border: 1px solid #999;
}

@media all and (min-width:576px) and (max-width:767.98px) {
	footer.footer {
		width: 540px;
	}
}

@media ( max-width :575.98px) {
	footer.footer {
		width: 100%;
	}
}

table {
	width: 100%;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>
<body bgcolor="white">
	<header class="header"> header區域 </header>
	<div class="main_content">
		<aside class="aside">
			<nav class="nav">
				<ul class="nav_list">
					<h1>出租者專區</h1>
					<li><a href="orderList/listAllOrderList.jsp">全部訂單明細</a></li>
				</ul>
			</nav>
		</aside>
		<main class="main">
			<div>
				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/OrderListServlet">
					<b>輸入訂單明細編號 (如1):</b> <input type="text" name="listID"> <input
						type="hidden" name="action" value="getOne_For_Display"> <input
						type="submit" value="送出">
				</FORM>
				<jsp:useBean id="OrdserListSvc" scope="page"
					class="web.order.model.OrderListService" />
				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/OrderListServlet">
					<b>選擇訂單明細編號:</b> <select size="1" name="listID">
						<c:forEach var="OrderListVO" items="${OrdserListSvc.all}">
							<option value="${OrderListVO.listID}">${OrderListVO.listID}
						</c:forEach>
					</select> <input type="hidden" name="action" value="getOne_For_Display">
					<input type="submit" value="送出">
				</FORM>
				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/OrderListServlet">
					<b>選擇訂單狀態:</b> <select size="1" name="status">
						<option value="0">已成立
						<option value="1">待歸還
						<option value="2">已完成
						<option value="9">已取消
					</select> <input type="hidden" name="action" value="get_Status_Display">
					<input type="submit" value="送出">
				</FORM>
			</div>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			<table id="table-1">
				<div>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/OrderListServlet">
						<tr>
							<td><a href="listAllOrderList.jsp">全部</a></td>
							<td><button name="status" value="0">已成立</button></td>
							<td><button name="status" value="1">待歸還</button></td>
							<td><button name="status" value="2">已完成</button></td>
							<td><button name="status" value="9">已取消</button></td>
						</tr>
						<input type="hidden" name="action" value="get_Status_Display">
					</FORM>
				</div>
			</table>	
			<table id="table-1">
				<tr>
					<th>訂單明細編號</th>
					<th>商品編號</th>
					<th>商品名稱</th>
					<th>訂單編號</th>
					<th>訂單金額</th>
					<th>預計開始日期</th>
					<th>預計結束日期</th>
					<th>訂單狀態</th>
				</tr>
				<tr>
					<td><%=olVO.getListID()%></td>
					<td><%=olVO.getProdID()%></td>
					<td><%=prodVO.getProdName()%></td>
					<td><%=olVO.getOrdID()%></td>
					<td><%=olVO.getPrice()%></td>
					<td><%=olVO.getEstStart()%></td>
					<td><%=olVO.getEstEnd()%></td>
					<c:choose>
						<c:when test="${olVO.status == '0'}">
							<td>已成立</td>
						</c:when>
						<c:when test="${olVO.status == '1'}">
							<td>待歸還</td>
						</c:when>
						<c:when test="${olVO.status == '2'}">
							<td>已完成</td>
						</c:when>
						<c:otherwise>
							<td>已取消</td>
						</c:otherwise>
					</c:choose>
					<td>
						<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/OrderMasterServlet" style="margin-bottom: 0px;">
						<input type="submit" value="查看明細"> 
						<input type="hidden" name="ordID" value="<%=olVO.getOrdID()%>"> 
						<input type="hidden" name="action" value="getOne_For_Display">
						</FORM>
					</td>
				</tr>
			</table>
		</main>
	</div>
	<footer class="footer"> footer區域 </footer>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</html>