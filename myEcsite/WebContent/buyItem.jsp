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
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Home</title>
</head>
<body>
	<header>
		<div class="logo">
		<img src="./img/icon.png">
		</div>
		<ul>
			<li><a href="home.jsp">Home</a></li>
			<li><a href="myPage.jsp">MyPage</a></li>
			<li><a href="login.jsp">Login</a></li>
			<li>Logout</li>
		</ul>
	</header>
	<div class="main">
		<h1>購入</h1>

		<s:form action="BuyItemAction">
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
					<s:property value="session.buyItem_price"/>
					<span>円</span>
				</td>
			</tr>
			<tr>
				<td class="left"><span>購入個数</span></td>
				<td class="right">
					<select name="count">
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="left"><span>支払い方法</span></td>
				<td class="right">
					<input type="radio" name="pay" value="1" checked="checked">現金払い
					<br>
					<input type="radio" name="pay" value="2">クレジットカード
					<br>
					<input type="radio" name="pay" value="3">代引き
				</td>
			</tr>
			<tr>
				<td><s:submit value="購入" class="submit"/></td>
			</tr>
		</table>
		</s:form>
	</div>
	<footer>
		<p class="copy">&copy; iwamoto internous</p>
	</footer>

</body>
</html>