<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>import-data</title>
	<link href="${ pageContext.request.contextPath }/model.css" rel="stylesheet">
	<style>
	</style>
</head>
<body>
	<br>
	<table border=1>
		<tr>
			<th>code</th>
			<th>countries</th>
			<th>symbol</th>
			<th></th>
		</tr>
			<p>registered country code</p>
		<c:choose>
			<c:when test="${empty InfoList}">
				<p>List not found<br> EMPTY!</p>
			</c:when>
			<c:otherwise>
			<c:forEach items="${InfoList}" var="users">
				<tr>
					<td>${users.code}</td>
					<td>${users.countries}</td>
					<td>${users.symbol}</td>
					<td>
						<form action="${ pageContext.request.contextPath }/delete"
							method="post">
							<input type="hidden" name="code" value="${ users.code }" />
						    <input type="submit" value="delete" />
						</form>
					</td>
				</tr>
			</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<br>
	<a href="${ pageContext.request.contextPath }/login.jsp">back to login</a>
</body>
</html>
