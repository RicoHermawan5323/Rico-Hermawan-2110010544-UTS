/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

/**
 *
 * @author Rico Hermawan
 */
import java.sql.*;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class frmKeluar extends javax.swing.JFrame {

    /**
     * Creates new form frmKeluar
     */
    public Statement st;
    public ResultSet rs;
    Connection kon = Config.classKoneksi.BukaKoneksi();
    public frmKeluar() {
        initComponents();
        Bersih();
        TampilData(); 
    }
    private void Bersih(){
               
        tNoKwitansi.setText("");
        tKode.setText("");
        tNama.setText("");
        tMerk.setText("");  
        tJumlah.setText("");
        tStokAwal.setText("");
        tStokAkhir.setText("");
        
        dTanggal.setEnabled(false);
        tNoKwitansi.setEnabled(false);
        tKode.setEnabled(false);
        tNama.setEnabled(false);
        tMerk.setEnabled(false);
        tJumlah.setEnabled(false);
        tStokAwal.setEnabled(false);
        

        
        bCariBarang.setEnabled(false);
        bTambah.setEnabled(true);
        bUbah.setEnabled(false);
        bHapus.setEnabled(false);
        bBatal.setEnabled(false);
        bSimpan.setEnabled(false);
        bKeluar.setEnabled(true);
        
        tblKeluar.setEnabled(true);
        dCari.setEnabled(true);
        bCari.setEnabled(true);
        bRefresh.setEnabled(true);
        
        tStokAkhir.setVisible(false);
        tJumlahAwal.setVisible(false);
    }
    
   private void TampilData(){
        try {
            st = kon.createStatement();
            String sql = "SELECT * FROM barangkeluar";
            rs = st.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Tanggal");
            model.addColumn("No Kwitansi");
            model.addColumn("Kode Barang");
            model.addColumn("Jumlah");
            
            int no = 1;   
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {                    
                    no++,
                    rs.getString("tanggal"),
                    rs.getString("no_kwitansi"),
                    rs.getString("kode"),
                    rs.getString("jumlah")
                };    
                model.addRow(data);
                tblKeluar.setModel(model);
            }
        } catch (Exception e) {
        }
    }
    private void CariDataBarang(){
        try {
            st = kon.createStatement();
            String sql = "SELECT * FROM barang WHERE kode = '"+tKode.getText()+"'";
            rs = st.executeQuery(sql);                                    
            if (rs.next()) {
                tKode.setText(rs.getString("kode"));  
                tNama.setText(rs.getString("nama"));  
                tMerk.setText(rs.getString("merk")); 
                tStokAwal.setText(rs.getString("stok")); 
                tJumlah.requestFocus();
                
            } else {
                JOptionPane.showMessageDialog(null, "Maaf kode barang tidak ditemukan","Validasi",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (Exception e) {
        }
    }
    private void CariData(){
        try {
            st = kon.createStatement();
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(dCari.getDate()));           
            String sql = "SELECT * FROM barangkeluar WHERE tanggal = '"+tanggal+"%'";
            rs = st.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Tanggal");
            model.addColumn("No Kwitansi");
            model.addColumn("Kode Barang");
            model.addColumn("Jumlah");
            
            int no = 1;   
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {                    
                    no++,
                    rs.getString("tanggal"),
                    rs.getString("no_kwitansi"),
                    rs.getString("kode"),
                    rs.getString("jumlah")
                };    
                model.addRow(data);
                tblKeluar.setModel(model);
            }
        } catch (Exception e) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dTanggal = new com.toedter.calendar.JDateChooser();
        tKode = new javax.swing.JTextField();
        bCariBarang = new javax.swing.JButton();
        tNama = new javax.swing.JTextField();
        tMerk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tJumlah = new javax.swing.JTextField();
        bTambah = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bKeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKeluar = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        dCari = new com.toedter.calendar.JDateChooser();
        bCari = new javax.swing.JButton();
        bRefresh = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tNoKwitansi = new javax.swing.JTextField();
        tStokAwal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tStokAkhir = new javax.swing.JTextField();
        tJumlahAwal = new javax.swing.JTextField();
        bCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("BARANG KELUAR");

        jLabel2.setText("Tanggal");

        jLabel3.setText("Kode Barang");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Merk");

        dTanggal.setDateFormatString("d MMM, yyyy");

        bCariBarang.setText("Cari Barang");
        bCariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariBarangActionPerformed(evt);
            }
        });

        tNama.setEnabled(false);

        tMerk.setEnabled(false);

        jLabel6.setText("Jumlah");

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bBatal.setText("Batal");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bKeluar.setText("Keluar");
        bKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKeluarActionPerformed(evt);
            }
        });

        tblKeluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Tanggal", "No Kwitansi", "Kode Barang", "Jumlah"
            }
        ));
        tblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKeluarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKeluar);

        jLabel7.setText("Cari Tanggal");

        dCari.setDateFormatString("d MMM, yyyy");

        bCari.setText("Cari Data");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        bRefresh.setText("Refresh");
        bRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshActionPerformed(evt);
            }
        });

        jLabel8.setText("No. Kwitansi");

        tStokAwal.setEnabled(false);

        jLabel9.setText("Stok Awal");

        tStokAkhir.setEnabled(false);
        tStokAkhir.setFocusable(false);

        bCetak.setText("Cetak");
        bCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(tNama, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(bCariBarang)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(tMerk, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tJumlah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tStokAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(bTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bBatal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bKeluar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addComponent(jLabel7)
                                    .addGap(30, 30, 30)
                                    .addComponent(dCari, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bCari)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bRefresh)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bCetak))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel2)
                                .addGap(54, 54, 54)
                                .addComponent(dTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(tNoKwitansi, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tJumlahAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tStokAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tStokAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tNoKwitansi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tJumlahAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bCariBarang)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tStokAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bUbah)
                    .addComponent(bHapus)
                    .addComponent(bBatal)
                    .addComponent(bSimpan)
                    .addComponent(bKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bCari)
                        .addComponent(bRefresh)
                        .addComponent(bCetak))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariBarangActionPerformed
        // TODO add your handling code here:
        CariDataBarang();

    }//GEN-LAST:event_bCariBarangActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        dTanggal.setEnabled(true);
        tNoKwitansi.setEnabled(true);
        tKode.setEnabled(true);
        tNama.setEnabled(false);
        tMerk.setEnabled(false);
        tJumlah.setEnabled(true);
        tStokAwal.setEnabled(false);
        dTanggal.requestFocus();

        bCariBarang.setEnabled(true);
        bTambah.setEnabled(true);
        bUbah.setEnabled(false);
        bHapus.setEnabled(false);
        bBatal.setEnabled(true);
        bSimpan.setEnabled(true);
        bKeluar.setEnabled(false);

        tblKeluar.setEnabled(false);
        dCari.setEnabled(false);
        bCari.setEnabled(false);
        bRefresh.setEnabled(false);
    }//GEN-LAST:event_bTambahActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        // TODO add your handling code here:
        dTanggal.setEnabled(true);
        tNoKwitansi.setEnabled(false);
        tKode.setEnabled(true);
        tNama.setEnabled(false);
        tMerk.setEnabled(false);
        tJumlah.setEnabled(true);
        tStokAwal.setEnabled(false);
        dTanggal.requestFocus();

        bCariBarang.setEnabled(true);
        bTambah.setEnabled(false);
        bUbah.setEnabled(true);
        bHapus.setEnabled(false);
        bBatal.setEnabled(true);
        bSimpan.setEnabled(true);
        bKeluar.setEnabled(false);

        tblKeluar.setEnabled(false);
        dCari.setEnabled(false);
        bCari.setEnabled(false);
        bRefresh.setEnabled(false);
    }//GEN-LAST:event_bUbahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        if (tNoKwitansi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon pilih data yang ingin dihapus terlebih dahulu");
        } else {
            int jawab = JOptionPane.showConfirmDialog(null, "Apakah yakin data barang No. Kwitansi "+tNoKwitansi.getText()+" akan dihapus?","Konfirmasi",JOptionPane.YES_NO_OPTION);
            if (jawab==0) {
                try {
                    //update stok                
                    int stokawal = Integer.valueOf(tStokAwal.getText());
                    int jumlahawal = Integer.valueOf(tJumlahAwal.getText());                    
                    int stokakhir = stokawal+jumlahawal;

                    st = kon.createStatement();
                    //update stok barang
                    String updatestok = "UPDATE barang SET stok = '"+String.valueOf(stokakhir)+                                               
                        "' WHERE kode = '"+tKode.getText()+"'";
                    st.executeUpdate(updatestok);
                    
                    st = kon.createStatement();
                    String hapus = "DELETE FROM barangkeluar WHERE no_kwitansi='"+tNoKwitansi.getText()+"'";
                    st.execute(hapus);
                    JOptionPane.showMessageDialog(null, "Data barang masuk no.kwitansi "+tNoKwitansi.getText()+" berhasil dihapus");
                    Bersih();
                    TampilData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        // TODO add your handling code here:
        Bersih();
        TampilData();
    }//GEN-LAST:event_bBatalActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        int jawab = JOptionPane.showConfirmDialog(null, "Apakah yakin menyimpan data?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab==0) {
            try {
                st = kon.createStatement();
                Date cektanggal;
                cektanggal = dTanggal.getDate();
                if (cektanggal == null || tNoKwitansi.getText().equals("") || tKode.getText().equals("") || tNama.getText().equals("") || tMerk.getText().equals("") || tJumlah.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong","Validasi",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (bTambah.isEnabled()) {
                    //cek kode
                    String cekkwitansi = "SELECT * FROM barangkeluar WHERE no_kwitansi='"+tNoKwitansi.getText()+"'";
                    rs = st.executeQuery(cekkwitansi);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Maaf no kwitansi barang masuk sudah ada");
                    } else {
                        int stokawal = Integer.valueOf(tStokAwal.getText());
                        int jumlah = Integer.valueOf(tJumlah.getText());
                        int stokakhir = stokawal-jumlah;
                        
                        if (stokakhir<0) {
                            JOptionPane.showMessageDialog(null, "Maaf stok tidak cukup untuk jumlah pembelian yang diminta");
                            
                        } else {
                            //insert
                            String tampilan = "yyyy-MM-dd";
                            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
                            String tanggal = String.valueOf(fm.format(dTanggal.getDate()));
                            String sql = "INSERT INTO barangkeluar (tanggal,no_kwitansi,kode,jumlah) VALUES ('"+tanggal+
                            "','"+tNoKwitansi.getText()+
                            "','"+tKode.getText()+
                            "','"+tJumlah.getText()+"')";
                            st.executeUpdate(sql);
                            //update stok

                            st = kon.createStatement();
                            //update stok barang
                            String updatestok = "UPDATE barang SET stok = '"+String.valueOf(stokakhir)+
                            "' WHERE kode = '"+tKode.getText()+"'";
                            st.executeUpdate(updatestok);
                            JOptionPane.showMessageDialog(null, "Berhasil menambah data");
                            Bersih();
                            TampilData();
                        }
                    }

                } else if (bUbah.isEnabled()) {
                    //update
                    int stokawal = Integer.valueOf(tStokAwal.getText());
                    int jumlahawal = Integer.valueOf(tJumlahAwal.getText());
                    int jumlah = Integer.valueOf(tJumlah.getText());
                    int stokakhir = stokawal+jumlahawal-jumlah;
                    if (stokakhir<0) {
                            JOptionPane.showMessageDialog(null, "Maaf stok tidak cukup untuk jumlah pembelian yang diminta");
                            
                    } else {
                        String tampilan = "yyyy-MM-dd";
                        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
                        String tanggal = String.valueOf(fm.format(dTanggal.getDate()));
                        String sql = "UPDATE barangkeluar SET tanggal = '"+tanggal+
                        "', jumlah = '"+tJumlah.getText()+
                        "' WHERE no_kwitansi = '"+tNoKwitansi.getText()+"'";
                        st.executeUpdate(sql);

                        //update stok
                        st = kon.createStatement();
                        //update stok barang
                        String updatestok = "UPDATE barang SET stok = '"+String.valueOf(stokakhir)+
                        "' WHERE kode = '"+tKode.getText()+"'";
                        st.executeUpdate(updatestok);
                        JOptionPane.showMessageDialog(null, "Berhasil mengubah data");
                        Bersih();
                        TampilData();
                    }

                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_bSimpanActionPerformed

    private void bKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bKeluarActionPerformed

    private void tblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKeluarMouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel model = (DefaultTableModel)tblKeluar.getModel();
            int index = tblKeluar.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-mm-dd").parse((String)model.getValueAt(index,1));
            dTanggal.setDate(date);
        } catch (Exception e) {
        }
        tNoKwitansi.setText(tblKeluar.getValueAt(tblKeluar.getSelectedRow(),2).toString());
        if (!tNoKwitansi.getText().equals("")) {

            tNoKwitansi.setText(tblKeluar.getValueAt(tblKeluar.getSelectedRow(),2).toString());
            tKode.setText(tblKeluar.getValueAt(tblKeluar.getSelectedRow(),3).toString());
            tJumlah.setText(tblKeluar.getValueAt(tblKeluar.getSelectedRow(),4).toString());
            tJumlahAwal.setText(tblKeluar.getValueAt(tblKeluar.getSelectedRow(),4).toString());
            CariDataBarang();

            bCariBarang.setEnabled(false);
            bTambah.setEnabled(false);
            bUbah.setEnabled(true);
            bHapus.setEnabled(true);
            bBatal.setEnabled(true);
            bSimpan.setEnabled(false);
            bKeluar.setEnabled(false);
        }
    }//GEN-LAST:event_tblKeluarMouseClicked

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        CariData();
    }//GEN-LAST:event_bCariActionPerformed

    private void bRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshActionPerformed
        // TODO add your handling code here:
        Bersih();
        TampilData();
    }//GEN-LAST:event_bRefreshActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_formWindowClosed

    private void bCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetakActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Laporan Data Barang Keluar");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try{
            tblKeluar.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Gagal mencetak %s%n", e.getMessage());
        }
    }//GEN-LAST:event_bCetakActionPerformed

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
            java.util.logging.Logger.getLogger(frmKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmKeluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bCariBarang;
    private javax.swing.JButton bCetak;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bKeluar;
    private javax.swing.JButton bRefresh;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bUbah;
    private com.toedter.calendar.JDateChooser dCari;
    private com.toedter.calendar.JDateChooser dTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tJumlah;
    private javax.swing.JTextField tJumlahAwal;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tMerk;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNoKwitansi;
    private javax.swing.JTextField tStokAkhir;
    private javax.swing.JTextField tStokAwal;
    private javax.swing.JTable tblKeluar;
    // End of variables declaration//GEN-END:variables
}
