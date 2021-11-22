package web.product.controller;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import web.order.model.OrderListDAOImpl;
import web.order.model.OrderListVO;
import web.order.model.OrderMasterDAOImpl;
import web.order.model.OrderMasterVO;
import web.product.model.BookingDAO;
import web.product.model.BookingService;
import web.product.model.BookingVO;
import web.product.model.CartVO;
import web.product.model.ProdCategoryDAO;
import web.product.model.ProdDAO;
import web.product.model.ProdService;
import web.product.model.ProdVO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

@MultipartConfig()
public class ProdServlet extends HttpServlet {
	Timer timer;

	public void destroy() {
		timer.cancel();
	}

	public void init() {
		timer = new Timer();
//	        Calendar cal = new GregorianCalendar(2021, Calendar.MARCH, 0, 0, 0, 0);  

		TimerTask task = new TimerTask() {

			public void run() {
				
				
				BookingDAO bkDao = new BookingDAO();
				List<BookingVO> list = bkDao.getAll();
				//�b�{�b�ɶ��j���k�ٮɶ����T�ѫ�(�w�Įɶ�) �N��w�k��
				for (BookingVO bk : list) {
					if ((bk.getEstEnd().getTime() + 24*60*60*1000) < new Date().getTime()) {
						bk.setStatus(2);
						bkDao.update(bk);

					}
				}

				System.out.println("����ק窱�A�ɶ� = " + new Date(scheduledExecutionTime()));
			}
		};

		timer.scheduleAtFixedRate(task, 1000, 30 * 1000);
		
		
		
		
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		ProdDAO prodDao = new ProdDAO();
		BookingDAO bkDao = new BookingDAO();
		Gson gson = new Gson();
////////////////////////�إ߰ӫ~/////////////////////////////
	
		if ("upload".equals(req.getParameter("action"))) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			ProdVO prod = new ProdVO();
			System.out.println(ServletFileUpload.isMultipartContent(req));

			// �����ШD�Ѽ� ���~�榡�P�_
			String name = req.getParameter("product_name");
//			System.out.println(name.trim().length() == 0);
			if (name == null || (name.trim().length() == 0)) {
				errorMsgs.add("�ӫ~�W�٤��ର��");
				System.out.println("yes");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher(req.getContextPath() + "/product_view/ModifyProdPage.jsp");
				failureView.forward(req, res);
				return;

			}

			int rent = Integer.parseInt(req.getParameter("product_rent"));
			int price = Integer.parseInt(req.getParameter("product_price"));
			String cot = req.getParameter("product_cot");
			String comt = req.getParameter("comt");
			int cate = Integer.parseInt(req.getParameter("categorySelect"));

			Collection<Part> filePart = req.getParts();
			int i = 1;
			for (Part part : filePart) {

				if (part.getContentType() != null) {
					if (part.getContentType().contains("image")) {
						InputStream in = part.getInputStream();
//					byte[] b = new byte[in.available()];
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						byte[] buff = new byte[1024];
						int len;
						while ((len = in.read(buff)) != -1) {
							out.write(buff, 0, len);
						}
						// out�g�X������A������s��byte[]
						byte[] pic = out.toByteArray();

						switch (i) {
						case 1:
							// �s�JVO
							prod.setPic1(pic);
							break;
						case 2:
							prod.setPic2(pic);
							break;
						case 3:
							prod.setPic3(pic);
							break;
						}
						System.out.println(part.getContentType());
						i++;
						if (i > 3)
							break;

					} else if (!part.getContentType().contains("image")) {
						res.getWriter().print("<script language='javascript'>alert('�ФW�ǹϤ��榡')</script>");
						res.getWriter().print("<script>history.go(-1);</script>");

					}

				}

			}
			ProdService prodService = new ProdService();
			ProdDAO dao = new ProdDAO();
			// �I�sservice �s�Jdb

			// ���o�̷s�[�J�� �]�N�O���n�W�[��
			prodService.AddProd(cate, name, cot, rent, price, comt, prod.getPic1(), prod.getPic2(), prod.getPic3(),
					prod.getShelfDate());
			req.removeAttribute("prodID"); // �R���¦���

			req.getSession().setAttribute("prodID", dao.getLastKey());

			res.sendRedirect(req.getContextPath() + "/product_view/showUpdload.jsp");
//			req.getRequestDispatcher("/product_view/showUpdload.jsp").forward(req, res);
			return;

		}

