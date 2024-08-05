<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Get Students By group id</title>
</head>
<body>
<h2>${message}</h2>
<form action="/student/getStudentsByGroupId" method="get">
    <div>
        <label for="groupId"><h3>Enter group ID:</h3></label>
        <input type="number" id="groupId" name="groupId" />
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>
</body>
</html>