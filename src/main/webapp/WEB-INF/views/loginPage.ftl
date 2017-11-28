<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LoginPage</title>
</head>

<body class="container">
<#include "header.ftl">
<form action="/loginPage" method="post" class="form-group">

    <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" class="form-control" placeholder="Enter username" name="username" required>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" placeholder="Enter password" name="password" required>
    </div>

    <input type="submit" value="Login"/>

</form>
</body>
</html>