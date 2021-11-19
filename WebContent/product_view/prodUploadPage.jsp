<%@page import="web.product.model.ProdCategoryDAO"%>
<%@page import="web.product.model.ProdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>Insert title here</title>
<h2>上架頁面</h2>

<script src="<%=request.getContextPath()%>/jquery-3.6.0.min.js"
	"type="text/javascript"></script>

<style>
#userView {
	position: absolute;
	top: 0;
	right: 0;
}

#preview {
	border: 1px solid lightgray;
	display: inline-block;
	width: 100px;
	min-height: 150px;
	position: relative;
}

#preview span.text {
	position: absolute;
	display: inline-block;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	z-index: -1;
	color: lightgray;
}

#preview img.preview_img {
	width: 100%;
}

img.preview {
	width: 100%;
}
input.submit_btn{border:0;
  background-color:#003C9D;
  color:#fff;
  font-weight: bold;
  border-radius:10px;
  cursor:pointer;}

input.submit_btn:hover{
  color:black;
  font-weight: bold;
  background-color:red;
  border:2px #003C9D solid;
}
</style>
</head>
<body>

	<form id="form2" action="<%=request.getContextPath()%>/ProdServlet"
		method="post" enctype="multipart/form-data">
		圖片上傳(最多三張)<input type="file" id='file_id' name='file_name' value=""
			multiple> <br>
		<div id="preview">
			<span class="text">商品圖</span>
		</div>
		<br> 商品類別
		
		
<!-- 		動態加入商品類別 -->
		<jsp:useBean id="cateDao" scope="page" class="web.product.model.ProdCategoryDAO" />
		<select  id="cate_select" name="categorySelect">
		<option>請選擇商品類別</option>
		<c:forEach   varStatus="status" var="cateVO" items="${cateDao.allCategory}" >
		
		 <option  value="${cateVO.categoryID}">${cateVO.categoryName}

		
		</c:forEach> 
		</select> 
		
		<br> 商品名稱<input type="text" name="product_name"
			id="product_name"><br> 商品租金<input type="text"
			name="product_rent" id="product_rent"><br> 商品損壞賠償金<input
			type="text" name="product_price" id="product_price"><br>
		商品內容<input type="text" style="padding: 90px" name="product_cot"
			id="product_cot"><br> 備註<input type=text name="comt"
			id="comt"><br> <input type=hidden id="fileCount"
			name="fileCount"><br> 
			
			<input type = "hidden" name="action" value="upload">
			
			<input class="submit_btn" id="submit1" type="submit"
			value="建立商品" style="width:100px;height:50px;">
	</form>
	<div id="userView">
		<a href="memberData.jsp" title="測試超連結"><img
			src="https://img.ltn.com.tw/Upload/ent/page/800/2021/03/14/phpJc0Acy.jpg"
			width="60"></a> 會員編號<%=session.getAttribute("id")%>


	</div>







	<script>
		$("#file_id").change(function() {
			$("#preview").html(""); // 清除預覽
			readURL(this);

		});
		//圖片最多三張限制
		function readURL(input) {
			var fileCount = input.files.length;
			$("#fileCount").val(fileCount);
			if (input.files.length > 3) {
				alert("最多只能選三張圖片喔");
				$("#file_id").val("");
				$("#preview").html("<span class='text'>預覽圖</span>");
			} else {

				if (input.files && input.files.length >= 0) {
					for (var i = 0; i < input.files.length; i++) {
						var reader = new FileReader();
						reader.onload = function(e) {
							var img = $("<img class = 'preview_img'>").attr(
									'src', e.target.result);
							$("#preview").append(img);
						}
						reader.readAsDataURL(input.files[i]);
					}
				}
			}
		}
		//空白防呆
		$("#submit1").on(
				'click',
				function(e) {
					e.preventDefault();
					if ($("#file_id").val() == "") {
						alert("圖片至少上傳一張喔");
					} else if ($("#product_name").val() == "") {
						alert("商品名稱記得填");
					} else if ($("#product_rent").val() == "") {
						alert("商品租金記得填");
					} else if ($("#product_price").val() == "") {
						alert("損壞賠償金記得填");
					} else if ($("#product_cot").val() == "") {
						alert("商品內容記得填");
					} else if ($("#cate_select").val() == ""
							|| $("#cate_select").val() == "請選擇商品類別") {
						alert("商品類別記得填");
					} else {
						$("#form2").submit();
					}
				});
	</script>
</body>
</html>