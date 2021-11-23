<%@page import="web.product.model.CartVO"%>
<%@page import="redis.clients.jedis.Jedis"%>
<%@page import="redis.clients.jedis.JedisPool"%>
<%@page import="web.product.model.ProdService"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="web.product.model.ProdVO"%>
<%@page import="web.product.model.ProdDAO"%>
<%@page import="web.product.controller.JedisPoolUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="web.product.model.CartVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="<%=request.getContextPath()%>/jquery-3.6.0.min.js"></script>
<meta content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>JoyLease | Cart</title>
    
    <!-- Font awesome -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="css/bootstrap copy.css" rel="stylesheet">   
    <!-- SmartMenus jQuery Bootstrap Addon CSS -->
<!--     <link href="css/jquery.smartmenus.bootstrap.css" rel="stylesheet"> -->
    <!-- Product view slider -->
    <link rel="stylesheet" type="text/css" href="css/jquery.simpleLens.css">    
    <!-- slick slider -->
    <link rel="stylesheet" type="text/css" href="css/slick.css">
    <!-- price picker slider -->
    <link rel="stylesheet" type="text/css" href="css/nouislider.css">
    <!-- Theme color -->
    <link id="switcher" href="css/theme-color/dark-navy-theme.css" rel="stylesheet">
    <!-- <link id="switcher" href="css/theme-color/bridge-theme.css" rel="stylesheet"> -->
    <!-- Top Slider CSS -->
<!--     <link href="css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all"> -->

    <!-- Main style sheet -->
    <link href="css/style copy.css" rel="stylesheet">    

    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  

  </head>
  <body> 
  
  <%
  Integer memberID = (Integer)session.getAttribute("id");
  
  JedisPool pool = JedisPoolUtil.getJedisPool(); 
  Jedis jedis = pool.getResource();
  List<String> cart = jedis.lrange("member"+memberID, 0, jedis.llen("member"+memberID));
	
	Gson gson = new Gson();

