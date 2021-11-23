<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="web.member.model.*"%>
<%@page import="web.member_coupon.model.*"%>
<%@page import="web.promo_list.model.*"%>
<%@page import="web.member.model.*"%>
<%@page import="web.order.model.*"%>
<%@ page import="web.order.model.*"%>
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
	// 	out.print(product.getProdName());
	
	
	
	DefAddressJDBCDAO dadao = new DefAddressJDBCDAO();
	List<DefAddressVO> list2 = dadao.getAll();
	
	DefAddressVO daVO = new DefAddressVO();
	
	MemberJDBCDAO medao = new MemberJDBCDAO();
	MemberVO meVO = medao.findByPrimaryKey(1);
// 	Integer id = meVO.getMemberId();
	
// 	out.print(id);
	
// 	for (DefAddressVO da : list2) {
// 		if(da.getMemberId() == id && da.getStatus() == 1){
// 			out.print(da.getDef711());
// 		}
// 	}

	MemcouponDAO mcdao = new MemcouponDAO();
	List<MemcouponVO> list = mcdao.getAll();
	// 	PromolistDAO pldao = new PromolistDAO();
	// 	PromolistVO plVO = pldao.findByPrimaryKey();

	// 	for (PromolistVO pl : list3) {
	// 		// 		out.println(pl.getCoupon_name());
	// 		// 		out.println(pl.getCoupon_id());

	// 	}
	
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

table {
	width: 100%;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid black;	
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

<%@ include file="header.file" %>
<!-- 	<header class="header"> header區域 </header> -->
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
					<li><a href="#">返回購物車</a></li>
					<tr>
						<td>商品名稱 :</td>
						<td><a id="prodName"
							href="<%=request.getContextPath()%>/product_view/productDetail.jsp?picno=1"><%=prodVO.getProdName()%></a></td>
					</tr>
					<!-- 					<tr> -->
					<!-- 						<td>預定租借起日:</td> -->
					<!-- 						<td><p id="estStart"></p></td> -->
					<!-- 					</tr> -->
					<!-- 					<tr> -->
					<!-- 						<td>預定租借訖日:</td> -->
					<!-- 						<td><p id="estEnd"></p></td> -->
					<!-- 					</tr> -->
					<tr>
						<td>您的姓名:</td>
						<td><input type="hidden" name="memberID" value="<%=meVO.getMemberId()%>"><%=meVO.getName()%></td>
<!-- 						<td><input type="text" name="recipient"></td> -->
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
						<td>選擇折扣碼:</td>
						<td><select size="1" name="couponID" id="cpn">
								<option>使用折價券
									<%
									for (int i = 0; i < list.size(); i++) {
										MemcouponVO mcVO = list.get(i);
										if (mcVO.getMember_id() == 3) {
											// out.println(mcVO.getCoupon_id());
											PromolistDAO pldao = new PromolistDAO();
											PromolistVO plVO = pldao.findByPrimaryKey(mcVO.getCoupon_id());
											// String name = plVO.getCoupon_name();
											// out.print(name);
								%>
								
								<option id="disc" value="<%=mcVO.getCoupon_id()%>">!!<%=plVO.getCoupon_name()%>!!
									 可折扣 :
									<%=Math.round(plVO.getDiscount())%>元<br>
								</option>
								<%
									}
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td>預設物流:</td>
						<td><select size="1" name="code711" id="cpn">
								<option>我的超商選項
									<%									
									Integer id = meVO.getMemberId();
									for(int i = 0; i < list2.size(); i++){
										DefAddressVO daVO1 = list2.get(i);
										if(daVO1.getMemberId() == id){
								%>			
								<option id="def711" value="<%=daVO1.getCode711()%>"><%=daVO1.getName711()%> / <%=daVO1.getRecipient()%> / <%=daVO1.getRecptPhone()%><br>
								</option>
								<%
										}
									}
								%>
						</select></td>
					</tr>				
					<tr>
						<td>商品小計:</td>
						<td><input type="hidden" name="price" value="100">100</td>
					</tr>
					<tr>
						<td>折扣:</td>
						<td><p id="discount"></p></td>
					</tr>
					<tr>
						<td>運費:</td>
						<td><input type="hidden" name="shipFee" value="60">60</td>
					</tr>
					<tr>
						<td>訂單金額:</td>
						<td><p id="ordPrice"></p></td>
					</tr>
				</table>
				<input type="hidden" name="action" value="submit_order"> 
				<input
					type="hidden" name="prodName" value="<%=prodVO.getProdName()%>">

				<input type="submit" value="送出訂單 !">
			</main>
		</div>
		<%@ include file="footer.file" %>
<!-- 		<footer class="footer"> footer區域 </footer> -->
	</FORM>
	</head>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$("#cpn").change(function(){
		alert(($("#cpn")).val());
		$("#discount").text($("#cpn").val());
	});
</script>

</html>