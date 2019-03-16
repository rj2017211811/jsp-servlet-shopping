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
	
	function gotoRegister() {
		window.open("register.jsp","_self");

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
		<tr align="center">
			<td>

				<h1>注册成功!</h1>
				<a href="login.jsp">去登录</a>



			</td>

		</tr>
		<tr>
			<td height="62" colspan="2" align="center"><jsp:include
					page="tail.jsp" flush="true"></jsp:include></td>
		</tr>
	</table>

</body>
</html>
