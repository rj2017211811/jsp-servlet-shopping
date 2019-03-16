<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>



<head>
<meta charset="utf-8">
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
	function add1() {
		var count = document.getElementsByClassName("count");
		var inc = document.getElementsByClassName("inc");
		var dec = document.getElementsByClassName("dec");
		count[0].innerHTML = parseInt(count[0].innerHTML) + 1;

	}
	function del1() {
		var count = document.getElementsByClassName("count");
		var inc = document.getElementsByClassName("inc");
		var dec = document.getElementsByClassName("dec");
		if (count[0].innerHTML > 0)
			count[0].innerHTML = parseInt(count[0].innerHTML) - 1;

	}
	function add2() {
		var x = document.getElementsByTagName("input");
		var a=Number(x[1].value);
	
	    x[1].value=a+1;
		

	}
	function del2() {
		var x = document.getElementsByTagName("input");
		var a=Number(x[1].value);
		if(a>0)
	
	    x[1].value=a-1;

	}

	-->
</script>
</head>
<body >
	<input id="dec" type="button" value="-" class="dec" onclick="del2()">
	<input id="count" type="text" value="1" size="1"
		style="text-align: center;" name="newNum" class="count">
	<input id="inc" type="button" value="+" onclick="add2()" class="inc">
	
	<p>12333</p>


</body>
</html>