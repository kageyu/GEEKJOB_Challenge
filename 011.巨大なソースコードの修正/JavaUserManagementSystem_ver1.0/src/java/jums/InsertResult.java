package jums;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jums.UserDataBeans;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
        
        //セッションスタート　セッションから引き出すだけなので文字コード宣言は必要ないと考えています
        HttpSession session = request.getSession();
        UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
        
        try{
            //課題２　アクセスチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)udb.getAc()!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }

            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            UserDataDTO userdata = new UserDataDTO();
            userdata.setName((String)udb.getName());
            
            //SimpleDateFormatを使って文字列型から変形
            try {
                String year  = (String)udb.getYear();
                String month = (String)udb.getMonth();
                String day   = (String)udb.getDay();

                String strDate = year+"/"+month+"/"+day;

                SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date birthday = sdFormat.parse(strDate);
                userdata.setBirthday(birthday);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            userdata.setType((Integer)udb.getTypeInt());
            userdata.setTell((String)udb.getTell());
            userdata.setComment((String)udb.getComment());
            
            //DBへデータの挿入
            UserDataDAO .getInstance().insert(userdata);
            
            //表示後にセッションの削除
            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
            session.removeAttribute("udb");
            System.out.println("Session deleted!!");
            
            
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
