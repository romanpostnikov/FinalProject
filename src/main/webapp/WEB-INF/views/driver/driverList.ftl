<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DriverData</title>
</head>
<body class="container">
<#include "*/header.ftl" >
<p style="font-size: 26; color: #bfbbc0">List of drivers</p>
<a href="create" title="ADD" style="font-size: 70px; color: #bfbbc0;">+</a>
<div class="table-responsive" style="background-color: beige">
    <table class="table table-striped">
        <tr>
            <th><a href="all?order=id">Id</a></th>
            <th><a href="all?order=name">Name</a></th>
            <th><a href="all?order=surname">Surname</a></th>
            <th><a href="all?order=email">Email</a></th>
            <th><a href="all?order=status">Status</a></th>
            <th>Edit & Delete</th>
        </tr>
    <#list driver as item>
        <tr>
            <td>${item.id}</a></td>
            <td>${item.name}</td>
            <td>${item.surname}</td>
            <td>${item.email}</td>
            <td>${item.status?c}</td>
            <td><a href="${item.id}">Edit</a> |
                <a href="delete/${item.id}">Delete</a>
            </td>
        </tr>
    </#list>
    </table>
<#if pages??>
    <#list pages as page>
        <span><a href="/driver/all?page=${page}">${page}  </a></span>
    </#list>
</#if>
</div>
<br>
<a href="create" title="ADD" style="font-size: 70px; color: #bfbbc0;">+</a>
</body>
</html>