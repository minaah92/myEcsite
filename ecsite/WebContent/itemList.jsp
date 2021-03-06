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
<title>ItemList画面</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>ItemList</p>
		</div>
		<div>
			<s:if test="itemList.size==0">
				<h3>商品登録情報はありません。</h3>
			</s:if>
			<s:else>
				<h3>商品登録情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>登録個数</th>
					</tr>
					<s:iterator value="itemList">
					<tr>
						<td><s:property value="itemName"/></td>
						<td><s:property value="itemPrice"/><span>円</span></td>
						<td><s:property value="itemStock"/><span>個</span></td>
					</tr>
					</s:iterator>
				</table>
				<s:form action="ItemListDeleteConfirmAction">
<!-- 					<input type="hidden" name="deleteFlg" value="1"> -->
					<s:submit value="削除"/>
				</s:form>
			</s:else>
<%-- 			<s:if test="message!=null"> --%>
<%-- 				<h3><s:property value="message"/></h3> --%>
<%-- 			</s:if> --%>
			<div id="text-right">
				<p>管理者画面へ戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
<%-- 				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p> --%>
			</div>
		</div>
	</div>
	<footer>
		<div id="pr">
		</div>
	</footer>

</body>
</html>