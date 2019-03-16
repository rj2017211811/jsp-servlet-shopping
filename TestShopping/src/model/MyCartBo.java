package model;

import java.sql.*;
import java.util.*;


public class MyCartBo{
	//��ϣ���ϴ洢�����id��num
	private HashMap<String,String> hm=new HashMap<String,String>();
	
	public String getGoodsNumById(int goodsId)
	{
		return (String)hm.get(goodsId+"");
		
	}
	//��ӻ���
	public void addGoods(String goodsId,String goodsNum)
	{
		hm.put(goodsId,goodsNum);
	}
	//ɾ������
	public void removeGoods(String goodsId) {
		hm.remove(goodsId);
	}
	
	//�޸Ļ�������
	public void  modifyGoods(String goodsId,String goodsNum) {
		hm.put(goodsId,goodsNum);
	}
	//��ջ���
	public void clear() {
		hm.clear();
	}
	//��ʾ���ﳵ
	public List<GoodsBean> displayCartBo()throws Exception
	{
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
		Connection conn=DBtool.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql1="select * from goods where goodsId in";
		String sql2="(";
	    Iterator<String> it=hm.keySet().iterator();
	    while(it.hasNext())
	    {
	    	String goodsId=(String)it.next();
	    	if(!it.hasNext())
	    	{
	    		sql2+=goodsId+")";
	    	}
	    	else
	    	{
	    		sql2+=goodsId+",";
	    		
	    	}
	    }
	
	    String sql=sql1+sql2;
	    pst=conn.prepareStatement(sql);
	    rs=pst.executeQuery();
	    while(rs.next())
	    {
	    	int goodsId = rs.getInt(1);
			String goodsName = rs.getString(2);
			String goodsInfo = rs.getString(3);
			float goodsPrice = rs.getFloat(4);
			int goodsNum = rs.getInt(5);
			String publisher = rs.getString(6);
			String type = rs.getString(8);
			GoodsBean g1 = new GoodsBean(goodsId, goodsName, goodsInfo, goodsPrice, goodsNum, publisher, type);
			goodsList.add(g1);
	    	
	    	
	    }
		return goodsList;
	}

	
}