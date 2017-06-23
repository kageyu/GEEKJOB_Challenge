package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの更新処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ud.setNewDate(new Timestamp(System.currentTimeMillis()));
        
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET name=?,birthday=?,tell=?,type=?,comment=?,newDate=? WHERE userID=? ");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, ud.getNewDate());
            st.setInt(7, ud.getUserID());
            
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの削除処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void delete(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("DELETE FROM user_t WHERE userID = ?");
            st.setInt(1, ud.getUserID());
            st.executeUpdate();
            System.out.println("delete completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            //入力に従ってSQL文とフラッグを操作
            String sql = "SELECT * FROM user_t";
            boolean flag = false;
            boolean FN = false;
            boolean FT = false;
            boolean FY = false;
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
                FN = true;
            }
            if (ud.getBirthday()!=null) {
                if(!flag){
                    ////
                    sql += " WHERE birthday like ?";
                    flag = true;
                }else{
                    sql += " AND birthday like ?";
                }
                FY = true;
            }
            if (ud.getType()!=0) {
                if(!flag){
                    sql += " WHERE type = ?";
                }else{
                    sql += " AND type = ?";
                }
                FT = true;
            }
            st =  con.prepareStatement(sql);
            
            //入力があった場合の分岐 6パターン
            if(FN){
                st.setString(1, "%"+ud.getName()+"%");
                if(FY){
                    st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                    if(FT){
                        st.setInt(3, ud.getType());
                    }
                }else if(FT){
                    st.setInt(2, ud.getType());
                }
            }else if(FY){
                st.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                if(FT){
                    st.setInt(2, ud.getType());
                }
            }else if(FT){
                st.setInt(1, ud.getType());
            }
            
            ResultSet rs = st.executeQuery();
            
            ArrayList<UserDataDTO> UDD = new ArrayList();
            
            while(rs.next()){
                UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
                UDD.add(resultUd);
            }
            System.out.println("search completed");

            return UDD;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
}
