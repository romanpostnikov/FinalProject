<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Taxi database</title>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<#include "WEB-INF/views/header.ftl">
<div class="container">

<@security.authorize access="isAuthenticated()">
    <p>Hello, <@security.authentication property="principal.username"/></p>
</@security.authorize>

</div>

</body>
</html>