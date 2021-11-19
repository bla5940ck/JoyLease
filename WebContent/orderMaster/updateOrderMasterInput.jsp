<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.order.model.*"%>

<%
	OrderMasterVO omVO = (OrderMasterVO) request.getAttribute("OrderMasterVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�q���Ƨ�s:</title>

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
					<h1>�X���̱M��</h1>
					<ul class="nav_list">
						<li><a href="orderMaster/listAllOrderMaster.jsp">�����q��</a></li>
						<li><a href="orderMaster/select_page.jsp">�q��d��</a></li>
					</ul>
				</nav>
			</aside>
			<main class="main">
				<div>
					<h3>��s�q��</h3>
					<h3>
						�q��s�� :<%=omVO.getOrdID()%></h3>
				</div>
				<table id="table-1">
					<tr>
						<th>�B�e���A :</th>
						<td><p id="shipS"><%=omVO.getShipStatus()%></p></td>
						<td><select name="shipStatus" size="1" id="s">
								<option value="0">�ݥX�f</option>
								<option value="1">�w�X�f</option>
								<option value="2">�ݨ��f</option>
								<option value="3">���f����</option>
								<option value="9">�ӫ~��</option>
						</select></td>
					</tr>
					<tr>
						<th>�I�ڪ��A :</th>
						<td><p id="payS"><%=omVO.getPayStatus()%></p></td>
						<td><select name="payStatus" size="1">
								<option value="0">�ݥI��</option>
								<option value="1">�w�I��</option>
						</select></td>
					</tr>
					<tr>
						<th>�q�檬�A :</th>
						<td><p id="ordS"><%=omVO.getOrdStatus()%></p></td>
						<td><select name="ordStatus" size="1">
								<option value="0">�w����</option>
								<option value="1">���k��</option>
								<option value="2">�w����</option>
								<option value="3">�w����</option>
						</select></td>
					</tr>
				</table>
				<table>
					<tr>
						<th>�X�f�N�X</th>
						<td><input type="TEXT" name="shipCode" size="20"
							value="${OrderMasterVO.shipCode}"></td>

					</tr>

					<tr>
						<th>�k�٥N�X</th>
						<td><input type="TEXT" name="returnCode" size="20"
							value="${OrderMasterVO.returnCode}" /></td>
					</tr>

				</table>
				<table>
					<tr>
						<th>�X�f���</th>
						<td><input name="shipDate" type="TEXT" value="<%=omVO.getShipDate()%>"></td>
					</tr>
					<tr>
						<th>��ڨ�f���</th>
						<td><input type="TEXT" name="arrivalDate" value="<%=omVO.getArrivalDate()%>"></td>
					</tr>
					<tr>
						<th>����k�٤��</th>
						<td><input type="TEXT" name="returnDate" value="<%=omVO.getReturnDate()%>"></td>
					</tr>
				</table>
				<table>
					<tr>
						<th>�ӯ������</th>
						<td><p id="rr"><%=omVO.getRentRank()%></p></td>
						<td><select name="rentRank" size="1">
								<option value="${OrderMasterVO.rentRank}">����</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select></td>
					</tr>
					<tr>
						<th>�X�������</th>
						<td><p id="rr"><%=omVO.getLeaseRank()%></p></td>
						<td><select name="leaseRank" size="1">
								<option value="${OrderMasterVO.leaseRank}">����</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select></td>
					</tr>
					<tr>
						<th>�ӯ������</th>
						<td><p id="rc"><%=omVO.getRentComt()%></p></td>
						<td><select name="rentComt">
								<option value="${OrderMasterVO.rentComt}">�п��</option>
								<option value="�X�f�� !">�X�f�� !</option>
								<option value="����X�z !">����X�z !</option>
								<option value="���q�}�n !">���q�}�n !</option>
								<option value="�A�פ��� !">�A�פ��� !</option>
								<option value="�X�f�t�׺C !">�X�f�t�׺C !</option>
								<option value="�P�Ӥ����� !">�P�Ӥ����� !</option>
								
						</select></td>
					</tr>
					<tr>
						<th>�X�������</th>
						<td><p id="lc"><%=omVO.getLeaseComt()%></p></td>
						<td><select name="leaseComt">
								<option value="${OrderMasterVO.leaseComt}">�п��</option>
								<option value="�X�f�� !">�k�٧ֳt !</option>
								<option value="����X�z !">�r�֪���� !</option>
								<option value="���q�}�n !">���q�}�n !</option>
								<option value="�A�פ��� !">�A�פ��� !</option>
								<option value="�X�f�t�׺C !">�ٳf�t�׺C !</option>
								<option value="���R�����~ !">���R�����~ !</option>
						</select></td>
					</tr>
				</table>
				<input type="hidden" name="action" value="update"> 
				<input type="hidden" name="ordID" value="<%=omVO.getOrdID()%>">
				<input type="hidden" name="rentComtdate" value="${OrderMasterVO.rentComtdate}">
				<input type="hidden" name="leaseComtdate" value="${OrderMasterVO.leaseComtdate}">
				<input type="submit" value="�T�{��s">
			</main>
		</div>
		<footer class="footer"> footer�ϰ� </footer>
	</FORM>
</body>


<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
	
	/*=====�ӯ������=====*/
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
	/*=====�X�������=====*/
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
	
	/*=====�ӯ������=====*/

	
</script>
</html>
