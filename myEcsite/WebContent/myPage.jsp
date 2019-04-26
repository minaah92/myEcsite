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
<title>MyPage</title>
</head>
<body>
	<header>
		<div class="logo">
		<img src="./img/icon.png">
		</div>
		<ul>
			<li><a href='<s:url action="GoHomeAction"/>'>Home</a></li>
			<li><a href='<s:url action="MyPageAction"/>'>MyPage</a></li>
			<li><a href='<s:url action="HomeAction"/>'>Login</a></li>
			<li><a href='<s:url action="LogoutAction"/>'>Login</a></li>
		</ul>
	</header>
	<div class="main">
		<h3><s:property value="#session.userName"/>さんの購入履歴</h3>

		<s:if test="myPageList==null">
			<p>ご購入情報はありません。</p>
		</s:if>
		<s:elseif test="message==null">
			<p>ご購入情報は以下になります。</p>
			<table>
				<tr>
					<th>商品名</th>
					<th>値段</th>
					<th>購入個数</th>
					<th>支払い方法</th>
					<th>購入日</th>
				</tr>
				<s:iterator value="myPageList">
				<tr>
					<td><s:property value="itemName"/></td>
					<td><s:property value="totalPrice"/><span></span></td>
					<td><s:property value="totalCount"/><span></span></td>
					<td><s:property value="payment"/></td>
					<td><s:property value="insert_date"/></td>
				</tr>
				</s:iterator>
			</table>
			<s:form>
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" method="delete"/>
			</s:form>
		</s:elseif>
		<s:if test="message!=null">
			<h3><s:property value="message"/></h3>
		</s:if>
	</div>
	<footer>
		<p class="copy">&copy; iwamoto internous</p>
	</footer>

</body>
</html>