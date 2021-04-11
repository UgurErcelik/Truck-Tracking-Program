
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class KamyonSorgu {
    
    public static final String kullanici_adi = "root";
    public static final String parola = "";
    public static final String databasename = "proje";
    public static final String hostlocal = "localhost";
    public static final int port = 3306;
    
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement psmt = null;
    /*
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
            Logger.getLogger(KamyonSorgu.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
    }
    */
    public KamyonSorgu()
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
            Logger.getLogger(KamyonSorgu.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
/*
    public void aracekle()
    {
        
        try{
            stmt=conn.createStatement();
            int id = 1;
            String girissaati = "12.10";
            int giriskilosu = 1400;
            String plaka = "20 YT 240";
            String marka = "HYUNDAİ";
            String tip = "NAKLİYAT";
            String cıkıssaati = "";
            int cıkıskilosu = 0;
            String values="'"+id+"',"+"'"+girissaati+"',"+"'"+giriskilosu+"',"+"'"+plaka+"',"+"'"+marka+"',"+"'"+tip+"',"+"'"+cıkıssaati+"',"+cıkıskilosu+"'";
            String sorgu="Insert Into kamyon(id,Giriş Saati,Giriş Kilosu,Plaka,Marka,Tip,Çıkış Saati,Çıkış Kilosu)VALUES"+"("+values+")";
            stmt.executeUpdate(sorgu);
        }catch(SQLException ex)
        {
            Logger.getLogger(KamyonSorgu.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    */
    
    public boolean sorguplaka(String plaka,JTable tablo)
    {
        boolean varmı=false;
        try{
            String sorgu="Select*From kamyon";
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sorgu);
            
            while (rs.next()) {                
                if(rs.getString("Plaka").equals(plaka))
                {
                    DefaultTableModel model = (DefaultTableModel)tablo.getModel();
                    model.getDataVector().clear();
                    
                    int id = rs.getInt("id");
                    String girissaati = rs.getString("Giriş Saati");
                    int giriskilosu = rs.getInt("Giriş Kilosu");
                    String plakan = rs.getString("Plaka");
                    String marka = rs.getString("Marka");
                    String tip = rs.getString("Tip");
                    //String cıkıssaati = rs.getString("Çıkış Saati");
                    //int cıkıskilosu = rs.getInt("Çıkış Kilosu");
                    Object[]ekle={id,girissaati,giriskilosu,plakan,marka,tip};
                    model.addRow(ekle);
                    varmı=true;
                    return varmı;
                }
            }
            return varmı;
        }catch(SQLException ex)
        {
            System.out.println("Hata Oluştu");
        }
        return varmı;
    }
    
    public JTable Listele(JTable tablo)
    {
        String sorgu = "Select*From kamyon";
        try {
            DefaultTableModel tabloModel = (DefaultTableModel) tablo.getModel();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sorgu);
            while (rs.next()) {                
                int id = rs.getInt("id");
                String girissaati = rs.getString("Giriş Saati");
                int giriskilosu = rs.getInt("Giriş Kilosu");
                String plakan = rs.getString("Plaka");
                String marka = rs.getString("Marka");
                String tip = rs.getString("Tip");
                String cıkıssaati = rs.getString("Çıkış Saati");
                String cıkıskilosu = rs.getString("Çıkış Kilosu");
                
                Object[] kamyon = {id,girissaati,giriskilosu,plakan,marka,tip,cıkıssaati,cıkıskilosu};
                tabloModel.addRow(kamyon);
            }
            return tablo;
        } catch (SQLException ex) {
            System.out.println("Liste Hatası");
        }
        return tablo;
    }
    
    public void aracekle(Map<Object,Object>liste){
        try{
            stmt=conn.createStatement();
            String plaka=liste.get("Plaka").toString().trim();
            int gkilo_alan=Integer.valueOf(liste.get("Giriş Kilosu").toString().trim());
            int id_giris = Integer.valueOf(liste.get("id").toString().trim());
            String giris_alan = liste.get("Giriş Saati").toString().trim();
            String marka = liste.get("Marka").toString().trim();
            String tip = liste.get("Tip").toString().trim();
           
            String sorgu=String.format("Insert Into kamyon(`id`,`Giriş Saati`,`Giriş Kilosu`,`Plaka`,`Marka`,`Tip`)values('%d','%s','%d','%s','%s','%s')",id_giris,giris_alan,gkilo_alan,plaka,marka,tip);
            //System.out.println(plaka + gkilo_alan + id_giris + giris_alan + marka + tip);
            System.out.println(sorgu);
            stmt.executeUpdate(sorgu);
            JOptionPane.showMessageDialog(null,"Eklendi");
        }catch(SQLException ex){
            System.out.println("Eklenmedi");  
        }
    }
    
    public void kamyoncıkıs(Map liste)
    {
        try {
            stmt=conn.createStatement();
            String plaka=liste.get("Plaka").toString().trim();
            String gkilo_alan=liste.get("Giriş Kilosu").toString().trim();
            String id_giris = liste.get("id").toString().trim();
            String giris_alan = liste.get("Giriş Saati").toString().trim();
            String marka = liste.get("Marka").toString().trim();
            String tip = liste.get("Tip").toString().trim();
            String cıkıs_saat = liste.get("Çıkış Saati").toString().trim();
            String cıkıs_kilo = liste.get("Çıkış Kilosu").toString().trim();
            
            String sorgu=String.format("Insert Into kamyon(`id`,`Giriş Saati`,`Giriş Kilosu`,`Plaka`,`Marka`,`Tip`,`Çıkış Saati`,`Çıkış Kilosu`)values('%d','%s','%d','%s','%s','%s')",id_giris,giris_alan,gkilo_alan,plaka,marka,tip,cıkıs_saat,cıkıs_kilo);
            stmt.executeUpdate(sorgu);
            System.out.println("Eklendi");
        } catch (Exception e) {
            System.out.println("Eklenemedi");
        }
    }
    public static void main(String[] args)
    {
        KamyonSorgu kmynsrg = new KamyonSorgu();
        kmynsrg.aracgetir();
        
        
        
        
    }

    
    
   
    
    
}
