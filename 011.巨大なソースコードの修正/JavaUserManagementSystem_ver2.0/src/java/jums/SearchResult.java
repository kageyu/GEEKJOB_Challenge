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
public class SearchResult extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");//リクエストパラメータ/セッションの文字コードをUTF-8に変更
            
            //検索用のUserDataBeansを宣言
            UserDataBeans udb = new UserDataBeans();
            
            //条件分岐用のフラグを宣言
            boolean frag = false;
            
            //セッションスタート
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            
            //アクセス元がSearchの場合フォームからの入力を取得してUserDataBeansに格納
            String accesschk = request.getParameter("ac");
            if(accesschk !=null && Integer.parseInt(accesschk)==(Integer)session.getAttribute("ac")){
                frag = true;
                udb.setName(request.getParameter("name"));
                udb.setYear(request.getParameter("year"));
                udb.setType(request.getParameter("type"));
                //検索条件が入ったUDBをセッションに格納（更新/削除後の表示の為にトップに戻るまで保持）
                session.setAttribute("searchcondition", udb);
            }
            
            //セッションに格納されているデータを元に条件分岐
            //アクセス元がSearch以外で検索結果のリストを保持している場合は何もせずにjspに飛ばす
            //検索条件を保持していれば引き出して検索
            if(frag || null == session.getAttribute("resultDataList")){
                if(null != session.getAttribute("searchcondition")){
                    udb = (UserDataBeans)session.getAttribute("searchcondition");
                
                    //UserDataBeansをDTOオブジェクトにマッピング。DB専用のパラメータに変換
                    UserDataDTO searchData = new UserDataDTO();
                    udb.UD2DTOMapping(searchData);

                    //検索
                    ArrayList<UserDataDTO> searchResultList = UserDataDAO .getInstance().search(searchData);
                    
                    //検索結果リストをUDBリストにマッピング
                    ArrayList<UserDataBeans> resultDataList = new ArrayList();
                    for(UserDataDTO searchResult: searchResultList){
                        UserDataBeans UDB = new UserDataBeans();
                        searchResult.DTO2UDMapping(UDB);
                        resultDataList.add(UDB);
                    }

                    //検索結果をセッションに格納（検索結果と詳細をスムーズに行き来するために、削除/更新に進むかトップに戻るまで保持）
                    session.setAttribute("resultDataList", resultDataList);

                //アクセス元がSearch以外で検索結果も検索条件もない場合はエラーページに飛ばします
                }else{
                    throw new Exception("不正なアクセスです");
                }
            }
            
            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);  
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
