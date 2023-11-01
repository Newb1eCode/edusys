/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.edusys.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Com.edusys.model.Login;
import Com.edusys.utility.DBcontext;
//import poly.edu.utility.DBcontext111;

/**
 *
 * @author ADMIN
 */
public class LoginDao {

//    List<Login> ls = new ArrayList<>();
//
//    public LoginDao() {
//        ls.add(new Login("admin", "12345", true));
//        ls.add(new Login("Tom", "12345", true));
//        ls.add(new Login("Bray", "12345", true));
//        ls.add(new Login("Maesew", "12345", true));
//        ls.add(new Login("Emmy", "12345", true));
//    }
    public  Login getEmployeeByID(String username){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Login lg = new Login();
        try {
            String sql = "select * from Users where username = ?";
            conn = DBcontext.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            while (rs.next()) {                
                lg.setUser(rs.getString(1));
                lg.setPass(rs.getString(2));
                lg.setRole(rs.getBoolean(3));
                return lg;
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        } finally {
            try {
                conn.close();
                rs.close();
                stm.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
//    public boolean checkLogin(String user, String pass) {
//        for (Login l : ls) {
//            if (l.getUser().equals(user)
//                    && l.getPass().equals(pass)) {
//                return true;
//            }
//        }
//        return false;
//    }
     public int add(Login lg) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "insert into Users values (?,?,?)";
            conn = DBcontext.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, lg.getUser());
            stm.setString(2, lg.getPass());
            stm.setBoolean(3, lg.getRole());
            if (stm.executeUpdate() > 0) {
                System.out.println("add Thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                conn.close();
                stm.close();
            } catch (Exception e) {

            }
        }
        return -1;
    }
    
     public boolean checkLogin(String user, String pass,boolean role) {
        Login lg = getEmployeeByID(user);
         if (lg != null) {
             if (lg.getPass().equals(pass)) {
                 return true;
             }
         }
        return false;
    }
}
