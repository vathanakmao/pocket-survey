<%@ page import="com.goldengekko.signin.security.ClientThemeFilter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale = 1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
        <title>Reset password - Signin Provider</title>
    </head>
    <body>
        <div id="header" class="ui-widget"></div>
        
        <div id="contents" class="ui-widget">
        	<div id="login_box">
	            <div id="signin_logo"></div>
            	<div id="reset_msg">
            		<div class="strikethrough"><h1>Reset Password</h1></div>
            		<div class="reset_password_msg">Your new password has been sent to you in an email.</div>
            	</div>
	        </div>
	        <br/><br/>
	        <a href="/index.html">Sign in...</a>
        </div>
        
        <div id="footer" class="ui-widget"></div>
    </body>
</html>
