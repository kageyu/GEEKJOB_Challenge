<%-- 
    Document   : DB_challenge10
    Created on : 2017/06/12, 16:41:07
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB操作　複合検索フォーム</title>
    </head>
    <body>
        <form action="../DB_challenge10" method="post"><br>
            <input type ="radio" name="and_or" value="and">and
            <input type ="radio" name="and_or" value="or">or<br>
            名前:<input type ="text" name="name"><br>
            年齢:<input type ="text" name="age"><br>
            誕生日:<input type ="text" name="birthday"><br>
            <input type="submit" name="Submit" value="検索">
        </form>
    </body>
</html>
