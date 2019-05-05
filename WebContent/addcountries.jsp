<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>new registration</title>
	<link href="${ pageContext.request.contextPath }/model.css" rel="stylesheet">
	<style>
	</style>
</head>
<body>
	new registration
	<br>
	<br> ${ message }
	<br>
	<br>
	<form action="${ pageContext.request.contextPath }/add"
		method="post">
		<table border=1>
			<tr>
				<th>code</th>
				<td><input type="text" name="code" /></td>
			</tr>
			<tr>
				<th>countries</th>
				<td><input type="text" name="countries" /></td>
			</tr>
			<tr>
				<th>symbol</th>
				<td><input type="text" name="symbol" /></td>
			</tr>
			</table>
		<input type="submit" value="submit" />
	</form>
	<a href="${ pageContext.request.contextPath }/importdata">countries code list</a>
</body>
</html>
