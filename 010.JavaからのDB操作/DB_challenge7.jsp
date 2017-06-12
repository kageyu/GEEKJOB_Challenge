<%-- 
    Document   : DB_challenge7
    Created on : 2017/06/12, 13:56:16
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB操作　登録フォーム</title>
    </head>
    <body>
        <form action="../DB_challenge7" method="post"><br>
            ID:<input type ="text" name="profilesID"><br>
            名前:<input type ="text" name="name"><br>
            TELL:<input type ="text" name="tell"><br>
            Age:<input type ="text" name="age"><br>
            誕生日:<input type ="text" name="birthday"><br>
            <input type="submit" name="Submit" value="登録">
        </form>
    </body>
</html>
