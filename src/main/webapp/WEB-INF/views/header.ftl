<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<#import "/spring.ftl" as spring/>

<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Main</a>
        </div>
        <ul class="nav navbar-nav navbar-left">
            <li class=""><a href="/user/all">User</a></li>
            <li class=""><a href="/driver/all">Driver</a></li>
            <li class=""><a href="/vehicle/all">Vehicle</a></li>
            <li class=""><a href="/trip/all">Trip</a></li>
            <li class=""><a href="/fuel/all">Fuel</a></li>
        </ul>
    </div>
</nav>