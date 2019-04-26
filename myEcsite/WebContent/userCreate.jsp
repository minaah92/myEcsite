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
<title>新規ユーザー登録</title>
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
		<h1>新規ユーザー登録</h1>

		<s:if test="errorMessage!=''">
			<s:property value="errorMessage" escape="false"/>
		</s:if>
		<s:form action="UserCreateConfirmAction">
		<table>
			<tr>
				<td class="left">ID:</td>
				<td class="right"><input type="text" name="loginUserId"></td>
			</tr>
			<tr>
				<td class="left">パスワード:</td>
				<td class="right"><input type="password" name="loginPassword"/></td>
			</tr>
			<tr>
				<td class="left">ユーザー名:</td>
				<td class="right"><input type="text" name="userName"/></td>
			</tr>
		</table>
			<s:submit value="登録" class="submit"/>
		</s:form>
	</div>
	<footer>
		<p class="copy">&copy; iwamoto internous</p>
	</footer>

</body>
</html>