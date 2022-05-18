<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  !!!!!!!!!!!!!!!!!!!!use javaCode--%>
<div style="color: #0083C9">use javaCode</div>
<%
    Enumeration<String> parameterNameList = request.getParameterNames();
    while (parameterNameList.hasMoreElements()) {
        String parameterName =  parameterNameList.nextElement();
        String parameterValue = request.getParameter(parameterName);
        out.println("<div>"+parameterName+"："+parameterValue+"</div>");
    }
%>
<%--  !!!!!!!!!!!!!!!!!!!!use EL--%>
<div style="color: #0083C9">use EL</div>
<%
    request.setAttribute("name",request.getParameter("name"));
    request.setAttribute("myClass",request.getParameter("class"));
    request.setAttribute("Id",request.getParameter("Id"));
    request.setAttribute("submit",request.getParameter("submit"));
%>
<div>name：${name}</div>
<div>submit：${submit}</div>
<div>class：${myClass}</div>
<div>Id：${Id}</div>

</body>
</html>
