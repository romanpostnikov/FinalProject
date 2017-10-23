<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>VehicleData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive" style="background-color: beige">
    <table class="table table-striped">
        <tr>
            <th><a href="all?order=id">Id</a></th>
            <th><a href="all?order=brand">Brand</a></th>
            <th><a href="all?order=model">Model</a></th>
            <th><a href="all?order=fuel">Fuel</a></th>
            <th><a href="all?order=year">Year</a></th>
            <th><a href="all?order=consumption">Consumption</a></th>
            <th><a href="all?order=status">Status</a></th>
            <th><a href="all?order=rank">Rank</a></th>
            <th>Buttons</th>
        </tr>
    <#list vehicle as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.brand}</td>
            <td>${item.model}</td>
            <td>${item.fuel}</td>
            <td>${item.year}</td>
            <td>${item.consumption}</td>
            <td>${item.status}</td>
            <td>${item.rank}</td>
            <td><a href="delete/${item.id}">Delete</a>
                <a href="${item.id}?edit=true">Edit</a>
            </td>
        </tr>
    </#list>
    </table>
<#if pages??>
    <#list pages as page>
        <span><a href="/vehicle/all?page=${page}">${page} ;</a></span>
    </#list>
</#if>
</div>
<a href="create">Create new</a>
</body>
</html>