<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
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

<h3>�q��d��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
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
        <b>��J�q��s�� (�p1):</b>
        <input type="text" name="ordID">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="OrdserMasterSvc" scope="page" class="web.order.model.OrderMasterService" />
   
  <li>
     <FORM METHOD="post" ACTION="/JoyLease/OrderMasterServlet" >
       <b>��ܭq��s��:</b>
       <select size="1" name="ordID">
         <c:forEach var="OrderMasterVO" items="${OrdserMasterSvc.all}" > 
          <option value="${OrderMasterVO.ordID}">${OrderMasterVO.ordID}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  

<!-- <h3>���u�޲z</h3> -->

<!-- <ul> -->
<!--   <li><a href='addEmp.jsp'>Add</a> a new Emp.</li> -->
</ul>

</body>
</html>