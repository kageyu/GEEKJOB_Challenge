/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.*;


/**
 *
 * @author guest1Day
 */
public class Challenge11 extends HttpServlet {
//ユーザー定義メソッドのメソッド    
    void myprofile (PrintWriter pw){
        pw.print("私の名前は内藤です。<br>");
        pw.print("10月1日生まれです。<br>");
        pw.print("趣味は人と話すことです。<br>");
    }
    
//引数１のメソッド    
    void hikisu1 (int i,PrintWriter pw){
        if(i%2==0){
            pw.print(i+" は偶数です。<br>");
        }else{
            pw.print(i+" は奇数です。<br>");
        }
    }
    
//    void hikisu1 (int i){
//        if(i%2==0){
//            out.print("偶数です。<br>");
//        }else{
//            out.print("奇数です。<br>");
//        }
//    }
    
    
//引数２のメソッド
    void hikisu2 (int i,int j,boolean k,PrintWriter pw){
        int num = i*j;
        if (k == true){
            num = (i*j)^2;
        }
        pw.print(num+"<br><br>");
    }
    
//    void hikisu2 (int i,int j,boolean k){
//        int num = i*j;
//        if (k == true){
//            num = (i*j)^2;
//        }
//        out.print(num+"<br>");
//    }
    void hikisu2 (int i,int j,PrintWriter pw){
        hikisu2(i,j,false,pw);
    }
    void hikisu2(int i,boolean k,PrintWriter pw){
        hikisu2(i,5,k,pw);
    }
    void hikisu2(int i,PrintWriter pw){
        hikisu2(i,5,false,pw);
    }
    
    //戻り値１のメソッド    
    boolean modoriti1 (PrintWriter pw){
        pw.print("私の名前は内藤です。<br>");
        pw.print("10月1日生まれです。<br>");
        pw.print("趣味は人と話すことです。<br><br>");
        return true;
    }
    
    //戻り値２のメソッド
    ArrayList<String> modoriti2 (String a,String b,String c,String d){
        ArrayList<String> data1 = new ArrayList<>();
        data1.add(a);
        data1.add(b);
        data1.add(c);
        data1.add(d);
        return data1;
    }

//引数、戻り値１のメソッド
    ArrayList<String> hikimodo1 (String st){
        ArrayList<String> list1= modoriti2 ("abcd","内藤","10/1","東京都");
        ArrayList<String> list2 =modoriti2 ("1234","鈴木","1/22","埼玉県");
        ArrayList<String> list3 =modoriti2 ("1a2b","今井","1/21","長野県");
        if (st.equals("abcd")==true){
            return list1;
        }else if(st.equals("1234")==true){
            return list2;
        }else if(st.equals("1a2b")==true){
            return list3;
        }else{
            return null;
        }
    }
    
    
//引数、戻り値２のメソッド
        ArrayList<String> hikimodo2 (String st){
        ArrayList<String> list1= modoriti2 ("abcd","内藤","10/1",null);
        ArrayList<String> list2 =modoriti2 ("1234","鈴木","1/22","埼玉県");
        ArrayList<String> list3 =modoriti2 ("1a2b","今井","1/21","長野県");
        if (st.equals("abcd")==true){
            return list1;
        }else if(st.equals("1234")==true){
            return list2;
        }else if(st.equals("1a2b")==true){
            return list3;
        }else{
            return null;
        }
    }
        
//引数、戻り値２のおまけ実験＜メソッドの戻り値に静的配列を使う＞
        String[] hikimodo3 (String st){
            ArrayList<String> a = hikimodo2(st);
        String[] lista = {a.get(0),a.get(1),a.get(2),a.get(3)};
        return lista;
        }
    
//おまけ実験２＜メソッドの戻り値に連想配列を使う＞
        HashMap<String,String> hikimodo4 (String a,String b,String c,String d){
            HashMap<String,String> hm = new HashMap<>();
            hm.put("ID",a);
            hm.put("名前",b);
            hm.put("生年月日",c);
            hm.put("住所",d);
            return hm;
        }
        
//引数、戻り値３のメソッド
    ArrayList<String> hikimodo5 (String st){
        ArrayList<String> list1= modoriti2 ("abcd","内藤","10/1",null);
        ArrayList<String> list2 =modoriti2 ("1234","鈴木","1/22","埼玉県");
        ArrayList<String> list3 =modoriti2 ("1a2b","今井","1/21","長野県");
        if (st.equals("abcd")==true){
            return list1;
        }else if(st.equals("1234")==true){
            return list2;
        }else if(st.equals("1a2b")==true){
            return list3;
        }else{
            return null;
        }
    }
        
    Integer limit = 2;
        
        
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
            
            //ユーザー定義メソッドの表示部
            out.print("ユーザー定義メソッド<br>");
            for (int i = 0 ; i < 10 ; i++){
                out.print(i+1+"回目。<br>");
                myprofile(out);
            }
            out.print("<br>");
            
            //引数１の表示部
            out.print("引数１<br>");
            int[] ex = {1,2,3};
            for(int i:ex){
                hikisu1(i,out);
            }
            out.print("<br>");
            
            //引数２の表示部
            out.print("引数２<br>");
            hikisu2(500,out);
            
            //戻り値１の表示部
            out.print("戻り値１<br>");
            if(modoriti1(out)==true){
                out.print("この処理は正しく実行できました<br><br>");
            }else{
                out.print("この処理は正しく実行できませんでした<br><br>");
            }
            
            //戻り値２の表示部
            out.print("戻り値２<br>");
            ArrayList<String> t = modoriti2("0000","内藤","1990/10/1","東京都");
            for (int i=1;i<4;i++){
                out.print(t.get(i)+" , ");
            }
            
            //引数、戻り値１の表示部
            out.print("<br><br>引数、戻り値１<br>");
            ArrayList<String> s = hikimodo1("1234");
            for (int i=0;i<3;i++){
                out.print(s.get(i+1)+" , ");
            }
            
            //引数、戻り値２の表示部
            out.print("<br><br>引数、戻り値２<br>");
            String[] u = {"abcd","1234","1a2b"};
            for (String v:u){
                ArrayList<String> w = hikimodo2(v);
                for(int i=0;i<3;i++){
                    String z = w.get(i+1);
//                    if(z.equals(null)==true){
//                        out.print("イコール機能してます。");
//                        continue;
//                    }else 
                    if(z==null){
                        //out.print("＝＝機能してます。");
                        continue;
                    }
                    out.print(z+" , ");
                }
                out.print("<br>");
            }
            
            //引数、戻り値２の実験表示部
            out.print("<br>やってみよう！大科学実験<br>");
            String[] ab = hikimodo3("abcd");
            out.print(ab[2]);
            
            //実験その２表示部
            out.print("<br><br>やってみよう！大科学実験２<br>");
            HashMap<String,String> ad = hikimodo4("5678","百瀬","5/10","東京都");
            for (Map.Entry<String,String> ac:ad.entrySet()){
                out.print(ac.getKey()+" : "+ac.getValue()+"<br>");
            }
            
            
            //引数、戻り値３の表示部
            out.print("<br><br>引数、戻り値３<br>");
            
            int y = 0;
            String[] x = {"abcd","1234","1a2b"};
            for (String v:x){
                if(y==limit){
                    break;
                }
                y++;
                ArrayList<String> w = hikimodo2(v);
                for(int i=0;i<3;i++){
                    if(w.get(i+1)==null){
                        continue;
                    }
                    out.print(w.get(i+1)+" , ");
                }
                out.print("<br>");
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Challenge11</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Challenge11 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
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
