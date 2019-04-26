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
<title>Cart</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>Cart</p>
		</div>
		<div>
			<s:if test="cartList==null">
				<h3>カートに入っている商品はありません。</h3>
			</s:if>
			<s:elseif test="message==null">
				<h3><s:property value="session.login_user_name"/>さんのカートの中身は以下になります。</h3>
				<s:form action="BuyItemAction">
				<table border="1">
					<tr>
						<th>checkbox</th>
						<th>商品名</th>
						<th>個数</th>
						<th>合計金額</th>
						<!-- <th></th> -->
					<!-- 	<th>支払い方法</th> -->
					<!-- 	<th></th> -->
					</tr>
					<s:iterator value="cartList" status="status">
					<tr>
						<td><input type="checkbox" name="checkbox" value="<s:property value='#status.index'/>">
							<s:property value="#status.index"/>
						</td>
						<s:property value="<s:property value='#status.index'/>"/>
						<td><s:property value="itemName"/></td>
						<td><s:property value="totalCount"/><span>個</span></td>
						<td><s:property value="totalPrice"/><span>円</span></td>
						<%-- <td>
							<input type="hidden" name="itemName" value='<s:property value="itemName"/>'>
							<input type="hidden" name="totalCount" value='<s:property value="totalCount"/>'>
							<input type="hidden" name="totalPrice" value='<s:property value="totalPrice"/>'>
							<input type="submit" value="購入">
						</td> --%>
						<%-- <td><s:property value="payment"/></td> --%>
						<%-- <td><s:property value="insert_date"/></td> --%>
					</tr>
					</s:iterator>
				</table>
					<div>
						<s:submit value="購入"/>
					</div>
				</s:form>
					<%-- <s:submit value="購入"/> --%>
				<s:form action="CartAction">
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit value="削除" method="delete"/>
				</s:form>
			</s:elseif>
			<s:if test="message!=null">
				<h3><s:property value="message"/></h3>
			</s:if>
			<div id="text-right">
				<p>お買い物を続ける場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<footer>
		<div id="pr">
		</div>
	</footer>

</body>
</html>