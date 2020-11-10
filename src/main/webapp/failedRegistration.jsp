<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>SignIn</title>
</head>
<body>
<h1> User ${userName} already exist </h1>
<div>
    <form action="login" method="get">
        Enter your name:<input type="text" name="userName"/><br/>
        Enter your password:<input type="password" name="userPass"/><br/>
        <input type="submit" value="Signup!"/>

    </form>
</div>
</body>
</html>