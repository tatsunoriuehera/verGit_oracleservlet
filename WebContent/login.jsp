<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
	<link href="${ pageContext.request.contextPath }/model.css" rel="stylesheet">
	<!-- awesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	<!-- awesome animation -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.0.10/font-awesome-animation.css" type="text/css" media="all" />
	<style>
	</style>
</head>
<body>
	${ message }
	<form action="${ pageContext.request.contextPath }/login" method="post">
		<i class="fas fa-key connect-blue fa-2x faa-bounce animated"></i>
		<h2>login</h2>
		<table>
			<tr>
				<td>user ID:</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="login" />
	</form>
</body>
</html>
