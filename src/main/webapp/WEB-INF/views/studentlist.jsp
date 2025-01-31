<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="<c:url value='/js/something.js' />"></script>
</head>
<body>
<h1>STUDENT LIST</h1>
<table border="1" cellpadding ="10" cellspacing="0">
	<thead>
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Accepted></th>
			<th>Course</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="student" items="${students}">
			 <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.status}</td>
                    <td>${student.course.id}</td>
                                    
             </tr>
		</c:forEach>	
	</tbody>
</table>

</body>
</html>