%>
  
  
  
  
   <!-- wpf loader Two -->
    <div id="wpf-loader-two">          
      <div class="wpf-loader-two-inner">
        <span>Loading</span>
      </div>
    </div> 
    <!-- / wpf loader Two -->       
  <!-- SCROLL TOP BUTTON -->
    <a class="scrollToTop" href="#"><i class="fa fa-chevron-up"></i></a>
  <!-- END SCROLL TOP BUTTON -->


  <!-- Start header section -->
  <header id="aa-header">
    <!-- start header top  -->
    <div class="aa-header-top">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="aa-header-top-area">
              <!-- start header top left -->
              <div class="aa-header-top-left">
                <p style="font-size: 20px; margin:0;font-weight:normal;">JoyLease</p>
              </div>
                
                <!-- start language -->
                <!-- <div class="aa-language">
                  <div class="dropdown">
                    <a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                      <img src="img/flag/english.jpg" alt="english flag">ENGLISH
                      <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                      <li><a href="#"><img src="img/flag/french.jpg" alt="">FRENCH</a></li>
                      <li><a href="#"><img src="img/flag/english.jpg" alt="">ENGLISH</a></li>
                    </ul>
                  </div>
                </div> -->
                <!-- / language -->

                <!-- start currency -->
                <!-- <div class="aa-currency">
                  <div class="dropdown">
                    <a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                      <i class="fa fa-usd"></i>USD
                      <span class="caret"></span>
                    </a> -->
                    <!-- <ul class="dropdown-menu" aria-labelledby="dropdownMenu1"> -->
                      <!-- <li><a href="#"><i class="fa fa-euro"></i>EURO</a></li>
                      <li><a href="#"><i class="fa fa-jpy"></i>YEN</a></li> -->
                    <!-- </ul>
                  </div>
                </div> 
                < / currency -->
                <!-- start cellphone -->
                <!-- <div class="cellphone hidden-xs">
                  <p><span class="fa fa-phone"></span>00-62-658-658</p>
                </div> -->
                <!-- / cellphone -->
              <!-- </div> -->
              <!-- / header top left -->
              <div class="aa-header-top-right">
                <ul class="aa-head-top-nav-right">
                  <li><a href="account copy.html">會員帳戶</a></li>
                  <li class="hidden-xs"><a href="account copy.html">我要出租</a></li>
                  <li class="hidden-xs"><a href="cart copy.html">購物車</a></li>
                  <!-- <li class="hidden-xs"><a href="checkout.html">Checkout</a></li> -->
                  <li><a href="" data-toggle="modal" data-target="#login-modal">會員登入</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- / header top  -->

    <!-- start header bottom  -->
    <div class="aa-header-bottom">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="aa-header-bottom-area">
              <!-- logo  -->
              <div class="aa-logo">
                <!-- Text based logo -->
                <a href="index copy.html">
                  
                  <img src="img\logo_org_noframe_191561.png" alt="">
                  <!-- <p>JoyLease</p> -->
                  <!-- <span class="fa fa-shopping-cart"></span> --> 
                  
                </a>
                <!-- img based logo -->
                <!-- <a href="index.html"><img src="img/logo.jpg" alt="logo img"></a> -->
              </div>
              <!-- / logo  -->
               <!-- cart box -->
              <div class="aa-cartbox">
                <a class="aa-cart-link" href="">
                  <span class="fa fa-shopping-basket"></span>
                  <span class="aa-cart-title">我的購物車</span>
                  <span class="aa-cart-notify">1</span>
                </a>
                <div class="aa-cartbox-summary">
                  <ul>
                    <li>
                      <a class="aa-cartbox-img" href="#"><img src="img/woman-small-2.jpg" alt="img"></a>
                      <div class="aa-cartbox-info">
                        <h4><a href="#">SwitchOLED</a></h4>
                        <p>1 x $250</p>
                      </div>
                      <a class="aa-remove-product" href="#"><span class="fa fa-times"></span></a>
                    </li>
                    <li>
                      <a class="aa-cartbox-img" href="#"><img src="img/woman-small-1.jpg" alt="img"></a>
                      <div class="aa-cartbox-info">
                        <h4><a href="#">健身環大冒險</a></h4>
                        <p>1 x $250</p>
                      </div>
                      <a class="aa-remove-product" href="#"><span class="fa fa-times"></span></a>
                    </li>                    
                    <li>
                      <span class="aa-cartbox-total-title">
                        總計
                      </span>
                      <span class="aa-cartbox-total-price">
                        $500
                      </span>
                    </li>
                  </ul>
                  <a class="aa-cartbox-checkout aa-primary-btn" href="checkout copy.html">購物車結帳</a>
                </div>
              </div>
              <!-- / cart box -->
              <!-- search box -->
              <div class="aa-search-box">
                <form action="">
                  <input type="text" name="" id="" placeholder="健身環大冒險">
                  <button type="submit"><span class="fa fa-search"></span></button>
                </form>
              </div>
              <!-- / search box -->             
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- / header bottom  -->
  </header>
  <!-- / header section -->
  <!-- menu -->
  <section id="menu">
    <div class="container">
      <div class="menu-area">
        <!-- Navbar -->
        <div class="navbar navbar-default" role="navigation">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>          
          </div>
          <div class="navbar-collapse collapse">
            <!-- Left nav -->
            <ul class="nav navbar-nav ">
              <!-- <li><a href="index.html">Home</a></li> -->
              <li><a href="#">全部分類 <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="#">Nintendo</a></li>
                  <li><a href="#">PlayStation</a></li>
                  <li><a href="#">XBOX</a></li>
                  <li><a href="#">其他遊戲主機</a></li>                                                
                  <li><a href="#">電腦遊戲</a></li>
                  <li><a href="#">桌遊</a></li>
                  <li><a href="#">拼圖</a></li>
                  <li><a href="#">其他</a></li>
                  <!-- <li><a href="#">And more.. <span class="caret"></span></a> -->
                    <!-- <ul class="dropdown-menu">
                      <li><a href="#">Sleep Wear</a></li>
                      <li><a href="#">Sandals</a></li>
                      <li><a href="#">Loafers</a></li>                                      
                    </ul> -->
                  <!-- </li> -->
                </ul>
              </li>
              <li><a href="#">使用教學</a>
                <!-- <ul class="dropdown-menu">  
                  <li><a href="#">Kurta & Kurti</a></li>                                                                
                  <li><a href="#">Trousers</a></li>              
                  <li><a href="#">Casual</a></li>
                  <li><a href="#">Sports</a></li>
                  <li><a href="#">Formal</a></li>                
                  <li><a href="#">Sarees</a></li>
                  <li><a href="#">Shoes</a></li>
                  <li><a href="#">And more.. <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Sleep Wear</a></li>
                      <li><a href="#">Sandals</a></li>
                      <li><a href="#">Loafers</a></li>
                      <li><a href="#">And more.. <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                          <li><a href="#">Rings</a></li>
                          <li><a href="#">Earrings</a></li>
                          <li><a href="#">Jewellery Sets</a></li>
                          <li><a href="#">Lockets</a></li>
                          <li class="disabled"><a class="disabled" href="#">Disabled item</a></li>                       
                          <li><a href="#">Jeans</a></li>
                          <li><a href="#">Polo T-Shirts</a></li>
                          <li><a href="#">SKirts</a></li>
                          <li><a href="#">Jackets</a></li>
                          <li><a href="#">Tops</a></li>
                          <li><a href="#">Make Up</a></li>
                          <li><a href="#">Hair Care</a></li>
                          <li><a href="#">Perfumes</a></li>
                          <li><a href="#">Skin Care</a></li>
                          <li><a href="#">Hand Bags</a></li>
                          <li><a href="#">Single Bags</a></li>
                          <li><a href="#">Travel Bags</a></li>
                          <li><a href="#">Wallets & Belts</a></li>                        
                          <li><a href="#">Sunglases</a></li>
                          <li><a href="#">Nail</a></li>                       
                        </ul>
                      </li>                   
                    </ul>
                  </li>
                </ul> -->
              </li>
              <li><a href="#">Q&A</a>
                <!-- <ul class="dropdown-menu">                
                  <li><a href="#">Casual</a></li>
                  <li><a href="#">Sports</a></li>
                  <li><a href="#">Formal</a></li>
                  <li><a href="#">Standard</a></li>                                                
                  <li><a href="#">T-Shirts</a></li>
                  <li><a href="#">Shirts</a></li>
                  <li><a href="#">Jeans</a></li>
                  <li><a href="#">Trousers</a></li>
                  <li><a href="#">And more.. <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Sleep Wear</a></li>
                      <li><a href="#">Sandals</a></li>
                      <li><a href="#">Loafers</a></li>                                      
                    </ul>
                  </li>
                </ul> -->
              </li>
              <!-- <li><a href="#">Sports</a></li>
             <li><a href="#">Digital <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="#">Camera</a></li>
                  <li><a href="#">Mobile</a></li>
                  <li><a href="#">Tablet</a></li>
                  <li><a href="#">Laptop</a></li>                                                
                  <li><a href="#">Accesories</a></li>                
                </ul>
              </li>
              <li><a href="#">Furniture</a></li>            
              <li><a href="blog-archive.html">Blog <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="blog-archive.html">Blog Style 1</a></li>
                  <li><a href="blog-archive-2.html">Blog Style 2</a></li>
                  <li><a href="blog-single.html">Blog Single</a></li>                
                </ul>
              </li>
              <li><a href="contact.html">Contact</a></li>
              <li><a href="#">Pages <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="product.html">Shop Page</a></li>
                  <li><a href="product-detail.html">Shop Single</a></li>                
                  <li><a href="404.html">404 Page</a></li>                 -->
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>       
    </div>
  </section>
  <!-- / menu -->  
 
  <!-- catg header banner section -->
  <!-- <section id="aa-catg-head-banner">
   <img src="img/fashion/fashion-header-bg-8.jpg" alt="fashion img">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Cart Page</h2>
        <ol class="breadcrumb">
          <li><a href="index.html">Home</a></li>                   
          <li class="active">Cart</li>
        </ol>
      </div>
     </div>
   </div>
  </section> -->
  <!-- / catg header banner section -->

 <!-- Cart view section -->
 <section id="cart-view">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="cart-view-area">
           <div class="cart-view-table">
             <form action="">
               <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                          <th></th>
                        <th>商品圖片</th>
                        <th>商品名稱</th>
                        <th>租金</th>
                        <th>預計租借日</th>
                        <th>預計歸還日</th>
                        <th>總計</th>
                      </tr>
                    </thead>
                    <tbody>
                    <% int tatol=0;
                       int index=0;
                    for(String item : cart) {
                    	
                    CartVO cartVO1 = gson.fromJson(item, CartVO.class);%>
                      <tr>
                      	<input type="hidden" value="<%=cartVO1.getProdID() %>">
                      	<input type="hidden" value=<%=index++ %>>
                        <td><a class="remove" ><fa class="fa fa-close"></fa></a></td>
                        <td><a ><img src="<%=request.getContextPath()%>/ProdServlet?action=detail&no=1&prodID=<%=cartVO1.getProdID()%>" alt="img"></a></td>
                        <td><a class="aa-cart-title" href="#"><%=cartVO1.getProdName() %></a></td>
                        <td><%=cartVO1.getRent() %></td>
                        <td><%=cartVO1.getEstStart()%></td>
                         <td><%=cartVO1.getEstEnd()%></td>
                        <!--                         <td><input class="aa-cart-quantity" type="number" value="1"></td> -->
                        <td><%=cartVO1.getTatolPrice()%></td>
                       
                      </tr>
                         <%
                         tatol +=cartVO1.getTatolPrice();
                    } 
                         
                         %>
                     
                      <tr>
                        <td colspan="6" class="aa-cart-view-bottom">
                          <div class="aa-cart-coupon">
                            <input class="aa-coupon-code" type="text" placeholder="請輸入折扣碼">
                            <input class="aa-cart-view-btn" type="submit" value="使用折扣碼">
                          </div>
                          <input class="aa-cart-view-btn" type="submit" value="更新購物車">
                        </td>
                      </tr>
                      </tbody>
                  </table>
                </div>
             </form>
             <!-- Cart Total view -->
             <div class="cart-view-total">
               <h4>購物車結帳金額</h4>
               <table class="aa-totals-table">
                 <tbody>
                   <tr>
                     <th>小計</th>
                     <td>$<%=tatol %></td>
                   </tr>
                   <tr>
                     <th>總計</th>
                     <td>$<%=tatol %></td>
                   </tr>
                 </tbody>
               </table>
               <a href="#" class="aa-cart-view-btn">購物車結帳</a>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- / Cart view section -->


  <!-- Subscribe section -->
  <!-- <section id="aa-subscribe">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-subscribe-area">
            <h3>Subscribe our newsletter </h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ex, velit!</p>
            <form action="" class="aa-subscribe-form">
              <input type="email" name="" id="" placeholder="Enter your Email">
              <input type="submit" value="Subscribe">
            </form>
          </div>
        </div>
      </div>
    </div>
  </section> -->
  <!-- / Subscribe section -->

  <!-- footer -->  
  <footer id="aa-footer">
    <!-- footer bottom -->
    <div class="aa-footer-top">
     <div class="container">
        <div class="row">
        <div class="col-md-12">
          <div class="aa-footer-top-area">
            <div class="row">
              <div class="col-md-3 col-sm-6">
                <div class="aa-footer-widget">
                  <h3>全部分類</h3>
                  <ul class="aa-footer-nav">
                    <li><a href="#">Nintendo</a></li>
                    <li><a href="#">PlayStation</a></li>
                    <li><a href="#">XBOX</a></li>
                    <li><a href="#">其他遊戲主機</a></li>                                                
                    <li><a href="#">電腦遊戲</a></li>
                    <li><a href="#">桌遊</a></li>
                    <li><a href="#">拼圖</a></li>
                    <li><a href="#">其他</a></li>
                  </ul>
                </div>
              </div>
              <div class="col-md-3 col-sm-6">
                <div class="aa-footer-widget">
                  <div class="aa-footer-widget">
                    <h3>關於我們</h3>
                    <ul class="aa-footer-nav">
                      <li><a href="#">網站理念</a></li>
                      <li><a href="#">團隊介紹</a></li>
                      <!-- <li><a href="#">Services</a></li>
                      <li><a href="#">Discount</a></li>
                      <li><a href="#">Special Offer</a></li> -->
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-md-3 col-sm-6">
                <div class="aa-footer-widget">
                  <div class="aa-footer-widget">
                    <h3>使用須知</h3>
                    <ul class="aa-footer-nav">
                      <li><a href="#">服務條款</a></li>
                      <!-- <li><a href="#">Search</a></li>
                      <li><a href="#">Advanced Search</a></li>
                      <li><a href="#">Suppliers</a></li>
                      <li><a href="#">FAQ</a></li> -->
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-md-3 col-sm-6">
                <div class="aa-footer-widget">
                  <div class="aa-footer-widget">
                    <h3>聯絡我們</h3>
                    <address>
                      <p> 104台北市中山區南京東路三段219號5樓</p>
                      <p><span class="fa fa-phone"></span>02-2712-0589</p>
                      <p><span class="fa fa-envelope"></span>JoyLease@gmail.com</p>
                    </address>
                    <div class="aa-footer-social">
                      <a href="#"><span class="fa fa-facebook"></span></a>
                      <a href="#"><span class="fa fa-twitter"></span></a>
                      <a href="#"><span class="fa fa-google-plus"></span></a>
                      <a href="#"><span class="fa fa-youtube"></span></a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
     </div>
    </div>
     <!-- footer-bottom -->
     <div class="aa-footer-bottom">
      <div class="container">
        <div class="row">
        <div class="col-md-12">
          <div class="aa-footer-bottom-area">
            <!-- <p>Designed by <a href="http://www.markups.io/">MarkUps.io</a></p> -->
            <div class="aa-footer-payment">
              <span class="fa fa-cc-mastercard"></span>
              <span class="fa fa-cc-visa"></span>
              <span class="fa fa-paypal"></span>
              <span class="fa fa-cc-discover"></span>
            </div>
          </div>
        </div>
      </div>
      </div>
    </div>
  </footer>
  <!-- / footer -->

  <!-- Login Modal -->  
  <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">                      
        <div class="modal-body">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4>登入/註冊</h4>
          <form class="aa-login-form" action="">
            <label for="">請輸入Email<span>*</span></label>
            <input type="text" placeholder="Username or email">
            <label for="">密碼<span>*</span></label>
            <input type="password" placeholder="Password">
            <button class="aa-browse-btn" type="submit">登入</button>
            <label for="rememberme" class="rememberme"><input type="checkbox" id="rememberme"> 記住我的帳號 </label>
            <p class="aa-lost-password"><a href="#">忘記密碼？</a></p>
            <div class="aa-register-now">
              還不是JoyLease的會員嗎？<a href="account copy.html">馬上註冊！</a>
            </div>
          </form>
        </div>                        
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div>    

  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.js"></script>  
  <!-- SmartMenus jQuery plugin -->
  <script type="text/javascript" src="js/jquery.smartmenus.js"></script>
  <!-- SmartMenus jQuery Bootstrap Addon -->
  <script type="text/javascript" src="js/jquery.smartmenus.bootstrap.js"></script>  
  <!-- To Slider JS -->
  <script src="js/sequence.js"></script>
