<!DOCTYPE html>
<html>
<body>
<h2>Registration</h2>
<br>
<h3>Please, fill following form for registration</h3>
<br>
<form action="${pageContext.request.contextPath}/registration" method="post">
    First name: <input name="firstName">
    <br><br>
    Last name: <input name="lastName">
    <br><br>
    Order amount: <input name="amount" type="number" min="1">
	<br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

