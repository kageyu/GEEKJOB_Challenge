<%-- 
    Document   : challenge5-2
    Created on : 2017/05/11, 17:22:22
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
    int i = 1;
    switch(i){
        case 1 :out.print("one");
        break;
        
        case 2 :out.print("two");
        break;
        
        default:out.print("想定外");
        break;
    }
            
%>