package jums;

import java.util.ArrayList;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを定数として設定
    private final String homeURL = "Index";
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    
    //検索結果へのリンクを定数として設定
    private final String SR_URL = "SearchResult";
    
    //検索結果へのリンクを返却
    public String SR(){
        return "<a href=\""+SR_URL+"\"> 検索結果に戻る</a>";
    }
    //検索画面へのリンクを定数として設定
    private final String S_URL = "Search";
    
    //検索画面へのリンクを返却
    public String S(){
        return "<a href=\""+S_URL+"\"> 検索画面に戻る</a>";
    }
    
    //詳細画面へのリンクを定数として設定
    private final String RD_URL = "resultdetail.jsp";
    
    //詳細画面へ戻るボタンを返却
    public String RD(){
        return "<form action=\"ResultDetail\" method=\"POST\">\n" +
"<input type=\"submit\" name=\"NO\" value=\"詳細画面に戻る\"style=\"width:120px\">\n" +
"</form>";
    }
    
    /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が
     * 未入力なのかのhtml文を返却する
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("year")){
                    output +="年";
                }
                if(val.equals("month")){
                    output +="月";
                }
                if(val.equals("day")){
                    output +="日";
                }
                if(val.equals("type")){
                    output +="種別";
                }
                if(val.equals("tell")){
                    output +="電話番号";
                }
                if(val.equals("comment")){
                    output +="自己紹介";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    /**
     * 種別は数字で取り扱っているので画面に表示するときは日本語に変換
     * @param i
     * @return 
     */
    public String exTypenum(int i){
        switch(i){
            case 1:
                return "営業";
            case 2:
                return "エンジニア";
            case 3:
                return "その他";
        }
        return "";
    }
}
