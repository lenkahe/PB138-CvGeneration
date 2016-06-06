<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <%@include file="meta.jsp" %>
</head>
<body>
<div class="jumbotron">
    <div class="row">
        <div class="col-md-6">
            <h1>Resume Generator</h1>
            <p>Create your resume here!</p>
        </div>
        <div class="col-md-2 col-md-offset-3">
            <form action="${pageContext.request.contextPath}" method="GET">
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
    <form action="${pageContext.request.contextPath}/save" class="form-horizontal" method="POST" name="userForm"
          id="cvForm">
        <div class="row">

            <h1>Personal info</h1>
            </br></br>
            <div class="col-md-6">
                <!-- **************************** Pre-title ************************** -->
                <div class="form-group" >
                    <label for="pre-title" class="col-md-2">Pre-title</label>
                    <div class="col-md-9">
                        <input type="text" name="pre-title" id="pre-title" class="form-control" placeholder="e.g. Ing."
                               value="<c:out value="${person.getPersonalInfo().getPreTitle()}"/>"/>
                    </div>
                </div>
                <!-- **************************** First name ************************** -->
                <div class="form-group" >
                    <label for="first-name" class="col-md-2">Name*</label>
                    <div class="col-md-9">
                        <input type="text" name="first-name" id="first-name" class="form-control" required placeholder="e.g. George"
                               value="<c:out value="${person.getPersonalInfo().getFirstName()}"/>"/>
                    </div>
                </div>
                <!-- **************************** Last name ************************** -->
                <div class="form-group" >
                    <label for="last-name" class="col-md-2">Surname*</label>
                    <div class="col-md-9">
                        <input type="text" name="last-name" id="last-name" class="form-control" required placeholder="e.g. Smith"
                               value="<c:out value="${person.getPersonalInfo().getLastName()}"/>" />
                    </div>
                </div>
                <!-- **************************** Post-title ************************** -->
                <div class="form-group" >
                    <label for="post-title" class="col-md-2">Post-title</label>
                    <div class="col-md-9">
                        <input type="text" name="post-title" id="post-title" class="form-control" placeholder="e.g. Ph.D."
                               value="<c:out value="${person.getPersonalInfo().getPostTitle()}"/>" />
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <!-- **************************** Street ************************** -->
                <div class="form-group" >
                    <label for="street" class="col-md-2">Street*</label>
                    <div class="col-md-9">
                        <input type="text" name="street" id="street" class="form-control" required placeholder="e.g. Masarykova 32"
                               value="<c:out value="${person.getPersonalInfo().getAddress().getStreet()}"/>"/>
                    </div>
                </div>
                <!-- **************************** City ************************** -->
                <div class="form-group" >
                    <label for="city" class="col-md-2">City*</label>
                    <div class="col-md-9">
                        <input type="text" name="city" id="city" class="form-control" required placeholder="e.g. Banská Bystrica"
                               value="<c:out value="${person.getPersonalInfo().getAddress().getCity()}"/>"/>
                    </div>
                </div>
                <!-- **************************** Postal code ************************** -->
                <div class="form-group" >
                    <label for="postal-code" class="col-md-2">Postal code*</label>
                    <div class="col-md-9">
                        <input type="text" name="postal-code" id="postal-code" class="form-control" required placeholder="e.g. 974 01"
                               value="<c:out value="${person.getPersonalInfo().getAddress().getPostalCode()}"/>"/>
                    </div>
                </div>
                <!-- **************************** Phone numbers ************************** -->
                <div class="form-group" >
                    <div ng-init="phones = [<c:forEach items="${person.getPersonalInfo().getPhones()}">
                                                    <c:out value="${'[], '}"/>
                                                </c:forEach> ];


                                  _phone = [<c:forEach items="${person.getPersonalInfo().getPhones()}" var="phone">
                                               <c:out value="'${phone}'," />
                                            </c:forEach>]">
                        <label class="col-md-2">Phone number*</label>
                        <div class="col-md-9">
                            <input class="form-control" type="tel" name="phone[0]" ng-model="_phone[0]" required placeholder="e.g. +421914868497">
                            </br>
                            <div ng-repeat="phone in phones">
                                <input class="form-control" type="tel" name="phone[{{$index + 1}}]" ng-model="_phone[ $index + 1 ]" >
                                </br>
                            </div><a ng-click="phones.push([])" class="btn pull-right">Add phone number</a>

                        </div>
                    </div>
                </div>
                <!-- **************************** Emails ************************** -->
                <div class="form-group" >
                    <div ng-init="emails = [ <c:forEach items="${person.getPersonalInfo().getEmails()}">
                                                    <c:out value="${'[], '}"/>
                                                </c:forEach>];
                                 _email = [ <c:forEach items="${person.getPersonalInfo().getEmails()}" var="email">
                                               <c:out value="'${email}'," />
                                            </c:forEach>]">
                        <label class="col-md-2">Email*</label>
                        <div class="col-md-9">
                            <input class="form-control" type="email" name="email[0]" ng-model="_email[0]" required placeholder="e.g. default@gmail.com">
                            </br>
                            <div ng-repeat="email in emails">
                                <input class="form-control" type="email" name="email[{{$index + 1}}]" ng-model="_email[ $index + 1 ]" >
                                </br>
                            </div><a ng-click="emails.push([])" class="btn pull-right">Add email</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- **************************** Education ************************** -->
            <h1>Education</h1>
            </br>
            <div ng-init="schools = [ [], <c:forEach items="${person.getEducation()}">
                                            <c:out value="${'[], '}"/>
                                          </c:forEach> ];
                          _c_name = [<c:forEach items="${person.getEducation()}" var="school">
                                        <c:out value="' ${school.getSchoolName()}'," />
                                     </c:forEach>];
                          _c_fieldOfStudy = [<c:forEach items="${person.getEducation()}" var="school">
                                                <c:out value="'${school.getFieldOfStudy()}'," />
                                             </c:forEach>];
                          _c_since = [<c:forEach items="${person.getEducation()}" var="school">
                                                <c:out value="'${school.getDateStart()}'," />
                                             </c:forEach>];
                          _c_to = [<c:forEach items="${person.getEducation()}" var="school">
                                                <c:out value="'${school.getDateEnd()}'," />
                                             </c:forEach>];
                          _c_grade = [<c:forEach items="${person.getEducation()}" var="school">
                                                <c:out value="'${school.getGrade()}'," />
                                             </c:forEach>]" class="row">

            <hr>
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
                    </br>
                </div>
            </div><a ng-click="schools.push([])" class="btn pull-right">Add education</a>
            <div class="both"></div>
            </br>
        </div>

        <!-- ************************************ Employment ******************************** -->

        <hr>

        <div class="row">
            <h1>Employments</h1>
            </br>
            <div ng-init="companies = [ [], <c:forEach items="${person.getEmployments()}">
                                                <c:out value="${'[], '}"/>
                                            </c:forEach> ];
                          _c_nameC = [<c:forEach items="${person.getEmployments()}" var="employment">
                                        <c:out value="'${employment.getCompany()}'," />
                                      </c:forEach>];
                          _c_position = [<c:forEach items="${person.getEmployments()}" var="employment">
                                        <c:out value="' ${employment.getPosition()}'," />
                                      </c:forEach>];
                          _c_sinceC = [<c:forEach items="${person.getEmployments()}" var="employment">
                                        <c:out value="'${employment.getDateStart()}'," />
                                      </c:forEach>];
                          _c_toC = [<c:forEach items="${person.getEmployments()}" var="employment">
                                        <c:out value="'${employment.getDateEnd()}'," />
                                      </c:forEach>];
                          <%-- rename to description --%>
                          _c_note = [<c:forEach items="${person.getEmployments()}" var="employment">
                                        <c:out value="'${employment.getDescription()}'," />
                                      </c:forEach>]" class="row">
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

                <div class="col-md-3">
                    <input class="form-control" type="text" name="c_nameC[]" ng-model="_c_nameC[ $index ]" placeholder="e.g. Monitor s.r.o.">
                </div>
                <div class="col-md-3">
                    <input class="form-control" type="text" name="c_position[]" ng-model="_c_position[ $index ]" placeholder="e.g. tester">
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="c_sinceC[{{$index}}]" ng-model="_c_sinceC[ $index ]" placeholder="e.g. 1.1.2011">
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="c_toC[{{$index}}]" ng-model="_c_toC[ $index ]" placeholder="e.g. 1.1.2011" ng-pattern="/^((19|20)[0-9]{2})\-(01|02|03|04|05|06|07|08|09|10|11|12)$/" placeholder="e.g. 2012-07">
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="c_note[]" ng-model="_c_note[ $index ]" placeholder="e.g. Testing monitors">
                    </br>
                </div>
            </div><a ng-click="companies.push([])" class="btn pull-right">Add employment</a>
            <div class="both"></div>
        </div>
        <!----------------------------------- Languages ----------------------->
        <hr>
        <div class="row">
            <div id="languages "class="col-md-5">
                <h1>Languages</h1>
                <div ng-init="languages = [ [], <c:forEach items="${person.getLanguages()}">
                                                 <c:out value="${'[], '}"/>
                                               </c:forEach> ];
                              _l_language = [<c:forEach items="${person.getLanguages()}" var="language">
                                                <c:out value="' ${language.getLanguageName()}'," />
                                            </c:forEach>];
                              _l_level = [<c:forEach items="${person.getLanguages()}" var="language">
                                            <c:out value="'${language.getLevel()}'," />
                                          </c:forEach> 'basic']" class="row">
                    <div class="col-md-7">
                        <label class="block">Language</label>
                    </div>
                    <div class="col-md-5">
                        <label class="block">Level</label>
                    </div>
                </div>
                <div class="both"></div>
                <div ng-repeat="language in languages" class="row">

                    <div class="col-md-7">
                        <input class="form-control" type="text" name="l_language[]" ng-model="_l_language[$index]" placeholder="e.g. German">
                    </div>
                    <div class="col-md-5">
                        <select class="form-control" name="l_level[]" ng-model="_l_level[ $index ]">
                            <option>basic</option>
                            <option>intermediate</option>
                            <option>advanced</option>
                            <option>native speaker</option>
                        </select>
                        </br>
                    </div>
                </div><a ng-click="languages.push([]); _l_level[ _l_level.length ] = 'basic'" class="btn pull-right">Add language</a>
            </div>

            <div class="col-md-2"></div>
            <!----------------------------------- Skills ----------------------->
            <div id="skills "class="col-md-5">
                <h1>Skills</h1>
                <div ng-init="skills = [ [],  <c:forEach items="${person.getSkills()}">
                                                 <c:out value="${'[], '}"/>
                                               </c:forEach>];
                              _s_skill = [<c:forEach items="${person.getSkills()}" var="skill">
                                                <c:out value="'${skill.getSkillName()}'," escapeXml="false" />
                                            </c:forEach>];
                              _s_level = [<c:forEach items="${person.getSkills()}" var="skill">
                                                <c:out value="'${skill.getLevel()}'," escapeXml="false" />
                                            </c:forEach> 'basic']" class="row">
                    <div class="col-md-7">
                        <label class="block">Skill</label>
                    </div>
                    <div class="col-md-5">
                        <label class="block">Level</label>
                    </div>
                </div>
                <div class="both"></div>
                <div ng-repeat="skill in skills" class="row">

                    <div class="col-md-7">
                        <input class="form-control" type="text" name="s_skill[]" ng-model="_s_skill[$index]" placeholder="e.g. Microsoft Excel">
                    </div>
                    <div class="col-md-5">
                        <select class="form-control" name="s_level[]" ng-model="_s_level[ $index ]">
                            <option>basic</option>
                            <option>intermediate</option>
                            <option>advanced</option>
                            <option>professional</option>

                        </select>
                        </br>
                    </div>

                </div><a ng-click="skills.push([]); _s_level[ _s_level.length ] = 'basic'" class="btn pull-right">Add skill</a>
            </div>
        </div>
        <hr>
        <!----------------------------------- Certificates ----------------------->
        <div class="row">
            <div id="certificates" class="col-md-5">
                <h1>Certificates</h1>
                <div ng-init="certificates = [ [], <c:forEach items="${person.getCertificates()}">
                                                    <c:out value="${'[], '}"/>
                                                  </c:forEach>];
                              _c_certificate = [<c:forEach items="${person.getCertificates()}" var="certificate">
                                                    <c:out value="'${certificate}'," />
                                                </c:forEach>]" class="row">
                    <div class="col-md-12">
                        <div ng-repeat="certificate in certificates" class="row">

                            <input class="form-control" type="text" name="certificates[]" ng-model="_c_certificates[$index]" placeholder="e.g. FCE">
                            </br>
                        </div>
                    </div>
                </div><a ng-click="certificates.push([])" class="btn pull-right">Add certificate</a>
            </div>
            <div class="col-md-2"></div>

            <!----------------------------------- Hobbies ----------------------->
            <div id="hobbies" class="col-md-5">
                <h1>Hobbies</h1>
                <div ng-init="hobbies = [ [], <c:forEach items="${person.getHobbies()}">
                                                 <c:out value="${'[], '}"/>
                                             </c:forEach>];
                              _c_hobbies = [<c:forEach items="${person.getHobbies()}" var="hobby">
                                                <c:out value="'${hobby}'," escapeXml="false" />
                                            </c:forEach>]" class="row">
                    <div class="col-md-12">
                        <div ng-repeat="hobby in hobbies" class="row">

                            <input class="form-control" type="text" name="hobbies[]" ng-model="_c_hobbies[$index]" placeholder="e.g. Fishing">
                            </br>
                        </div>
                    </div>
                </div><a ng-click="hobbies.push([])" class="btn pull-right">Add hobbies</a>
            </div>
        </div>
            <input type="hidden" name="login" value="<c:out value="${person.getUserLogin()}"/>">
            </br></br>

        <button type="submit" class="btn btn-primary btn-lg btn-block">Save</button>
        </br>
        <div class="row">
            <div class="col-md-6"><button type="" class="btn btn-primary btn-lg btn-block">Download pdf in CZ</button></div>
            <div class="col-md-6"><button type="" class="btn btn-primary btn-lg btn-block">Download pdf in EN</button></div>
        </div>


    </form>
</div>
</body>
</html>