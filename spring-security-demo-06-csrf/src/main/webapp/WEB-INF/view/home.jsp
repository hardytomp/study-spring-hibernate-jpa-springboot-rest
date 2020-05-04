<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

	<head>
		<title> Spring security Demo</title> 
	</head>

	<body>
		<h2>Spring security Demo Page</h2>
		<hr>
			<p>
				Welcome to Spring security!
			</p>
			
			<!-- Logout button -->
			<form:form action="${pageContext.request.contextPath}/logout"
						method="POST">
				<input type="submit" value="Logout" />
			
			</form:form>
			
	</body>

</html>