
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"
	import="model.*"%>
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

	function add() {
		var count = document.getElementById("count");
		var inc = document.getElementById("inc");
		var dec = document.getElementById("dec");
		count.value = parseInt(count.value) + 1;
	}
	function del() {
		var count = document.getElementById("count");
		var inc = document.getElementById("inc");
		var dec = document.getElementById("dec");
		if (count.value > 0)
			count.value = parseInt(count.value) - 1;

	}
	-->
</script>
</head>
<body background="img/bg.jpg">
	<%
	//获取session
			String username = (String) session.getAttribute("username");
			if (username != null) {

				//out.println(0);

				//request.getRequestDispatcher("GoodsDealServlet?pageNow=1&flag=dividePage").forward(request, response);
			} else {

				Cookie[] cookies = request.getCookies();

				if (cookies != null) {
					int i = 0;
					for (i = 0; i < cookies.length; i++) {
						Cookie cookie = cookies[i];

						if (cookie.getName().equals("username")) {
							username = cookie.getValue();

							break;

						}

					}
					if (i == cookies.length) {
						//out.println(2);
						//out.println("cookie失效");
						//response.sendRedirect("/mywebsite/website/login.jsp");
						out.println("<script>alert('您的登录已失效!');</script>");
					}

				} else {
					//无cookie
					// out.println(3);
					//response.sendRedirect("/mywebsite/website/login.jsp");
					out.println("<script>alert('您还未登录,快去登录吧!');</script>");
				}

			}
	   
		
		MyCartBo mycartBo = (MyCartBo) request.getSession().getAttribute("mycart");
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

		goodsList = (List<GoodsBean>) request.getAttribute("goodsList");
		float price = 0;
		if (goodsList != null) {

			for (int i = 0; i < goodsList.size(); i++) {
				int num =0;
				String strNum=mycartBo.getGoodsNumById(goodsList.get(i).getGoodsId());
				if(strNum!=null)
				{
					num=Integer.parseInt(strNum);
				}
				
				price += goodsList.get(i).getGoodsPrice() * num;
			}

		}
	//	out.println(price);
	
	%>
	<table width="80%" border="1" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="94" colspan="2" align="center"><jsp:include
					page="head.jsp" flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td>
				<table border="1" height="300px" width="100%" align="center"
					width="80%">
					<tr align="center" height="50px">
						<td colspan="7"><b>购物流程 </b>&nbsp;&nbsp; <font color="blue">查看购物车</font>
							->填写购物信息->订单完成</td>

					</tr>
					<tr align="center">
						<td width="13%">id</td>
						<td width="20%">名称</td>

						<td width="10%">数量</td>
						<td width="13%">修改数量</td>
						<td width="13%">价格</td>
						<td width="13%">删除</td>
						<td width="13%">查看</td>


					</tr>
					<%
						for (int i = 0; i < goodsList.size(); i++) {
					%>

					<tr height="40px" align="center">
						<form action="MyCartBoServlet">
						<td><%=goodsList.get(i).getGoodsId()%></td>
						<td><%=goodsList.get(i).getGoodsName()%></td>
						<td><input id="dec" type="button" value="-" class="dec"
							onclick="del()"> <input id="count" type="text"
							value=<%=mycartBo.getGoodsNumById(goodsList.get(i).getGoodsId())%>
							size="1" style="text-align: center;" name="newNum" class="count">
							<input id="inc" type="button" value="+" onclick="add()" class="inc">
							<input type="hidden" name="goodsId"
							value="<%=goodsList.get(i).getGoodsId()%>" /> <input
							type="hidden" name="flag" value="modify" /></td>
						<td><button type="submit">修改数量</button></td>
						</form>
						<td><%=goodsList.get(i).getGoodsPrice()%></td>

						<td><button
								onclick="window.location='MyCartBoServlet?flag=remove&goodsId=<%=goodsList.get(i).getGoodsId()%>'">
								删除</a></td>
						<td><button
								onclick="window.location='GoodsDealServlet?flag=showDetail&goodsName=<%=goodsList.get(i).getGoodsName()%>'">
								查看</a></td>

					</tr>
					<%
						}
					%>


					<tr height="40px" align="center">

						<td width="25%" colspan="7"><button
								onclick="window.location='MyCartBoServlet?flag=removeAll'">删除所有商品</button></td>


					</tr>
					<tr height="35px" align="center">
						<td colspan="7"></td>
					</tr>
					<tr height="35px">
						<td colspan="7">您已选择了价值￥<%=price%>的商品,点<a
							href="GoodsDealServlet?pageNow=1&flag=dividePage">此处</a>继续购物。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button align="right" onclick="window.location='UserDealServlet?username=<%=username%>&price=<%=price%>'">下一步</button></td>

					</tr>

				</table>
				
			</td>

		</tr>


		<tr>
			<td height="62" colspan="2" align="center"><jsp:include
					page="tail.jsp" flush="true"></jsp:include></td>
		</tr>
	</table>

</body>
</html>
