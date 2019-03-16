package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GoodsBean;
import model.GoodsBeanDeal;
import model.MyCartBo;

/**
 * Servlet implementation class ShowGoodsDealServlet
 */
@WebServlet("/ShowGoodsDealServlet")
public class GoodsDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * 
	 * 
	 *      /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public static String getNewString(String input) {
		String result = "";
		try {
			result = new String(input.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		String flag = request.getParameter("flag");

		// String goodsName=(String)request.getParameter("goodsName");
		// pw.println(goodsName);
		if (flag.equals("showDetail")) {
			request.setCharacterEncoding("UTF-8");

			String goodsName = (String) request.getParameter("goodsName");
			//goodsName = this.getNewString(goodsName);
			// String goodsName="ºÚ°×É­ÁÖ";
			pw.println(goodsName);

			pw.println(2);
			GoodsBeanDeal goodsDeal = new GoodsBeanDeal();
			List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
			try {
				pw.println(2);
				goodsList = goodsDeal.showDetailGoodsInfo(new GoodsBean(goodsName));
				if (goodsList.isEmpty()) {
					pw.println(3);
				} else {
					pw.println(4);
				}
				request.setAttribute("goodsList", goodsList);
				pw.println(goodsList);

				request.getRequestDispatcher("showDetail.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (flag.equals("dividePage")) {

			try {
				String strPageNow = request.getParameter("pageNow");
				int pageNow = 1;
				if (strPageNow != null) {
					pageNow = Integer.parseInt(strPageNow);
				}
				GoodsBeanDeal goodsDeal = new GoodsBeanDeal();
				int pageCount = goodsDeal.getPageCount(6);
				List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
				goodsList = goodsDeal.getPageNowGoods(pageNow, 6);
				request.setAttribute("pageCount", pageCount + "");
				request.setAttribute("goodsList", goodsList);
				request.getRequestDispatcher("mainPage.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
