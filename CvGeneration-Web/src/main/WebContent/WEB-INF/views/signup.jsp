<%--
  Created by IntelliJ IDEA.
  User: Marek Perichta
  Date: 14.05.2016
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="meta.html"%>
    <link rel="stylesheet" href="css/signup.css">
</head>
<body>

    <div class="container">

        <form class="form-signin">
            <h2 class="form-signin-heading">Registration</h2>
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" class="form-control" placeholder="User Name" required autofocus>
            </div>

            <div class="form-group">
                <label for="inputPassword" >Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            </div>

            <div class="form-group">
                <label for="inputPassword" >Confirm Password</label>
                <input type="password" id="inputPassword2" class="form-control" placeholder="Password" required>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
        </form>

    </div> <!-- /container -->

</body>
</html>
