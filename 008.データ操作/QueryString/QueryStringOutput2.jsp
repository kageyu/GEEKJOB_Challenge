<%-- 
    Document   : QueryStringOutput2
    Created on : 2017/05/31, 11:47:16
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>クエリストリング課題２</title>
    </head>
    <body>
        <h1>簡易素因数分解</h1>
    </body>
</html>

<%
    request.setCharacterEncoding("UTF-8");
    String qss=request.getParameter("num");
    int qsi=Integer.parseInt(qss);
    String ans="";
    
    int[] sosu={2,3,5,7};
    for (int j:sosu){
        while(true){
            if(qsi%j == 0 && qsi/j != 1){
                ans+=j+"×";
                qsi=qsi/j;
            }else{
                break;
            }
        }
    }
    out.print(qss+"の素因数は"+ans+qsi+"です。");
%>