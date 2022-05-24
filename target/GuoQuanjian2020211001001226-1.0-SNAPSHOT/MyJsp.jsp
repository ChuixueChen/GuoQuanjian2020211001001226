<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>I am MyJsp.jsp</div>
<%--<form method="post" action="MyDearJsp.jsp">--%>
    <form method="post" action="myDearServletURL">
    name<input name="name"/><br>
    class<input name="class"/><br>
    Id<input name="Id"/><br>
    <input type="submit" name="submit" value="send data to server"/>
</form>
</body>
</html>
