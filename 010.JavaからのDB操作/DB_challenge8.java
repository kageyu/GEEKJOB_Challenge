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
public class DB_challenge8 extends HttpServlet {
        public void DB_challenge8(PrintWriter out,HttpServletRequest request, HttpServletResponse response){
        //変数を宣言
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","kageyu","1234321");

            //入力データの格納
            request.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(request.getParameter("profilesID"));
            //IDが存在しない場合の分岐表示
            db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE profilesID = ?");
            db_st.setInt(1,id);
            db_data = db_st.executeQuery();
            int i = 0;
            while(db_data.next()){
                i = db_data.getInt("profilesID");
            }
            if(i == 0){
                out.print("そのIDは存在しません。");
                
            //削除処理
            }else{
                db_st = db_con.prepareStatement("DELETE FROM profiles where profilesID = ?");
                db_st.setInt(1,id);
                db_st.executeUpdate();
                out.print("削除されました。");
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
            out.println("<title>削除結果</title>");            
            out.println("</head>");
            out.println("<body>");
            
            DB_challenge8(out,request,response);
            
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
