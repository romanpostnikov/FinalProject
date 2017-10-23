<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive" style="background-color: beige">
    <table class="table table-striped">
        <tr>
            <th><a href="all?order=username">Username</a></th>
            <th><a href="all?order=password">Password</a></th>
            <th><a href="all?order=role">Role</a></th>
            <th>Buttons</th>
        </tr>
    <#list user as item>
        <tr>
            <td>${item.username}</td>
            <td>${item.password}</td>
            <td>${item.role}</td>
            <td><a href="delete/${item.id}">Delete</a>
                <a href="${item.id}?edit=true">Edit</a>
            </td>
        </tr>
    </#list>
    </table>

</div>
</body>
</html>