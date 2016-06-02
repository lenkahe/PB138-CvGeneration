<%--
  Created by IntelliJ IDEA.
  User: Marek Perichta
  Date: 14.05.2016
  Time: 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app>
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
            </br></br>
            <div class="col-md-6">
                <!-- **************************** Pre-title ************************** -->
                <div class="form-group" >
                    <label for="pre-title" class="col-md-2">Pre-title</label>
                    <div class="col-md-9">
                        <input type="text" name="pre-title" id="pre-title" class="form-control" placeholder="e.g. Ing."/>
                    </div>
                </div>
                <!-- **************************** First name ************************** -->
                <div class="form-group" >
                    <label for="first-name" class="col-md-2">Name*</label>
                    <div class="col-md-9">
                        <input type="text" name="first-name" id="first-name" class="form-control" required placeholder="e.g. George"/>
                    </div>
                </div>
                <!-- **************************** Last name ************************** -->
                <div class="form-group" >
                    <label for="last-name" class="col-md-2">Surname*</label>
                    <div class="col-md-9">
                        <input type="text" name="last-name" id="last-name" class="form-control" required placeholder="e.g. Smith"/>
                    </div>
                </div>
                <!-- **************************** Post-title ************************** -->
                <div class="form-group" >
                    <label for="post-title" class="col-md-2">Post-title</label>
                    <div class="col-md-9">
                        <input type="text" name="post-title" id="post-title" class="form-control" placeholder="e.g. Ph.D."/>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <!-- **************************** Street ************************** -->
                <div class="form-group" >
                    <label for="street" class="col-md-2">Street</label>
                    <div class="col-md-9">
                        <input type="text" name="street" id="street" class="form-control" required placeholder="e.g. Masarykova 32"/>
                    </div>
                </div>
                <!-- **************************** City ************************** -->
                <div class="form-group" >
                    <label for="city" class="col-md-2">City</label>
                    <div class="col-md-9">
                        <input type="text" name="city" id="city" class="form-control" required placeholder="e.g. Banská Bystrica"/>
                    </div>
                </div>
                <!-- **************************** Postal code ************************** -->
                <div class="form-group" >
                    <label for="postal-code" class="col-md-2">Postal code</label>
                    <div class="col-md-9">
                        <input type="text" name="postal-code" id="postal-code" class="form-control" required placeholder="e.g. 974 01"/>
                    </div>
                </div>
                <!-- **************************** Phone numbers ************************** -->
                <div class="form-group" >
                    <div ng-init="phones = []; _phone = []">
                        <label class="col-md-2">Phone number*</label>
                        <div class="col-md-9">
                            <input class="form-control" type="text" name="phone[0]" ng-model="_phone[0]" required placeholder="e.g. +421914868497">
                            <div ng-repeat="phone in phones">
                                </br>
                                <input class="form-control" type="text" name="phone[{{$index + 1}}]" ng-model="_phone[ $index + 1 ]" >
                            </div><a ng-click="phones.push([])" class="btn pull-right">Add phone number</a>
                        </div>
                    </div>
                </div>
                <!-- **************************** Emails ************************** -->
                <div class="form-group" >
                    <div ng-init="emails = []; _email = []">
                        <label class="col-md-2">Email*</label>
                        <div class="col-md-9">
                            <input class="form-control" type="text" name="email[0]" ng-model="_email[0]" required placeholder="e.g. default@gmail.com">
                            <div ng-repeat="email in emails">
                                </br>
                                <input class="form-control" type="text" name="email[{{$index + 1}}]" ng-model="_email[ $index + 1 ]" >
                            </div><a ng-click="emails.push([])" class="btn pull-right">Add email</a>
                        </div>
                    </div>
                </div>
            </div>
            <h1>Education</h1>
            </br>
            <div ng-init="schools = [ [] ]; _c_name = []; _c_fieldOfStudy = []; _c_since = []; _c_to = []; _c_grade = []" class="row">
                <div class="col-md-3">
                    <label class="block">School</label>
                </div>
                <div class="col-md-3">
                    <label class="block">Field of study</label>
                </div>
                <div class="col-md-2">
                    <label class="block">Since</label>
                </div>
                <div class="col-md-2">
                    <label class="block">To</label>
                </div>
                <div class="col-md-2">
                    <label class="block">Grade</label>
                </div>
            </div>
            <div class="both"></div>
            <div ng-repeat="school in schools" class="row">
                </br>
                <div class="col-md-3">
                    <input class="form-control" type="text" name="c_name[]" ng-model="_c_name[ $index ]" placeholder="e.g. Masaryk University">
                </div>
                <div class="col-md-3">
                    <input class="form-control" type="text" name="c_fieldOfStudy[]" ng-model="_c_fieldOfStudy[ $index ]" placeholder="e.g. Informatics">
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="c_since[{{$index}}]" ng-model="_c_since[ $index ]" placeholder="e.g. 1.1.2011">
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="c_to[{{$index}}]" ng-model="_c_to[ $index ]" placeholder="e.g. 1.1.2011" ng-pattern="/^((19|20)[0-9]{2})\-(01|02|03|04|05|06|07|08|09|10|11|12)$/" placeholder="e.g. 2012-07">
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="c_grade[]" ng-model="_c_grade[ $index ]" placeholder="e.g. 4">
                </div>
            </div><a ng-click="schools.push([])" class="btn pull-right">Add education</a>
            <div class="both"></div>
            </br>
        </div>
        <div class="row">
            <h1>Employment</h1>
            </br>
            <div ng-init="companies = [ [] ]; _c_name = []; _c_position = []; _c_since = []; _c_to = []; _c_note = []" class="row">
                <div class="col-md-3">
                    <label class="block">Company</label>
                </div>
                <div class="col-md-3">
                    <label class="block">Position</label>
                </div>
                <div class="col-md-2">
                    <label class="block">Since</label>
                </div>
                <div class="col-md-2">
                    <label class="block">To</label>
                </div>
                <div class="col-md-2">
                    <label class="block">Note</label>
                </div>
            </div>
            <div class="both"></div>
            <div ng-repeat="company in companies" class="row">
                </br>
                <div class="col-md-3">
                    <input class="form-control" type="text" name="c_name[]" ng-model="_c_name[ $index ]" placeholder="e.g. Monitor s.r.o.">
                </div>
                <div class="col-md-3">
                    <input class="form-control" type="text" name="c_position[]" ng-model="_c_position[ $index ]" placeholder="e.g. tester">
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="c_since[{{$index}}]" ng-model="_c_since[ $index ]" placeholder="e.g. 1.1.2011">
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="c_to[{{$index}}]" ng-model="_c_to[ $index ]" placeholder="e.g. 1.1.2011" ng-pattern="/^((19|20)[0-9]{2})\-(01|02|03|04|05|06|07|08|09|10|11|12)$/" placeholder="e.g. 2012-07">
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="c_note[]" ng-model="_c_note[ $index ]" placeholder="e.g. Testing monitors">
                </div>
            </div><a ng-click="companies.push([])" class="btn pull-right">Add employment</a>
            <div class="both"></div>
        </div>
        <!----------------------------------- Languages ----------------------->
        <div id="languages "class="col-md-5">
            <h1>Languages</h1>
            <div ng-init="languages = [ [] ]; _l_language = []; _l_level = ['basic']" class="row">
                <div class="col-xs-8">
                    <label class="block">Language</label>
                </div>
                <div class="col-xs-4">
                    <label class="block">Level</label>
                </div>
            </div>
            <div class="both"></div>
            <div ng-repeat="language in languages" class="row">
                </br>
                <div class="col-xs-8">
                    <input class="form-control" type="text" name="l_language[]" ng-model="_l_language[$index]" placeholder="e.g. German">
                </div>
                <div class="col-xs-4">
                    <select class="form-control" name="l_level[]" ng-model="_l_level[ $index ]">
                        <option>basic</option>
                        <option>intermediate</option>
                        <option>advanced</option>
                        <option>native speaker</option>
                    </select>
                </div>
            </div><a ng-click="languages.push([]); _l_level[ _l_level.length ] = 'basic'" class="btn pull-right">Add language</a>
        </div>

        <div class="col-md-2"></div>
        <!----------------------------------- Skills ----------------------->
        <div id="skills "class="col-md-5">
            <h1>Skills</h1>
            <div ng-init="skills = [ [] ]; _l_skill = []; _l_level = ['basic']" class="row">
                <div class="col-xs-8">
                    <label class="block">Skill</label>
                </div>
                <div class="col-xs-4">
                    <label class="block">Level</label>
                </div>
            </div>
            <div class="both"></div>
            <div ng-repeat="skill in skills" class="row">
                </br>
                <div class="col-xs-8">
                    <input class="form-control" type="text" name="l_skill[]" ng-model="_l_skill[$index]" placeholder="e.g. Microsoft Excel">
                </div>
                <div class="col-xs-4">
                    <select class="form-control" name="l_level[]" ng-model="_l_level[ $index ]">
                        <option>basic</option>
                        <option>intermediate</option>
                        <option>advanced</option>
                        <option>native speaker</option>
                    </select>
                </div>
            </div><a ng-click="skills.push([]); _l_level[ _l_level.length ] = 'basic'" class="btn pull-right">Add skill</a>
        </div>
        <!----------------------------------- Certificates ----------------------->
        <div id="certificates" class="col-xs-5">
            <h1>Certificates</h1>
            <div ng-init="certificates = [ [] ]; _c_certificate = []" class="row">
                <div class="col-xs-12">
                    <div ng-repeat="certificate in certificates" class="row">
                        </br>
                        <input class="form-control" type="text" name="certificates[]" ng-model="_c_certificates[$index]" placeholder="e.g. FCE">
                    </div>
                </div>
            </div><a ng-click="certificates.push([])" class="btn pull-right">Add certificate</a>
        </div>
        <div class="col-xs-2"></div>

        <!----------------------------------- Hobbies ----------------------->
        <div id="hobbies" class="col-xs-5">
            <h1>Hobbies</h1>
            <div ng-init="hobbies = [ [] ]; _c_hobbies = []" class="row">
                <div class="col-xs-12">
                    <div ng-repeat="hobby in hobbies" class="row">
                        </br>
                        <input class="form-control" type="text" name="hobbies[]" ng-model="_c_hobbies[$index]" placeholder="e.g. Fishing">
                    </div>
                </div>
            </div><a ng-click="hobbies.push([])" class="btn pull-right">Add hobbies</a>
        </div>
        </br></br>

        <button type="submitButton" class="btn btn-primary btn-lg btn-block">Save</button>

    </form>
</div>
</body>
</html>