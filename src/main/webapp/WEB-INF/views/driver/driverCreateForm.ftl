<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create driver</title>
</head>
<body class="container">
<#include "*/header.ftl">

<#if errors??>
ERROR:
    <#list errors as error>
    <h1>error</h1><br>
    </#list>
</#if>


<form action="create" method="post" name="driver" class="form-group">
    Name
    <input title="Name" type="text" name="name" "/>
    Surname
    <input title="Surname" type="text" name="surname" "/>
    Date of birth
    <input title="Dob" type="date" name="dob"/>
    Email
    <input title="Email" type="text" name="email" "/>
    Status
    <input title="Status" type="checkbox" name="status" "/>
    <input type="submit" value="Create"/>
</form>
<a type="button" href="/all" class="button">Back</a>
</body>
</html>