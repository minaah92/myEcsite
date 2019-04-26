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
<title>ItemCreateConfirm画面</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>ItemCreateConfirm</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
			<s:form action="ItemCreateCompleteAction">
				<tr id="box">
					<td>
						<label>商品名：</label>
					</td>
					<td>
						<s:property value="sellName" escape="false"/>
					</td>
				</tr>
				<tr id="box">
					<td>
						<label>値段：</label>
					</td>
					<td>
						<s:property value="sellPrice" escape="false"/>
						<span>円</span>
					</td>
				</tr>
				<tr id="box">
					<td>
						<label>出品数：</label>
					</td>
					<td>
						<s:property value="sellStock" escape="false"/>
						<span>個</span>
					</td>
				</tr>
				<s:submit value="完了"/>
			</s:form>
			</table>
		</div>
	</div>
	<footer>
		<div id="pr">
		</div>
	</footer>

</body>
</html>