package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodsBeanDeal {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private Statement st = null;
	private ResultSet rs = null;
    //显示货物详细信息
	public List<GoodsBean> showDetailGoodsInfo(GoodsBean g) throws Exception {
		conn = DBtool.getConnection();
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
		String sql = "select * from goods where goodsName='" + g.getGoodsName() + "'";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while (rs.next()) {
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
		DBtool.closeResource(conn, pst, pst, rs);
		return goodsList;
	}
    //获取货物的页数
	public int getPageCount(int pageSize) throws Exception {
		int pageCount = 0;
		conn = DBtool.getConnection();
		String sql = "select count(*) from goods";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		if (rs.next()) {
			int rowCount = rs.getInt(1);
			if (rowCount % pageSize == 0) {
				pageCount = rowCount / pageSize;
			} else {
				pageCount = (rowCount / pageSize) + 1;
			}
		}
		DBtool.closeResource(conn, pst, pst, rs);
		return pageCount;
	}
    //获取本页的货物
	public List<GoodsBean> getPageNowGoods(int pageNow, int pageSize) throws Exception {
		int rowCount = 0;// 共有多少记录(查表)
		int pageCount = 0;// 共有几页(计算)
		conn = DBtool.getConnection();
		pst = conn.prepareStatement("select count(*)  from goods");
		rs = pst.executeQuery();
		if (rs.next()) {
			rowCount = rs.getInt(1);

		}
		// 计算pageCount
		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;
		} else {
			pageCount = (rowCount / pageSize) + 1;
		}
		pst = conn.prepareStatement("select  * from goods  limit ?,?");
		pst.setInt(2, pageSize);
		pst.setInt(1, pageSize * (pageNow - 1));

		rs = pst.executeQuery();
		List<GoodsBean> user = new ArrayList<GoodsBean>();
		while (rs.next()) {

			
			String username = rs.getString(2);
			
			GoodsBean u = new GoodsBean( username);
			user.add(u);
		}
		DBtool.closeResource(conn, pst, pst, rs);
		return user;

	}
    
}
