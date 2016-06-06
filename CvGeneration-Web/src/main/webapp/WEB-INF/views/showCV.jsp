<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app lang="en">
<head>
    <%@include file="meta.jsp" %>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="header-left">
            <h1>Resume Generator</h1>
            <p>Create your resume here!</p>
        </div>
        <div class="header-right">
            <form action="${pageContext.request.contextPath}" method="GET">
                Welcome ${person.getUserLogin()}!<br/>You are logged in!
                <div class="cleaner"></div>
                <br/>
                <button class="btn btn-danger">
                    <span class="glyphicon glyphicon-off " aria-hidden="true"></span> Log out
                </button>
            </form>
        </div>
    </div>
</div>
<div class="container">
<script type="text/javascript">
    $(document).ready(function(){
       $("#cvForm").validationEngine();
    });
</script>
    <!----------------------------------------------- BEGINNING OF FORM ----------------------------------------->
    <form action="${pageContext.request.contextPath}/save" class="form-horizontal" method="POST"
          name="userForm"
          id="cvForm">
        <div class="box">

            <h2>Personal info</h2>
            <div class="left-side">
                <!-- **************************** Pre-title ************************** -->
                <div class="input-info">
                    <label for="pre-title" class="">Pre-title</label>
                    <input type="text" name="pre-title" id="pre-title" class="form-control" placeholder="e.g. Ing."
                           value="<c:out value="${person.getPersonalInfo().getPreTitle()}"/>"/>
                    <div class="cleaner"></div>
                </div>
                <div class="cleaner"></div>
                <!-- **************************** First name ************************** -->
                <div class="input-info">
                    <label for="first-name" class="">Name*</label>
                    <input type="text" name="first-name" id="first-name" class="form-control validate[required]"
                           placeholder="e.g. George"
                           value="<c:out value="${person.getPersonalInfo().getFirstName()}"/>"/>
                    <div class="cleaner"></div>
                </div>
                <div class="cleaner"></div>
                <!-- **************************** Last name ************************** -->
                <div class="input-info">
                    <label for="last-name" class="">Surname*</label>
                    <input type="text" name="last-name" id="last-name" class="form-control validate[required]"
                           placeholder="e.g. Smith"
                           value="<c:out value="${person.getPersonalInfo().getLastName()}"/>"/>
                    <div class="cleaner"></div>
                </div>
                <div class="cleaner"></div>
                <!-- **************************** Post-title ************************** -->
                <div class="input-info">
                    <label for="post-title" class="">Post-title</label>
                    <input type="text" name="post-title" id="post-title" class="form-control"
                           placeholder="e.g. Ph.D."
                           value="<c:out value="${person.getPersonalInfo().getPostTitle()}"/>"/>
                    <div class="cleaner"></div>
                </div>
                <div class="cleaner"></div>
            </div>
            <div class="right-side">
                <!-- **************************** Street ************************** -->
                <div class="input-info">
                    <label for="street" class="">Street*</label>
                    <input type="text" name="street" id="street" class="form-control validate[required]"
                           placeholder="e.g. Masarykova 32"
                           value="<c:out value="${person.getPersonalInfo().getAddress().getStreet()}"/>"/>
                    <div class="cleaner"></div>
                </div>
                <div class="cleaner"></div>
                <!-- **************************** City ************************** -->
                <div class="input-info">
                    <label for="city" class="">City*</label>
                    <input type="text" name="city" id="city" class="form-control validate[required]"
                           placeholder="e.g. Banská Bystrica"
                           value="<c:out value="${person.getPersonalInfo().getAddress().getCity()}"/>"/>
                    <div class="cleaner"></div>
                </div>
                <div class="cleaner"></div>
                <!-- **************************** Postal code ************************** -->
                <div class="input-info">
                    <label for="postal-code" class="">Postal code*</label>
                    <input type="text" name="postal-code" id="postal-code" class="form-control validate[required, custom[zip]]"
                           placeholder="e.g. 974 01"
                           value="<c:out value="${person.getPersonalInfo().getAddress().getPostalCode()}"/>"/>
                    <div class="cleaner"></div>
                </div>
                <div class="cleaner"></div>
                <!-- **************************** Phone numbers ************************** -->
                <div class="input-info">
                    <div ng-init="phones = [<c:forEach items="${person.getPersonalInfo().getPhones()}">
                                                    <c:out value="${'[], '}"/>
                                                </c:forEach> ];


                                  _phone = [<c:forEach items="${person.getPersonalInfo().getPhones()}" var="phone">
                                               <c:out value="'${phone}'," />
                                            </c:forEach>]">
                        <label class="">Phone number*</label>
                        <input class="form-control validate[required, custom[phone]]" type="tel" name="phone[0]" ng-model="_phone[0]"
                               placeholder="e.g. +421914868497">
                        <div ng-repeat="phone in phones" class="more-inputs">
                            <input class="form-control validate[custom[phone]]" type="tel" name="phone[{{$index + 1}}]"
                                   ng-model="_phone[ $index + 1 ]">
                        </div>
                        <a ng-click="phones.push([])" class="btn btn-add">Add phone number</a>
                        <div class="cleaner"></div>

                    </div>
                </div>
                <div class="cleaner"></div>
                <!-- **************************** Emails ************************** -->
                <div class="input-info">
                    <div ng-init="emails = [ <c:forEach items="${person.getPersonalInfo().getEmails()}">
                                                    <c:out value="${'[], '}"/>
                                                </c:forEach>];
                                 _email = [ <c:forEach items="${person.getPersonalInfo().getEmails()}" var="email">
                                               <c:out value="'${email}'," />
                                            </c:forEach>]">
                        <label class="">Email*</label>
                        <input class="form-control validate[required, custom[email]]" type="email" name="email[0]" ng-model="_email[0]"
                               placeholder="e.g. default@gmail.com">
                        <div ng-repeat="email in emails" class="more-inputs">
                            <input class="form-control validate[custom[email]]" type="email" name="email[{{$index + 1}}]"
                                   ng-model="_email[ $index + 1 ]">
                        </div>
                        <div class="cleaner"></div>
                        <a ng-click="emails.push([])" class="btn btn-add">Add email</a>
                        <div class="cleaner"></div>
                    </div>
                </div>

                <div class="cleaner"></div>
            </div>
            <div class="cleaner"></div>
        </div>

    <!-- **************************** Education ************************** -->

    <div class="box">
        <h2>Education</h2>
        <div ng-init="schools = [ [], <c:forEach items="${person.getEducation()}">
                                            <c:out value="${'[], '}"/>
                                          </c:forEach> ];
                          _e_name = [<c:forEach items="${person.getEducation()}" var="school">
                                        <c:out value="' ${school.getSchoolName()}'," />
                                     </c:forEach>];
                          _e_fieldOfStudy = [<c:forEach items="${person.getEducation()}" var="school">
                                                <c:out value="'${school.getFieldOfStudy()}'," />
                                             </c:forEach>];
                          _e_since = [<c:forEach items="${person.getEducation()}" var="school">
                                                <c:out value="'${school.getDateStart()}'," />
                                             </c:forEach>];
                          _e_to = [<c:forEach items="${person.getEducation()}" var="school">
                                                <c:out value="'${school.getDateEnd()}'," />
                                             </c:forEach>];
                          _e_grade = [<c:forEach items="${person.getEducation()}" var="school">
                                                <c:out value="'${school.getGrade()}'," />
                                             </c:forEach>]" class="">


            <div class="col-1">
                <label class="block">School</label>
            </div>
            <div class="col-1">
                <label class="block">Field of study</label>
            </div>
            <div class="col-2">
                <label class="block">Since</label>
            </div>
            <div class="col-2">
                <label class="block">To</label>
            </div>
            <div class="col-3">
                <label class="block">Grade</label>
            </div>
            <div class="both"></div>
            <div ng-repeat="school in schools" class="more-inputs">

                <div class="col-1">
                    <input class="form-control" type="text" name="e_name[{{$index}}]" ng-model="_e_name[ $index ]"
                           placeholder="e.g. Masaryk University" id="school{{$index}}">
                </div>
                <div class="col-1">
                    <input class="form-control" type="text" name="e_fieldOfStudy[{{$index}}]"
                           ng-model="_e_fieldOfStudy[ $index ]"
                           placeholder="e.g. Informatics">
                </div>
                <div class="col-2">
                    <input class="form-control validate[condRequired[school{{$index}}]]" type="text" name="e_since[{{$index}}]" ng-model="_e_since[ $index ]"
                           placeholder="e.g. 1.1.2011">
                </div>
                <div class="col-2">
                    <input class="form-control" type="text" name="e_to[{{$index}}]" ng-model="_e_to[ $index ]"
                           placeholder="e.g. 1.1.2011" placeholder="e.g. 2012-07">
                </div>
                <div class="col-3">
                    <input class="form-control" type="text" name="e_grade[{{$index}}]" ng-model="_e_grade[ $index ]"
                           placeholder="e.g. 4">
                </div>
                <div class="cleaner"></div>
            </div>
            <div class="cleaner"></div>
            <a ng-click="schools.push([])" class="btn pull-right">Add education</a>
            <div class="cleaner"></div>
        </div>
    </div>
    <!-- ************************************ Employment ******************************** -->

    <div class="box">
        <h2>Employments</h2>
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
                          _c_note = [<c:forEach items="${person.getEmployments()}" var="employment">
                                        <c:out value="'${employment.getDescription()}'," />
                                      </c:forEach>]" class="">
            <div class="col-1">
                <label class="block">Company</label>
            </div>
            <div class="col-1">
                <label class="block">Position</label>
            </div>
            <div class="col-2">
                <label class="block">Since</label>
            </div>
            <div class="col-2">
                <label class="block">To</label>
            </div>
            <div class="col-3">
                <label class="block">Note</label>
            </div>
            <div class="cleaner"></div>
        </div>
        <div class="cleaner"></div>
        <div ng-repeat="company in companies" class="more-inputs">

            <div class="col-1">
                <input class="form-control" type="text" name="c_nameC[{{$index}}]" ng-model="_c_nameC[ $index ]"
                       placeholder="e.g. Monitor s.r.o." id="comp{{$index}}">
            </div>
            <div class="col-1">
                <input class="form-control validate[condRequired[comp{{$index}}]]" type="text" name="c_position[{{$index}}]"
                       ng-model="_c_position[ $index ]"
                       placeholder="e.g. tester">
            </div>
            <div class="col-2">
                <input class="form-control validate[condRequired[comp{{$index}}]]" type="text" name="c_sinceC[{{$index}}]" ng-model="_c_sinceC[ $index ]"
                       placeholder="e.g. 1.1.2011">
            </div>
            <div class="col-2">
                <input class="form-control" type="text" name="c_toC[{{$index}}]" ng-model="_c_toC[ $index ]"
                       placeholder="e.g. 1.1.2011">
            </div>
            <div class="col-3">
                <input class="form-control" type="text" name="c_note[{{$index}}]" ng-model="_c_note[ $index ]"
                       placeholder="e.g. Testing monitors">

            </div>
            <div class="cleaner"></div>
        </div>
        <a ng-click="companies.push([])" class="btn pull-right">Add employment</a>
        <div class="cleaner"></div>
    </div>
    <!----------------------------------- Languages ----------------------->
    <div id="languages " class="box box-left">
        <h2>Languages</h2>
        <div ng-init="languages = [ [], <c:forEach items="${person.getLanguages()}">
                                                 <c:out value="${'[], '}"/>
                                               </c:forEach> ];
                              _l_language = [<c:forEach items="${person.getLanguages()}" var="language">
                                                <c:out value="' ${language.getLanguageName()}'," />
                                            </c:forEach>];
                              _l_level = [<c:forEach items="${person.getLanguages()}" var="language">
                                            <c:out value="'${language.getLevel()}'," />
                                          </c:forEach> 'basic']" class="">
            <div class="col-box-text">
                <label class="block">Language</label>
            </div>
            <div class="col-box-select">
                <label class="block">Level</label>
            </div>
        </div>
        <div class="cleaner"></div>
        <div ng-repeat="language in languages" class="more-inputs">

            <div class="col-box-text">
                <input class="form-control" type="text" name="l_language[{{$index}}]"
                       ng-model="_l_language[$index]"
                       placeholder="e.g. German">
            </div>
            <div class="col-box-select">
                <select class="form-control" name="l_level[{{$index}}]" ng-model="_l_level[ $index ]">
                    <option>basic</option>
                    <option>intermediate</option>
                    <option>advanced</option>
                    <option>native speaker</option>
                </select>

            </div>
        </div>
        <div class="cleaner"></div>
        <a ng-click="languages.push([]); _l_level[ _l_level.length ] = 'basic'" class="btn pull-right">Add
            language</a>
        <div class="cleaner"></div>
    </div>

    <!----------------------------------- Skills ----------------------->
    <div id="skills " class="box box-right">
        <h2>Skills</h2>
        <div ng-init="skills = [ [],  <c:forEach items="${person.getSkills()}">
                                                 <c:out value="${'[], '}"/>
                                               </c:forEach>];
                              _s_skill = [<c:forEach items="${person.getSkills()}" var="skill">
                                                <c:out value="'${skill.getSkillName()}'," escapeXml="false" />
                                            </c:forEach>];
                              _s_level = [<c:forEach items="${person.getSkills()}" var="skill">
                                                <c:out value="'${skill.getLevel()}'," escapeXml="false" />
                                            </c:forEach> 'basic']" class="">
            <div class="col-box-text">
                <label class="block">Skill</label>
            </div>
            <div class="col-box-select">
                <label class="block">Level</label>
            </div>
        </div>
        <div class="cleaner"></div>
        <div ng-repeat="skill in skills" class="more-inputs">

            <div class="col-box-text">
                <input class="form-control" type="text" name="s_skill[{{$index}}]" ng-model="_s_skill[$index]"
                       placeholder="e.g. Microsoft Excel">
            </div>
            <div class="col-box-select">
                <select class="form-control" name="s_level[{{$index}}]" ng-model="_s_level[ $index ]">
                    <option>basic</option>
                    <option>intermediate</option>
                    <option>advanced</option>
                    <option>professional</option>

                </select>
            </div>
            <div class="cleaner"></div>
        </div>
        <div class="cleaner"></div>
        <a ng-click="skills.push([]); _s_level[ _s_level.length ] = 'basic'" class="btn pull-right">Add
            skill</a>
        <div class="cleaner"></div>
    </div>
    <div class="cleaner"></div>
    <!----------------------------------- Certificates ----------------------->
    <div id="certificates" class="box box-left">
        <h2>Certificates</h2>
        <div ng-init="certificates = [ [], <c:forEach items="${person.getCertificates()}">
                                                    <c:out value="${'[], '}"/>
                                                  </c:forEach>];
                              _c_certificates = [<c:forEach items="${person.getCertificates()}" var="certificate">
                                                    <c:out value="'${certificate}'," />
                                                </c:forEach>]" class="">
            <div class="">
                <div ng-repeat="certificate in certificates" class="more-inputs">

                    <input class="form-control" type="text" name="certificates[{{$index}}]"
                           ng-model="_c_certificates[$index]" placeholder="e.g. FCE">
                </div>
            </div>
            <div class="cleaner"></div>
        </div>
        <div class="cleaner"></div>
        <a ng-click="certificates.push([])" class="btn pull-right">Add certificate</a>
        <div class="cleaner"></div>
    </div>

    <!----------------------------------- Hobbies ----------------------->
    <div id="hobbies" class="box box-right">
        <h2>Hobbies</h2>
        <div ng-init="hobbies = [ [], <c:forEach items="${person.getHobbies()}">
                                                 <c:out value="${'[], '}"/>
                                             </c:forEach>];
                              _c_hobbies = [<c:forEach items="${person.getHobbies()}" var="hobby">
                                                <c:out value="'${hobby}',"  />
                                            </c:forEach>]" class="">
            <div class="">
                <div ng-repeat="hobby in hobbies" class="more-inputs">

                    <input class="form-control" type="text" name="hobbies[{{$index}}]"
                           ng-model="_c_hobbies[$index]"
                           placeholder="e.g. Fishing">
                </div>
            </div>
            <div class="cleaner"></div>
        </div>
        <div class="cleaner"></div>
        <a ng-click="hobbies.push([])" class="btn pull-right">Add hobbies</a>
        <div class="cleaner"></div>
    </div>
    <div class="cleaner"></div>

    <div class="box">
        <input type="hidden" name="login" value="<c:out value="${person.getUserLogin()}"/>">


        <button type="submit" class="btn btn-primary btn-lg btn-block btn-full" name="save">Save</button>

        <button type="submit" class="btn btn-primary btn-lg btn-block btn-left" name="download" value="cz">Download pdf
            in CZ
        </button>

        <button type="submit" class="btn btn-primary btn-lg btn-block btn-right" name="download" value="en">Download pdf
            in EN
        </button>
        <div class="cleaner"></div>
    </div>
    <div class="cleaner"></div>
    </form>

</div>
<div class="footer">
    © 2016 | Lenka Heldová, Pavel Ježek, Juraj Galbavý, Marek Perichta
</div>
</body>
</html>