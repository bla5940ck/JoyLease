<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>JoyLease: Home</title>

<style>
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<p>This is the Home page for JoyLease: Home</p>

<h3>訂單查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllOrderMaster.jsp'>List</a> all Order.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="/JoyLease/OrderMasterServlet" >
        <b>輸入訂單編號 (如1):</b>
        <input type="text" name="ordID">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="OrdserMasterSVC" scope="page" class="web.order.model.OrderMasterService" />
   
  <li>
     <FORM METHOD="post" ACTION="/JoyLease/OrderMasterServlet" >
       <b>選擇訂單編號:</b>
       <select size="1" name="ordID">
         <c:forEach var="OrderMasterVO" items="${OrdserMasterSVC.all}" > 
          <option value="${OrderMasterVO.ordID}">${OrderMasterVO.ordID}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  

<!-- <h3>員工管理</h3> -->

<!-- <ul> -->
<!--   <li><a href='addEmp.jsp'>Add</a> a new Emp.</li> -->
</ul>

</body>
</html>