		//////////////////////// �i�J�ӫ~�ӹ�/////////////////////////////

		if ("detail".equals(req.getParameter("action"))) {
			int prodID =0; 
			if(req.getParameter("picNo")!=null)
				prodID = Integer.parseInt(req.getParameter("picNo"));
			else if(req.getParameter("prodID")!=null) {
				prodID = Integer.parseInt(req.getParameter("prodID"));
			}
			ProdVO prod = prodDao.findProductByPK(prodID);

			OutputStream os = res.getOutputStream();
			byte[] pic1 = prod.getPic1();
			byte[] pic2 = prod.getPic2();
			byte[] pic3 = prod.getPic3();

			String no = req.getParameter("no");
			if (no != null) {
				switch (no) {
				case "1":
					if (pic1 != null)
						os.write(pic1);
					break;
				case "2":
					if (pic2 != null)
						os.write(pic2);
					break;
				case "3":
					if (pic3 != null)
						os.write(pic3);
					break;
				}

			}

		}

////////////////////////�s��ӫ~/////////////////////////////

		if ("update".equals(req.getParameter("action"))) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			// �ӫ~�W������
			String name = req.getParameter("product_name");

			if (name == null || (name.trim().length() == 0)) {
				errorMsgs.add("�ӫ~�W�٤��ର��");

			}

			// �ӫ~��������
			int rent = 0;
			try {
				rent = Integer.parseInt(req.getParameter("product_rent"));

			} catch (Exception e) {
				errorMsgs.add("�����Ь��Ʀr");
			}
			if (rent <= 0) {
				errorMsgs.add("�����Фj��0��");
			}

			// �ӫ~�l�a������
			int price = 0;
			try {
				price = Integer.parseInt(req.getParameter("product_price"));
			} catch (Exception e) {
				errorMsgs.add("�ӫ~�l�a���Ь��Ʀr");
			}

			if (price <= 0) {
				errorMsgs.add("�ӫ~�l�a���Фj��0��");
			}
			
			String cot = req.getParameter("product_cot");

			if (cot == null || (cot.trim().length() == 0)) {
				errorMsgs.add("�ӫ~���e���ର��");

			}

			String comt = req.getParameter("comt");
			int cate = Integer.parseInt(req.getParameter("categorySelect"));

			long date = System.currentTimeMillis();
			Timestamp shelfTime = null;

			ProdVO prodVO =  new ProdVO();
			prodVO.setProdName(name);
			prodVO.setProdRent(rent);
			prodVO.setProdPrice(price);
			prodVO.setProdCot(cot);
			prodVO.setCategoryID(cate);
			prodVO.setComt(comt);
			prodVO.setProdID(Integer.valueOf(req.getParameter("prodID")));
			int status = 0;
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("proVO", prodVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/product_view/ModifyProdPage.jsp");
				failureView.forward(req, res);
				return;

			}

			// ���o�n��s���ӫ~ID
			int prodID = Integer.parseInt(req.getParameter("prodID"));
			//���\�W�[�� �����W�[���
			if ("shelf".equals(req.getParameter("status"))) {
				status = 1;
				shelfTime = new Timestamp(date);
			} else if ("complete".equals(req.getParameter("status"))) {
				status = 0;
				shelfTime = null; // �U�[ �M�ŤW�[���
			}

			ProdVO prod = prodDao.findProductByPK(prodID);
			
			
			//�}�l��s���
			ProdService prodService = new ProdService();
			prodService.updateProd(prodID, cate, name, cot, rent, price, comt, prod.getPic1(), prod.getPic2(),
					prod.getPic3(), shelfTime, status);	

		}
		
			//////////////�[�J�ʪ���/////////////////////////////
			if("cart".equals(req.getParameter("action"))) {
				System.out.println("�I���ʪ���");

				Integer prodID = Integer.valueOf(req.getParameter("prodID"));
				String estStart = req.getParameter("startDate");
				String estEnd = req.getParameter("endDate");
				String prodName = req.getParameter("prodName");
				Integer rent = Integer.valueOf(req.getParameter("rent"));
				Integer tatolPrice = Integer.valueOf(req.getParameter("tatolPrice"));
//				Integer status = 0;
				java.sql.Date sdate = null;
				java.sql.Date edate =null;
				Integer memberID = (Integer)req.getSession().getAttribute("id");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					sdate = new java.sql.Date(df.parse(estStart).getTime());
					edate = new java.sql.Date(df.parse(estEnd).getTime());
				} catch (ParseException e) {
					System.out.println("����榡���~");
				}
				CartVO cartVO = new CartVO();
