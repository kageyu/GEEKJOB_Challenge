<%@page import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    ArrayList<String> chkList = udb.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新確認画面</title>
    </head>
    <body>
    <% if(chkList.size()==0){ %>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容に更新します。よろしいですか？
        <form action="UpdateResult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=jh.chkinput(chkList) %>
    <% } %>
        <form action="Update" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="no" value="更新画面に戻る">
        </form>
        <%=jh.RD()%>
        <%=jh.home()%>
    </body>
</html>
