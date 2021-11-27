<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="web.promo.model.*"%>
<!DOCTYPE html>
<%
  PromoVO promoVO = (PromoVO) request.getAttribute("promoVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>專案資料 - listOne_promo.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 600px;
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

<!-- <h4>此頁暫練習採用 Script 的寫法取值:</h4> -->
<table id="table-1">
	<tr><td>
		 <h3>員工資料 - listOne_promo.jsp</h3>
		 <h4><a href="select_promo.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>專案編號</th>
		<th>專案名稱</th>
		<th>專案開始日期</th>
		<th>專案結束日期</th>
		<th>專案內容</th>
		<th>專案狀態</th>
	</tr>
	<tr>
<%-- 		<td><%=promoVO.getPromo_id()%></td> --%>
<%-- 		<td><%=promoVO.getPromo_name()%></td> --%>
<%-- 		<td><%=promoVO.getPromo_start()%></td> --%>
<%-- 		<td><%=promoVO.getPromo_end()%></td> --%>
<%-- 		<td><%=promoVO.getPromo_text()%></td> --%>
<%-- 		<td><%=promoVO.getStatus()%></td> --%>

			<td>${promoVO.promo_id}</td>
			<td>${promoVO.promo_name}</td>
			<td>${promoVO.promo_start}</td>
			<td>${promoVO.promo_end}</td>
			<td>${promoVO.promo_text}</td> 
			<td>${promoVO.status}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/promo/promo.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="promo_id"  value="${promoVO.promo_id}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/promo/promo.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="promo_id"  value="${promoVO.promo_id}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>

	</tr>
</table>

</body>
</html>