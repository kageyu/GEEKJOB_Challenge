<%-- 
    Document   : challenge3
    Created on : 2017/05/11, 16:38:54
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
    final int year = 2017;
    out.print("変数：" + age  + "<br>");
    out.print("定数：" + year + "<br><br>");
    
    int wa    = age + year;
    int sa    = age - year;
    int seki  = age * year;
    int shou  = age / year;
    int amari = age % year;
    
    out.print("和　：" + wa    + "<br>");
    out.print("差　：" + sa    + "<br>");
    out.print("積　：" + seki  + "<br>");
    out.print("商　：" + shou  + "<br>");
    out.print("余り：" + amari + "<br>");

%>