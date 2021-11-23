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
<title>�q���T</title>
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
</head>
<body bgcolor="white">
	<header class="header"> header�ϰ� </header>
	<div class="main_content">
		<aside class="aside">
			<nav class="nav">
				<ul class="nav_list">
					<h1>�X���̱M��</h1>
					<li><a href="orderMaster/listAllOrderMaster.jsp">�����q��</a></li>
					<li><a href="orderMaster/select_page.jsp">�q��d��</a></li>

				</ul>
			</nav>
		</aside>

		<main class="main">
			<h3>�q���T</h3>
			<h4>�q��s�� :</h4>
			<p><%=omVO.getOrdID()%></p>

			<h4>�ӯ��̽s�� :</h4>
			<p><%=omVO.getRentID()%></p>

			<h4>�X���̽s�� :</h4>
			<p><%=omVO.getLeaseID()%></p>

			<h4>����覡�s�X :</h4>
			<p><%=omVO.getPayID()%></p>

			<h4>�����s�� :</h4>
			<p><%=omVO.getCouponID()%></p>

			<h4>�B�e���A :</h4>
			<p id="shipS">
				�B�e���A :<%=omVO.getShipStatus()%></p>

			<h4>�I�ڪ��A :</h4>
			<p id="payS"><%=omVO.getPayStatus()%></p>

			<h4>�q�檬�A :</h4>
			<p id="ordS"><%=omVO.getOrdStatus()%></p>

			<h4>�q���� :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getOrdDate()%>"
					pattern="yyyy-MM-dd HH:MM" />
			</p>

			<h4>�X�f�N�X :</h4>
			<p><%=omVO.getShipCode()%></p>

			<h4>�k�٥N�X :</h4>
			<p><%=omVO.getReturnCode()%></p>

			<h4>�W�ӥN�X :</h4>
			<p><%=omVO.getStoreCode()%></p>

			<h4>�w�p���ɰ_�� :</h4>
			<p><%=omVO.getEstStart()%></p>

			<h4>�w�p���ɰW�� :</h4>
			<p><%=omVO.getEstEnd()%></p>

			<h4>��ڥX�f��� :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getShipDate()%>"
					pattern="yyyy-MM-dd HH:MM" />
			</p>

			<h4>��ڨ�f��� :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getArrivalDate()%>"
					pattern="yyyy-MM-dd HH:MM" />
			</p>

			<h4>����k�٤�� :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getReturnDate()%>"
					pattern="yyyy-MM-dd HH:MM" />
			</p>

			<h4>�ӯ��Ѽ� :</h4>
			<p><%=omVO.getRentDays()%></p>

			<h4>�ӯ��̵��� :</h4>
			<p><%=omVO.getRentRank()%></p>

			<h4>�X���̵��� :</h4>
			<p><%=omVO.getLeaseRank()%></p>

			<h4>�ӯ��̵��� :</h4>
			<p><%=omVO.getRentComt()%></p>

			<h4>�X���̵��� :</h4>
			<p><%=omVO.getLeaseComt()%></p>

			<h4>�ӯ��̵��פ�� :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getRentComtdate()%>"
					pattern="yyyy-MM-dd" />
			</p>

			<h4>�X���̵��פ�� :</h4>
			<p>
				<fmt:formatDate value="<%=omVO.getLeaseComtdate()%>"
					pattern="yyyy-MM-dd" />
			</p>

			<h4>�ӫ~�p�p :</h4>
			<p><%=omVO.getProdPrice()%></p>

			<h4>�B�O :</h4>
			<p><%=omVO.getShipFee()%></p>

			<h4>�q����B :</h4>
			<p><%=omVO.getOrdPrice()%></p>

			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/OrderMasterServlet"
				style="margin-bottom: 0px;">
				<input type="submit" value="��s"> <input type="hidden"
					name="ordID" value="<%=omVO.getOrdID()%>"> <input
					type="hidden" name="action" value="getOne_For_Update">
			</FORM>



		</main>
	</div>
	<footer class="footer"> footer�ϰ� </footer>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	/*=====�B�e���A=====*/

	var shipS = $("#shipS");
	if (
<%=omVO.getShipStatus()%>
	== 0) {
		shipS.text("�ݥX�f");
	} else if (
<%=omVO.getShipStatus()%>
	== 1) {
		shipS.text("�w�X�f");
	} else if (
<%=omVO.getShipStatus()%>
	== 2) {
		shipS.text("�ݨ��f");
	} else if (
<%=omVO.getShipStatus()%>
	== 3) {
		shipS.text("���f����");
	} else {
		shipS.text("�ӫ~��");
	};

	/*=====�I�ڪ��A=====*/

	var payS = $("#payS");
	if (
<%=omVO.getPayStatus()%>
	== 0) {
		payS.text("�ݥI��");
	} else {
		payS.text("�w�I��");
	};

	/*=====�q�檬�A=====*/

	var ordS = $("#ordS");
	if (
<%=omVO.getOrdStatus()%>
	== 0) {
		ordS.text("�w����");
	} else if (
<%=omVO.getOrdStatus()%>
	== 1) {
		ordS.text("���k��");
	} else if (
<%=omVO.getOrdStatus()%>
	== 2) {
		ordS.text("�w����");
	} else {
		ordS.text("�w����");
	};
</script>
</html>