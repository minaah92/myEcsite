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
<title>新規ユーザー登録 確認</title>
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
		<p>登録する内容は以下でよろしいですか。</p>

		<s:form action="UserCreateCompleteAction">
		<table>
			<tr>
				<td class="left">ID:</td>
				<td class="right"><s:property value="loginUserId" escape="false"/></td>
			</tr>
			<tr>
				<td class="left">パスワード:</td>
				<td class="right"><s:property value="loginPassword" escape="false"/></td>
			</tr>
			<tr>
				<td class="left">ユーザー名:</td>
				<td class="right"><s:property value="userName" escape="false"/></td>
			</tr>
		</table>
			<s:submit value="完了" class="submit"/>
		</s:form>
	</div>
	<footer>
		<p class="copy">&copy; iwamoto internous</p>
	</footer>

</body>
</html>