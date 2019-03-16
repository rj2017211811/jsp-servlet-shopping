package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.OrderDetailBean;
import model.OrderDetailBeanDeal;
import model.OrderInfoBean;
import model.OrderInfoBeanDeal;
import model.UserBean;

/**
 * Servlet implementation class OrderDealServlet
 */
@WebServlet("/OrderDealServlet")
public class OrderInfoDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderInfoDealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=null;
		try {
			pw = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pw.println(1);
		String username=request.getParameter("username");
		pw.println(username);
		String truename=request.getParameter("truename");
		pw.println(truename);
		String address=request.getParameter("address");
		pw.println(address);
		String phone=request.getParameter("phone");
		pw.println(phone);
		String email=request.getParameter("email");
		pw.println(email);
		String postcode=request.getParameter("postcode");
		pw.println(postcode);
		String strPrice=request.getParameter("price");
		pw.println(strPrice);
		
		float totalprice=0;
		if(strPrice!=null)
		{
			totalprice=Float.parseFloat(strPrice);
		}
		
		pw.println(totalprice);
		
		java.sql.Date sqlDate=new java.sql.Date(new java.util.Date().getTime());
		OrderInfoBean orderInfoBean=new OrderInfoBean(username,truename,email,phone,address,postcode,5,sqlDate,totalprice);
		
		
		OrderInfoBeanDeal orderDeal=new OrderInfoBeanDeal();
		
		try {
			
			
			List<OrderInfoBean> ordersList=new ArrayList<OrderInfoBean>();
			ordersList=orderDeal.produceOrderInfo(orderInfoBean);
			
			if(!ordersList.isEmpty())
			{
				
				
				
				
				request.setAttribute("ordersList", ordersList);
				
				//request.setAttribute("", o);
				//request.setCharacterEncoding("utf-8");
				request.getRequestDispatcher("Ordersfinish.jsp").forward(request, response);
				//pw.println("success");
				
			}
			else
			{
				request.getRequestDispatcher("Ordersfailed.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
