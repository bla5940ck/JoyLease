<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="web.order.model.*"%>
<%@page import="web.product.model.*"%>


<%
	OrderMasterService ordserMasterSvc = new OrderMasterService();
	List<OrderMasterVO> list = ordserMasterSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<html>
<head>
<title>所有訂單資料 - listAllOrderMaster.jsp</title>
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

/*--------------------table區域-------------------- */
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
	<header class="header"> header區域 </header>
	<div class="main_content">
		<aside class="aside">
			<nav class="nav">
				<h1>出租者專區</h1>
				<ul class="nav_list">
					<li><a href="listAllOrderMaster.jsp">全部訂單</a></li>
					<li><a href="select_page.jsp">訂單查詢</a></li>
				</ul>
			</nav>
		</aside>
		<main class="main">
			<div>
				<jsp:useBean id="OrdserMasterSvc" scope="page"
					class="web.order.model.OrderMasterService" />
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/OrderMasterServlet">
						<b>選擇訂單編號:</b> <select size="1" name="ordID">
							<c:forEach var="OrderMasterVO" items="${OrdserMasterSvc.all}">
								<option value="${OrderMasterVO.ordID}">${OrderMasterVO.ordID}
							</c:forEach>
						</select> <input type="hidden" name="action" value="getOne_For_Display">
						<input type="submit" value="送出">
					</FORM>
				
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/OrderMasterServlet">
						<b>輸入訂單編號 (如1):</b> <input type="text" name="ordID"> <input
							type="hidden" name="action" value="getOne_For_Display"> <input
							type="submit" value="送出">
					</FORM>
			</div>
			<table id="table-1">
				<tr>
					<th>訂單編號</th>
					<th>承租者編號</th>
					<th>出租者編號</th>
					<th>交易方式編碼</th>
					<th>折價券編號</th>
					<th>運送狀態</th>
					<th>付款狀態</th>
					<th>訂單狀態</th>
					<th>訂單日期</th>
					<th>出貨代碼</th>
					<th>歸還代碼</th>
					<th>超商代碼</th>
					<th>預計租借起日</th>
					<th>預計租借訖日</th>
					<th>實際出貨日期</th>
					<th>實際到貨日期</th>
					<th>實際歸還日期</th>
					<th>承租天數</th>
					<th>承租者評分</th>
					<th>出租者評分</th>
					<th>承租者評論</th>
					<th>出租者評論</th>
					<th>承租者評論日期</th>
					<th>出租者評論日期</th>
					<th>商品小計</th>
					<th>運費</th>
					<th>訂單金額</th>
				</tr>
				<%@ include file="page1.file"%>
				<c:forEach var="omVO" items="${list}" begin="<%=pageIndex%>"
					end="<%=pageIndex+rowsPerPage-1%>">
					<tr>
						<td>${omVO.ordID}</td>
						<td>${omVO.rentID}</td>
						<td>${omVO.leaseID}</td>
						<td>${omVO.payID}</td>
						<td>${omVO.couponID}</td>
						<td>${omVO.shipStatus}</td>
						<td>${omVO.payStatus}</td>
						<td>${omVO.ordStatus}</td>
						<td><fmt:formatDate value="${omVO.ordDate}"
								pattern="yyyy-MM-dd" /></td>
						<td>${omVO.shipCode}</td>
						<td>${omVO.returnCode}</td>
						<td>${omVO.storeCode}</td>
						<td>${omVO.estStart}</td>
						<td>${omVO.estEnd}</td>
						<td><fmt:formatDate value="${omVO.shipDate}"
								pattern="yyyy-MM-dd" /></td>
						<td><fmt:formatDate value="${omVO.arrivalDate}"
								pattern="yyyy-MM-dd" /></td>
						<td><fmt:formatDate value="${omVO.returnDate}"
								pattern="yyyy-MM-dd" /></td>
						<td>${omVO.rentDays}</td>
						<td>${omVO.rentRank}</td>
						<td>${omVO.leaseRank}</td>
						<td>${omVO.rentComt}</td>
						<td>${omVO.leaseComt}</td>
						<td><fmt:formatDate value="${omVO.rentComtdate}"
								pattern="yyyy-MM-dd" /></td>
						<td><fmt:formatDate value="${omVO.leaseComtdate}"
								pattern="yyyy-MM-dd" /></td>
						<td>${omVO.prodPrice}</td>
						<td>${omVO.shipFee}</td>
						<td>${omVO.ordPrice}</td>
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/OrderMasterServlet"
								style="margin-bottom: 0px;">
								<input type="submit" value="修改"> <input type="hidden"
									name="ordID" value="${omVO.ordID}"> <input
									type="hidden" name="action" value="getOne_For_Update">
							</FORM>
						</td>
					</tr>
				</c:forEach>
			</table>
			<%@ include file="page2.file"%>
		</main>
	</div>
	<footer class="footer"> footer區域 </footer>
</body>
</html>