<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>BuyItem画面</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
	<%-- 		<s:iterator value="buyItemList"> --%>
			<s:form action="CartAction">
				<table class="product">
					<tr>
						<td><span>商品名</span></td>
						<td>
							<s:property value="session.buyItem_name"/><br>
						</td>
					</tr>
					<tr>
						<td><span>値段</span></td>
						<td>
							<s:property value="session.buyItem_price"/>
							<span>円</span>
						</td>
					</tr>
					<tr>
						<td><span>購入個数</span></td>
						<td>
							<select name="count">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</td>
					</tr>
				<%-- 	<tr>
						<td><span>支払い方法</span></td>
						<td>
							<input type="radio" name="pay" value="1" checked="checked">現金払い
							<input type="radio" name="pay" value="2">クレジットカード
						</td>
					</tr> --%>
					<tr>
						<td><s:submit value="カートに入れる"/></td>
					</tr>
				</table>
				<%-- <s:property value="#status.index"/> --%>
			</s:form>
		<%-- 	</s:iterator> --%>
			<br/>
			<div id="text-link">
				<p>前画面に戻る場合は
					<a href='<s:url action="LoginAction"/>'>こちら</a>
				</p>
				<p>マイページは
					<a href='<s:url action="MyPageAction"/>'>こちら</a>
				</p>
			</div>
		</div>
	</div>
	<footer>
		<div id="pr">
		</div>
	</footer>

</body>
</html>