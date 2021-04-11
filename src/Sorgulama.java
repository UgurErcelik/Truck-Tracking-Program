import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Sorgulama extends javax.swing.JFrame {

    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement psmt = null;
    
    
    DefaultTableModel model;
    SorguKamyon islem = new SorguKamyon();
    
    public void aracGor()
    {
        model.setRowCount(0);
        ArrayList<Arac> kamyon = new ArrayList<>();
        kamyon = islem.KamyonSorgulama();
        
        if(kamyon != null)
        {
            for(Arac item:kamyon){
                Object[] ekle = {item.getItemId(),item.getGirisSaati(),item.getGirisKilosu(),item.getPlaka(),item.getMarka(),item.getTip(),item.getCıkısSaati(),item.getCıkısKilosu()};
                model.addRow(ekle);
            }
        }
    }
    /*
    private void tablodoldur() throws Exception {
      Object [] baslik={"id","Giriş Saati","Giriş Kilosu","Plaka","Marka","Tip","Çıkış Saati","Çıkış Kilosu"};
      Object [][]veri;
      String sorgu = "SELECT * FROM kamyon";
      
      PreparedStatement psmt =conn.prepareStatement(sorgu);
      ResultSet rs = stmt.executeQuery(sorgu);
      int count=0;
      rs.last();
      count=rs.getRow();
      veri=new Object[count][8];
      rs.first();
      for(int i=0;i<count;i++){
      for(int j=0;j<8;j++){
      veri[i][j]=rs.getObject(j+1);
      rs.next();
      }
      }

      tablo.setModel(new DefaultTableModel(veri,baslik));
      rs.close();
}
*/
    public Sorgulama() {
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        plaka_sorgu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo = new javax.swing.JTable();
        sorgu_buton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Plaka:");

        plaka_sorgu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                plaka_sorguKeyReleased(evt);
            }
        });

        tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Giriş Saati", "Giriş Kilosu", "Plaka", "Marka", "Tip", "Çıkış Saati", "Çıkış Kilosu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablo);
        if (tablo.getColumnModel().getColumnCount() > 0) {
            tablo.getColumnModel().getColumn(0).setResizable(false);
            tablo.getColumnModel().getColumn(1).setResizable(false);
            tablo.getColumnModel().getColumn(2).setResizable(false);
            tablo.getColumnModel().getColumn(3).setResizable(false);
            tablo.getColumnModel().getColumn(4).setResizable(false);
            tablo.getColumnModel().getColumn(5).setResizable(false);
            tablo.getColumnModel().getColumn(6).setResizable(false);
            tablo.getColumnModel().getColumn(7).setResizable(false);
        }

        sorgu_buton.setText("Sorgula");
        sorgu_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sorgu_butonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(plaka_sorgu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(sorgu_buton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(plaka_sorgu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sorgu_buton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plaka_sorguKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plaka_sorguKeyReleased
  
    }//GEN-LAST:event_plaka_sorguKeyReleased

    private void sorgu_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sorgu_butonActionPerformed
        String sorgu=plaka_sorgu.getText().trim();
        boolean varmı=false;
        SorguKamyon s=new SorguKamyon();
        varmı=s.sorgulaplaka(sorgu);
        if (varmı) {
            JOptionPane.showMessageDialog(this, "Mevcut");
        }else{
            JOptionPane.showMessageDialog(this, "Mevcut değil");
        }

    }//GEN-LAST:event_sorgu_butonActionPerformed

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
            java.util.logging.Logger.getLogger(Sorgulama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sorgulama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sorgulama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sorgulama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sorgulama().setVisible(true);
            }
        });
    }
class SorguKamyon {
    
    public static final String kullanici_adi = "root";
    public static final String parola = "";
    public static final String databasename = "proje";
    public static final String hostlocal = "localhost";
    public static final int port = 3306;
    
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement psmt = null;
    
