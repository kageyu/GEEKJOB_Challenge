<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans"
        import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<UserDataBeans> UDB = (ArrayList<UserDataBeans>)hs.getAttribute("resultDataList");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <% if(UDB.size()!=0){ %>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <%for(UserDataBeans udb : UDB){%>
            <tr>
                <td><a href="ResultDetail?id=<%= udb.getUserID()%>"><%= udb.getName()%></a></td>
                <td><%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%></td>
                <td><%= jh.exTypenum(udb.getType())%></td>
                <td><%= udb.getNewDate()%></td>
            </tr>
            <%}%>
        </table>
        <% }else{%>みつかりませんでした<br><%}%>
        <%=jh.S()%>
        <%=jh.home()%>
    </body>
</html>
