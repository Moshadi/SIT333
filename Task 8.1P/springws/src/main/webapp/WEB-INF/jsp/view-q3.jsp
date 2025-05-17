<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Question 3 - Multiplication</title>
</head>
<body>
    <h2>Question 3: Multiplication</h2>
    <form action="/q3" method="post">
        Number 1: <input type="text" name="number1" required /><br/>
        Number 2: <input type="text" name="number2" required /><br/>
        Your Answer: <input type="text" name="result" required /><br/>
        <button type="submit">Submit</button>
    </form>

    <c:if test="${not empty message}">
        <p style="color: red">${message}</p>
    </c:if>
</body>
</html>
