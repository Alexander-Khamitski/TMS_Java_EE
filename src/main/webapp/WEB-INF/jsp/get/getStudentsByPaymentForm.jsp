<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Get Students By Payment Status</title>
</head>
<body>
<h2>${message}</h2>
<form action="/student/getStudentsByPayment" method="get">
    <div>
        <label for="ispaid"><h3>Is Paid:</h3></label>
        <select id="ispaid" name="ispaid">
            <option value="true">Yes</option>
            <option value="false">No</option>
        </select>
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>
</body>
</html>
