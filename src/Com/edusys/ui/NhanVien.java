  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Com.edusys.ui;

import Com.edusys.DAO.NhanVienDao;
import Com.edusys.model.nhanVien;
import Com.edusys.utility.DialogHelper;
import Com.edusys.utility.ShareHelper;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vha74
 */
public class NhanVien extends javax.swing.JFrame {

    private final NhanVienDao Dao = new NhanVienDao();
    DefaultTableModel mol = new DefaultTableModel();
    int index = 0;

    /**
     * Creates new form NhanVien
     */
    public NhanVien() {
        initComponents();
        init();
        mol = (DefaultTableModel) tbl_nhanvien.getModel();
        if (ShareHelper.USER == null) {
            this.load();
        } else {
            DialogHelper.alert(this, "Vui lòng đăng nhập lại");
            this.tabs.removeAll();
        }
    }

    void init() {
        setIconImage(ShareHelper.APP_ICON);
        setLocationRelativeTo(null);
    }

    void load() {
        mol.setRowCount(0);
        try {
            List<nhanVien> list = Dao.select();
            for (nhanVien nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getMatKhau(),
                    nv.getHoTen(),
                    nv.getRole()
                };
                mol.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    nhanVien getmodel() {
        nhanVien molVien = new nhanVien();
        molVien.setHoTen(txtName.getText());
        molVien.setMaNV(txtMa.getText());
        molVien.setMatKhau(txtMK.getText());
        molVien.setMatKhau(txtAmk.getText());
        if (molVien.isVaiTro() == true) {
            rdo_truongphong.setSelected(true);
        } else {
            rdo_nhanvien.setSelected(true);
        }
        return molVien;
    }

    void clear() {
        txtAmk.setText("");
        txtMK.setText("");
        txtMa.setText("");
        txtName.setText("");
    }

    void setmodel(nhanVien x) {
        txtMa.setText(x.getMaNV());
        txtAmk.setText(x.getMatKhau());
        txtMK.setText(x.getMatKhau());
        txtName.setText(x.getHoTen());
        if (x.isVaiTro() == true) {
            rdo_truongphong.setSelected(true);
        } else {
            rdo_nhanvien.setSelected(true);
        }
    }

    void edit() {
        try {
            String manv = (String) tbl_nhanvien.getValueAt(this.index, 0);
            nhanVien nh = Dao.findById(manv);
            if (nh != null) {
                this.setmodel(nh);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setStatus(boolean insertable) {
        txtMa.setEditable(insertable);
        btn_add.setEnabled(insertable);
        btn_del.setEnabled(!insertable);
        btn_sua.setEnabled(!insertable);

        boolean first = this.index > 0;
        boolean last = this.index < tbl_nhanvien.getRowCount() - 1;
        btn_frist.setEnabled(!insertable && first);
        btn_prev.setEnabled(!insertable && first);
        btn_next.setEnabled(!insertable && last);
        btn_last.setEnabled(!insertable && last);
    }

    void insert() {
        nhanVien moVien = getmodel();
        try {
            Dao.insert(moVien);
            this.load();
            this.clear();
            DialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm thất bại");
        }
    }

    void del() {
        if (DialogHelper.confirm(this, "Bạn có chắc muốn xóa ko?")) {
            String manv = txtMa.getText();
            try {
                Dao.delete(manv);
                this.load();
                this.clear();
                DialogHelper.alert(this, "Xóa thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Xóa thất bại");
            }
        }
    }

    void update() {
        nhanVien moVien = getmodel();
        try {
            Dao.update(moVien);
            this.load();
            this.clear();
            DialogHelper.alert(this, "update thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "update thất bại");
        }
    }

    @SuppressWarnings("unchecked")
    boolean flag = false;

    void check() {
        if (txtMa.getText().length() > 5 || txtMa.getText().length() < 5) {
            DialogHelper.alert(this, "Mã chuyên đề phải nhập đúng 5 ký tự");
        } else if (txtName.getText().length() == 0) {
            DialogHelper.alert(this, "Tên chuyên đề không được bỏ trống");
        } else if (!txtName.getText().matches("[a-zA-Z][a-zA-Z ]+")) {
            DialogHelper.alert(this, "Tên chuyên đề chỉ chứa alphabet và ký tự trắng");
        } else {
            flag = true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMK = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAmk = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdo_truongphong = new javax.swing.JRadioButton();
        rdo_nhanvien = new javax.swing.JRadioButton();
        btn_add = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();
        btn_frist = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nhanvien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản lý nhân viên quản trị");

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Mật khẩu");

        jLabel4.setText("Xác nhận mật khẩu");

        jLabel5.setText("Họ và tên");

        jLabel6.setText("Vai trò");

        buttonGroup1.add(rdo_truongphong);
        rdo_truongphong.setText("Trưởng phòng");

        buttonGroup1.add(rdo_nhanvien);
        rdo_nhanvien.setText("Nhân viên");

        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_del.setText("Xóa");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_new.setText("Mới");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_frist.setText("|<");
        btn_frist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fristActionPerformed(evt);
            }
        });

        btn_prev.setText("<<");
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_next.setText(">>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_last.setText(">|");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_del)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_new)
                        .addGap(46, 46, 46)
                        .addComponent(btn_frist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_prev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_last)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa)
                            .addComponent(txtMK)
                            .addComponent(txtAmk)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdo_truongphong)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdo_nhanvien)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_truongphong)
                    .addComponent(rdo_nhanvien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_sua)
                    .addComponent(btn_del)
                    .addComponent(btn_new)
                    .addComponent(btn_frist)
                    .addComponent(btn_prev)
                    .addComponent(btn_next)
                    .addComponent(btn_last))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Cập nhật", jPanel1);

        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã NV", "Mật khẩu", "Họ và tên", "Vai trò"
            }
        ));
        tbl_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nhanvien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        tabs.addTab("Danh sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_btn_addActionPerformed

    private void tbl_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanvienMouseClicked
        if (evt.getClickCount() == 1) {
            this.index = tbl_nhanvien.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
                tabs.setSelectedIndex(0);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_nhanvienMouseClicked

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        update();
// TODO add your handling code here:
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        del();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_fristActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fristActionPerformed
        this.index = 0;
        this.edit();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_fristActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        this.index--;
        this.edit();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        this.index++;
        this.edit();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        this.index = tbl_nhanvien.getRowCount();
        this.edit();
// TODO add your handling code here:
    }//GEN-LAST:event_btn_lastActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_frist;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_sua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_nhanvien;
    private javax.swing.JRadioButton rdo_truongphong;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbl_nhanvien;
    private javax.swing.JTextField txtAmk;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
