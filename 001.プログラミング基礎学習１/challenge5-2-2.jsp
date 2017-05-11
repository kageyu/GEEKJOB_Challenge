<%-- 
    Document   : challenge5-2-2
    Created on : 2017/05/11, 17:34:59
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
    String moji = "あ";
    int i = 0;
    
    if(moji=="A"){
        i = 1;
    }else if(moji=="あ"){
        i = 2;
    }
    
    switch(i){
        case 1 :out.print("英語");
        break;
        
        case 2:out.print("日本語");
        break;
    }
%>

<%
//    String t = "A";
//    if(t.equals("")){
//        System.out.print("NULL!!");
//    }else switch(t){
//            case "あ":System.out.print("日本語");
//            break;
//            
//            case "A":System.out.print("英語");
//            break;
//    }        
%>