<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException" %>
<%@ page import="com.goldengekko.signin.security.ClientThemeFilter" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" id="authorize_account">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
  <meta name="viewport" content="width=device-width,initial-scale = 1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
  <title>Signin Provider</title>
	<link type="text/css" href="<%= session.getAttribute(ClientThemeFilter.NAME_CSS_URL) %>/signin_provider.css" rel="stylesheet" />
</head>
<body>
  <div id="contents">
    <div id="signin_logo">Logo goes here</div>

    <% if (session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null && !(session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) instanceof UnapprovedClientAuthenticationException)) { %>
      <div class="error">
        <h2>Woops!</h2>

        <p>Access could not be granted. (<%= ((AuthenticationException) session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>)</p>
      </div>
    <% } %>
    <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION"/>

    <authz:authorize ifAllGranted="ROLE_USER">
      <h2>Please Confirm</h2>

      <p>You hereby authorize "<c:out value="${client.clientId}"/>" to access your name and email address.</p>

      <form id="confirmationForm" name="confirmationForm" action="<%=request.getContextPath()%>/oauth/authorize" method="post">
        <input name="user_oauth_approval" value="true" type="hidden"/>
        <button id="authorizeButton">Authorize</button>
      </form>
      <form id="denialForm" name="denialForm" action="<%=request.getContextPath()%>/oauth/authorize" method="post">
        <input name="user_oauth_approval" value="false" type="hidden"/>
        <button id="denyButton">Deny</button>
      </form>
    </authz:authorize>
  </div>

  <div id="footer" class="ui-widget"></div>

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/jquery-ui.min.js"></script>
        <script type="text/javascript" src="<%= session.getAttribute(ClientThemeFilter.NAME_CSS_URL) %>/signin_provider.js"></script>
        <script type="text/javascript">
				$.ajaxSetup( {
					 cache: false,
					 data: null
				});

				$("#authorizeButton").button().click(function() {
					 $("#confirmationForm").submit();
				});

				$("#denyButton").button().click(function() {
					 $("#denialForm").submit();
				});
        </script>
</body>
</html>
