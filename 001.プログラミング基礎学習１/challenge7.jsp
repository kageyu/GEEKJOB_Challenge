<%-- 
    Document   : challenge7
    Created on : 2017/05/12, 11:19:55
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

<%@ page import ="java.util.HashMap"%>
<%@ page import ="java.util.*"%>

<%
    
    HashMap <String , String> data =
                    new HashMap<String,String>();
    data.put("1","AAA");
    data.put("hello","world");
    data.put("soeda","33");
    data.put("20","20");
    
    out.print("課題チェック<br>");
    for(Map.Entry <String,String> s: data.entrySet()){
        out.print(s.getKey()+" : ");
        out.print(s.getValue()+"<br>");
        
    }
%>