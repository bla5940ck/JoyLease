
<%@page import="web.product.model.BookingService"%>
<%@page import="web.product.model.ProdCategoryDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page import="web.product.model.BookingDAO"%>
<%@page import="web.product.model.BookingVO"%>
<%@page import="web.product.model.ProdVO"%>
<%@page import="web.product.model.ProdDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	ProdDAO productDao = new ProdDAO();
	ProdVO product=null;
	//上傳頁面 的值
	int prodID =Integer.valueOf(request.getParameter("prodID"));
		product = productDao.findProductByPK(prodID);
	//修改後 的值
		if(request.getAttribute("proVO")!=null){
			product =(ProdVO)request.getAttribute("proVO");
		}
	
	//會員修改資料傳進來的參數(上架時)

	//未上架修改
	
		
		
	BookingVO bk = new BookingVO();
	BookingService bkDao = new BookingService();
	ProdCategoryDAO cateDao1 = new ProdCategoryDAO();
	int picAmount = 0;
	
	//動態算出 資料庫圖片個數
	if (product != null) {
		if (product.getPic1() != null)
			picAmount++;
		if (product.getPic2() != null)
			picAmount++;
		if (product.getPic3() != null)
			picAmount++;
	}
	
	List<BookingVO> list = bkDao.findDateByProdID(product.getProdID());
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上傳前預覽</title>
<script src="<%=path%>/jquery-3.6.0.min.js"></script>

<style type="text/css">
hr {
	border-color: FF7F00;
}

div {
	float: left;
	margin-left: 30px;
	margin-right: 30px;
	margin-top: 5px;
	margin-bottom: 5px;
}

div dd {
	margin: 0px;
	font-size: 10pt;
}

div dd.dd_name {
	color: blue;
}

div dd.dd_city {
	color: #000;
}

div #cart {
	margin: 0px auto;
	text-align: right;
}

span {
	padding: 0 2px;
	border: 1px #c0c0c0 solid;
	cursor: pointer;
}

a {
	text-decoration: none;
}

#userView {
	position: absolute;
	top: 0;
	right: 0;
}

#userView {
	position: absolute;
	top: 0;
	right: 0;
}

.box {
	width: 400px;
}

#show_L img {
	width: 80%;
}

.all_img {
	display: grid;
	grid-template-columns: repeat(4, 1fr);
}

.all_img img {
	width: 80%;
	cursor: pointer;
}

input.submit_btn {
	border: 0;
	background-color: #003C9D;
	color: #fff;
	font-weight: bold;
	border-radius: 10px;
	cursor: pointer;
}

input.submit_btn:hover {
	color: black;
	font-weight: bold;
	background-color: red;
	border: 2px #003C9D solid;
}

input.submit_btn1 {
	border: 0;
	background-color: #003C9D;
	color: red;
	font-weight: bold;
	border-radius: 10px;
	cursor: pointer;
}

