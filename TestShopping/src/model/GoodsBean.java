package model;
public class GoodsBean{
	private int goodsId;
	private String goodsName;
	private String goodsInfo;
	private float goodsPrice;
	private int num;
	private String publisher;
	private String type;
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
	public String getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public GoodsBean(int goodsId, String goodsName, String goodsInfo, float goodsPrice, int num, String publisher,
			String type) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsInfo = goodsInfo;
		this.goodsPrice = goodsPrice;
		this.num = num;
		this.publisher = publisher;
		this.type = type;
	}
	public GoodsBean(String goodsName)
	{
		super();
		this.goodsName=goodsName;
	}
	
	
	
	
}