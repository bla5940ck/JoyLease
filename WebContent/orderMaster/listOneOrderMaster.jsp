<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="web.order.model.*"%>
<%
	OrderMasterVO omVO = (OrderMasterVO) request.getAttribute("OrderMasterVO");

%>
<html>
<head>
<title>訂單資訊</title>
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
</style>
</head>
<body bgcolor="white">
	<header class="header"> header區域 </header>
	<div class="main_content">
		<aside class="aside">
			<nav class="nav">
				<ul class="nav_list">
					<h1>出租者專區</h1>
					<li><a href="orderMaster/listAllOrderMaster.jsp">全部訂單</a></li>
					<li><a href="orderMaster/select_page.jsp">訂單查詢</a></li>

				</ul>
			</nav>
		</aside>

		<main class="main">
			<h3>訂單資訊</h3>
			<h4>訂單編號 :</h4>
			<p><%=omVO.getOrdID()%></p>

			<h4>承租者編號 :</h4>
			<p><%=omVO.getRentID()%></p>

			<h4>出租者編號 :</h4>
			<p><%=omVO.getLeaseID()%></p>

			<h4>交易方式編碼 :</h4>
			<p><%=omVO.getPayID()%></p>

			<h4>折價券編號 :</h4>
			<p><%=omVO.getCouponID()%></p>

			<h4>運送狀態 :</h4>
			<p id="shipS">
				運送狀態 :<%=omVO.getShipStatus()%></p>

			<h4>付款狀態 :</h4>
			<p id="payS"><%=omVO.getPayStatus()%></p>

			<h4>訂單狀態 :</h4>
			<p id="ordS"><%=omVO.getOrdStatus()%></p>

			<h4>訂單日期 :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getOrdDate()%>"
					pattern="yyyy-MM-dd HH:MM" />
			</p>

			<h4>出貨代碼 :</h4>
			<p><%=omVO.getShipCode()%></p>

			<h4>歸還代碼 :</h4>
			<p><%=omVO.getReturnCode()%></p>

			<h4>超商代碼 :</h4>
			<p><%=omVO.getStoreCode()%></p>

			<h4>預計租借起日 :</h4>
			<p><%=omVO.getEstStart()%></p>

			<h4>預計租借訖日 :</h4>
			<p><%=omVO.getEstEnd()%></p>

			<h4>實際出貨日期 :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getShipDate()%>"
					pattern="yyyy-MM-dd HH:MM" />
			</p>

			<h4>實際到貨日期 :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getArrivalDate()%>"
					pattern="yyyy-MM-dd HH:MM" />
			</p>

			<h4>實際歸還日期 :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getReturnDate()%>"
					pattern="yyyy-MM-dd HH:MM" />
			</p>

			<h4>承租天數 :</h4>
			<p><%=omVO.getRentDays()%></p>

			<h4>承租者評分 :</h4>
			<p><%=omVO.getRentRank()%></p>

			<h4>出租者評分 :</h4>
			<p><%=omVO.getLeaseRank()%></p>

			<h4>承租者評論 :</h4>
			<p><%=omVO.getRentComt()%></p>

			<h4>出租者評論 :</h4>
			<p><%=omVO.getLeaseComt()%></p>

			<h4>承租者評論日期 :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getRentComtdate()%>"
					pattern="yyyy-MM-dd" />
			</p>

			<h4>出租者評論日期 :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getLeaseComtdate()%>"
					pattern="yyyy-MM-dd" />
			</p>

			<h4>商品小計 :</h4>
			<p><%=omVO.getProdPrice()%></p>

			<h4>運費 :</h4>
			<p><%=omVO.getShipFee()%></p>

			<h4>訂單金額 :</h4>
			<p><%=omVO.getOrdPrice()%></p>

			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/OrderMasterServlet"
				style="margin-bottom: 0px;">
				<input type="submit" value="更新"> <input type="hidden"
					name="ordID" value="<%=omVO.getOrdID()%>"> <input
					type="hidden" name="action" value="getOne_For_Update">
			</FORM>



		</main>
	</div>
	<footer class="footer"> footer區域 </footer>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	/*=====運送狀態=====*/

	var shipS = $("#shipS");
	if (
<%=omVO.getShipStatus()%>
	== 0) {
		shipS.text("待出貨");
	} else if (
<%=omVO.getShipStatus()%>
	== 1) {
		shipS.text("已出貨");
	} else if (
<%=omVO.getShipStatus()%>
	== 2) {
		shipS.text("待取貨");
	} else if (
<%=omVO.getShipStatus()%>
	== 3) {
		shipS.text("取貨完成");
	} else {
		shipS.text("商品遺失");
	};

	/*=====付款狀態=====*/

	var payS = $("#payS");
	if (
<%=omVO.getPayStatus()%>
	== 0) {
		payS.text("待付款");
	} else {
		payS.text("已付款");
	};

	/*=====訂單狀態=====*/

	var ordS = $("#ordS");
	if (
<%=omVO.getOrdStatus()%>
	== 0) {
		ordS.text("已成立");
	} else if (
<%=omVO.getOrdStatus()%>
	== 1) {
		ordS.text("待歸還");
	} else if (
<%=omVO.getOrdStatus()%>
	== 2) {
		ordS.text("已完成");
	} else {
		ordS.text("已取消");
	};
</script>
</html>