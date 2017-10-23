<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DriverData</title>
</head>
<body class="container">
<#include "*/header.ftl" >
<div class="table-responsive" style="background-color: beige">
    <table class="table table-striped">
        <tr>
            <th><a href="all?order=id">Id</a></th>
            <th><a href="all?order=name">Name</a></th>
            <th><a href="all?order=surname">Surname</a></th>
            <th><a href="all?order=dob">DoB</a></th>
            <th><a href="all?order=email">Email</a></th>
            <th><a href="all?order=status">Status</a></th>
        </tr>
    <#list driver as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.surname}</td>
            <td>${item.dob}</td>
            <td>${item.email}</td>
            <td>${item.status?c}</td>
        </tr>
    </#list>
    </table>

<#if pages??>
    <#list pages as page>
        <span><a href="/driver/all?page=${page}">${page} ;</a></span>
    </#list>
</#if>

</div>
</body>
</html>