/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.edusys.Service;

import Com.edusys.model.ChuyenDe;
import Com.edusys.DBconnect.ChuyenDeRepository;
import java.util.List;

/**
 *
 * @author vha74
 */
public class ChuyenDeService {
    ChuyenDeRepository repo = new ChuyenDeRepository();

    public ChuyenDeService() {
    }
    public List<ChuyenDe> getListDB(){
        return repo.getlistfromDb();
    }
    public String addDB(ChuyenDe x){
        return repo.add(x);
                
    }
    public String delete(ChuyenDe x){
        return repo.delete(x);
                
    }
    public String update(ChuyenDe x){
        return repo.update(x);
                
    }
}
