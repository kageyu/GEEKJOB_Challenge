<%-- 
    Document   : QueryStringOutput
    Created on : 2017/05/31, 10:26:40
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
<%
    request.setCharacterEncoding("UTF-8");
    int qs1=Integer.parseInt(request.getParameter("total"));
    int qs2=Integer.parseInt(request.getParameter("count"));
    int qs3=Integer.parseInt(request.getParameter("type"));
    out.print("総額"+qs1+"円、");
    out.print(qs2+"個、");
    out.print("商品種別は");
    switch (qs3){
        case 1 :out.print("雑貨");
        break;
        case 2 :out.print("生鮮食品");
        break;
        case 3 :out.print("その他");
        break;
    }
    
    int i=qs1/qs2;
    out.print("<br>1個当たりの値段は"+i+"円、<br>");
    
    float x=0;
    if(qs1>=5000){
        x = 0.05F;
    }else if(qs1>=3000){
        x = 0.04F;
    }
    
    String st=String.valueOf(qs1*x);
    st.substring(0,st.indexOf("."));
    
    out.print("今回のポイントは"+st.substring(0,st.indexOf("."))+"ポイントです。");
    
    //豆知識floatで入れようとしてもdoubleに入る値は丸まった後の0だゾ
double s = 0.0000000000000000001F;

%>