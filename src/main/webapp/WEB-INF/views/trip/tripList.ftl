<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TripData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive" style="background-color: beige">
    <table class="table table-striped">
        <tr>
            <th><a href="all?order=id">Id</a></th>
            <th><a href="all?order=pointA">Point A</a></th>
            <th><a href="all?order=pointB">Point B</a></th>
            <th><a href="all?order=driver">Driver</a></th>
            <th><a href="all?order=vehicle">Vehicle</a></th>
            <th><a href="all?order=distance">Distance</a></th>
            <th><a href="all?order=price">Price</a></th>
            <th><a href="all?order=status">Status</a></th>
            <th>Buttons</th>
        </tr>
    <#list trip as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.pointA}</td>
            <td>${item.pointB}</td>
            <td>${item.driver}</td>
            <td>${item.vehicle}</td>
            <td>${item.distance}</td>
            <td>${item.price}</td>
            <td>${item.status}</td>
            <td><a href="delete/${item.id}">Delete</a>
                <a href="${item.id}?edit=true">Edit</a>
            </td>
        </tr>
    </#list>
    </table>
<#if pages??>
    <#list pages as page>
        <span><a href="/trip/all?page=${page}">${page} ;</a></span>
    </#list>
</#if>
</div>
</body>
</html>