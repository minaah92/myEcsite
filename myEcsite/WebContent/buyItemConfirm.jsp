<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url);
		$('form').submit();
	}
</script>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>購入確認</title>
</head>
<body>
	<header>
		<div class="logo">
		<img src="./img/icon.png">
		</div>
		<ul>
			<li><a href='<s:url action="GoHomeAction"/>'>Home</a></li>
			<li><a href='<s:url action="HomeAction"/>'>Login</a></li>
			<li><a href='<s:url action="LogoutAction"/>'>Logout</a></li>
		</ul>
	</header>
	<div class="main">
		<h1>購入確認</h1>

		<s:form action="BuyItemConfirmAction">
		<table>
			<tr>
				<td class="left"><span>商品名</span></td>
				<td class="right">
					<s:property value="session.buyItem_name"/>
				</td>
			</tr>
			<tr>
				<td class="left"><span>値段</span></td>
				<td class="right">
					<s:property value="session.total_price"/>
					<span>円</span>
				</td>
			</tr>
			<tr>
				<td class="left"><span>購入個数</span></td>
				<td class="right">
					<s:property value="session.count"/>
					<span>個</span>
				</td>
			</tr>
			<tr>
				<td class="left"><span>支払い方法</span></td>
				<td class="right">
					<s:property value="session.pay"/>
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><input type="button" value="戻る" onclick="submitAction('HomeAction')" class="submit"/></td>
				<td><input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')" class="submit"/></td>
			</tr>
		</table>
		</s:form>
	</div>
	<footer>
		<p class="copy">&copy; iwamoto internous</p>
	</footer>

</body>
</html>