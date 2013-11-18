<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<head>
    <title>Login</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign in to continue</h1>

            <div class="account-wall">
                <img class="profile-img"
                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120">

                <div class="message">
                    <c:out value="${message}"/>
                </div>
                <form class="form-signin" name='f' action="<c:url value='j_spring_security_check'/>" method="post"
                      id="loginForm">
                    <div class="control-group">
                        <input id="login" type="text" name="j_username" class="form-control" placeholder="Email"
                               autofocus>
                    </div>
                    <div class="control-group">
                        <input id="password" type="password" name="j_password"
                               class="form-control" placeholder="Password">
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">
                        Sign in
                    </button>
                    <label class="checkbox pull-left">
                        <input type="checkbox" value="remember-me">
                        Remember me
                    </label>
                </form>
            </div>
            <a href="#" class="text-center new-account">Join Us</a>
        </div>
    </div>
</div>
</body>
</html>