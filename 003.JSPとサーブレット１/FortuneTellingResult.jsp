<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/05/15, 13:01:46
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "org.mypackage.sample.ResultData"%>
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
        ResultData data = (ResultData)request.getAttribute("DATA");
        if (data != null){
            out.print("あなたの"+data.getD()+"の運勢は"+data.getLuck()+"です。<br>");
        }
%>