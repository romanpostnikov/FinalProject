<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit driver</title>
</head>
<body class="container">
<#include "*/header.ftl">

<div class="container">
    <form action="update" method="post" name="driver" class="form-group">

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" placeholder="Enter name" name="name" value="${driver.name}" required>
        </div>
        <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="text" class="form-control" placeholder="Enter surname" name="surname" value="${driver.surname}" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" placeholder="Enter email" name="email" value="${driver.email}" required>
        </div>
        <div class="form-group">
            <label for="status">Free:</label>
            <input type="checkbox" class="form-control" placeholder="Check if driver is not busy" name="status" value="${driver.status}">
        </div>
        <input type="submit" value="update"/>
    </form>
</div>
<a type="button" href="/driver/all" class="button">Back</a>

</body>
</html>