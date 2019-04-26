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
<title>BuyItemList画面</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>BuyItemList</p>
		</div>
		<div>
			<s:iterator value="buyItemList">
			<s:form action="BuyItemListAction">
				<table class="product">
					<tr>
						<td><span>商品名</span></td>
						<td>
							<s:property value="itemName"/><br>
						</td>
					</tr>
					<tr>
						<td><span>値段</span></td>
						<td>
							<s:property value="itemPrice"/>
							<span>円</span>
						</td>
					</tr>
					<tr>
						<td><s:submit value="購入"/></td>
					</tr>
				</table>
						<input type="hidden" name="itemId" value='<s:property value="id"/>'>
						<input type="hidden" name="itemName" value='<s:property value="itemName"/>'>
						<input type="hidden" name="itemPrice" value='<s:property value="itemPrice"/>'>
				<%-- <s:property value="#status.index"/> --%>
			</s:form>
			</s:iterator>
			<br/>
			<div id="text-link">
				<p>前画面に戻る場合は
					<a href='<s:url action="GoHomeAction"/>'>こちら</a>
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