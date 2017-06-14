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
        <title>入力フォーム</title>
    </head>
</html>

<%
    String r1=(String)session.getAttribute("name");
    String r2=(String)session.getAttribute("sex");
    String r3=(String)session.getAttribute("hobby");
    String r4=(String)session.getAttribute("Date");
%>

<html>
    <body>
        <h1>入力フォーム</h1>
        <form action="./SessionOutput" method="post"><br>
            名前<input type ="text" name="name" value=<%out.print(r1);%>><br>
            <input type ="radio" name="sex" value="1" <%if("1".equals(r2)){out.print("checked=\"checked\"");}%>>男性
            <input type ="radio" name="sex" value="2" <%if("2".equals(r2)){out.print("checked=\"checked\"");}%>>女性<br>
            趣味<textarea name="hobby"><%out.print(r3);%></textarea><br>
            <input type="submit" name="Submit" value="送信"><br>
            <%
                if(r4!=null){
                    out.print("最終ログイン："+r4);
                }else{
                    out.print("はじめまして<br>よろしくお願いします");
                }
            %>
        </form>
    </body>
</html>
