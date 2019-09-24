package services;

import modeles.Users;

import java.sql.ResultSet;

public class Userdao {
    public Users logon(String login,String password){
        Users u = null;
            try {
                String sql = "SELECT * FROM user where login=? and password=?";
                DatabaseHelper db = DatabaseHelper.getInstance();
                db.iniPreparedCmd(sql);
                db.getPstmt().setString(1,login);
                db.getPstmt().setString(2,password);
                ResultSet rs = db.My_ExecutePrepareQuery();
                if (rs.next()){
                    u = new Users(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                }
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return u;
    }
}
