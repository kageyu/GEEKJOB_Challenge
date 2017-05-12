<%-- 
    Document   : challemge6
    Created on : 2017/05/12, 9:52:52
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
//    System.out.println("課題１");
    out.print("<br><br>課題１<br>");
    String[] data = {"10", "100", "soeda", "hayashi", "-20", "118", "END"};
    out.print(data[2]+"<br>");
    
    for(String t : data){
        out.print(t+" ");
    }
    
    
//    System.out.println("<br><br>課題２");
    out.print("<br><br>課題２<br>");
    data[2] = "33";
    out.print(data[2]+"<br>");
    
    for(String s:data){
        out.print(s+" ");
    }
    
%>