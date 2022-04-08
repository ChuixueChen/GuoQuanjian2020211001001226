<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@include file="header.jsp" %>
<h1><%= "Welcome to My Home Page!!!" %>
</h1><br/>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="search">
</form>
<a href="home">Home</a><br/>
<a href="hello-servlet">Hello Servlet -week2</a><br/>
<a href="hello">StudentInfo -week2</a><br/>
<a href="register.jsp">register.jsp -week2</a><br/>
<a href="register">RegisterServlet -week3</a><br/>
<a href="config">ConfigDemoServlet -week4</a><br/>
<a href="login">login.jsp -week5</a><br/>
<a href="MyJsp.jsp">MyJsp.jsp -week5</a><br/>
<%@include file="footer.jsp" %>
</body>
</html>