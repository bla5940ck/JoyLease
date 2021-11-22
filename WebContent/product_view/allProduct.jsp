<%@page import="web.product.model.ProdService"%>
<%@page import="java.util.List"%>
<%@page import="web.product.model.ProdVO"%>
<%@page import="web.product.model.ProdDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表頁面</title>
<% session.setAttribute("id", 1); //測試用    %>
<header> <div id= "userView">
<a href="memberData.jsp" title="測試超連結"><img   src="https://img.ltn.com.tw/Upload/ent/page/800/2021/03/14/phpJc0Acy.jpg"  width="60px"></a>
	
	
	會員編號<%=session.getAttribute("id")%>
	</div></header>
<style type="text/css">
hr{
   border-color:FF7F00; 
}
div{
   float:left;
   margin: 10px;
}
div dd{
   margin:0px;
   font-size:10pt;
}
div dd.dd_name{
   color:blue;
}
div dd.dd_city{
   color:#000;
}
</style>
</head>
<body>
    <h1>商品展示</h1>
    <hr>
    <center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td>
           <!-- 商品迴圈開始 -->
           
           <% 
             
               request.setCharacterEncoding("UTF-8");
            
               ProdService prodDao = new ProdService(); 
               List<ProdVO> list = new ArrayList<ProdVO>();
      		    list = prodDao.getAll();

               if(list!=null&&list.size()>0){
              for(int i=0;i<list.size();i++){
                 ProdVO product = list.get(i);
                 
                 String path = request.getContextPath();
                 //狀態 為1時才可以顯示在上架頁面
                 if(product.getProdStatus()==1){
        
           %>   
          <div>
             <dl>
               <dt>
                 <a href="productDetail.jsp?picno=<%=product.getProdID()%>">
                      <img src="<%=request.getContextPath()%>/ProdServlet?picNo=<%=product.getProdID()%>&no=1&action=detail" width="120" height="90" border="1"/>
                 </a>
					

               </dt>
               	  
                  <dd class="dd_name"><%=product.getProdName() %></dd> 
                   <dd class="dd_rent">&nbsp;&nbsp;租金:$ <%=product.getProdRent() %></dd>  
                   
             </dl>
          </div>
          <!-- 商品迴圈結束 -->
        
          <%
                   }
              } 
               }
          %>
        </td>
      </tr>
    </table>
    </center>
    
   
    
</body>
</html>