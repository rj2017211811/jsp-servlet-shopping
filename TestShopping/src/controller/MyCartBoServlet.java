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

import model.GoodsBean;
import model.GoodsBeanDeal;
import model.MyCartBo;

/**
 * Servlet implementation class MyCartBoServlet
 */
@WebServlet("/MyCartBoServlet")
public class MyCartBoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCartBoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		String flag=(String)request.getParameter("flag");
		if(flag.equals("add"))
		{
			String goodsName=request.getParameter("goodsName");
			//goodsName=GoodsDealServlet.getNewString(goodsName);
			pw.println(goodsName);
			List<GoodsBean> goodsList=new ArrayList<GoodsBean>();
			GoodsBeanDeal g=new GoodsBeanDeal();
			try {
				goodsList=g.showDetailGoodsInfo(new GoodsBean(goodsName));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int id=goodsList.get(0).getGoodsId();
			
			MyCartBo cartBo=(MyCartBo) request.getSession().getAttribute("mycart");
			if(cartBo==null)
			{
				
				cartBo=new MyCartBo();
		
				 request.getSession().setAttribute("mycart", cartBo);
				
			}
			
			cartBo.addGoods(id+"", 1+"");
			
			try {
				goodsList=cartBo.displayCartBo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("goodsList", goodsList);
			request.setAttribute(id+"",1+"" );
			

			request.getRequestDispatcher("viewShopCar.jsp").forward(request, response);
		
		}
		else if(flag.equals("removeAll"))
		{
			MyCartBo cartBo=(MyCartBo)request.getSession().getAttribute("mycart");
			if(cartBo!=null)
			{
				request.getSession().removeAttribute("mycart");
				
			}
			
			request.getRequestDispatcher("viewShopCar.jsp").forward(request, response);
		}
		else if(flag.equals("remove"))
		{
			MyCartBo cartBo=(MyCartBo)request.getSession().getAttribute("mycart");
			String goodsId=request.getParameter("goodsId");
			cartBo.removeGoods(goodsId);
			if(cartBo!=null)
			{
				List<GoodsBean> goodsList=new ArrayList<GoodsBean>();
				try {
					goodsList=cartBo.displayCartBo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 request.setAttribute("goodsList", goodsList);
			}
			
			request.getRequestDispatcher("viewShopCar.jsp").forward(request, response);
		}else if(flag.equals("display"))
		{
			MyCartBo cartBo=(MyCartBo)request.getSession().getAttribute("mycart");
			
			if(cartBo!=null)
			{
				List<GoodsBean> goodsList=new ArrayList<GoodsBean>();
				try {
					goodsList=cartBo.displayCartBo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 request.setAttribute("goodsList", goodsList);
			}
			
			request.getRequestDispatcher("viewShopCar.jsp").forward(request, response);
			
		}
		else if(flag.equals("modify"))
		{
		
			String goodsId=request.getParameter("goodsId");
			String goodsNum=request.getParameter("newNum");
			pw.println(goodsId);
			pw.println(goodsNum);
			MyCartBo cartBo=(MyCartBo)request.getSession().getAttribute("mycart");
			List<GoodsBean> goodsList=new ArrayList<GoodsBean>();
			cartBo.modifyGoods(goodsId, goodsNum);
			if(cartBo!=null)
			{
				
				try {
					goodsList=cartBo.displayCartBo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 request.setAttribute("goodsList", goodsList);
			}
			 request.setAttribute("goodsList", goodsList);
			//	request.setAttribute(goodsId,goodsNum );
			 
			 request.getRequestDispatcher("viewShopCar.jsp").forward(request, response);
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
