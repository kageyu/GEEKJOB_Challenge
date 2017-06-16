/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

/**
 *
 * @author guest1Day
 */


import java.sql.Timestamp;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

public class UserDataBeans implements Serializable {
    public UserDataBeans(){}
   
    //フィールドを宣言
    //フォームからの格納は全てStringで取り出すときにintに変換します
    //アクセスチェック用のフィールドも用意
    private int ac = 0;
    private String name    = "";
    private String year    = "0";
    private String month   = "0";
    private String day     = "0";
    private String tell    = "";
    private String type    = "0";
    private String comment = "";
    private int sum;
    final private String[] types = {"エンジニア","営業","その他"};
    
    //C#のtryparse的なメソッドをネットから拾ってきてコピペ
    public boolean isNumber(String val) {
	try {
		Integer.parseInt(val);
		return true;
	} catch (NumberFormatException nfex) {
		return false;
	}
}

    //全入力項目をチェックしてから格納するメソッド
    public void setAll(HttpServletRequest request){
        
            this.sum = 0;
        if(!request.getParameter("name").equals("")){
            this.name    = request.getParameter("name");
            this.sum++;
        }
        if(!request.getParameter("year").equals("null") && isNumber(request.getParameter("year"))){
            this.year    = request.getParameter("year");
            this.sum++;
        }
        if(!request.getParameter("month").equals("null") && isNumber(request.getParameter("month"))){
            this.month   = request.getParameter("month");
            this.sum++;
        }
        if(!request.getParameter("day").equals("null") && isNumber(request.getParameter("day"))){
            this.day     = request.getParameter("day");
            this.sum++;
        }
        if(null != request.getParameter("type") && isNumber(request.getParameter("type"))){
            this.type    = request.getParameter("type");
            this.sum++;
        }
        if(!request.getParameter("tell").equals("")){
            this.tell    = request.getParameter("tell");
            this.sum++;
        }
        if(!request.getParameter("comment").equals("")){
            this.comment = request.getParameter("comment");
            this.sum++;
        }
    }
    
    //入力漏れがないか判定するメソッド
    public boolean getBoo(){
        return this.sum==7;
    }
    
    //getter/setter
    //生年月日と種別はgetterを2つ用意
    public void setAc(int ac){
        this.ac = ac;
    }
    public int getAc(){
        return ac;
    }
    
    public String getName(){
        return name;
    }
    
    public String getYear(){
        return year;
    }
    public int getYearInt(){
        return Integer.parseInt(year);
    }
    
    public String getMonth(){
        return month;
    }
    public int getMonthInt(){
        return Integer.parseInt(month);
    }
    
    public String getDay(){
        return day;
    }
    public int getDayInt(){
        return Integer.parseInt(day);
    }
    
    public String getTell(){
        return tell;
    }
    
    public String getType(){
        return types[Integer.parseInt(type)-1];
    }
    public int getTypeInt(){
        return Integer.parseInt(type);
    }
    
    public String getComment(){
        return comment;
    }
    
}