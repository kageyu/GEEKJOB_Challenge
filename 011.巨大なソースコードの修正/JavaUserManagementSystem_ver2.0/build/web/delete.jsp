<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans"
        import="javax.servlet.http.HttpSession" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？
    名前:<%= udb.getName()%><br>
    生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
    種別:<%= jh.exTypenum(udb.getType())%><br>
    電話番号:<%= udb.getTell()%><br>
    自己紹介:<%= udb.getComment()%><br>
    登録日時:<%= udb.getNewDate()%><br>
    
    <form action="DeleteResult" method="POST">
      <input type="submit" name="YES" value="はい"style="width:100px">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
    </form>
    <%=jh.RD()%><br>
    <%=jh.home()%>
    </body>
</html>
