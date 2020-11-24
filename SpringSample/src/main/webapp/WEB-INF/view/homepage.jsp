<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
    <title>tecno-tab | home</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
</head>
<body style="align-content: center">
<button href="/login">Login</button>
<button href="/register">Register</button>
<div class="container text-center" id="login">
    <h3>User Login</h3>
    <hr>
    <form class="form-horizontal" method="POST" action="/login-user">

        <div class="form-group">
            <label class="control-label col-md-3">Username</label>
            <div class="col-md-7">
                <input type="text" class="form-control" name="username"
                       value="${user.username }" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">Password</label>
            <div class="col-md-7">
                <input type="password" class="form-control" name="password"
                       value="${user.password }" />
            </div>
        </div>
        <div class="form-group ">
            <input type="submit" class="btn btn-primary" value="Login" />
        </div>
    </form>
</div>
<div class="container text-center" id="register ">
    <h3>New Registration</h3>
    <hr>
    <form class="form-horizontal" method="POST" action="create-user">
        <input type="hidden" name="id" value="${user.id }" />
        <div class="form-group">
            <label class="control-label col-md-3">Username</label>
            <div class="col-md-7">
                <input type="text" class="form-control" name="username"
                       value="${user.username }" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">First Name</label>
            <div class="col-md-7">
                <input type="text" class="form-control" name="firstname"
                       value="${user.firstname }" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">Last Name</label>
            <div class="col-md-7">
                <input type="text" class="form-control" name="lastname"
                       value="${user.lastname }" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">Age </label>
            <div class="col-md-3">
                <input type="text" class="form-control" name="age"
                       value="${user.age }" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">Password</label>
            <div class="col-md-7">
                <input type="password" class="form-control" name="password"
                       value="${user.password }" />
            </div>
        </div>
        <div class="form-group ">
            <input type="submit" class="btn btn-primary" value="Register" />
        </div>
    </form>
</div>
</body>
</html>
