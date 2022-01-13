<%--
  Created by IntelliJ IDEA.
  User: konstantinos
  Date: 13/1/2022
  Time: 8:02 μ.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h3>Enter The Citizen Details</h3>
<form:form method="POST"
           action="add-citizen-ok" modelAttribute="citizen">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td><form:label path="passcode">
                Password</form:label></td>
            <td><form:input path="passcode"/></td>
        </tr>
        <tr>
            <td><form:label path="fullName">Full Name</form:label></td>
            <td><form:input path="fullName"/></td>
        </tr>
        <tr>
            <td><form:label path="region">Region</form:label></td>
            <td><form:input path="region"/></td>
        </tr>
        <tr>
            <td><form:label path="address">Address</form:label></td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td><form:label path="phoneNumber">PhoneNumber</form:label></td>
            <td><form:input path="phoneNumber"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="enabled">Enable Citizen</form:label></td>
            <td><form:input element="span class='checkbox'" path="enabled"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
