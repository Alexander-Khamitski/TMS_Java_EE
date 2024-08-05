<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Get Student</title>
</head>
<body>
<h2>${message}</h2>
<form action="/student/getStudentBySurname" method="get">
    <div>
        <label for="surname"><h3>Enter surname:</h3></label>
        <input type="text" id="surname" name="surname" />
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>
</body>
<br>
<a href="/student/getStudentBySurname">Back</a>
</html>