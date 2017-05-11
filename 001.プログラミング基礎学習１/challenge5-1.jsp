<%-- 
    Document   : challenge5
    Created on : 2017/05/11, 17:15:08
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
    int i = 10;
    
    if(i==1){
        out.print("１です！");
        
    }else if(i==2){
        out.print("プログラミングキャンプ！");
        
    }else{
        out.print("その他です！");
    }
%>