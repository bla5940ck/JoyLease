<%@page import="web.promo_list.model.PromolistVO"%>
<%@page import="web.member_coupon.model.MemcouponVO"%>
<%@page import="web.member_coupon.model.MemcouponDAO"%>
<%@page import="web.promo_list.model.PromolistDAO"%>
<%@page import="web.member.model.DefAddressVO"%>
<%@page import="web.member.model.DefAddressJDBCDAO"%>
<%@page import="java.util.List"%>
<%@page import="web.order.model.PaymentOptionsVO"%>
<%@page import="web.order.model.PaymentOptionsDAOImpl"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.order.model.PaymentOptionsService"%>
<%@ page import="web.product.model.*"%>
<%
	// 	ProdVO prodVO = (ProdVO) request.getAttribute("prodVO");
	ProdDAO prodDAO = new ProdDAO();
	ProdVO prodVO = prodDAO.findProductByPK(1);
	// 	out.print(prodVO.getProdName());

	// 	PaymentOptionsDAOImpl podao = new PaymentOptionsDAOImpl();
	// 	List<PaymentOptionsVO> list = podao.getAllPaymentOptions();
	// 	for (PaymentOptionsVO po : list) {
	// 		out.print(po);
	// 	}

	ProdDAO productDao = new ProdDAO();
	// 	ProdVO product = productDao.findProductByPK(Integer.parseInt(request.getParameter("picno")));
	ProdVO product = productDao.findProductByPK(1);
	out.print(product.getProdName());

	// 	DefAddressJDBCDAO dadao = new DefAddressJDBCDAO();
	// 	List<DefAddressVO> list2 = dadao.getAll();
	// 	for(DefAddressVO da : list2){
	// 		out.print(da.getName711());
	// 	}

	MemcouponDAO mcdao = new MemcouponDAO();
	List<MemcouponVO> list = mcdao.getAll();

	for (MemcouponVO mc : list) {
		if (mc.getMember_id() == 1) {
			out.println(mc.getMem_coupon_id());

		}
	}

	PromolistDAO pldao = new PromolistDAO();
	PromolistVO plVO = pldao.findByPrimaryKey(1001);
%>

<html>
<head>
<title>結帳 :</title>

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
					<h1>標題</h1>
					<ul class="nav_list">
						<li><a href="#">連結</a></li>
						<li><a href="#">連結</a></li>
					</ul>
				</nav>
			</aside>
			<main class="main">
				<div>
					<h3>結帳頁面</h3>
				</div>


				<table id="table-1">
					<h3>確認以下資訊</h3>
					<p id="today">日期</p>
					<li><a href="#">返回購物車</a></li>
					<tr>
						<td>商品名稱 :</td>
						<td><a
							href="<%=request.getContextPath()%>/product_view/productDetail.jsp?picno=1"><%=prodVO.getProdName()%></a></td>
					</tr>
					<tr>
						<td>預定租借起日:</td>
						<td><p id="estStart"></p></td>
					</tr>
					<tr>
						<td>預定租借訖日:</td>
						<td><p id="estEnd"></p></td>
					</tr>
					<tr>
						<td>收件人姓名:</td>
						<td><input type="text" id="recipient"></td>
					</tr>
					<tr>
						<td>收件人電話:</td>
						<td><input type="text" id="recptPhone"></td>
					</tr>


					<jsp:useBean id="daDAO" class="web.member.model.DefAddressJDBCDAO" />
					<tr>
						<td>選擇711收件門市:</td>
						<td><select size="1" name="name711">
								<option value="0">面交
									<c:forEach var="daVO" items="${daDAO.getAll()}">
										<option value="${daVO.code711}">${daVO.name711}
									</c:forEach>
						</select></td>
					</tr>

					<jsp:useBean id="poDAO"
						class="web.order.model.PaymentOptionsDAOImpl" />
					<tr>
						<td>選擇付款方式:</td>
						<td><select size="1" name="payID">
								<c:forEach var="poVO" items="${poDAO.getAllPaymentOptions()}">
									<option value="${poVO.payID}">${poVO.payName}
								</c:forEach>
						</select></td>

					</tr>
					<tr>
						<td>選擇折扣碼</td>
						<td><select size="1" name="couponName">

						</select></td>
					</tr>
					<tr>
						<td>商品小計:</td>
						<td><p id="price"></p></td>
					</tr>
					<tr>
						<td>折扣:</td>
						<td><p id="discount"></p></td>
					</tr>
					<tr>
						<td>運費:</td>
						<td><p id="shipFee"></p></td>
					</tr>
					<tr>
						<td>訂單金額:</td>
						<td><p id="ordPrice"></p></td>
					</tr>
				</table>
				<input type="hidden" name="action" value="submit_order"> <input
					type="submit" value="送出訂單 !">
			</main>
		</div>
		<footer class="footer"> footer區域 </footer>
	</FORM>
</head>
</body>
</html>