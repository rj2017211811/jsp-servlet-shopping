<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"
	import="model.*"%>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	
}
</style>
</head>
<%
    String []goods={"未上架","未上架","未上架","未上架","未上架","未上架"};
    
	int pageNow = 1;
	int pageSize = 6;
	int pageCount = 1;
	String strPageCount = (String) request.getAttribute("pageCount");
	//out.println(strPageCount);
	

	if (strPageCount != null) {
		pageCount = Integer.parseInt(strPageCount);
	}
	String strPageNow=request.getParameter("pageNow");
	if (strPageNow != null) {
		pageNow = Integer.parseInt(strPageNow);
	}
	List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
	goodsList = (List<GoodsBean>) request.getAttribute("goodsList");
	for (int i = 0; i < goodsList.size(); i++) {

		//out.println(goodsList.get(i).getGoodsName());
		goods[i]=goodsList.get(i).getGoodsName();
	}
	

%>
<body background="img/bg.jpg">
	<table width="100%" border="1" align="center" cellpadding="0"
		cellspacing="0">
		<tr height="50px">
			<td colspan="3" bgcolor="#FFC431">最新商品推荐</td>
		</tr>
		<tr height="30px">
			<td colspan="3" style="color: #FFC431;">RECOMMEND NEW</td>
		</tr>

		<tr height="120px">
			<td width="33%"><a href="GoodsDealServlet?flag=showDetail&goodsName=<%=goods[0]%>"><%=goods[0]%></a></td>
			<td width="33%"><a href="GoodsDealServlet?flag=showDetail&goodsName=<%=goods[1]%>"><%=goods[1]%></a></td>
			<td width="33%"><a href="GoodsDealServlet?flag=showDetail&goodsName=<%=goods[2]%>" ><%=goods[2] %></a></td>
			<td>
		</tr>
		<tr height="30px">
			<td colspan="3"></td>
		</tr>
		<tr height="120px">
			<td><a href="GoodsDealServlet?flag=showDetail&goodsName=<%=goods[3]%>"><%=goods[3] %></a></td>
			<td><a href="GoodsDealServlet?flag=showDetail&goodsName=<%=goods[4]%>"><%=goods[4] %></a></td>
			<td><a href="GoodsDealServlet?flag=showDetail&goodsName=<%=goods[5]%>"><%=goods[5] %></a></td>
			<td>
		</tr>
		<tr height="50px" align="center">
			<td colspan="3">
			<% 
					  
						    
						    for(int i=1;i<=pageCount;i++)
						    {
						    	if(pageNow!=i)
						    	
						    	    out.println("<a href=GoodsDealServlet?pageNow="+i+"&flag=dividePage>"+"【"+i+"】"+"</a>");
						    	else
						    	{
						    		out.println("【"+i+"】");
						    	}
						    }
						  
						
						%>
			
			</td>
		</tr>


	</table>

</body>
</html>
