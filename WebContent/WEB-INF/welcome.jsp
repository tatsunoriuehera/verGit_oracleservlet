<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>welcome！</title>
	<link href="${ pageContext.request.contextPath }/model.css" rel="stylesheet">
	<style>
	</style>
</head>
<body>
	authentication succeed!
	<br>
	<br> welcome: ${ userName } ！
	<br>
	<table border=1>
		<th>menu</th>
		<tr>
			<td><a href="${ pageContext.request.contextPath }/importdata">country code list</a></td>
		</tr>
		<tr>
			<td><a href="${ pageContext.request.contextPath }/addcountries.jsp">add to country code</a></td>
		</tr>
	</table>
	<br>
	<a href="${ pageContext.request.contextPath }/login.jsp">back to login</a>
</body>
</html>
