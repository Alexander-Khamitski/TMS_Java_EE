<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete User</title>
</head>
<body>
<h2>${message}</h2>
<form:form action="/user/delete" method="post" modelAttribute="user">
    <div>
        <form:label path="id"><h3>Enter ID:</h3></form:label>
        <form:input path="id" type="text"  value="" />
    </div>
    <div>
        <button>Submit</button>
    </div>
</form:form>
</body>
</html>