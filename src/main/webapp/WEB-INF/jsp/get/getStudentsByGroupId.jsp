<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Students by Group</title>
</head>
<body>
<h2>Students in Group:</h2>
<ul>
    <c:forEach var="student" items="${students}">
        <li>${student}</li>
    </c:forEach>
</ul>
<br>
<a href="/student/getStudentsByGroupId">Back</a>
</body>
</html>