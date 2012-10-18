<%@ page import="com.goldengekko.signin.security.ClientThemeFilter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%
final Exception lastException = (Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
final String lastUsername = (String) session.getAttribute("SPRING_SECURITY_LAST_USERNAME");
final String cssUrl = (String) session.getAttribute(ClientThemeFilter.NAME_CSS_URL);
final Boolean isBlankEmail = (Boolean) session.getAttribute("SPRING_SECURITY_USERNAME_BLANK");
final Boolean isBlankPassword = (Boolean) session.getAttribute("SPRING_SECURITY_PASSWORD_BLANK");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale = 1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
        <title><spring:message code="signinProviderTitle"/></title>
        <link type="text/css" href="<%= null != cssUrl ? cssUrl : "/css" %>/signin_provider.css" rel="stylesheet" />
    </head>
    
    <body>
        <div id="header" class="ui-widget"></div>
        
        <div id="contents" class="ui-widget">
		<div id="login_box">

			      <form id="f" name="f" action="j_spring_security_check" method="POST">
						<div id="signin_logo"></div>
						<div class="strikethrough"><h1><spring:message code="signinH1" /></h1></div>
                        <div id="signin_msg"><spring:message code="signinMessage"/></div>
						<div class="input_fields">
							<label><spring:message code="emailLabel" /><% if(null != isBlankEmail && isBlankEmail){%><span style="color:#FF0000">*</span><%}%></label>
							<c:remove scope="session" var="SPRING_SECURITY_USERNAME_BLANK"/>
							<input  type ="text" id="j_username" name="j_username" autocapitalize="off" autocomplete="off" placeholder="<spring:message code="emailHint" />"  value="<%= null != lastUsername ? lastUsername : "" %>"/>
							<c:remove scope="session" var="SPRING_SECURITY_LAST_USERNAME"/>
						</div>
						<div class="input_fields">
							<label><spring:message code="passwordLabel" /><% if(null != isBlankPassword && isBlankPassword){%><span style="color:#FF0000">*</span><%}%></label>
							<c:remove scope="session" var="SPRING_SECURITY_PASSWORD_BLANK"/>
							<input type="password" id="j_password" name="j_password" autocomplete="off" placeholder="<spring:message code="passwordHint" />"/>
						</div>
                                                <div id="signin_error" style="color:red;"><%= null != lastException ? lastException.getMessage() : "" %></div>
						<div id="buttons">
							<button id="loginButton"><spring:message code="loginButton" /></button>
                            <span id="remember_me" style="display:none">
								<label for="_spring_security_remember_me"><spring:message code="rememberMeLabel"/></label>
                                <input type="checkbox" id="_spring_security_remember_me" name="_spring_security_remember_me" />
                            </span>
						</div>
						<div id="signin_msg_below"><spring:message code="signinMessage"/></div>
			      </form>
		</div>
                <div id="facebook_signin_box">
                        <form id="facebookSignin" action="signin/facebook" method="POST">
                            <button>Sign in using Facebook</button>
                        </form>
                </div>
        </div>
        
        <div id="footer" class="ui-widget"></div>

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/jquery-ui.min.js"></script>
        <script type="text/javascript">
				$.ajaxSetup( {
					 cache: false,
					 data: null
				});

				//$("#loginButton").button().click(function() {
				//	 $("#f").submit();
				//});
        </script>
        <script type="text/javascript" src="<%= null != cssUrl ? cssUrl : "/js" %>/signin_provider.js"></script>
    </body>
</html>
