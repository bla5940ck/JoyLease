<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.order.model.*"%>

<%
	OrderMasterVO omVO = (OrderMasterVO) request.getAttribute("OrderMasterVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>訂單資料更新:</title>

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



<style>
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

<body bgcolor='white'>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	<header class="header"> header區域 </header>
	<FORM METHOD="post" ACTION="/JoyLease/OrderMasterServlet" name="form1">

		<div class="main_content">
			<aside class="aside">
				<nav class="nav">
					<h1>出租者專區</h1>
					<ul class="nav_list">
						<li><a href="orderMaster/listAllOrderMaster.jsp">全部訂單</a></li>
						<li><a href="orderMaster/select_page.jsp">訂單查詢</a></li>
					</ul>
				</nav>
			</aside>
			<main class="main">
				<div>
					<h3>更新訂單</h3>
					<h3>
						訂單編號 :<%=omVO.getOrdID()%></h3>
				</div>
				<table id="table-1">
					<tr>
						<th>運送狀態 :</th>
						<td><p id="shipS"><%=omVO.getShipStatus()%></p></td>
						<td><select name="shipStatus" size="1" id="s">
								<option value="0">待出貨</option>
								<option value="1">已出貨</option>
								<option value="2">待取貨</option>
								<option value="3">取貨完成</option>
								<option value="9">商品遺失</option>
						</select></td>
					</tr>
					<tr>
						<th>付款狀態 :</th>
						<td><p id="payS"><%=omVO.getPayStatus()%></p></td>
						<td><select name="payStatus" size="1">
								<option value="0">待付款</option>
								<option value="1">已付款</option>
						</select></td>
					</tr>
					<tr>
						<th>訂單狀態 :</th>
						<td><p id="ordS"><%=omVO.getOrdStatus()%></p></td>
						<td><select name="ordStatus" size="1">
								<option value="0">已成立</option>
								<option value="1">待歸還</option>
								<option value="2">已完成</option>
								<option value="3">已取消</option>
						</select></td>
					</tr>
				</table>
				<table>
					<tr>
						<th>出貨代碼</th>
						<td><input type="TEXT" name="shipCode" size="20"
							value="${OrderMasterVO.shipCode}"></td>

					</tr>

					<tr>
						<th>歸還代碼</th>
						<td><input type="TEXT" name="returnCode" size="20"
							value="${OrderMasterVO.returnCode}" /></td>
					</tr>

				</table>
				<table>
					<tr>
						<th>出貨日期</th>
						<td><input name="shipDate" type="TEXT" value="<%=omVO.getShipDate()%>"></td>
					</tr>
					<tr>
						<th>實際到貨日期</th>
						<td><input type="TEXT" name="arrivalDate" value="<%=omVO.getArrivalDate()%>"></td>
					</tr>
					<tr>
						<th>實際歸還日期</th>
						<td><input type="TEXT" name="returnDate" value="<%=omVO.getReturnDate()%>"></td>
					</tr>
				</table>
				<table>
					<tr>
						<th>承租方評價</th>
						<td><p id="rr"><%=omVO.getRentRank()%></p></td>
						<td><select name="rentRank" size="1">
								<option value="${OrderMasterVO.rentRank}">評價</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select></td>
					</tr>
					<tr>
						<th>出租方評價</th>
						<td><p id="rr"><%=omVO.getLeaseRank()%></p></td>
						<td><select name="leaseRank" size="1">
								<option value="${OrderMasterVO.leaseRank}">評價</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select></td>
					</tr>
					<tr>
						<th>承租方評論</th>
						<td><p id="rc"><%=omVO.getRentComt()%></p></td>
						<td><select name="rentComt">
								<option value="${OrderMasterVO.rentComt}">請選擇</option>
								<option value="出貨快 !">出貨快 !</option>
								<option value="價格合理 !">價格合理 !</option>
								<option value="溝通良好 !">溝通良好 !</option>
								<option value="態度不佳 !">態度不佳 !</option>
								<option value="出貨速度慢 !">出貨速度慢 !</option>
								<option value="與照片不符 !">與照片不符 !</option>
								
						</select></td>
					</tr>
					<tr>
						<th>出租方評論</th>
						<td><p id="lc"><%=omVO.getLeaseComt()%></p></td>
						<td><select name="leaseComt">
								<option value="${OrderMasterVO.leaseComt}">請選擇</option>
								<option value="出貨快 !">歸還快速 !</option>
								<option value="價格合理 !">愉快的交易 !</option>
								<option value="溝通良好 !">溝通良好 !</option>
								<option value="態度不佳 !">態度不佳 !</option>
								<option value="出貨速度慢 !">還貨速度慢 !</option>
								<option value="不愛惜物品 !">不愛惜物品 !</option>
						</select></td>
					</tr>
				</table>
				<input type="hidden" name="action" value="update"> 
				<input type="hidden" name="ordID" value="<%=omVO.getOrdID()%>">
				<input type="hidden" name="rentComtdate" value="${OrderMasterVO.rentComtdate}">
				<input type="hidden" name="leaseComtdate" value="${OrderMasterVO.leaseComtdate}">
				<input type="submit" value="確認更新">
			</main>
		</div>
		<footer class="footer"> footer區域 </footer>
	</FORM>
</body>


<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
	
	/*=====承租方評級=====*/
	var rr = $("#rr");
	if(<%=omVO.getRentRank()%> == 1){
		rr.text("1");
	}else if(<%=omVO.getRentRank()%> == 2){
		rr.text("2");
	}else if(<%=omVO.getRentRank()%> == 3){
		rr.text("3");
	}else if(<%=omVO.getRentRank()%> == 4){
		rr.text("4");
	}else{
		rr.text("5");
	};
	/*=====出租方評級=====*/
	var lr = $("#rr");
	if(<%=omVO.getLeaseRank()%> == 1){
		lr.text("1");
	}else if(<%=omVO.getLeaseRank()%> == 2){
		lr.text("2");
	}else if(<%=omVO.getLeaseRank()%> == 3){
		lr.text("3");
	}else if(<%=omVO.getLeaseRank()%> == 4){
		lr.text("4");
	}else{
		lr.text("5");
	};
	
	/*=====承租方評論=====*/

	
</script>
</html>