    public ArrayList<Arac> KamyonSorgulama()
    {
        ArrayList<Arac> kmyn = new ArrayList<Arac>();
        try{
            stmt=conn.createStatement();
            String sorgu = "SELECT * FROM kamyon";
            ResultSet rs = stmt.executeQuery(sorgu);
            while(rs.next()){
                
                int id = rs.getInt("id");
                String girissaati = rs.getString("Giriş Saati");
                int giriskilosu = rs.getInt("Giriş Kilosu");
                String plaka = rs.getString("Plaka");
                String marka = rs.getString("Marka");
                String tip = rs.getString("Tip");
                String cıkıssaati = rs.getString("Çıkış Saati");
                int cıkıskilosu = rs.getInt("Çıkış Kilosu");
                
                
                kmyn.add(new Arac(id,girissaati,giriskilosu,plaka,marka,tip,cıkıssaati,cıkıskilosu));
                //System.out.format("%s, %s, %s, %s, %s, %s, %s, %s\n", id, girissaati, giriskilosu, plaka, marka, tip,cıkıssaati,cıkıskilosu);
                //System.out.println("id : " + id + "Giriş Saati: " + girissaati + "Giriş Kilosu: " + giriskilosu + "Plaka : " + plaka + "Marka : " + marka + "Tip : " + tip + "Çıkış Saati : " + cıkıssaati + "Çıkış Kilosu : " + cıkıskilosu);
            }
            return kmyn;
        }catch(SQLException ex)
        {
            Logger.getLogger(SorguKamyon.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
    }
    
    public SorguKamyon()
    {
         String url = "jdbc:mysql://"+ hostlocal + ":" + port + "/" + databasename ;
         try{
             Class.forName("com.mysql.jdbc.Driver");
         }catch(ClassNotFoundException e)
         {
             System.out.println("Driver Bulunamadı");
         }
         try{
             
            conn = DriverManager.getConnection(url,kullanici_adi,parola);
            System.out.println("Bağlantı Başarılı");
        }catch(SQLException e)
        {
            System.out.println("Bağlantı Başarısız");
        }
         
    }
    
    public void aracgetir()
    {
        String sorgu="Select*From kamyon";
        try{
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sorgu);
            while(rs.next()){
                int id = rs.getInt("id");
                String girissaati = rs.getString("Giriş Saati");
                int giriskilosu = rs.getInt("Giriş Kilosu");
                String plaka = rs.getString("Plaka");
                String marka = rs.getString("Marka");
                String tip = rs.getString("Tip");
                String cıkıssaati = rs.getString("Çıkış Saati");
                int cıkıskilosu = rs.getInt("Çıkış Kilosu");
                
                System.out.println("id : " + id + " Giriş Saati: " + girissaati + " Giriş Kilosu: " + giriskilosu + " Plaka : " + plaka + " Marka : " + marka + " Tip : " + tip + " Çıkış Saati : " + cıkıssaati + " Çıkış Kilosu : " + cıkıskilosu);
            }
        }catch(SQLException ex){
            Logger.getLogger(SorguKamyon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public boolean sorgulaplaka(String plaka){
    boolean varmı=false;
        try {
            stmt=conn.createStatement();
            DefaultTableModel model=(DefaultTableModel) tablo.getModel();
            String sorgu="Select*From kamyon";
            ResultSet rs=stmt.executeQuery(sorgu);
            while (rs.next()) {
                String pl=rs.getString("Plaka");
                if (rs.getString("Plaka").equals(plaka)) {
                    varmı=true;
                    return varmı;
                }
                
            }
            return varmı;
        } catch (SQLException ex) {
            Logger.getLogger(Sorgulama.class.getName()).log(Level.SEVERE, null, ex);
        }
        return varmı;
}
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField plaka_sorgu;
    private javax.swing.JButton sorgu_buton;
    private javax.swing.JTable tablo;
    // End of variables declaration//GEN-END:variables
}
