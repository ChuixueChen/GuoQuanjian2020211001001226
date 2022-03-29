<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<div>
    <h1>Login</h1>
<form method="post" action="login">
<%--<form method="post" action="${pageContext.request.contextPath}/login">--%>
    <div>
        <span>Username：</span><input type="text" name="username">
    </div>
    <div>
        <span>Password：</span><input type="password" name="password">
    </div>
    <div>
        <input type="submit" value="login">
    </div>
</form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
