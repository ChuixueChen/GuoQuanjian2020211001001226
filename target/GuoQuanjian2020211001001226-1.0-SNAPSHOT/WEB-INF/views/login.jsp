<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
    <h1>Login</h1>
    <%
        if (request.getAttribute("message") != null) {
            out.println("<h2 style="+"color:red;"+">"+request.getAttribute("message")+"</h2>");
        }
    %>
    <%
        Cookie[] cookies = request.getCookies();
        String username="";
        String password="";
        String rememberValue="";
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cUsername")){
                    username=cookie.getValue();
                }
                if (cookie.getName().equals("cPassword")){
                    password=cookie.getValue();
                }
                if (cookie.getName().equals("cRememberMe")){
                    rememberValue=cookie.getValue();
                }
                System.out.println(cookie);
                System.out.println(cookie.getName());
            }
        }
    %>
    <form method="post" action="login">
        <%--<form method="post" action="${pageContext.request.contextPath}/login">--%>
        <div>
            <span>Username：</span><input type="text" name="username" value="<%=username%>">
        </div>
        <div>
            <span>Password：</span><input type="password" name="password"  value="<%=password%>">
        </div>
            <div><input type="checkbox" name="rememberMe" value="1" <%=rememberValue.equals("1") ? "checked" : ""%> />rememberMe</div>
        <div>
            <input type="submit" value="login">
        </div>
    </form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
