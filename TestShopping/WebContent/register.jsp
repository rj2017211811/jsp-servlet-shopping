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
	function validateForm() {
		var username = Form.username.value;
		var password=Form.password.value;
		var password2=Form.password2.value;
		var truename=Form.truename.value;
		var email=Form.email.value;
		var phone=Form.phone.value;
		var address=Form.address.value;
		var postcode=Form.postcode.value;
        if ((username = null || username == "")||(password==null||password=="")||
        		(password2==null||password2=="")||(truename==null||truename=="")||
        		(email==null||email=="")||(phone==null||phone=="")||(address==null||address=="")||(postcode==null||postcode=="")) {
			alert('请输入完整信息!');
			return false;
		}
		else if(password!=password2)
		{
			alert('两次密码不一致!');
			return false;
			
		}
		
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




				<form action="RegisterDealServlet" method="post"
					onsubmit=" return validateForm()" id="Form">
					<table align="center" border="1px" cellspacing="0" cellpadding="0">

						<caption>用户注册</caption>

						<tr>
							<th>用户名</th>
							<td><input type="text" name="username" /></td>
						</tr>
						<tr>
							<th>密码</th>
							<td><input type="password" name="password" /></td>
						</tr>
						<tr>
							<th>重复密码</th>
							<td><input type="password" name="password2" /></td>
						</tr>
						<tr>
							<th>姓名</th>
							<td><input type="text" name="truename" /></td>
						</tr>
						<tr>
							<th>邮箱</th>
							<td><input type="text" name="email" /></td>
						</tr>
						<tr>
							<th>电话号码</th>
							<td><input type="text" name="phone" maxlength="11"
								minlength="6" /></td>
						</tr>

						<tr>
							<th>家庭地址</th>
							<td><input type="text" name="address" /></td>
						</tr>
						<tr>
							<th>邮政编码</th>
							<td><input type="text" name="postcode" maxlength="6"
								minlength="6" placeholder="请输入6位邮政编码"/></td>
						</tr>
						<tr align="center">
							<td colspan="2"><input type="reset" value="重置" /> <input
								type="submit" value="注册" /></td>

						</tr>
					</table>



				</form>
			</td>

		</tr>
		<tr>
			<td height="62" colspan="2" align="center"><jsp:include
					page="tail.jsp" flush="true"></jsp:include></td>
		</tr>
	</table>

</body>
</html>
