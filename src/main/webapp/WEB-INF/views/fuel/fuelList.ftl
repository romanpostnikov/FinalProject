<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FuelData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive" style="background-color: beige">
    <table class="table table-striped">
        <tr>
            <th><a href="all?order=fuelType">Fuel type</a></th>
            <th><a href="all?order=cost">Cost</a></th>
            <th>Buttons</th>
        </tr>
    <#list fuel as item>
        <tr>
            <td>${item.fuelType}</td>
            <td>${item.cost}</td>
            <td><a href="delete/${item.id}">Delete</a>
                <a href="${item.id}?edit=true">Edit</a>
            </td>
        </tr>
    </#list>
    </table>

</div>
</body>
</html>