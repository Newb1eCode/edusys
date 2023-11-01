/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.edusys.DBconnect;

import Com.edusys.model.ChuyenDe;
import Com.edusys.model.HocVien;
import Com.edusys.utility.DBcontext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vha74
 */
public class HocVienRepository {
    DBcontext db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<HocVien> list;

    public List<HocVien> getlistfromDb() {
        String select = "select maCD,tenCD,hocPhi,thoiLuon,hinh,moTa from chuyenDe";
        list = new ArrayList<>();

        try {
            pst = DBcontext.getConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new HocVien(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getDouble(4)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChuyenDeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
