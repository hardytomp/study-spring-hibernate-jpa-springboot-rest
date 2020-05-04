<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

	<head>
		<title> Student Confirmation </title>
	</head>
	<body>
	
	the student is confirmed:${student.firstName} ${student.lastName} 
	<br></br>
	Country: ${student.country}

	<br></br>
	Favourtite Language: ${student.favouriteLanguage}	

	<br></br>
	Operating System: 
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
	
		
	</body>
</html>	