package model;
public class OrderDetailBean{
	
	private int  ordersId;
	private  int goodsId;
	private String goodsName;
	private int goodsNum;
	private float goodsPrice;
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public OrderDetailBean(int ordersId, int goodsId, String goodsName, float goodsPrice,int goodsNum) {
		super();
		this.ordersId = ordersId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsNum = goodsNum;
		this.goodsPrice = goodsPrice;
	}
	public OrderDetailBean( int goodsId, String goodsName, float goodsPrice,int goodsNum) {
		super();
	
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsNum = goodsNum;
		this.goodsPrice = goodsPrice;
	}
	
	
	
	
	
	
}