<!--   <script src="js/sequence-theme.modern-slide-in.js"></script>   -->
  <!-- Product view slider -->
  <script type="text/javascript" src="js/jquery.simpleGallery.js"></script>
  <script type="text/javascript" src="js/jquery.simpleLens.js"></script>
  <!-- slick slider -->
  <script type="text/javascript" src="js/slick.js"></script>
  <!-- Price picker slider -->
  <script type="text/javascript" src="js/nouislider.js"></script>
  <!-- Custom js -->
  <script src="js/custom.js"></script> 


<script>
$("a.remove").click(function(){
    
	  let r = confirm("確認移除？");
  
  var that = this;

  var prodid = $(that).closest("tr").find("input").eq(0).val();
  var index1 = $(that).closest("tr").find("input").eq(1).val();
	  if (r){
    // that.closest("tr").remove();
  		
	    $.ajax({
	      url: "<%=request.getContextPath()%>/ProdServlet",           // 資料請求的網址
	      type: "POST",                
	      data: {
	    	  prodID: prodid,
	    	  action: "delete",
	    	  index :index1
	      },                  // 傳送資料到指定的 url
	      beforeSend: function(){       // 在 request 發送之前執行
	      }  
	    	  ,success: function(data){ 
        console.log(data);
        $(that).closest("tr").animate({
          "opacity": 0
        }, 1000, "swing", function(){
          $(this).remove();

        });


      }
      

    });
    }

  });
</script>
 <%jedis.close(); %>
  </body>
 
</html>