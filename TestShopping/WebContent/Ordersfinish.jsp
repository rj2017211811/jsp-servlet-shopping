
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"
	import="model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
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
	
	<table width="80%" border="1" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="94" colspan="2" align="center"><jsp:include
					page="head.jsp" flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td>
				<table align="center" cellspacing="0" cellpadding="0" border="1">
					<tr>
						<td>订单号</td>
						<td>收货人</td>
						<td>收货地址</td>
						<td>邮编</td>
						<td>联系电话</td>
						<td>总价</td>
						<td>用户名</td>
						<td>邮箱</td>
					
					</tr>
					<c:forEach items="${ordersList }" var="order">
					<tr>
						<td>${order.getOrdersId()}</td>
						<td>${order.getTruename()}</td>
						<td>${order.getAddress()}</td>
						<td>${order.getPostcode()}</td>
						<td>${order.getPhone()}</td>
						<td>${order.getTotalPrice()}</td>
						<td>${order.getUsername()}</td>
						<td>${order.getEmail()}</td>
					</tr>	
					</c:forEach>
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
