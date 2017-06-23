package jums;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class ResultDetail extends HttpServlet {

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
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

            //セッションに格納する用のUserDataBeansを宣言
            UserDataBeans udb = new UserDataBeans();
            
            //セッションに格納されているデータを元に条件分岐
            HttpSession session = request.getSession();
            //検索結果リストが無ければ個別の情報があるのでそれを取り出す(保守性×)
            if(null == session.getAttribute("resultDataList") && null != session.getAttribute("resultData")){
                udb = (UserDataBeans)session.getAttribute("resultData");
            }else if(null != session.getAttribute("resultDataList")){
                //セッションから検索結果リストを取り出す
                ArrayList<UserDataBeans> UDBList = (ArrayList<UserDataBeans>)session.getAttribute("resultDataList");

                //リンクで指定されていたIDのユーザー情報だけを選別
                int id = Integer.parseInt(request.getParameter("id"));
                for(UserDataBeans UDB : UDBList){
                    if(UDB.getUserID() == id){
                        udb = UDB;
                        break;
                    }
                }
            //検索結果も個別の情報もない場合はエラーページに飛ばす
            }else{
                throw new Exception("不正なアクセスです");
            }
            session.setAttribute("resultData", udb);
            
            request.getRequestDispatcher("/resultdetail.jsp").forward(request, response);  
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
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
