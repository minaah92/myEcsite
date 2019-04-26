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
<title>Admin画面</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>Admin</p>
		</div>
		<div id="text-center">
			<table>
			<tr>
				<td>商品</td>
				<td>ユーザー</td>
			</tr>
			<tr>
				<td>
					<s:form action="ItemCreateAction">
						<s:submit value="新規登録"/>
					</s:form>
				</td>
				<td>
					<s:form action="UserCreateAction">
						<s:submit value="新規登録"/>
					</s:form>
				</td>
			</tr>
			<tr>
				<td>
					<s:form action="ItemListAction">
						<s:submit value="一覧"/>
					</s:form>
				</td>
				<td>
					<s:form action="UserListAction">
						<s:submit value="一覧"/>
					</s:form>
				</td>
			</tr>
			</table>


				<p>ログアウトする場合は
				<a href='<s:url action="LogoutAction"/>'>こちら</a>
				</p>

		</div>
	</div>
	<footer>
		<div id="pr">
		</div>
	</footer>
</body>
</html>