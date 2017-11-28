<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create driver</title>
</head>
<body class="container">
<#include "*/header.ftl" >

<div class="container">
    <form action="create" method="post" name="driver" class="form-group">

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" placeholder="Enter name" name="name" required>
        </div>
        <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="text" class="form-control" placeholder="Enter surname" name="surname" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" placeholder="Enter email" name="email" required>
        </div>
        <div class="form-group">
            <label for="status">Free:</label>
            <input type="checkbox" class="form-control" placeholder="Check if driver is not busy" name="status">
        </div>
        <input type="submit" value="create"/>
    </form>
</div>
<a type="button" href="/driver/all" class="button">Back</a>

</body>
</html>