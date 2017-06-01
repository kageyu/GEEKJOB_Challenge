<%-- 
    Document   : Session
    Created on : 2017/06/01, 10:34:06
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
</html>

<%
    
    //request.setCharacterEncoding("UTF-8");

    String r1=(String)session.getAttribute("name");
    String r2=(String)session.getAttribute("sex");
    String r3=(String)session.getAttribute("hobby");
    String r4=(String)session.getAttribute("Date");
    if(r1!=null){
        out.print("名前："+r1+"<br>");
    }
    String t="";
    if("1".equals(r2)){
        t="男性";
    }else if("2".equals(r2)){
        t="女性";
    }        
    if(r2!=null){
        out.print("性別"+t+"<br>");
    }

    if(r3!=null){
        out.print("趣味<br>"+r3+"<br>");
    }
    if(r4!=null){
        out.print("最終ログイン："+r4);
    }else{
        out.print("はじめまして<br>よろしくお願いします");
    }


%>

<html>
    <body>
        <h1>入力フォーム</h1>
        <form action="../SessionOutput" method="post"><br>
            名前<input type ="text" name="name"><br>
            <input type ="radio" name="sex" value="1">男性
            <input type ="radio" name="sex" value="2">女性<br>
            趣味<textarea name="hobby"></textarea><br>
            <input type="submit" name="Submit" value="送信">
        </form>
    </body>
</html>
