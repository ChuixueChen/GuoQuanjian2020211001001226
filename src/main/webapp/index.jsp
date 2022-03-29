<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet -week2</a><br/>
<a href="hello">StudentInfo -week2</a><br/>
<a href="register">RegisterServlet -week3</a><br/>
<a href="config">ConfigDemoServlet -week4</a><br/>
<%@include file="footer.jsp"%>
</body>
</html>