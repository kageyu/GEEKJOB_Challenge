<%-- 
    Document   : 変数・定数　変数
    Created on : 2017/05/11, 15:27:42
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

<%
    int age = 26;
    String name = "内藤　洋二朗";
    out.print("こんにちは<br>" + name + "<br>" + age + "歳です");
    
%>