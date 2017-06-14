/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataChallenge;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class SessionOutput extends HttpServlet {
    
    //現在の時刻を文字列として出力するメソッドを作成
    public String ReturnNow(){
         Date d  = new Date();
        Calendar c = Calendar.getInstance();
         c.setTime(d);
         c.add(Calendar.MONTH, 1);
         return(c.get(Calendar.YEAR)       +"/"+c.get(Calendar.MONTH) +"/"+c.get(Calendar.DAY_OF_MONTH)
           +" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));            
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
                        
            //文字コードの指定
            request.setCharacterEncoding("UTF-8");
            
            //入力されたデータをセッションに追加
            HttpSession hs = request.getSession();
            String[] str={"name","sex","hobby"};
            for(String s:str){
                if(request.getParameter(s)!=null){
                    hs.setAttribute(s, request.getParameter(s));
                }
            }
            //日付情報をセッションに追加
            hs.setAttribute("Date",ReturnNow());
            
            //jsp呼び出し
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Session.jsp");
            rd.forward(request,response);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SessionOutput</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SessionOutput at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
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
