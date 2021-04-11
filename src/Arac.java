
public class Arac {
    
    private int itemId;
    private String girisSaati;
    private int girisKilosu;
    private String plaka;
    private String marka;
    private String tip;
    private String cıkısSaati;
    private int cıkısKilosu;
    
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getGirisSaati() {
        return girisSaati;
    }

    public void setGirisSaati(String girisSaati) {
        this.girisSaati = girisSaati;
    }

    public int getGirisKilosu() {
        return girisKilosu;
    }

    public void setGirisKilosu(int girisKilosu) {
        this.girisKilosu = girisKilosu;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getCıkısSaati() {
        return cıkısSaati;
    }

    public void setCıkısSaati(String cıkısSaati) {
        this.cıkısSaati = cıkısSaati;
    }

    public int getCıkısKilosu() {
        return cıkısKilosu;
    }

    public void setCıkısKilosu(int cıkısKilosu) {
        this.cıkısKilosu = cıkısKilosu;
    }
    
    public Arac(int id, String girissaati, int giriskilosu,String plaka,String marka,String tip,String cıkıssaati,int cıkıskilosu){
        
        this.itemId = id;
        this.girisSaati = girissaati;
        this.girisKilosu = giriskilosu;
        this.plaka = plaka;
        this.marka = marka;
        this.tip = tip;
        this.cıkısSaati = cıkıssaati;
        this.cıkısKilosu = cıkıskilosu;
        
    }
}
