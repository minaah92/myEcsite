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
<title>UserCreate画面</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>UserCreate</p>
		</div>
		<div>
			<s:if test="errorMessage!=''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<table>
			<s:form action="UserCreateConfirmAction">
				<tr>
					<td>
						<label>ログインID：</label>
					</td>
					<td>
						<input type="text" name="loginUserId" value=""/>
					</td>
				</tr>
				<tr>
					<td>
						<label>ログインPASS：</label>
					</td>
					<td>
						<input type="text" name="loginPassword" value=""/>
					</td>
				</tr>
				<tr>
					<td>
						<label>ユーザー名：</label>
					</td>
					<td>
						<input type="text" name="userName" value=""/>
					</td>
				</tr>
				<s:if test="session.adminFlg!=null">
				<tr>
					<td>
						<label>管理者権限：</label>
					</td>
					<td>
						<input type="radio" name="admin_Flg" checked="checked" value="1">あり
						<input type="radio" name="admin_Flg" value=null>なし
					</td>
				</tr>
				</s:if>
				<s:else>
					<input type="hidden" name="admin_Flg" value=null>
				</s:else>
				<s:submit value="登録"/>
			</s:form>
			</table>
			<s:if test="session.adminFlg!=null">
				<div id="text-link">
				<p>前画面に戻る場合は
					<a href='<s:url action="AdminAction"/>'>こちら</a>
				</p>
			</div>
			</s:if>
			<s:else>
			<div id="text-link">
				<p>前画面に戻る場合は
					<a href='<s:url action="GoHomeAction"/>'>こちら</a>
				</p>
			</div>
			</s:else>
		</div>
	</div>
	<footer>
		<div id="pr">
		</div>
	</footer>

</body>
</html>