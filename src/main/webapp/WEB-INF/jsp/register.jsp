<%@ page import="com.goldengekko.signin.security.ClientThemeFilter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale = 1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
        <title>Register - Signin Provider</title>
<!--        <link rel="stylesheet" type="text/css" media="all" href="/css/blitzer/jquery-ui-1.8.17.custom.css" />-->
<!--        <link type="text/css" href="<%= session.getAttribute(ClientThemeFilter.NAME_CSS_URL) %>/signin_provider.css" rel="stylesheet" />	-->
    </head>
    <body>
        <div id="header" class="ui-widget">
        </div>
        
        <div id="contents" class="ui-widget">
            <!--
            <form id="f" name="f" action="" method="POST">
            -->
            <table id="signin" class="ui-widget ui-widget-content">
                <thead class="ui-widget-header">
                    <tr>
                        <th colspan="2"><div id="signin_logo"></div></th>
                    </tr>
                </thead>
                <tbody id="signinBody">
                    <tr>
                        <td><label for="displayName">Name</label></td>
                        <td><input id="displayName" name="displayName" value="" /></td>
                    </tr>
                    <tr>
                        <td><label for="email">Email</label></td>
                        <td><input id="email" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td><label for="password">Password</label></td>
                        <td><input type="password" id="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><label for="confirm">Confirm Password</label></td>
                        <td><input type="password" id="confirm" name="confirm" value="" /></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2"><button id="registerButton">Register</button></td>
                    </tr>
                </tfoot>
            </table>
            <!--
            </form>
            -->
        <br/><br/>
        <a href="login.jsp">Sign in with existing account...</a>
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
    $("#displayName").focus();

    $("#registerButton").button().click(function() {
        var matches = $("#password").val() == $("#confirm").val();
        if (matches) {
            var data = new Object();
            data.displayName = $("#displayName").val();
            data.email = $("#email").val();
            data.password = $("#password").val();

            $.post("/user", data, function() {
                document.location = "login.jsp";
            });
        }
        else {
            $("#confirm").focus();
        }
    });

});
        </script>
    </body>
</html>
