/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.edusys.DAO;

import Com.edusys.model.nguoiHoc;
import Com.edusys.utility.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VuMinhHa
 */
public class NguoiHocDao {
    public void insert(nguoiHoc model) {
        String sql = "INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV,NgayDK) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
       
        jdbcHelper.executeUpdate(sql, model.getMaNH(), model.getHoTen(), model.getNgaySinh(), model.isGioiTinh(), model.getDienThoai(), model.getEmail(), model.getGhiChu(), model.getMaNV(),model.getNgayDK());
    }

    public void update(nguoiHoc model) {
        String sql = "UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?, MaNV=? WHERE MaNH=?";
        jdbcHelper.executeUpdate(sql, model.getHoTen(), model.getNgaySinh(), model.isGioiTinh(), model.getDienThoai(), model.getEmail(), model.getGhiChu(), model.getMaNV(), model.getMaNH());
    }

    public void delete(String id) {
        String sql = "DELETE FROM NguoiHoc WHERE MaNH=?";
        jdbcHelper.executeUpdate(sql, id);
    }

    public List<nguoiHoc> select() {
        String sql = "SELECT * FROM NguoiHoc";
        return select(sql);
    }

    public List<nguoiHoc> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public List<nguoiHoc> selectByCourse(Integer makh) {
        String sql = "SELECT * FROM NguoiHoc WHERE MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?)";
        return select(sql, makh);
    }

    public nguoiHoc findById(String manh) {
        String sql = "SELECT * FROM NguoiHoc WHERE MaNH=?";
        List<nguoiHoc> list = select(sql, manh);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<nguoiHoc> select(String sql, Object... args) {
        List<nguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    nguoiHoc model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {

                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private nguoiHoc readFromResultSet(ResultSet rs) throws SQLException {
        nguoiHoc model = new nguoiHoc();
        model.setMaNH(rs.getString("MaNH"));
        model.setHoTen(rs.getString("HoTen"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setDienThoai(rs.getString("DienThoai"));
        model.setEmail(rs.getString("Email"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setMaNV(rs.getString("MaNV"));
        model.setNgayDK(rs.getDate("NgayDK"));
        return model;
    }
}
