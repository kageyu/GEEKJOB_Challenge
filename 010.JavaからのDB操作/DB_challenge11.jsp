<%-- 
    Document   : DB_challenge
    Created on : 2017/06/12, 17:31:25
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "javax.servlet.http.HttpSession"%>

<%
    String r1=(String)session.getAttribute("name");
    String r2=(String)session.getAttribute("pass");
    String r3="";
           r3=(String)session.getAttribute("login");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理システム　トップページ</title>
    </head>
    <body>
        <%if("in".equals(r3)){%>
        ログイン中：<%out.print(r1);%>さん
        <form action="./DB_challenge14" method="post"><br>
            <input type="submit" name="Submit" value="ログアウト">
        </form>
        <%}else if("error".equals(r3)){%>
        名前かパスワードが間違っています<br>
        <form action="./DB_challenge11" method="post"><br>
            名前　　　:<input type ="text" name="name" value=<%out.print(r1);%>><br>
            パスワード:<input type ="password" name="pass" value=<%out.print(r2);%>><br>
            <input type="submit" name="Submit" value="ログイン">
        </form>
        <%}else{%>
        ログインして下さい<br>
        <form action="./DB_challenge11" method="post"><br>
            名前　　　:<input type ="text" name="name"><br>
            パスワード:<input type ="password" name="pass"><br>
            <input type="submit" name="Submit" value="ログイン">
        <%}%>
        
        商品登録フォーム<br>
        <form action="./DB_challenge12" method="post"><br>
            商品名:<input type ="text" name="name">
            <input type="submit" name="Submit" value="登録"><br>
        </form><br>
        
        <form action="./DB_challenge13" method="post">
            <input type="submit" name="Submit" value="商品一覧"><br>
        </form>
    </body>
</html>
