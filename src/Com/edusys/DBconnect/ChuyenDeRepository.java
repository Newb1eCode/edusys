/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.edusys.DBconnect;

import Com.edusys.model.ChuyenDe;
import Com.edusys.utility.DBcontext;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vha74
 */
public class ChuyenDeRepository {

    DBcontext db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<ChuyenDe> listCD;

    public List<ChuyenDe> getlistfromDb() {
        String select = "select maCD,tenCD,hocPhi,thoiLuon,hinh,moTa from chuyenDe";
        listCD = new ArrayList<>();

        try {
            pst = db.getConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                listCD.add(new ChuyenDe(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChuyenDeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCD;
    }

    public String add(ChuyenDe x) {
        String add = "insert into chuyenDe(maCD,tenCD,hocPhi,thoiLuon,hinh,moTa) values (?,?,?,?,?,?)";

        try {
            pst = db.getConnection().prepareStatement(add);
            pst.setString(1, x.getMaCD());
            pst.setString(2, x.getTenCD());
            pst.setDouble(3, x.getHocPhi());
            pst.setInt(4, x.getThoiLuong());
            pst.setString(5, x.getHinh());
            pst.setString(6, x.getMoTa());
            return "Thêm thành công";
        } catch (SQLException ex) {
            Logger.getLogger(ChuyenDeRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Thêm thất bại ";
        }
    }
    public String delete(ChuyenDe x) {
        String add = "delete from chuyenDe where maCd=? ";

        try {
            pst = db.getConnection().prepareStatement(add);
            pst.setString(1, x.getMaCD());
            
            return "Xóa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(ChuyenDeRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Xóa thất bại ";
        }
    }
public String update(ChuyenDe x) {
        String add = "update chuyenDe set maCd =?, tenCd=?,hocPhi=?,thoiLuong=?,hinh=?,moTa=? where macd=?";

        try {
            pst = db.getConnection().prepareStatement(add);
            pst.setString(1, x.getMaCD());
            pst.setString(2, x.getTenCD());
            pst.setDouble(3, x.getHocPhi());
            pst.setInt(4, x.getThoiLuong());
            pst.setString(5, x.getHinh());
            pst.setString(6, x.getMoTa());
            pst.setString(7, x.getMaCD());
            return "Sửa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(ChuyenDeRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Sửa thất bại ";
        }
    }

}
