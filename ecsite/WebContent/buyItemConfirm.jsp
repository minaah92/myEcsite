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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url);
		$('form').submit();
	}
</script>
<title>BuyItemConform画面</title>
</head>
<body>
	<header>
		<div id="pr">
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
			<table>
			<s:form action="UserCreateCompleteAction">
				<tr>
					<td>
						<label>商品名</label>
					</td>
					<td>
						<s:property value="session.buyConfirm_name"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>値段</label>
					</td>
					<td>
						<s:property value="session.buyConfirm_price"/>
						<span>円</span>
					</td>
				</tr>
				<tr>
					<td>
						<label>購入個数</label>
					</td>
					<td>
						<s:property value="session.buyConfirm_count"/>
						<span>個</span>
					</td>
				</tr>
				<tr>
						<td><span>支払い方法</span></td>
						<td>
							<input type="radio" name="pay" value="現金払い" checked="checked">現金払い
							<input type="radio" name="pay" value="クレジットカード">クレジットカード
						</td>
					</tr>
				<%-- <tr>
					<td>
						<label>支払い方法</label>
					</td>
					<td>
						<s:property value="session.pay"/>
					</td>
				</tr> --%>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><input type="button" value="戻る" onclick="submitAction('CartAction')"/></td>
					<td><input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')"/></td>
				</tr>
			</s:form>
			</table>
		</div>
		<div>
			<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
			<p>マイページは<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
		</div>
	</div>
	<footer>
		<div id="pr">
		</div>
	</footer>

</body>
</html>