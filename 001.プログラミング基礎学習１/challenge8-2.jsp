<%-- 
    Document   : challenge8-2
    Created on : 2017/05/12, 13:05:45
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
    out.print("while文 課題<br>");
    float i = 1000;
    while(i >= 100){
        i = i/2;
        out.print(i+" , ");
    
    }
    
%>