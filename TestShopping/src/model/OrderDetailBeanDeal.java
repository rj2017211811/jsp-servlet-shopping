package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailBeanDeal {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private Statement st = null;
	private ResultSet rs = null;
	//显示订单详细信息
	public List<OrderDetailBean> searchOrderDetailById(int id)throws Exception
	{
		
		List<OrderDetailBean> orderList=new ArrayList<OrderDetailBean>();
		String sql="select * from ordersdetail where ordersId="+id;
		conn=DBtool.getConnection();
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next())
		{
			int ordersId=rs.getInt(2);
			System.out.println("ordersId:"+ordersId);
			int goodsId=rs.getInt(3);
			String goodsName=rs.getString(4);
			//goodsName=new String(goodsName.getBytes("iso-8859-1"), "utf-8");
	
			System.out.println("goodsName:"+goodsName);
			int goodsNum=rs.getInt(6);
			float goodsPrice=rs.getFloat(5);
			OrderDetailBean orderDetailBean=new OrderDetailBean(ordersId,goodsId,goodsName,goodsPrice,goodsNum);
			orderList.add(orderDetailBean);
		}
		
		DBtool.closeResource(conn, pst, pst, rs);
		
		return orderList;
		
	}
	


}