//				BookingVO bk = new BookingVO();
				cartVO.setProdID(prodID);
//				bk.setStatus(status);
				cartVO.setEstStart(sdate);
				cartVO.setEstEnd(edate);
				cartVO.setProdName(prodName);
				cartVO.setRent(rent);
				cartVO.setTatolPrice(tatolPrice);
				
			
				JedisPool pool = JedisPoolUtil.getJedisPool();
				Jedis jedis = null;
				jedis = pool.getResource();
				
				
				String jsonString = gson.toJson(cartVO);
			
//				jedis.set("prod"+req.getParameter("prodID"),jsonString);
				List<String> cart = jedis.lrange("member"+memberID, 0, jedis.llen("member"+memberID));
				boolean flag = true;
				for(String item : cart) {
					CartVO cartVO1 = gson.fromJson(item, CartVO.class);
					if(prodID == cartVO1.getProdID()) {
						flag = false;
						res.getWriter().print("<script language='javascript'>alert('�ӫ~���ơA�нT�{�ʪ���');</script>");
						System.out.println("���ưӫ~");
					
					}
				}
				
				if(flag) {
					jedis.rpush("member"+memberID,jsonString);
					System.out.println("�ʪ����[�J�F: "+jsonString);

				}
								
			
				
				jedis.close(); 
				
			
				
				
			}
			
			if("delete".equals(req.getParameter("action"))) {
				System.out.println("�I��R��");
				Integer memberID = (Integer)req.getSession().getAttribute("id");
				Integer prodID = Integer.valueOf(req.getParameter("prodID"));
				
				JedisPool pool = JedisPoolUtil.getJedisPool();
				Jedis jedis = null;
				jedis = pool.getResource();
				
				
				
				//����I�쪺prodID ���� ��Ʈw�̭���prod �N�R��
				List<String> cart = jedis.lrange("member"+memberID, 0, jedis.llen("member"+memberID));
				for(String item : cart) {
					CartVO cartVO1 = gson.fromJson(item, CartVO.class);
					if(cartVO1.getProdID()==prodID) {
						jedis.lrem("member"+memberID, 1, item);
					}
				}
				
				jedis.close();
			}
			
			
			
			/////////////���b////////////////////
			if("checkout".equals(req.getParameter("action"))) {
				System.out.println("�I�쵲�b");
				
				
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
				Integer prodID= Integer.valueOf(req.getParameter("prodID"));
				
				String startDate = req.getParameter("startDate");
				String endDate =  req.getParameter("endDate");
				System.out.println(startDate);
				System.out.println(endDate);
				System.out.println("---------");
				java.sql.Date sdate = null;
				java.sql.Date edate = null;
				BookingVO bk = new BookingVO();
				//����ť�����
				if(startDate.trim().length()==0) {
					errorMsgs.add("�п�J�}�l���ɤ��");
				}
				
				if(endDate.trim().length()==0) {
					errorMsgs.add("�п�J�������ɤ��");
				}
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					//������~�榡����
					sdate = new java.sql.Date(df.parse(startDate).getTime());
					edate = new java.sql.Date(df.parse(endDate).getTime());
				} catch (Exception e) {
					
					errorMsgs.add("����榡��yyyy-MM-DD");
				}
				
			
				System.out.println(prodID);
				System.out.println(sdate);
				System.out.println(endDate);
				
				
				BookingService bkService = new BookingService();
				bk.setProdID(prodID);
				
				
				
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("bk",bk);
					RequestDispatcher failureView = req.getRequestDispatcher("/product_view/productDetail.jsp");
					failureView.forward(req, res);
					return;

				}
				//��Ʀs�J�w����Ʈw
				bkService.addBk(prodID, 1, sdate, edate);
			}

	}
	



}
