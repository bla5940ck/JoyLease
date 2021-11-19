<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="web.order.model.*"%>

<%
	OrderMasterService ordserMasterSvc = new OrderMasterService();
	List<OrderMasterVO> list = ordserMasterSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<html>
<head>
<title>�Ҧ��q���� - listAllOrderMaster.jsp</title>
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

/*--------------------table�ϰ�-------------------- */
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
	<header class="header"> header�ϰ� </header>
	<div class="main_content">
		<aside class="aside">
			<nav class="nav">
				<h1>�X���̱M��</h1>
				<ul class="nav_list">
					<li><a href="listAllOrderMaster.jsp">�����q��</a></li>
					<li><a href="select_page.jsp">�q��d��</a></li>
				</ul>
			</nav>
		</aside>
		<main class="main">
			<div>
				<jsp:useBean id="OrdserMasterSvc" scope="page"
					class="web.order.model.OrderMasterService" />
					<FORM METHOD="post" ACTION="/JoyLease/OrderMasterServlet">
						<b>��ܭq��s��:</b> <select size="1" name="ordID">
							<c:forEach var="OrderMasterVO" items="${OrdserMasterSvc.all}">
								<option value="${OrderMasterVO.ordID}">${OrderMasterVO.ordID}
							</c:forEach>
						</select> <input type="hidden" name="action" value="getOne_For_Display">
						<input type="submit" value="�e�X">
					</FORM>
				
					<FORM METHOD="post" ACTION="/JoyLease/OrderMasterServlet">
						<b>��J�q��s�� (�p1):</b> <input type="text" name="ordID"> <input
							type="hidden" name="action" value="getOne_For_Display"> <input
							type="submit" value="�e�X">
					</FORM>
			</div>
			<table id="table-1">
				<tr>
					<th>�q��s��</th>
					<th>�ӯ��̽s��</th>
					<th>�X���̽s��</th>
					<th>����覡�s�X</th>
					<th>�����s��</th>
					<th>�B�e���A</th>
					<th>�I�ڪ��A</th>
					<th>�q�檬�A</th>
					<th>�q����</th>
					<th>�X�f�N�X</th>
					<th>�k�٥N�X</th>
					<th>�W�ӥN�X</th>
					<th>�w�p���ɰ_��</th>
					<th>�w�p���ɰW��</th>
					<th>��ڥX�f���</th>
					<th>��ڨ�f���</th>
					<th>����k�٤��</th>
					<th>�ӯ��Ѽ�</th>
					<th>�ӯ��̵���</th>
					<th>�X���̵���</th>
					<th>�ӯ��̵���</th>
					<th>�X���̵���</th>
					<th>�ӯ��̵��פ��</th>
					<th>�X���̵��פ��</th>
					<th>�ӫ~�p�p</th>
					<th>�B�O</th>
					<th>�q����B</th>
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
								<input type="submit" value="�ק�"> <input type="hidden"
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
	<footer class="footer"> footer�ϰ� </footer>
</body>
</html>