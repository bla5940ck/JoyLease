<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="web.order.model.*"%>
<%
	OrderListVO olVO = (OrderListVO) request.getAttribute("OrderListVO");
	out.print(olVO);
%>
<html>
<head>
<meta charset="BIG5">
<title>單筆訂單明細頁面</title>
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
</head>
<body bgcolor="white">
	<header class="header"> header區域 </header>
	<FORM METHOD="post" ACTION="/JoyLease/OrderListServlet" name="form1">
		<div class="main_content">
			<aside class="aside">
				<nav class="nav">
					<ul class="nav_list">
						<h1>出租者專區</h1>
						<li><a href="/JoyLease/orderList/listAllOrderList.jsp">全部訂單明細</a></li>
					</ul>
				</nav>
			</aside>

			<main class="main">
				<h3>訂單明細</h3>

				<table id="table-1">
					<tr>
						<th>訂單明細編號</th>
						<th>商品編號</th>
						<th>訂單編號</th>
						<th>訂單金額</th>
					</tr>

					<tr>
						<td><%=olVO.getListID()%></td>
						<td><%=olVO.getProdID()%></td>
						<td><%=olVO.getOrdID()%></td>
						<td><%=olVO.getPrice()%></td>

					</tr>
				</table>

			</main>
		</div>
		<footer class="footer"> footer區域 </footer>
	</FORM>
</body>
</html>