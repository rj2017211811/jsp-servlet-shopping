<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body{background-image }
</style>
<script type="text/javascript">
</script>
</head>
<body background="img/bg.jpg">
    <%
	%>
	<table width="80%" border="1" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="94" colspan="2"  align="center">
			<jsp:include page="head.jsp" flush="true"></jsp:include>
			</td>
		</tr>
		<tr>

			<td width="20%" height="385" align="center"><jsp:include page="left.jsp" flush="true"></jsp:include></td>
			<td width="80%" align="center">
			<jsp:include page="right.jsp" flush="true"></jsp:include>
			</td>

		</tr>
		<tr>
			<td height="62" colspan="2"  align="center">
			<jsp:include page="tail.jsp" flush="true"></jsp:include>
			</td>
		</tr>
	</table>

</body>
</html>
