<%-- 
    Document   : output
    Created on : 2017/05/30, 10:24:07
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
</html>

<%
    request.setCharacterEncoding("UTF-8");
    out.print(request.getParameter("name")+"<br>");
    String s = request.getParameter("sex");
    String t="";
    if(s.equals("1")){
        t="男性";
    }else if(s.equals("2")){
        t="女性";
    }          
    out.print(t+"<br>");
    //out.print(s+"<br>");
    out.print(request.getParameter("hobby")+"<br>");
%>

<html>
    <body>
        <footer>
        <address>
            <a href="./index.html">ホームへ</a>
        </address>
        2017/5/31 更新
    </footer>
    </body>
</html>
