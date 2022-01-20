<%--
  Created by IntelliJ IDEA.
  User: konstantinos
  Date: 20/1/2022
  Time: 3:40 μ.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>List Citizens</title>

</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>You are viewing all Citizens</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <!--  add our html table here -->
        <table>
            <tr>
                <th>Code</th>
                <th>Full Name</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>Email</th>
            </tr>
            <!-- loop over and print our customers -->
            <c:forEach var="citizen" items="${citizens}">

                <tr>
                    <td>${citizen.code}</td>
                    <td>${citizen.fullName}</td>
                    <td>${citizen.address}</td>
                    <td>${citizen.phoneNumber}</td>
                    <td>${citizen.email}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>