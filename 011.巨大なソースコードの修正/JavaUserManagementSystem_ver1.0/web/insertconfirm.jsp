<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>

<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if(udb.getBoo()){ %>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= udb.getAc()%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
    <%  
        if(udb.getName() == ""){
            out.print("名前<br>");
        }
        if(udb.getYear() == "0"){
            out.print("年<br>");
        }
        if(udb.getMonth() == "0"){
            out.print("月<br>");
        }
        if(udb.getDay() == "0"){
            out.print("日<br>");
        }
        if(udb.getTypeInt() == 0){
            out.print("種別<br>");
        }
        if(udb.getTell() == ""){
            out.print("電話番号<br>");
        }
        if(udb.getComment() == ""){
            out.print("自己紹介<br>");
        }
        out.print("が未入力です。<br>");
    %>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
            <br>
            <%=JumsHelper.getInstance().home()%>
    </body>
</html>