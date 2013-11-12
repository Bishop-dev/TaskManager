<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<head>
    <title>Registration</title>
</head>
<body>
<div class="container">
    <form class="form-horizontal" id="registrationForm" action="registration" method="post"
          enctype="multipart/form-data">
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
            <div class="control-group">
                <div class="control-label">Avatar:</div>
                <div class="controls"><input id="avatar" class="btn" type="file" name="avatar"/></div>
            </div>
            <div class="control-group">
                <div class="control-label"><input class="btn btn-primary" id="submitBtn" type="submit" value="Ok"/></div>
                <div class="controls"><input class="btn" id="cancelBtn" type="button" value="Cancel"/></div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>