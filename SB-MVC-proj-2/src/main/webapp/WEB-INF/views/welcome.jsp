<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Welcome to Spring Boot MVC with JSP</h1>
    
    
    <h3>Addition</h3>
    <form action="add">
    <label>Enter 1st Number : </label>
    <input type="text" name=num1><br><br>
    <label>Enter 2nd Number : </label>
    <input type="text" name=num2><br><br>
    <input type="submit">
    </form>
    
    <h3>Add Alien</h3>
    <form action="alien">
    <label>Alien id : </label>
    <input type="text" name=aId><br><br>
    <label>Alien name : </label>
    <input type="text" name=aName><br><br>
    <input type="submit">
    </form>
    
</body>
</html>