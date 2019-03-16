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
		window.open("register.jsp", "_self");

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

			request.getRequestDispatcher("GoodsDealServlet?pageNow=1&flag=dividePage").forward(request, response);
		} else {

			Cookie[] cookies = request.getCookies();

			if (cookies != null) {
				int i = 0;
				for (i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];

					if (cookie.getName().equals("username")) {
						String value = cookie.getValue();

						request.getRequestDispatcher("GoodsDealServlet?pageNow=1&flag=dividePage").forward(request,
								response);
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
	%>
	<table width="80%" border="1" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="94" colspan="2" align="center"><jsp:include
					page="head.jsp" flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td>

				<fieldset>
					<legend align="center">用户登录</legend>
					<center>
						<form action="LoginDealServlet?flag=login" method="post">

							用户名<input type="text" name="username" /> <br>
							密码&nbsp;&nbsp;&nbsp;<input type="password" name="password" /><br>
							<input type="checkbox" name="keep">是否要保存cookie<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;没有账号?<input type="button" value="注册"
								onclick="gotoRegister()" /> <br> <input type="submit"
								value="登录" />&nbsp;&nbsp;&nbsp;
						</form>
					</center>
				</fieldset>

			</td>

		</tr>
		<tr>
			<td height="62" colspan="2" align="center"><jsp:include
					page="tail.jsp" flush="true"></jsp:include></td>
		</tr>
	</table>

</body>
</html>
