/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author guest1Day
 */
public class DB_challenge11 extends HttpServlet {
    
    //１レコードを表示するメソッドを作成
    public void printData (ResultSet db_data,PrintWriter out){
        try{
        int    ID       = db_data.getInt("itemID");
        String name     = db_data.getString("name");
        out.print(ID+" , "+name+"<br>");
        
        }catch(SQLException e_sql){
            System.out.println("接続時にエラーが発生しました。"+e_sql.getMessage());
        }catch(Exception e){
            System.out.println("接続時にエラーが発生しました。"+e.getMessage());
        }
    }    
//不要そうなので最後に消します
//        //入力内容をセッションに格納するメソッドを作成
//        public void AddSession (HttpSession hs,String name,String pass){
//            hs.setAttribute("name",name);
//            hs.setAttribute("pass",pass);
//        }    
    
    //課題内容をメソッド内に記述
     public void DB_challenge11(PrintWriter out,HttpServletRequest request, HttpServletResponse response){
         
        //変数を宣言
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","kageyu","1234321");
            
            //入力データの格納
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");
            
            //パスワード照会
            db_st = db_con.prepareStatement("SELECT * FROM UserTable WHERE name LIKE ? AND pass = ?");
            db_st.setString(1,"%"+name+"%");
            db_st.setString(2,pass);
            db_data = db_st.executeQuery();
            
            //検索結果の件数を取得
            int i = 0;
            while(db_data.next()){
                i++;
            }
            
            //セッションに入力内容を追加
            HttpSession hs = request.getSession();
            hs.setAttribute("name",name);
            hs.setAttribute("pass",pass);
            //1件の時にログイン判定を追加
            if(i == 1){
                hs.setAttribute("login","in");
            //nullの時にログイン判定を初期化
            }else if(name == null && pass == null){
                hs.removeAttribute("login");
            }else{
            //それ以外の時にエラー判定を追加
            //前提として、DB登録時にnameがユニークか判定して2件以上hitすることがないようにします
                hs.setAttribute("login","error");
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/DB_challenge11.jsp");
            rd.forward(request,response);
            
            //終了処理
            db_data.close();
            db_st.close();
            db_con.close();
            
        }catch(SQLException e_sql){
            System.out.println("接続時にエラーが発生しました。"+e_sql.getMessage());
        }catch(Exception e){
            System.out.println("接続時にエラーが発生しました。"+e.getMessage());
        }finally{
            if(db_con != null){
                try{
                    db_con.close();
                }catch(Exception e_con){
                    System.out.println(e_con.getMessage());
                }
            }
        }
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ログイン結果</title>");            
            out.println("</head>");
            out.println("<body>");
            
            DB_challenge11(out,request,response);
            
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
