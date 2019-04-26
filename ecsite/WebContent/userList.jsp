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
<title>UserList画面</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>
		<div>
			<s:if test="userList.size==0">
				<h3>ユーザー登録情報はありません。</h3>
			</s:if>
			<s:else>
				<h3>ユーザー登録情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>管理者権限</th>
						<th>ログインID</th>
						<th>パスワード</th>
						<th>ユーザー名</th>
					</tr>
					<s:iterator value="userList">
					<tr>
						<td><s:property value="AdminFlg"/></td>
						<td><s:property value="LoginId"/></td>
						<td><s:property value="LoginPassword"/></td>
						<td><s:property value="UserName"/></td>
					</tr>
					</s:iterator>
				</table>
				<s:form action="UserListDeleteConfirmAction">
					<s:submit value="削除"/>
				</s:form>
			</s:else>

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