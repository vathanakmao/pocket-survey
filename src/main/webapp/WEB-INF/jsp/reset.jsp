<%@ page import="com.goldengekko.signin.security.ClientThemeFilter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
final String cssUrl = (String) session.getAttribute(ClientThemeFilter.NAME_CSS_URL);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale = 1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
        <title>Reset password - Signin Provider</title>
        <link rel="stylesheet" type="text/css" media="all" href="/css/blitzer/jquery-ui-1.8.17.custom.css" />
        <link type="text/css" href="<%= null != cssUrl ? cssUrl : "/css" %>/signin_provider.css"  rel="stylesheet" />
    </head>
    <body>
        <div id="header" class="ui-widget">
        </div>
        
        <div id="contents" class="ui-widget">
        	<div id="login_box">
	            <div id="signin_logo"></div>
	            	<div id="reset_msg">
	            		<div class="strikethrough"><h1>Reset Password</h1></div>
	            		<div id="signin_msg">You have to provide your email address in order to reset the password.</div>
	            	</div>
	            	<div class="input_fields">
	                	<label>Email</label>
	                    <input id="email" name="email" value="" placeholder="Enter email address" autocapitalize="off" type="email" />
	                </div>
					<div id="invalid"></div>
					<div id="success_msg"></div>
	               <div id="buttons">
	               		<button id="resetButton">Reset password</button>
	               </div>
	               <br/><br/>
	               <div class="reset_password_section">
	               <a href="login.jsp">Sign in with existing account...</a>
	               </div>
	          </div>
            <!--
            </form>
            -->
        </div>
        
        <div id="footer" class="ui-widget"></div>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/jquery-ui.min.js"></script>
        <script type="text/javascript">
$.ajaxSetup( {
    cache: false,
    data: null
});

$(function() {
    $("#email").focus();

    $("#resetButton").button().click(function() {
        var data = new Object();
        data.email = $("#email").val();
      	//clear old message 
    	$("#invalid").html("");
    	$("#success_msg").html("");

        $.post("/user/resetrequest", data, function() {
        	$("#success_msg").html("An email with reset link has been sent to " + $("#email").val());
            document.location = "login.jsp";
        }).error(function(){$("#invalid").html("User name is not found");});
    });
});
        </script>
    </body>
</html>
