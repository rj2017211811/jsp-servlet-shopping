package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

public class OrderInfoBeanDeal {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	//产生订单信息
	public List<OrderInfoBean> produceOrderInfo(OrderInfoBean orderInfo)throws Exception
	{
	
		List<OrderInfoBean> ordersList=new ArrayList<OrderInfoBean>();
		String sql="insert into orderInfo(username,truename,email,phone,address,postcode,grade,orderDate,totalPrice) values(?,?,?,?,?,?,?,?,?)";
		conn=DBtool.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setString(1, orderInfo.getUsername());
		pst.setString(2, orderInfo.getTruename());
		pst.setString(3,orderInfo.getEmail());
		pst.setString(4, orderInfo.getPhone());
		pst.setString(5, orderInfo.getAddress());
		pst.setString(6, orderInfo.getPostcode());
		pst.setInt(7, orderInfo.getGrade());
		java.sql.Date sqlDate=new java.sql.Date(new java.util.Date().getTime());
		pst.setDate(8,sqlDate);
		pst.setFloat(9, orderInfo.getTotalPrice());
		int result=pst.executeUpdate();
		if(result==1)
		{
			
			sql="select * from orderInfo order by ordersId DESC limit 1";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			int ordersId=0;
			if(rs.next())
			{
				 ordersId=rs.getInt(1);
				String username=rs.getString(3);
				String truename=rs.getString(4);
				String email=rs.getString(6);
				String phone=rs.getString(7);
				String address=rs.getString(8);
				String postcode=rs.getString(9);
				int grade=rs.getInt(10);
				java.sql.Date  date=rs.getDate(11);
			    Float prices=rs.getFloat(14);
			    OrderInfoBean orderInfoBean=new OrderInfoBean(ordersId,username,truename,email,phone,address,postcode,grade,date,prices);
			    ordersList.add(orderInfoBean);
			    
			}
		
			
			
		}
		DBtool.closeResource(conn, pst, pst, rs);
		return ordersList;
		
	}
    
	
}
