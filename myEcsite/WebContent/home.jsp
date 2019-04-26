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
			<li><a href='<s:url action="GoHomeAction"/>'>Home</a></li>
			<li><a href='<s:url action="HomeAction"/>'>Login</a></li>
			<li><a href='<s:url action="LogoutAction"/>'>Logout</a></li>
		</ul>
	</header>
	<div class="main">
		<h1>オンライン・ショコラティエ</h1>
		<img src="./img/home.jpg">

		<s:form action="HomeAction">
			<s:submit value="購入" class="submit"/>
		</s:form>
	</div>
	<footer>
		<p class="copy">&copy; iwamoto internous</p>
	</footer>

</body>
</html>