<%--
  Created by IntelliJ IDEA.
  User: Marek Perichta
  Date: 14.05.2016
  Time: 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="meta.html" %>
</head>
<body>
<div class="jumbotron">
    <div class="row">
        <div class="col-md-6">
            <h1>Resume Generator</h1>
            <p>Create your resume here!</p>
        </div>
        <div class="col-md-2 col-md-offset-3">
            <form action="${pageContext.request.contextPath}/index" method="GET">
                <button class="btn btn-danger">
                    <span class="glyphicon glyphicon-off " aria-hidden="true"></span> Log out
                </button>
            </form>
        </div>
    </div>
</div>
<div class="container">
    Welcome! You are logged in!
    <!----------------------------------------------- BEGINNING OF FORM ----------------------------------------->
    <form action="${pageContext.request.contextPath}/editcv/save" class="form-horizontal" method="POST" name="userForm"
          id="cvForm">
        <div class="row">
            <h1>Personal info</h1>
            <div class="col-md-6">
                <!-- **************************** Pre-title ************************** -->
                <div class="form-group" >
                    <label for="pre-title" class="col-md-2">Pre-title</label>
                    <div class="col-md-9">
                        <input type="text" name="pre-title" id="pre-title" class="form-control"/>
                    </div>
                </div>
                <!-- **************************** First name ************************** -->
                <div class="form-group" >
                    <label for="first-name" class="col-md-2">First name*</label>
                    <div class="col-md-9">
                        <input type="text" name="first-name" id="first-name" class="form-control" required />
                    </div>
                </div>
                <!-- **************************** Last name ************************** -->
                <div class="form-group" >
                    <label for="last-name" class="col-md-2">Last name*</label>
                    <div class="col-md-9">
                        <input type="text" name="last-name" id="last-name" class="form-control" required />
                    </div>
                </div>
                <!-- **************************** Post-title ************************** -->
                <div class="form-group" >
                    <label for="post-title" class="col-md-2">Post-title</label>
                    <div class="col-md-9">
                        <input type="text" name="post-title" id="post-title" class="form-control"/>
                    </div>
                </div>


            </div>
        </div>

        <div class="col-md-6">
            <!-- **************************** Street ************************** -->
            <div class="form-group" >
                <label for="street" class="col-md-2">Street</label>
                <div class="col-md-9">
                    <input type="text" name="street" id="street" class="form-control"/>
                </div>
            </div>
            <!-- **************************** Street ************************** -->
            <div class="form-group" >
                <label for="city" class="col-md-2">City</label>
                <div class="col-md-9">
                    <input type="text" name="city" id="city" class="form-control"/>
                </div>
            </div>
            <!-- **************************** Postal code ************************** -->
            <div class="form-group" >
                <label for="postal-code" class="col-md-2">Postal code</label>
                <div class="col-md-9">
                    <input type="text" name="postal-code" id="postal-code" class="form-control"/>
                </div>
            </div>


        </div>



    </form>
</div>











Welcome! You are logged in!
</body>
</html>
