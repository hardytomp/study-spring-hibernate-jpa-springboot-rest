<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<title>Customer confirmation </title>
	</head>
	
	<body>
		Customer is confirmed : ${customer.firstName} ${customer.lastName}
		<br></br>
		FreePasses :${customer.freePasses}
		<br></br>
		postalCode :${customer.postalCode}
		<br></br>
		CourseCode :${customer.courseCode}
		<br></br>
	</body>

</html>