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
<title>UserCreateConfirm画面</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>UserCreateConfirm</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
			<s:form action="UserCreateCompleteAction">
				<tr id="box">
					<td>
						<label>ログインID：</label>
					</td>
					<td>
						<s:property value="loginUserId" escape="false"/>
					</td>
				</tr>
				<tr id="box">
					<td>
						<label>ログインPASS：</label>
					</td>
					<td>
						<s:property value="loginPassword" escape="false"/>
					</td>
				</tr>
				<tr id="box">
					<td>
						<label>ユーザー名：</label>
					</td>
					<td>
						<s:property value="userName" escape="false"/>
					</td>
				</tr>
				<s:if test="session.adminFlg!=null">
				<tr>
					<td>
						<label>管理者権限：</label>
					</td>
					<td>
						<s:if test="#session.admin_Flg==1">あり</s:if>
						<s:else>なし</s:else>
					</td>
				</tr>
				</s:if>
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