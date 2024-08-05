<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
</head>
<body>
<h2>${message}</h2>
<form:form action="/student/update" method="post" modelAttribute="student">
    <div>
        <form:label path="id"><h3>Enter ID:</h3></form:label>
        <form:input path="id" type="text" />
    </div>
    <div>
        <form:label path="name"><h3>Enter name:</h3></form:label>
        <form:input path="name" type="text"  value="" />
    </div>
    <div>
        <form:label path="surname"><h3>Enter surname:</h3></form:label>
        <form:input path="surname" type="text"  value="" />
    </div>
    <div>
        <form:label path="groupId"><h3>Enter group id:</h3></form:label>
        <form:input path="groupId" type="number" value="" />
    </div>
    <div>
        <form:label path="ispaid"><h3>Is Paid:</h3></form:label>
        <form:checkbox path="ispaid" />
    </div>
    <div>
        <button>Submit</button>
    </div>
</form:form>
</body>
</html>