<%--
  Created by IntelliJ IDEA.
  User: Marek Perichta
  Date: 14.05.2016
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="meta.html"%>
    <link rel="stylesheet" href="../../resources/css/form-elements.css">
</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">

            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Resumé</strong> generator </h1>
                    <div class="description">
                        <p>
                            Instantly Create a Resume
                            that Employers Love
                        </p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5">

                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Login to our site</h3>
                                <p>Enter username and password to log on:</p>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-lock"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <form:form role="form" action="login" method="post" class="login-form">
                                <div class="form-group">
                                    <label class="sr-only" for="form-username">Username</label>
                                    <input type="text" name="form-username" placeholder="Username..." class="form-username form-control" id="form-username" required>
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-password">Password</label>
                                    <input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password" required>
                                </div>
                                <button type="submit" class="btn">Sign in!</button>
                            </form:form>
                        </div>
                    </div>


                </div>

                <div class="col-sm-1 middle-border"></div>
                <div class="col-sm-1"></div>

                <div class="col-sm-5">

                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Sign up now</h3>
                                <p>Fill in the form below to get instant access:</p>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-pencil"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <form:form role="form" action="register" method="post" class="registration-form">
                                <div class="form-group">
                                    <label class="sr-only" for="form-username-reg">User name</label>
                                    <input type="text" name="form-username-reg" placeholder="User name..." class="form-first-name form-control" id="form-username-reg" required>
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-pass1-reg">Password</label>
                                    <input type="password" name="form-pass1-reg" placeholder="Password..." class="form-password form-control" id="form-pass1-reg" required>
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-pass2-reg">Confirm password</label>
                                    <input type="password" name="form-pass2-reg" placeholder="Password..." class="form-password form-control" id="form-pass2-reg" required>
                                </div>
                                <button type="submit" class="btn">Sign me up!</button>
                            </form:form>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>

</div>

</body>

</html>