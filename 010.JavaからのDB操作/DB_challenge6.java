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

/**
 *
 * @author guest1Day
 */
public class DB_challenge6 extends HttpServlet {

    //１レコードを表示するメソッドを作成
    public void printData (ResultSet db_data,PrintWriter out){
        try{
        int    ID       = db_data.getInt("profilesID");
        String name     = db_data.getString("name");
        String tell     = db_data.getString("tell");
        int    age      = db_data.getInt("age");
        String birthday = db_data.getString("birthday");
        out.print(ID+" , "+name+" , "+tell+" , "+age+" , "+birthday+"<br>");
        
        }catch(SQLException e_sql){
                System.out.println("接続時にエラーが発生しました。"+e_sql.getMessage());
            }catch(Exception e){
                System.out.println("接続時にエラーが発生しました。"+e.getMessage());
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
            out.println("<title>検索結果</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //変数を宣言
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","kageyu","1234321");
                
                //入力データの格納
                request.setCharacterEncoding("UTF-8");
                String st = request.getParameter("name");
                //格納した文字列でレコードを検索
                db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ?");
                db_st.setString(1,"%"+st+"%");
                db_data = db_st.executeQuery();
                
                //検索結果が0件の場合の分岐表示
                if(!db_data.next()){
                    out.print(st+"を含むデータは見つかりませんでした。");
                }else{
                    //一度カーソルの位置を初期化
                    //没コードdb_data = db_st.executeQuery();
                    db_data.beforeFirst();
                    //取得したレコードを全件表示
                    while(db_data.next()){
                        printData (db_data,out);
                    }
                }
                
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
            
            
            
            
            out.println("<h1>Servlet DB_challenge6 at " + request.getContextPath() + "</h1>");
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
