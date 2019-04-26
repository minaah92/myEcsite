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
<title>UserListDeleteConfirm</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>UserListDeleteConfirm</p>
		</div>
		<div>
			<h3>管理ユーザー以外のユーザー情報を削除します。</h3>
			<h3>本当に削除してもよろしいですか。</h3>
			<table>
				<tr>
					<td>
					<s:form action="UserListDeleteCompleteAction">
						<s:submit value="OK"/>
					</s:form>
					</td>
					<td>
					<s:form action="UserListAction">
						<s:submit value="キャンセル"/>
					</s:form>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<footer>
		<div id="pr">
		</div>
	</footer>

</body>
</html>