input.submit_btn1:hover {
	color: black;
	font-weight: bold;
	background-color: #fff;
	border: 2px #003C9D solid;
}
</style>
</head>
<body>
	<div id="userView">
		<a href="memberData.jsp" title="測試超連結"><img
			src="https://img.ltn.com.tw/Upload/ent/page/800/2021/03/14/phpJc0Acy.jpg"
			width="60px"></a> 會員編號<%=session.getAttribute("id")%>

	</div>
	<h1>商品詳情</h1>
	<a href="<%=path %>/product_view/allProduct.jsp"">首頁</a> >>
	<a href="<%=path %>/product_view/allProduct.jsp" title="商品頁面">商品列表</a>
	<hr>
	<center>
		<%-- 錯誤表列 --%>

		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>


		<form action="<%=path%>/ProdServlet">
			<table width="750" height="60" cellpadding="0" cellspacing="0"
				border="0">
				<tr>
					<%
					if (product != null) {
				%>

					<td width="70%" valign="top">
						<table>
							<tr>
								<div class="box">
									<div id='show_L'>
										<img
											src="<%=path%>/ProdServlet?action=detail&picNo=<%=prodID%>&no=1"
											alt="">
									</div>
									<div class="all_img" id="all_img"></div>
								</div>

							</tr>
							<tr>
								<td><B>商品名稱<input id="product_name" name="product_name"
										value=<%=product.getProdName()%>></B></td>
							</tr>
							<tr>
								<td>會員編號：<%=product.getMemberID()%></td>
							</tr>
							<tr>
								<td>租金：$<input id="product_rent" name="product_rent"
									value=<%=product.getProdRent()%>></td>
							</tr>
							<tr>
								<td>商品損壞賠償金：$<input id="product_price" name="product_price"
									value=<%=product.getProdPrice()%>></td>
							</tr>

							<tr>
								<td>商品內容：<input id="product_cot" name="product_cot"
									value=<%=product.getProdCot()%>></td>
							</tr>

							<tr>
								<td>備註：<input id="product_comt" name="comt"
									value=<%=product.getComt()%>></td>
								<br> 商品類別
								<jsp:useBean id="cateDao" scope="page"
									class="web.product.model.ProdCategoryDAO" />
								<select id="cate_select" name="categorySelect">
									<option value="<%=product.getCategoryID()%>"><%=cateDao1.findCategoryByPK(product.getCategoryID()).getCategoryName() %>
										<c:forEach varStatus="status" var="cateVO"
											items="${cateDao.allCategory}">

											<option value="${cateVO.categoryID}">${cateVO.categoryName}
										</c:forEach>
								</select>
							</tr>
							<tr>
								<td><input class="submit_btn" id="submit1" type="submit"
									value="直接上架" style="width: 100px; height: 50px;">
							</tr>
							<input type="hidden" name="action" value="update">
							<input type="hidden" name="prodID" value=<%=product.getProdID()%>>
							<input type="hidden" value="shelf" name="status">

							<%} %>
						</table>
						</form>

						<form action="<%=path%>/ProdServlet">
							<input id="hid_name" type="hidden" name="product_name"> <input
								id="hid_rent" type="hidden" name="product_rent"> <input
								id="hid_price" type="hidden" name="product_price"> <input
								id="hid_cate" type="hidden" name="categorySelect"> <input
								id="hid_cot" type="hidden" name="product_cot"> <input
								id="hid_comt" type="hidden" name="comt"> <input
								type="hidden" name="prodID" value=<%=product.getProdID()%>>
							<input type="hidden" id="complete" name="status"> <input
								type="hidden" name="action" value="update"> <input
								class="submit_btn1" type="submit" value="建立後不上架"
								style="width: 100px; height: 50px;">
						</form> <script>
			var picAmount = <%=picAmount%>
			console.log(picAmount);
			function change_img(e) {
				let new_sre = e.target.getAttribute('src');
				document.querySelector('#show_L > img').setAttribute(
						'src', new_sre);
			}
			function init() {
				//動態印出資料庫裡的圖片
				for (var i = 1; i <= picAmount; i++) {
					//取得圖片編號對應1 2 3
					var query =
		<%=prodID%>
			+ "&no=" + i;

					$('div.all_img').append(
							"<img src='/JoyLease/ProdServlet?action=detail&picNo="
									+ query + "'>");
				}
				document.querySelectorAll('.all_img > img').forEach(
						function(element) {
							element.addEventListener('click',
									change_img);
						});
			}
			window.addEventListener('load', init);
			
			//設定到hidden
			$("input.submit_btn1").click(function(){
				$('#hid_name').val($("#product_name").val());
				$('#hid_price').val($("#product_price").val());
				$('#hid_rent').val($("#product_rent").val());
				$('#hid_cot').val($("#product_cot").val());
				$('#hid_comt').val($("#product_comt").val());
				$('#hid_cate').val($("#cate_select").val());
					
			});
			
				</script>