
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"
	import="model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	
}
</style>
<script type="text/javascript">
<!--
	function returnHall() {
		window.open("GoodsDealServlet?pageNow=1&flag=dividePage", "_self");
	}
	-->
</script>
</head>
<body background="img/bg.jpg">
	<%
		
		MyCartBo mycartBo = (MyCartBo) request.getSession().getAttribute("mycart");
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
		goodsList = mycartBo.displayCartBo();
		String strPrice=request.getParameter("price");
		float price=0;
		if(strPrice!=null)
		{
			price=Float.parseFloat(strPrice);
		}
		
		
	%>
	<table width="80%" border="1" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="94" colspan="2" align="center"><jsp:include
					page="head.jsp" flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td><br>
				<p align="center">

					<b>购物流程 </b>&nbsp;&nbsp;查看购物车 -> <font color="blue">填写购物信息</font>->订单完成
				</p>
				<form action="/TestShopping/OrderInfoDealServlet?price=<%=price %>" method="post">


				<table align="center" border="1px" cellspacing="0" cellpadding="0"
					width="300px">
					<tr align="center">
						<td colspan="2">个人信息</td>
					</tr>



					<tr>
						<th>用户名</th>
						<td><input type="text" name="username"
							value="${userList.get(0).getUsername() }" /></td>
					</tr>

					<tr>
						<th>真实姓名</th>
						<td><input type="text" name="truename"
							value="${userList.get(0).getTruename() }" /></td>
					</tr>

					<tr>
						<th>家庭地址</th>
						<td><input type="text" name="address"
							value="${userList.get(0).getAddress() }" /></td>
					</tr>
					<tr>
						<th>联系电话</th>
						<td><input type="text" name="phone" maxlength="11"
							minlength="6" value="${userList.get(0).getPhone() }" /></td>
					</tr>
					<tr>
						<th>邮箱</th>
						<td><input type="text" name="email"
							value="${userList.get(0).getEmail() }" /></td>
					</tr>
					<tr>
						<th>邮政编码</th>
						<td><input type="text" name="postcode" maxlength="6"
							minlength="6" value="${ userList.get(0).getPostcode() }" /></td>
					</tr>
					<tr align="center">
					
						<td colspan="2"><button>修改信息</button> 
						
						<%
									for (int i = 0; i < goodsList.size(); i++) {
								%>
						<input type="hidden" name="goodsId" value="<%=goodsList.get(i).getGoodsId()%>">
						<input type="hidden" name="goodsName" value="<%=goodsList.get(i).getGoodsName()%>">
						<input type="hidden" name="goodsPrice" value="<%=goodsList.get(i).getGoodsPrice()%>">
						<input type="hidden" name="goodsNum" value="<%=mycartBo.getGoodsNumById(goodsList.get(i).getGoodsId())%>">
						
						
						<%
					
									}
								%>
							<input type="hidden" name="goodsList" value="<%=goodsList%>">
						<input type="submit" value="完成订单" /></td>

					</tr>
					</table>
					</form>
					


					
					<tr align="center">
						<td colspan="2">订单信息</td>
					</tr>
					<tr align="center">
						<td colspan="2">
							<table border="1" cellpadding="0" cellspacing="0" align="center"
								width="270px">
								<tr>
									<td>id</td>
									<td>名称</td>
									<td>价格</td>
									<td>数量</td>
								</tr>
								
								<%
									for (int i = 0; i < goodsList.size(); i++) {
								%>
								<tr>
									<td><%=goodsList.get(i).getGoodsId()%></td>
									<td><%=goodsList.get(i).getGoodsName()%></td>
									<td><%=goodsList.get(i).getGoodsPrice()%></td>
									<td><%=mycartBo.getGoodsNumById(goodsList.get(i).getGoodsId())%></td>
								</tr>
								<%
									}
								%>
								<tr><td colspan="4">总价为<%=price %>元</td></tr>


							</table>

						</td>

					</tr>
					<tr align="center">
						<td colspan="2"><button
								onclick="window.location='MyCartBoServlet?flag=display'">返回更改购物车</button>
								</td>

					</tr>
					

				
				
				</td>

		</tr>


		<tr>
			<td height="62" colspan="2" align="center"><jsp:include
					page="tail.jsp" flush="true"></jsp:include></td>
		</tr>
	</table>

</body>
</html>
