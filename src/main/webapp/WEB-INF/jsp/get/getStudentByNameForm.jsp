<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Get Student</title>
</head>
<body>
<h2>${message}</h2>
<form action="/student/getStudentByName" method="get">
    <div>
        <label for="name"><h3>Enter name:</h3></label>
        <input type="text" id="name" name="name" />
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>
</body>
<br>
<a href="/student/getStudentByName">Back</a>
</html>