<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="web.order.model.*"%>

<%
	OrderListService olSVC = new OrderListService();
	List<OrderListVO> list = olSVC.getAll();
	pageContext.setAttribute("list", list);
%>

<html>
<head>
<title>�Ҧ��q�����</title>
</head>
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
<body bgcolor='white'>
	<header class="header"> header�ϰ� </header>
	<div class="main_content">
		<aside class="aside">
			<nav class="nav">
				<h1>�X���̱M��</h1>
				<ul class="nav_list">
					<li><a href="listAllOrderList.jsp">�����q�����</a></li>
				</ul>
			</nav>
		</aside>
		<main class="main">
			<div>
			
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/OrderListServlet">
					<b>��J�q����ӽs�� (�p1):</b> 
					<input type="text" name="listID"> 
					<input type="hidden" name="action" value="getOne_For_Display">
					<input type="submit" value="�e�X">
			</FORM>
			
			<jsp:useBean id="OrdserListSvc" scope="page" class="web.order.model.OrderListService" />
				
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/OrderListServlet">
				<b>��ܭq����ӽs��:</b> 
				<select size="1" name="listID">
					<c:forEach var="OrderListVO" items="${OrdserListSvc.all}">
						<option value="${OrderListVO.listID}">${OrderListVO.listID}
					</c:forEach>
				</select> 
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>

			</div>
			<table id="table-1">
				<tr>
					<th>�q����ӽs��</th>
					<th>�ӫ~�s��</th>
					<th>�q��s��</th>
					<th>�q����B</th>
				</tr>
				<%@ include file="page1.file"%>
				<c:forEach var="olVO" items="${list}" begin="<%=pageIndex%>"
					end="<%=pageIndex+rowsPerPage-1%>">
					<tr>
						<td>${olVO.listID}</td>
						<td>${olVO.prodID}</td>
						<td>${olVO.ordID}</td>
						<td>${olVO.price}</td>
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/OrderMasterServlet"
								style="margin-bottom: 0px;">
								<input type="submit" value="�d�ݩ���"> 
								<input type="hidden" name="ordID" value="${olVO.ordID}"> 
								<input type="hidden" name="action" value="getOne_For_Display">
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