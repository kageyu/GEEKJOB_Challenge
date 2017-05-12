<%-- 
    Document   : challenge8-1-1
    Created on : 2017/05/12, 11:59:17
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
    out.print("for文 課題１<br>");
    long num = 1;
    for(int i=0;i<20;i++){
        num = num * 8;
        out.print(num+" , ");
        if(i%5==4){
            out.print("<br>");
        }
    }
    
    out.print("<br>for文 課題２<br>");
    String s = "";
    for(int i=0;i<30;i++){
        s = s + "A";
        if(i%5==4){
            out.print(i+1+"個："+s+"<br>");
        }
    }
    
    out.print("<br>for文 課題３<br>");
    int sum = 0;
    for(int i=0;i<100;i++){
        sum = sum + i;
        if(i%10==9){
            out.print(i+1+"までで、"+sum+"です。<br>");
        }
    }
%>