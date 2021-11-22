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
<title>���b :</title>

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

/*-------------------aside�ϰ�------------------- */
aside.aside {
	background-color: #ddd;
	width: 200px;
	display: inline-block;
	vertical-align: top;
	font-size: 1rem;
	margin-right: 10px;
	border: 1px solid #999;
}

/*--------------------main�ϰ�-------------------- */
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
	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>


	<header class="header"> header�ϰ� </header>
	<FORM METHOD="post" ACTION="/JoyLease/OrderMasterServlet" name="form1">
		<div class="main_content">
			<aside class="aside">
				<nav class="nav">
					<h1>���D</h1>
					<ul class="nav_list">
						<li><a href="#">�s��</a></li>
						<li><a href="#">�s��</a></li>
					</ul>
				</nav>
			</aside>
			<main class="main">
				<div>
					<h3>���b����</h3>
				</div>


				<table id="table-1">
					<h3>�T�{�H�U��T</h3>
					<p id="today">���</p>
					<li><a href="#">��^�ʪ���</a></li>
					<tr>
						<td>�ӫ~�W�� :</td>
						<td><a
							href="<%=request.getContextPath()%>/product_view/productDetail.jsp?picno=1"><%=prodVO.getProdName()%></a></td>
					</tr>
					<tr>
						<td>�w�w���ɰ_��:</td>
						<td><p id="estStart"></p></td>
					</tr>
					<tr>
						<td>�w�w���ɰW��:</td>
						<td><p id="estEnd"></p></td>
					</tr>
					<tr>
						<td>����H�m�W:</td>
						<td><input type="text" id="recipient"></td>
					</tr>
					<tr>
						<td>����H�q��:</td>
						<td><input type="text" id="recptPhone"></td>
					</tr>


					<jsp:useBean id="daDAO" class="web.member.model.DefAddressJDBCDAO" />
					<tr>
						<td>���711�������:</td>
						<td><select size="1" name="name711">
								<option value="0">����
									<c:forEach var="daVO" items="${daDAO.getAll()}">
										<option value="${daVO.code711}">${daVO.name711}
									</c:forEach>
						</select></td>
					</tr>

					<jsp:useBean id="poDAO"
						class="web.order.model.PaymentOptionsDAOImpl" />
					<tr>
						<td>��ܥI�ڤ覡:</td>
						<td><select size="1" name="payID">
								<c:forEach var="poVO" items="${poDAO.getAllPaymentOptions()}">
									<option value="${poVO.payID}">${poVO.payName}
								</c:forEach>
						</select></td>

					</tr>
					<tr>
						<td>��ܧ馩�X</td>
						<td><select size="1" name="couponName">

						</select></td>
					</tr>
					<tr>
						<td>�ӫ~�p�p:</td>
						<td><p id="price"></p></td>
					</tr>
					<tr>
						<td>�馩:</td>
						<td><p id="discount"></p></td>
					</tr>
					<tr>
						<td>�B�O:</td>
						<td><p id="shipFee"></p></td>
					</tr>
					<tr>
						<td>�q����B:</td>
						<td><p id="ordPrice"></p></td>
					</tr>
				</table>
				<input type="hidden" name="action" value="submit_order"> <input
					type="submit" value="�e�X�q�� !">
			</main>
		</div>
		<footer class="footer"> footer�ϰ� </footer>
	</FORM>
</head>
</body>
</html>