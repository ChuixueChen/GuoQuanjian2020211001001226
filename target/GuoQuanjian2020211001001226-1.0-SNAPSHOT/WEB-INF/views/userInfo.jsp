<%@ page import="com.GuoQuanjian.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
    <h1>User Info</h1>
<%
    Cookie[] allCookies = request.getCookies();
    for (int i = 0; i < allCookies.length; i++) {
        for (Cookie cookie : allCookies) {
            out.println("<br/>"+cookie.getName()+"===>"+cookie.getValue());
        }
    }
%>
<%
    User user= (User) session.getAttribute("user");
%>
    <table>
        <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
        <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
        <tr><td>Email:</td><td><%=user.getEmail()%></td></tr>
        <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
        <tr><td>BirthDate:</td><td><%=user.getBirthDate()%></td></tr>
        <tr><td><a href="updateUser">Update User</a></td></tr>
    </table>
<%@include file="footer.jsp"%>
</body>
</html>
