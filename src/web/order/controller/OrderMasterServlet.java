package web.order.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.member.model.DefAddressVO;
import web.member.model.MemberVO;
import web.order.model.OrderMasterDAOImpl;
import web.order.model.OrderMasterService;
import web.order.model.OrderMasterVO;
import web.product.model.BookingDAO;
import web.product.model.BookingVO;
import web.product.model.ProdDAO;
import web.product.model.ProdVO;


@WebServlet("/OrderMasterServlet")
public class OrderMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
//		String path = req.getRequestURI();
//		System.out.println(path);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String str = req.getParameter("ordID");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J���u�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/select_page.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				Integer ordID = null;

				try {
					ordID = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/select_page.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}
				/*************************** 2.�}�l�d�߸�� *****************************************/
//				OrderMasterService omSVC = new OrderMasterService();
//				OrderMasterVO omVO = omSVC.getOneOrderMaster(ordID);

				OrderMasterDAOImpl omdao = new OrderMasterDAOImpl();
				OrderMasterVO omVO = omdao.findOrderMasterByPK(ordID);

				if (omVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/select_page.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
				req.setAttribute("OrderMasterVO", omVO); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/orderMaster/listOneOrderMaster.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllOrderMaster.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				Integer ordID = new Integer(req.getParameter("ordID"));

				/*************************** 2.�}�l�d�߸�� ****************************************/
				OrderMasterService omSVC = new OrderMasterService();
				OrderMasterVO omVO = omSVC.getOneOrderMaster(ordID);

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
				req.setAttribute("OrderMasterVO", omVO); // ��Ʈw���X��omVO����,�s�Jreq
				String url = "/orderMaster/updateOrderMasterInput.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_emp_input.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/updateOrderMasterInput.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // �Ӧ�updateOrderMasterInput.jsp���ШD
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				Integer ordID = new Integer(req.getParameter("ordID").trim());

				Integer shipStatus = new Integer(req.getParameter("shipStatus").trim());

				if (shipStatus == 0) {
					req.setAttribute("shipStatus", "�ݥX�f");
				} else {
					req.setAttribute("shipStatus", "�w�X�f");
				}

				Integer ordStatus = new Integer(req.getParameter("payStatus").trim());
				Integer payStatus = new Integer(req.getParameter("ordStatus").trim());
				String shipCode = req.getParameter("shipCode").trim();
				if (shipCode == null || shipCode.trim().length() == 0) {
					errorMsgs.add("�X�f�N�X�ФŪť�");
				}

				String returnCode = req.getParameter("returnCode").trim();

				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String strsd = req.getParameter("shipDate");
				long lsd = sdf.parse(strsd).getTime();
				Timestamp shipDate = new Timestamp(lsd);

				String strad = req.getParameter("arrivalDate");
				long lad = sdf.parse(strad).getTime();
				Timestamp arrivalDate = new Timestamp(lad);

				String strrd = req.getParameter("returnDate");
				long lrd = sdf.parse(strrd).getTime();
				Timestamp returnDate = new Timestamp(lrd);

				Integer rentRank = new Integer(req.getParameter("rentRank").trim());
				Integer leaseRank = new Integer(req.getParameter("leaseRank").trim());
				String rentComt = req.getParameter("rentComt").trim();
				String leaseComt = req.getParameter("leaseComt").trim();

				Date date = new Date();

				long strrc = (date.getTime());
				Timestamp rentComtdate = new Timestamp(strrc);
				System.out.println(rentComtdate);

				long strlc = (date.getTime());
				Timestamp leaseComtdate = new Timestamp(strlc);
				System.out.println(leaseComtdate);

				OrderMasterVO omVO = new OrderMasterVO();
				omVO.setOrdID(ordID);
				omVO.setShipStatus(shipStatus);
				omVO.setOrdStatus(ordStatus);
				omVO.setPayStatus(payStatus);
				omVO.setShipCode(shipCode);
				omVO.setReturnCode(returnCode);
				omVO.setShipDate(shipDate);
				omVO.setArrivalDate(arrivalDate);
				omVO.setReturnDate(returnDate);
				omVO.setRentRank(rentRank);
				omVO.setLeaseRank(leaseRank);
				omVO.setRentComt(rentComt);
				omVO.setLeaseComt(leaseComt);
				omVO.setRentComtdate(rentComtdate);
				omVO.setLeaseComtdate(leaseComtdate);

				System.out.println(omVO);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("OrderMasterVO", omVO); // �t����J�榡���~��omVO����,�]�s�Jreq

					System.out.println("���F��?????????????");

					RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/updateOrderMasterInput.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}
				/*************************** 2.�}�l�ק��� *****************************************/

				OrderMasterDAOImpl omdao = new OrderMasterDAOImpl();
				omdao.updateOrderMaster(omVO);

				/***************************
				 * NEW�ק�᪺VO
				 *****************************************/
				OrderMasterVO omVO1 = omdao.findOrderMasterByPK(ordID);

				/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
				req.setAttribute("OrderMasterVO", omVO1); // ��Ʈwupdate���\��,���T����ordermasterVO����,�s�Jreq
				String url = "/orderMaster/listOneOrderMaster.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneOrderMaster.jsp
				successView.forward(req, res);
				System.out.println("����");
				System.out.println(omVO);
				System.out.println(omVO1);
				return;

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				System.out.println("����");
				errorMsgs.add("�ק��ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/updateOrderMasterInput.jsp");
				failureView.forward(req, res);
			}
		}

		if ("submit_order".equals(action)) { // �Ӧ�addOrderMaster.jsp���ШD
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String prodName = req.getParameter("prodName");
				
				Date date = new Date();
				long ord = date.getTime();
				Timestamp ordDate = new Timestamp(ord);
				System.out.println(ordDate);
				
				String strES = req.getParameter("estStart");
				java.sql.Date estStart = java.sql.Date.valueOf(strES);
				
				String strEE = req.getParameter("estEnd");
				java.sql.Date estEnd = java.sql.Date.valueOf(strEE);
				
				String name = req.getParameter("name");
				
				String phoneNum = req.getParameter("phoneNum");
				
				String recipient = req.getParameter("recipient");
				
				
				/*************�s�JVO**************/
				ProdVO prodVO = new ProdVO();
				OrderMasterVO omVO = new OrderMasterVO();
				MemberVO memVO = new MemberVO();
				
				
				prodVO.setProdName(prodName);
				omVO.setOrdDate(ordDate);
				omVO.setEstStart(estStart);
				omVO.setEstEnd(estEnd);
				memVO.setName(name);
				memVO.setPhoneNum(phoneNum);
				
			
				
				
				ProdDAO proddao = new ProdDAO();
				OrderMasterDAOImpl omdao = new OrderMasterDAOImpl();
				proddao.add(prodVO);
				omdao.addOrderMaster(omVO);
				
			} catch (Exception e) {

			}
		}

	}

}
