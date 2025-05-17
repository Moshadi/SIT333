<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login to STEM Math Game</h2>

    <c:if test="${not empty message}">
        <p style="color:red">${message}</p>
    </c:if>

    <form action="/login" method="post">
        <label for="username">Username:</label><br/>
        <input type="text" id="username" name="username" required/><br/><br/>

        <label for="passwd">Password:</label><br/>
        <input type="password" id="passwd" name="passwd" required/><br/><br/>

        <label for="dob">Date of Birth:</label><br/>
        <input type="date" id="dob" name="dob" required/><br/><br/>

        <button type="submit">Login</button>
    </form>
</body>
</html>
