<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>
<h2> Requested user info: </h2>
<c:if test="${isUserExist}">
    id: ${id}
    name: ${name}
    surname: ${surname}
    age: ${age}
    passport_number: ${passport_number}
</c:if>
<c:if test="${!isUserExist}">
</c:if>
</body>
</html>