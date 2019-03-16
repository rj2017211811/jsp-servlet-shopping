
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" import="model.*" %>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	
}
</style>
<script type="text/javascript">
<!--
    function returnHall()
    {
	    window.open("index.jsp","_self");
    }

-->

</script>
</head>
<body background="img/bg.jpg">

	<table width="80%" border="1" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="94" colspan="2" align="center"><jsp:include
					page="head.jsp" flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="1" align="center" cellpadding="0"
					cellspacing="0" height="350px">
					<tr>
						<td rowspan="8"></td>
					</tr>
					<tr>
						<td colspan="2">名称 ${goodsList.get(0).getGoodsName() }</td>
					</tr>
					<tr>
						<td colspan="2">价格:￥${goodsList.get(0).getGoodsPrice() }</td>
					</tr>
					<tr>
						<td colspan="2">ISBN:${goodsList.get(0).getNum()  } </td>
					</tr>
					<tr>
						<td colspan="2">类型:${goodsList.get(0).getType() } </td>
					</tr>
					<tr>
						<td colspan="2">出版社:${goodsList.get(0).getPublisher() } </td>
					</tr>
					<tr>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td colspan="2">这是一部好片</td>
					</tr>
					<tr align="center" height="30px">
						<td>
							<button onclick="window.location='MyCartBoServlet?flag=add&goodsName=${goodsList.get(0).getGoodsName() }'">购买</</button>
						</td>
						<td><button onclick="returnHall()">返回大厅</</button></td>
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
