/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.edusys.Service;

import Com.edusys.model.HocVien;
import Com.edusys.DBconnect.HocVienRepository;
import java.util.List;

/**
 *
 * @author vha74
 */
public class HocVienService {
    HocVienRepository repo = new HocVienRepository();
    public HocVienService() {
    }
    public List<HocVien> getlistform(){
        return  repo.getlistfromDb();
    }
}
