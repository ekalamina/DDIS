<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>SignIn</title>
</head>
<body>
<h1> User ${userName} doesn't exist </h1>
<div>
    <form action="login" method="get">
        Name:<input type="text" name="userName"/><br/>
        Password:<input type="password" name="userPass"/><br/>
        <input type="submit" value="Sign in"/>

    </form>
    <form action="signup.html">
        <button>Sign up</button>
    </form>
</div>
</body>
</html>