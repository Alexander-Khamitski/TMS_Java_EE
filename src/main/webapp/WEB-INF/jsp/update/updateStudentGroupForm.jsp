<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
</head>
<body>
<h2>${message}</h2>
<form:form action="/student/updateStudentGroup" method="post" modelAttribute="student">
    <div>
        <form:label path="id"><h3>Enter ID:</h3></form:label>
        <form:input path="id" type="text" />
    </div>
    <div>
        <form:label path="groupId"><h3>Enter group id:</h3></form:label>
        <form:input path="groupId" type="number" value="" />
    </div>
    <div>
        <button>Submit</button>
    </div>
</form:form>
</body>
</html>