<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>
<h2>${message}</h2>
<form:form action="/user/create" method="post" modelAttribute="user">
    <div>
        <form:label path="id"><h3>Enter ID:</h3></form:label>
        <form:input path="id" type="text"  value="" />
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
        <form:label path="age"><h3>Enter age:</h3></form:label>
        <form:input path="age" type="number" value="" />
    </div>
    <div>
        <form:label path="passport_number"><h3>Enter passport number:</h3></form:label>
        <form:input path="passport_number" type="text" value="" />
    </div>
    <div>
        <button>Submit</button>
    </div>
</form:form>
</body>
</html>