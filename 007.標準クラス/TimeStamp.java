/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 標準クラス;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.HashSet;

/**
 *
 * @author guest1Day
 */
public class TimeStamp extends HttpServlet {
    public String ReturnNow(){
        Date d2  = new Date();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        c2.add(Calendar.MONTH, 1);
        return(c2.get(Calendar.YEAR)       +"-"+c2.get(Calendar.MONTH) +"-"+c2.get(Calendar.DAY_OF_MONTH)
          +" "+c2.get(Calendar.HOUR_OF_DAY)+":"+c2.get(Calendar.MINUTE)+":"+c2.get(Calendar.SECOND));
            
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            //課題１　タイムスタンプの作成
            out.print("標準クラス　日付編<br>課題１　タイムスタンプの作成<br>");
            Date d1 = new Date(2016,1,1,0,0,0);
            out.print(d1.getTime());
            
            //課題２　現在の日時の表示
            out.print("<br><br>課題２　現在の日時の表示<br>");
            Date d2  = new Date();
            Calendar c2 = Calendar.getInstance();
            c2.setTime(d2);
            c2.add(Calendar.MONTH, 1);
            out.print(c2.get(Calendar.YEAR)       +"-"+c2.get(Calendar.MONTH) +"-"+c2.get(Calendar.DAY_OF_MONTH)
                 +" "+c2.get(Calendar.HOUR_OF_DAY)+":"+c2.get(Calendar.MINUTE)+":"+c2.get(Calendar.SECOND));
            
            //課題３　タイムスタンプの表示
            out.print("<br><br>課題３　タイムスタンプの表示<br>");
            Date d3 = new Date(2016,11,4,10,0,0);
            Calendar c3 = Calendar.getInstance();
            c3.setTime(d3);
            c3.add(Calendar.MONTH, 1);
            out.print(c3.get(Calendar.YEAR)       +"-"+c3.get(Calendar.MONTH) +"-"+c3.get(Calendar.DAY_OF_MONTH)
                 +" "+c3.get(Calendar.HOUR_OF_DAY)+":"+c3.get(Calendar.MINUTE)+":"+c3.get(Calendar.SECOND));
            
            //課題４　タイムスタンプの表示
            out.print("<br><br>課題４　タイムスタンプの表示<br>");
            Date d4 = new Date(2015,1,1,0,0,0);
            Date d5 = new Date(2015,12,31,23,59,59);
            out.print(d5.getTime()-d4.getTime()+"<br>");
            //差をDateとして出す遊び
            out.print("<br><br>おまけ<br>");
            Date d6 = new Date(d5.getTime()-d4.getTime());
            out.print(d6+"<br>");
            //そのCalemdar表記
            Calendar c6 = Calendar.getInstance();
            c6.setTime(d6);
            c6.add(Calendar.MONTH, 1);
            out.print(c6.get(Calendar.YEAR)       +"-"+c6.get(Calendar.MONTH) +"-"+c6.get(Calendar.DAY_OF_MONTH)
                 +" "+c6.get(Calendar.HOUR_OF_DAY)+":"+c6.get(Calendar.MINUTE)+":"+c6.get(Calendar.SECOND)+"<br>");
            //タイムスタンプを日付にすると1970年を基準に表記されることがわかったので修正したものがこちら
            c6.add(Calendar.YEAR,-1970);
            out.print(c6.get(Calendar.YEAR)       +"年"  +c6.get(Calendar.MONTH) +"ヶ月"+c6.get(Calendar.DAY_OF_MONTH)
                +"日"+c6.get(Calendar.HOUR_OF_DAY)+"時間"+c6.get(Calendar.MINUTE)+"分"  +c6.get(Calendar.SECOND)+"秒");
            
            
            //課題１　バイト数と文字数の取得
            out.print("<br><br>標準クラス　文字列編<br>課題１　バイト数と文字数の取得<br>");
            String s1 = "内藤洋二朗";
            int b1 = s1.getBytes().length;
            int i1 = s1.length();
            out.println(b1+"バイト<br>");
//            out.println("デフォルトでは"+b1+"バイト<br>");
//            out.println("Shift_JISでは"+s1.getBytes(Shift_JIS).length+"バイト<br>");
//            out.println("UTF-8では"+s1.getBytes(UTF-8).length+"バイト<br>");
            out.println(i1+"文字<br>");
            
            //getBytes()メソッドだけだと何で返すのか知りたい
            out.println("おまけ "+s1.getBytes());
            
            //課題２　文字数の取得
            out.print("<br><br>課題２　文字数の取得<br>");
            String s2 = "kageyu0931@gmail.com";
            int    i2 = s2.indexOf("@");
            String a2 = s2.substring(i2);
            out.println(a2);
            
            //課題３　文字の入れ替え
            out.print("<br><br>課題３　文字の入れ替え<br>");
            String s3 = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
            String a3 = s3.replace("U", "う").replace("I", "い");
            out.println(a3);
            
            //課題１　ファイルの書き出しと保存
            out.print("<br><br>標準クラス　ファイル操作編<br>課題１　ファイルの書き出しと保存<br>");
            File fp = new File("test.txt");
            FileWriter fw = new FileWriter(fp);
            fw.write("こんにちは。<br>内藤洋二朗です。");
            fw.close();
            
            //課題２　ファイルから読み出しと表示
            out.print("<br>課題２　ファイルから読み出しと表示<br>");
            FileReader fr = new FileReader(fp);
            //out.print(fr+"<br>");　ファイルリーダーは読めない
            BufferedReader br = new BufferedReader(fr);
            //out.print(br+"<br>");　バッファリーダーも読めない
            out.print(br.readLine());
            fr.close();
            
            //課題３　標準クラスを利用して処理を作成
            out.print("<br><br>課題３　標準クラスを利用して処理を作成<br>");
            //開始処理
            File flog = new File("log.txt");
            FileWriter flw = new FileWriter(flog,true);
            flw.write(ReturnNow()+"開始<br>");
            //処理内容
            HashSet<String> hs = new HashSet();
            hs.add("内");
            hs.add("藤");
            hs.add("洋");
            hs.add("二");
            hs.add("朗");
            for (int i=0 ;i<s1.length() ; i++){
                hs.add(s1.substring(i,i+1));
            }
            for (String a:hs){
                out.print(a);
            }
            out.print("<br>");
            //終了処理
            flw.write(ReturnNow()+"終了<br>");
            flw.close();
            
            //ログ表示
            FileReader flr = new FileReader(flog);
            BufferedReader blr = new BufferedReader(flr);
            out.print(blr.readLine()+"<br>");
            flr.close();
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TimeStamp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimeStamp at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

