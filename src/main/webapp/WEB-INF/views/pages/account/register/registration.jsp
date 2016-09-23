<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

Registration
<br>
<form:form commandName="registerForm" action="registration/register" method="post">
    <label>login</label>
    <form:errors path="email"/>
    <form:input path="email" required="required" />
    <br>
    <label>password</label>
    <form:errors path="password"/>
    <form:password path="password" required="required" />
    <br>
    <label>firstName</label>
    <form:errors path="firstName"/>
    <form:input path="firstName" required="required" />
    <br>
    <label>lastName</label>
    <form:errors path="lastName"/>
    <form:input path="lastName" />
    <br>
    <form:button value="Register"/>
</form:form>