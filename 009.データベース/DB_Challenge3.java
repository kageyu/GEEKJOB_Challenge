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
public class DB_Challenge extends HttpServlet {
    
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
            
            //変数を宣言
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","kageyu","1234321");
                //追加データを設定
//                db_st = db_con.prepareStatement("INSERT INTO profiles VALUES (?,?,?,?,?)");
//                db_st.setInt(1,5);
//                db_st.setString(2,"内藤");
//                db_st.setString(5,"1990-10-01");
//                db_st.setString(3,"123-1234-1234");
//                db_st.setInt(4,26);
//                
//                db_st.executeUpdate();
                
                //全情報の取得と表示
                //取得
                db_st = db_con.prepareStatement("SELECT * FROM profiles");
                db_data = db_st.executeQuery();
                //表示
                while(db_data.next()){
                    printData (db_data,out);
                }
                out.print("<br>");
                
                
                //特定のレコードの情報取得と表示
                //レコードのIDを指定
                int i = 1;
                //指定したIDのレコードを取得
                db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE profilesID = ?");
                db_st.setInt(1,i);
                db_data = db_st.executeQuery();
                //取得したレコードの表示
                db_data.next();
                printData (db_data,out);
                out.print("<br>");
                
                
                //指定した文字列でレコードを検索
                db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE '%茂%'");
                db_data = db_st.executeQuery();
                //取得したレコードの表示
                db_data.next();
                printData (db_data,out);
                
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
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DB_Challenge</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DB_Challenge at " + request.getContextPath() + "</h1>");
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
