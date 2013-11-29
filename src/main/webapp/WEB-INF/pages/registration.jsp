<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='tags' tagdir='/WEB-INF/tags' %>
<html>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<head>
    <title>Registration</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/registration.js"></script>
<body>

<div class="container">
    <form class="form-horizontal" id="registrationForm" action="registration" method="post">
        <fieldset>
            <legent>Registration Form</legent>
            <div class="control-group">
                <div class="control-label">Login:</div>
                <div class="controls"><input id="login" type="text" name="login"/></div>
            </div>
            <div class="control-group">
                <div class="control-label">Password:</div>
                <div class="controls"><input id="password" type="password" name="password"/></div>
            </div>
            <div class="control-group">
                <div class="control-label">Confirm:</div>
                <div class="controls"><input id="confirm" type="password" name="password"/></div>
            </div>
            <div class="control-group">
                <div class="control-label">Email:</div>
                <div class="controls"><input id="email" type="text" name="email"/></div>
            </div>
            <div class="control-group">
                <div class="control-label">Phone:</div>
                <div class="controls"><input id="phone" type="text" name="phone"/></div>
            </div>
            <div class="control-group">
                <div class="control-label">First Name:</div>
                <div class="controls"><input id="firstName" type="text" name="firstName"/></div>
            </div>
            <div class="control-group">
                <div class="control-label">Last Name:</div>
                <div class="controls"><input id="lastName" type="text" name="lastName"/></div>
            </div>
            <div class="control-group">
                <div class="control-label">Birthday:</div>
                <div class="controls"><input id="birthday" type="text" name="birthday"/></div>
            </div>
            <div class="control-group">
                <div class="control-label">Role:</div>
                <div class="controls"><select name="role" id="role">
                    <option value="student">Student</option>
                    <option value="expert">Expert</option>
                </select></div>
            </div>

            <tags:captcha privateKey="6LcheuoSAAAAAIa6CHWF8Qh_K7lMfsjEvhbN2Gdx"
                          publicKey="6LcheuoSAAAAABiUwapK7iF_nACc7VM2dZFGt1C0"/>

            <div class="control-group">
                <div class="control-label"><input class="btn btn-primary" id="submitBtn" type="submit" value="Ok"/>
                </div>
                <div class="controls"><input class="btn" id="cancelBtn" type="button" value="Cancel"/></div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>