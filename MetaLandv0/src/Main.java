import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
//Metaland ilk denemelerimiz 28 Mayıs 6:11 bitmis hal 2
class Arsa{
    int arsaID;
    int kullaniciID;
    int arsafiyat;
    int isletmegeliri;
    String isletmeturu;
    int urunfiyati;
    int isletmelevel;
    int isletmexp;
    int kapasite;
    int isletmecalisansayisi;
    JButton arsabutton;
    JFrame arsabilgileriframe;
    JPanel arsabilgileripanel;
    JLabel arsaIDlabel= new JLabel("Arsa ID:"+arsaID);
    JLabel kullaniciIDlabel= new JLabel("Kullanici ID:"+kullaniciID);
    JLabel arsafiyatlabel= new JLabel("Arsa Fiyat:"+arsafiyat);
    JLabel isletmegelirilabel= new JLabel("İşletme Geliri:"+isletmegeliri);
    JLabel isletmeturulabel= new JLabel("İşletme Türü:"+isletmeturu);
    JLabel urunfiyatilabel= new JLabel("Urun Fiyati");
    JLabel isletmelevellabel= new JLabel("İşletme Level:"+isletmelevel);
    JLabel isletmexplabel= new JLabel("İşletme XP :"+isletmexp);
    JLabel kapasitelabel= new JLabel("İşletme kapasite:"+kapasite);
    JLabel isletmecalisansayisilabel= new JLabel("Çalışan sayısı"+isletmecalisansayisi);


    public Arsa(int arsaID, int kullaniciID, int arsafiyat, int isletmegeliri, String isletmeturu, int urunfiyati, int isletmelevel, int isletmexp, int kapasite, int isletmecalisansayisi) {
        this.arsaID = arsaID;
        this.kullaniciID=kullaniciID;
        this.arsafiyat = arsafiyat;
        this.isletmegeliri = isletmegeliri;
        this.isletmeturu = isletmeturu;
        this.urunfiyati = urunfiyati;
        this.isletmelevel = isletmelevel;
        this.isletmexp = isletmexp;
        this.kapasite = kapasite;
        this.isletmecalisansayisi=isletmecalisansayisi;

        /*JLabel arsaIDlabel= new JLabel("Arsa ID:"+arsaID);
        JLabel kullaniciIDlabel= new JLabel("Kullanici ID:"+kullaniciID);
        JLabel arsafiyatlabel= new JLabel("Arsa Fiyat:"+arsafiyat);
        JLabel isletmegelirilabel= new JLabel("İşletme Geliri:"+isletmegeliri);
        JLabel isletmeturulabel= new JLabel("İşletme Türü:"+isletmeturu);
        JLabel urunfiyatilabel= new JLabel("Urun Fiyati");
        JLabel isletmelevellabel= new JLabel("İşletme Level:"+isletmelevel);
        JLabel isletmexplabel= new JLabel("İşletme XP :"+isletmexp);
        JLabel kapasitelabel= new JLabel("İşletme kapasite:"+kapasite);
        JLabel isletmecalisansayisilabel= new JLabel("Çalışan sayısı"+isletmecalisansayisi);*/

        arsaIDlabel.setText("Arsa ID :"+arsaID);
        kullaniciIDlabel.setText("Kullanici ID :"+kullaniciID);
        arsafiyatlabel.setText("Arsa Fiyat :"+arsafiyat);
        isletmegelirilabel.setText("İşletme Geliri :"+isletmegeliri);
        isletmeturulabel.setText("İşletme Türü :"+isletmeturu);
        urunfiyatilabel.setText("Urun Fiyati :"+urunfiyati);
        isletmelevellabel.setText("İşletme Level :"+isletmelevel);
        isletmexplabel.setText("İşletme XP :"+isletmexp);
        kapasitelabel.setText("İşletme kapasite :"+kapasite);
        isletmecalisansayisilabel.setText("Çalışan sayısı :"+isletmecalisansayisi);

        JFrame arsabilgileriframe=new JFrame();
        JPanel arsabilgileripanel=new JPanel();
        arsabilgileripanel.setLayout(new BoxLayout(arsabilgileripanel, BoxLayout.Y_AXIS));
        arsabilgileripanel.add(arsaIDlabel);
        arsabilgileripanel.add(kullaniciIDlabel);
        arsabilgileripanel.add(arsafiyatlabel);
        arsabilgileripanel.add(isletmegelirilabel);
        arsabilgileripanel.add(isletmeturulabel);
        arsabilgileripanel.add(urunfiyatilabel);
        arsabilgileripanel.add(isletmelevellabel);
        arsabilgileripanel.add(isletmexplabel);
        arsabilgileripanel.add(kapasitelabel);
        arsabilgileripanel.add(isletmecalisansayisilabel);

        arsabilgileriframe.getContentPane().add(arsabilgileripanel);
        arsabilgileriframe.pack();
        arsabutton=new JButton("ID:"+arsaID);
        arsabutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arsabilgileriframe.setVisible(true);
            }
        });
        arsabilgileriframe.setSize(300,400);
        arsabilgileriframe.setLayout(null);

    }

    @Override
    public String toString() {
        return "ArsaID: " + arsaID +
                "\nKullaniciID: " + kullaniciID +
                "\nArsafiyat: " + arsafiyat +
                "\nIsletmegeliri: " + isletmegeliri +
                "\nIsletmeturu: " + isletmeturu +
                "\nUrunfiyati: " + urunfiyati +
                "\nIsletmelevel: " + isletmelevel +
                "\nIsletmexp: " + isletmexp +
                "\nKapasite: " + kapasite+
                "\nIsletmeCalisanSayisi: " + isletmecalisansayisi;
    }

    public void setKullaniciID(int kullaniciID) {
        baglanti.guncelle("UPDATE arsalar SET idkullanici="+kullaniciID+" WHERE idarsa="+arsaID+";");
        kullaniciIDlabel.setText("Kullanici ID:"+kullaniciID);
        this.kullaniciID = kullaniciID;
    }

    public void setArsafiyat(int arsafiyat) {
        baglanti.guncelle("UPDATE arsalar SET arsafiyat="+arsafiyat+" WHERE idarsa="+arsaID+";");

        arsafiyatlabel.setText("Arsa Fiyat:"+arsafiyat);

        this.arsafiyat = arsafiyat;
    }

    public void setIsletmegeliri(int isletmegeliri) {
        baglanti.guncelle("UPDATE arsalar SET isletmegelir="+isletmegeliri+" WHERE idarsa="+arsaID+";");
        isletmegelirilabel.setText("İşletme Geliri:"+isletmegeliri);

        this.isletmegeliri = isletmegeliri;
    }

    public void setIsletmeturu(String isletmeturu) {
        baglanti.guncelle("UPDATE isletme SET isletmeturu='"+isletmeturu+"' WHERE idarsa="+arsaID+";");
        isletmeturulabel.setText("İşletme Türü:"+isletmeturu);

        this.isletmeturu = isletmeturu;
    }

    public void setUrunfiyati(int urunfiyati) {
        baglanti.guncelle("UPDATE isletme SET urunfiyati="+urunfiyati+" WHERE idarsa="+arsaID+";");
        urunfiyatilabel.setText("Urun Fiyati");

        this.urunfiyati = urunfiyati;
    }

    public void setIsletmelevel(int isletmelevel) throws SQLException {
        System.out.println("UPDATE isletme SET isletmelevel="+isletmelevel+" WHERE idarsa="+arsaID+";");
        baglanti.guncelle("UPDATE isletme SET isletmelevel="+isletmelevel+" WHERE idarsa="+arsaID+";");
        isletmelevellabel.setText("İşletme Level:"+isletmelevel);

        this.isletmelevel = isletmelevel;
        ResultSet myRS = baglanti.baglantiyap("SELECT kapasite FROM prolab3denemesi.isletmeseviyetablosu where seviye="+isletmelevel+";");
        while (myRS.next()){
            kapasite=myRS.getInt("kapasite");
        }

    }

    public void setIsletmexp(int isletmexp) {
        baglanti.guncelle("UPDATE isletme SET isletmexp="+isletmexp+" WHERE idarsa="+arsaID+";");
        isletmexplabel.setText("İşletme XP :"+isletmexp);
        this.isletmexp = isletmexp;
    }

    public void setKapasite(int kapasite) {
        baglanti.guncelle("UPDATE isletmeseviyetablosu SET kapasite="+kapasite+" WHERE idarsa="+arsaID+";");
        kapasitelabel.setText("İşletme kapasite:"+kapasite);
        this.kapasite = kapasite;
    }

    public void setIsletmecalisansayisi(int isletmecalisansayisi){
        baglanti.guncelle("UPDATE isletme SET isletmecalisansayisi="+isletmecalisansayisi+" WHERE idarsa="+arsaID+";");
        isletmecalisansayisilabel.setText("Çalışan sayısı"+isletmecalisansayisi);
        this.isletmecalisansayisi=isletmecalisansayisi;
    }
}

class YoneticiCalisanlari{
    int kullaniciID;
    String isletmeturu;
    int maas;

    public YoneticiCalisanlari(int kullaniciID, String isletmeturu, int maas) {
        this.kullaniciID = kullaniciID;
        this.isletmeturu = isletmeturu;
        this.maas = maas;
    }

    public void setIsletmeturu(String isletmeturu) {
        baglanti.guncelle("UPDATE isletmeyonetici SET isletmeturu='"+isletmeturu+"' WHERE idkullanici="+kullaniciID+";");
        this.isletmeturu = isletmeturu;
    }

    public void setMaas(int maas) {
        baglanti.guncelle("UPDATE isletmeyonetici SET maas="+isletmeturu+" WHERE idkullanici="+kullaniciID+";");
        this.maas = maas;
    }
    @Override
    public String toString() {
        return "KullaniciID: " + kullaniciID +
                "\nIsletmeturu: " + isletmeturu +
                "\nMaas: " + maas;
    }

}
class Yonetici{
    int yoneticiID;
    String yoneticiadi;
    String yoneticisifre;
    ArrayList <YoneticiCalisanlari> yoneticiCalisanlariArrayList = new ArrayList<>();
    ArrayList<Arsa> yoneticiarsaArrayList = new ArrayList<>();
    public Yonetici(int yoneticiID, String yoneticiadi, String yoneticisifre) throws SQLException {
        this.yoneticiID = yoneticiID;
        this.yoneticiadi = yoneticiadi;
        this.yoneticisifre = yoneticisifre;
        ResultSet myRS=baglanti.baglantiyap("SELECT * FROM prolab3denemesi.isletmeyonetici where idyonetici="+yoneticiID+";");
        while (myRS.next()){
            yoneticiCalisanlariArrayList.add(new YoneticiCalisanlari(myRS.getInt("idkullanici"),myRS.getString("isletmeturu"),myRS.getInt("maas")));
        }
    }

    public void addYoneticiCalisanlari(YoneticiCalisanlari yoneticiCalisanlari){
        baglanti.kayitekle("INSERT INTO isletmeyonetici (idyonetici,idkullanici,isletmeturu,maas) VALUES ("+yoneticiID+","+yoneticiCalisanlari.kullaniciID+",'"+yoneticiCalisanlari.isletmeturu+"',"+yoneticiCalisanlari.maas+");");
        yoneticiCalisanlariArrayList.add(yoneticiCalisanlari);
    }

    public void deleteYoneticiCalisanlari(YoneticiCalisanlari yoneticiCalisanlari){
        baglanti.kayitsil("DELETE FROM isletmeyonetici WHERE (idkullanici="+yoneticiCalisanlari.kullaniciID+");");
        yoneticiCalisanlariArrayList.remove(yoneticiCalisanlari);
    }

    @Override
    public String toString() {
        return "YoneticiID: " + yoneticiID +
                "\nYoneticiadi: " + yoneticiadi +
                "\nYoneticisifre: " + yoneticisifre;
    }

}

class Kullanici{
    int IDkullanici;
    String kullaniciadi;
    String kullanicisifre;
    int yiyecekmiktari;
    int para;
    int esyamiktari;
    int gunlukkazanc; // arsalardan gelen para
    int gunsayisi;
    ArrayList <Arsa> sahipolunanarsa=new ArrayList<>();
    int IDcalisilanarsa;
    int maas; // çalışılan yerden gelen para
    JFrame kullaniciframe;
    JLabel kullaniciadilabel= new JLabel("Kullanıcı adı :"+kullaniciadi);
    JLabel yiyecekmiktarilabel= new JLabel("Yiyecek miktarı :"+yiyecekmiktari);
    JLabel paralabel= new JLabel("Para Miktarı :"+para);
    JLabel esyamiktarilabel= new JLabel("Eşya miktarı :"+esyamiktari );
    JLabel gunlukkazanclabel= new JLabel("Günlük Kazanç : "+ gunlukkazanc);
    JLabel gunsayisilabel= new JLabel("Gün Sayısı : " +gunsayisi);
    JLabel IDcalisilanarsalabel= new JLabel("Çalışılan Arsa ID: "+ IDcalisilanarsa);
    JLabel maaslabel= new JLabel("Maaş :"+maas);

    public Kullanici(int IDkullanici, String kullaniciadi, String kullanicisifre, int yiyecekmiktari, int para, int esyamiktari, int gunlukkazanc, int gunsayisi, int IDcalisilanarsa, int maas) {
        this.IDkullanici = IDkullanici;
        this.kullaniciadi = kullaniciadi;
        this.kullanicisifre = kullanicisifre;
        this.yiyecekmiktari = yiyecekmiktari;
        this.para = para;
        this.esyamiktari = esyamiktari;
        this.gunlukkazanc = gunlukkazanc;
        this.gunsayisi = gunsayisi;
        this.IDcalisilanarsa = IDcalisilanarsa;
        this.maas = maas;
        kullaniciframe = new JFrame(IDkullanici+" ID numaralı oyuncunun ekranı");
        kullaniciframe.setLayout(null);
        kullaniciframe.setSize(600,600);
        /*JLabel kullaniciadilabel= new JLabel("Kullanıcı adı :"+kullaniciadi);
        JLabel yiyecekmiktarilabel= new JLabel("Yiyecek miktarı :"+yiyecekmiktari);
        JLabel paralabel= new JLabel("Para Miktarı :"+para);
        JLabel esyamiktarilabel= new JLabel("Eşya miktarı :"+esyamiktari );
        JLabel gunlukkazanclabel= new JLabel("Günlük Kazanç : "+ gunlukkazanc);
        JLabel gunsayisilabel= new JLabel("Gün Sayısı : " +gunsayisi);
        JLabel IDcalisilanarsalabel= new JLabel("Çalışılan Arsa ID: "+ IDcalisilanarsa);
        JLabel maaslabel= new JLabel("Maaş :"+maas);*/

        kullaniciadilabel.setText("Kullanıcı adı :"+kullaniciadi);
        yiyecekmiktarilabel.setText("Yiyecek miktarı :"+yiyecekmiktari);
        paralabel.setText("Para Miktarı :"+para);
        esyamiktarilabel.setText("Eşya miktarı :"+esyamiktari );
        gunlukkazanclabel.setText("Günlük Kazanç : "+ gunlukkazanc);
        gunsayisilabel.setText("Gün Sayısı : " +gunsayisi);
        IDcalisilanarsalabel.setText("Çalışılan Arsa ID: "+ IDcalisilanarsa);
        maaslabel.setText("Maaş :"+maas);
        if(IDcalisilanarsa==-1){
            IDcalisilanarsalabel.setText("Çalışılan arsa yok");
        }

        JButton arsaAlButton = new JButton("Arsa Satın Al");
        arsaAlButton.setBounds(210,5,150,30);
        arsaAlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sahipolunanarsa.size() <2){//eğer sahip olunan arsa 2 den az ise satın alma işlemini gerçekleştir
                    int satinalinmakistenenarsaID = Integer.parseInt(JOptionPane.showInputDialog(kullaniciframe, "Satın almak istediğiniz arsanın ID numarasını giriniz"));
                for (int i = 0; i < Main.arsaArrayList.size(); i++) {
                    if (satinalinmakistenenarsaID == Main.arsaArrayList.get(i).arsaID) { // alınmak istenen arsayı bulduk

                        if (Main.arsaArrayList.get(i).kullaniciID == IDkullanici) { // kullanıcı kendi arsasını girmişse
                            JOptionPane.showMessageDialog(kullaniciframe, "Bu arsa zaten " + IDkullanici + " ID numaralı kullanıcıya ait", "Arsa Satın Alma İşlemi Başarısız", JOptionPane.WARNING_MESSAGE);

                        } else if (Main.arsaArrayList.get(i).kullaniciID == Main.yonetici.yoneticiID) { // arsa yöneticiye ait ise

                            if (Main.arsaArrayList.get(i).arsafiyat<para) { // para yetiyorsa

                                String onayliyormusunuz = JOptionPane.showInputDialog("Yönetici Satın alma işlemini onaylıyor mu? Onaylıyorsa 'onay' yazınız");

                                if (onayliyormusunuz.equals("onay")){ // yönetici onaylıysa
                                    sahipolunanarsa.add(Main.arsaArrayList.get(i));
                                    Main.yonetici.yoneticiarsaArrayList.remove(Main.arsaArrayList.get(i));
                                    Main.arsaArrayList.get(i).setKullaniciID(IDkullanici);
                                    for (int k = 0; k < Main.kullaniciArrayList.size(); k++) {
                                        if(Main.kullaniciArrayList.get(k).IDkullanici==IDkullanici){ // içinde olan kullanıcıyı tutar
                                            Main.kullaniciArrayList.get(k).setPara(Main.kullaniciArrayList.get(k).para - Main.arsaArrayList.get(i).arsafiyat);
                                            JOptionPane.showMessageDialog(kullaniciframe, Main.arsaArrayList.get(i).arsaID + " ID numaralı arsayı satın aldınız. Mevcut bakiyeniz : " + Main.kullaniciArrayList.get(k).para, "Arsa Satın Alma İşlemi Başarılı", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }

                                }
                            }
                            else{ // para yetmiyorsa
                                JOptionPane.showMessageDialog(kullaniciframe,"Mevcut Bakiyeniz Arsa için yetersiz","Arsa Satın Alma İşlemi Başarısız",JOptionPane.WARNING_MESSAGE);
                            }
                        }else{
                            for (int j = 0; j < Main.kullaniciArrayList.size(); j++) {
                                if(Main.arsaArrayList.get(i).kullaniciID==Main.kullaniciArrayList.get(j).IDkullanici){ // alınmak istenen arsaya sahip olan kullanıcıyı j de tutuyoruz
                                    if (Main.arsaArrayList.get(i).arsafiyat<para) { // para yetiyorsa

                                        String onayliyormusunuz = JOptionPane.showInputDialog("Kullanici Satın alma işlemini onaylıyor mu? Onaylıyorsa 'onay' yazınız");

                                        if (onayliyormusunuz.equals("onay")){ // kullanici onaylıysa
                                            sahipolunanarsa.add(Main.arsaArrayList.get(i));
                                            Main.kullaniciArrayList.get(j).sahipolunanarsa.remove(Main.arsaArrayList.get(i));
                                            Main.arsaArrayList.get(i).setKullaniciID(IDkullanici);
                                            for (int k = 0; k < Main.kullaniciArrayList.size(); k++) {
                                                if(Main.kullaniciArrayList.get(k).IDkullanici==IDkullanici){ // içinde olan kullanıcıyı tutar
                                                    Main.kullaniciArrayList.get(k).setPara(Main.kullaniciArrayList.get(k).para - Main.arsaArrayList.get(i).arsafiyat); //satın alandan parayı düşürtür
                                                    Main.kullaniciArrayList.get(j).setPara(Main.kullaniciArrayList.get(k).para + Main.arsaArrayList.get(i).arsafiyat); // satanın parayı arttırır
                                                    Main.kullaniciArrayList.get(k).setGunlukkazanc(Main.kullaniciArrayList.get(k).gunlukkazanc+Main.arsaArrayList.get(i).isletmegeliri); // satın alanın arsasındaki kazancı ekler
                                                    Main.kullaniciArrayList.get(j).setGunlukkazanc(Main.kullaniciArrayList.get(k).gunlukkazanc-Main.arsaArrayList.get(i).isletmegeliri); // satanın arsasındaki kazancı düşürür
                                                    JOptionPane.showMessageDialog(kullaniciframe, Main.arsaArrayList.get(i).arsaID + " ID numaralı arsayı satın aldınız. Mevcut bakiyeniz : " + Main.kullaniciArrayList.get(k).para, "Arsa Satın Alma İşlemi Başarılı", JOptionPane.WARNING_MESSAGE);
                                                }
                                            }
                                            break;

                                        }
                                        else{ // yonetici onaylamadıysa
                                            JOptionPane.showMessageDialog(kullaniciframe,"Kullanıcı onay vermedi","Arsa Satın Alma İşlemi Başarısız",JOptionPane.WARNING_MESSAGE);
                                        }

                                    } else{ // para yetmiyorsa
                                        JOptionPane.showMessageDialog(kullaniciframe,"Mevcut Bakiyeniz Arsa için yetersiz","Arsa Satın Alma İşlemi Başarısız",JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            }
                        }

                    } // alınmak istenen arsa tutuluyor
                }
               }else { // 2 tane arsa var. Satın alma işlemi olmaz
                    JOptionPane.showMessageDialog(kullaniciframe,"2'den fazla arsaya sahipsiniz. Arsa Satın alamazsınız","Arsa Satın Alma İşlemi Başarısız",JOptionPane.WARNING_MESSAGE);
                }


            }

        });

        JButton isletmeKurButton=new JButton("İşletme Kur");
        isletmeKurButton.setBounds(210,40,150,30);
        isletmeKurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Main.kullaniciArrayList.size(); i++) {
                    if(Main.kullaniciArrayList.get(i).IDkullanici==IDkullanici){//  i -) şuan içinde olduğumuz kullanıcıyı tutar

                        int isletmekurulacakarsaID=Integer.parseInt(JOptionPane.showInputDialog(kullaniciframe, "İşletme kurmak istediğiniz arsanın ID numarasını giriniz"));

                        for (int j = 0; j < Main.arsaArrayList.size(); j++) {
                            if(Main.arsaArrayList.get(j).arsaID==isletmekurulacakarsaID){ // j - ) işletme kurulacak arsayı tutar

                                if(Main.arsaArrayList.get(j).kullaniciID==IDkullanici){ // eğer kullanıcı arsaya sahip ise

                                    if (Main.arsaArrayList.get(j).isletmeturu.equals("bos")){ // eğer arsa boşsa bu işlemleri yap
                                        String acmakistenilenisletme = JOptionPane.showInputDialog(kullaniciframe,"Açmak istediğiniz işletme : 'emlak'(100) & 'market'(50) & 'magaza'(50)");
                                        if(acmakistenilenisletme.equals("emlak")){

                                            if(Main.kullaniciArrayList.get(i).para>100) { //işletme kuracak para varsa
                                                Main.kullaniciArrayList.get(i).setPara(Main.kullaniciArrayList.get(i).para-100);
                                                Main.arsaArrayList.get(j).setIsletmeturu(acmakistenilenisletme);
                                                Main.arsaArrayList.get(j).setArsafiyat(Main.arsaArrayList.get(j).arsafiyat+50);
                                                Main.arsaArrayList.get(j).setIsletmegeliri(10);
                                                Main.kullaniciArrayList.get(i).setGunlukkazanc(Main.kullaniciArrayList.get(i).gunlukkazanc+Main.arsaArrayList.get(j).isletmegeliri);
                                                Main.arsaArrayList.get(j).setUrunfiyati(0);
                                                Main.arsaArrayList.get(j).setIsletmexp(0);
                                                Main.arsaArrayList.get(j).setIsletmecalisansayisi(0);
                                                try {
                                                    Main.arsaArrayList.get(j).setIsletmelevel(1);
                                                } catch (SQLException ex) {
                                                    throw new RuntimeException(ex);
                                                }
                                            }else {
                                                JOptionPane.showMessageDialog(kullaniciframe,"Emlak kurabilmeniz için 100 den fazla paranız olması gerek. Mevcut bakiyeniz:"+Main.kullaniciArrayList.get(i).para,"Bakiyeniz yetersiz ! ",JOptionPane.WARNING_MESSAGE);
                                            }

                                        } else if (acmakistenilenisletme.equals("market")) {

                                            if(Main.kullaniciArrayList.get(i).para>50) { //market kuracak para varsa
                                                Main.kullaniciArrayList.get(i).setPara(Main.kullaniciArrayList.get(i).para-50);
                                                Main.arsaArrayList.get(j).setIsletmeturu(acmakistenilenisletme);
                                                Main.arsaArrayList.get(j).setArsafiyat(Main.arsaArrayList.get(j).arsafiyat+25);
                                                Main.arsaArrayList.get(j).setIsletmegeliri(5);
                                                Main.kullaniciArrayList.get(i).setGunlukkazanc(Main.kullaniciArrayList.get(i).gunlukkazanc+Main.arsaArrayList.get(j).isletmegeliri);
                                                Main.arsaArrayList.get(j).setUrunfiyati(5);
                                                Main.arsaArrayList.get(j).setIsletmexp(0);
                                                Main.arsaArrayList.get(j).setIsletmecalisansayisi(0);
                                                try {
                                                    Main.arsaArrayList.get(j).setIsletmelevel(1);
                                                } catch (SQLException ex) {
                                                    throw new RuntimeException(ex);
                                                }
                                            }else {
                                                JOptionPane.showMessageDialog(kullaniciframe,"Market kurabilmeniz için 50 den fazla paranız olması gerek. Mevcut bakiyeniz:"+Main.kullaniciArrayList.get(i).para,"Bakiyeniz yetersiz ! ",JOptionPane.WARNING_MESSAGE);
                                            }

                                        } else if (acmakistenilenisletme.equals("magaza")) {

                                            if(Main.kullaniciArrayList.get(i).para>50) { //magaza kuracak para varsa
                                                Main.kullaniciArrayList.get(i).setPara(Main.kullaniciArrayList.get(i).para-50);
                                                Main.arsaArrayList.get(j).setIsletmeturu(acmakistenilenisletme);
                                                Main.arsaArrayList.get(j).setArsafiyat(Main.arsaArrayList.get(j).arsafiyat+25);
                                                Main.arsaArrayList.get(j).setIsletmegeliri(5);
                                                Main.kullaniciArrayList.get(i).setGunlukkazanc(Main.kullaniciArrayList.get(i).gunlukkazanc+Main.arsaArrayList.get(j).isletmegeliri);
                                                Main.arsaArrayList.get(j).setUrunfiyati(5);
                                                Main.arsaArrayList.get(j).setIsletmexp(0);
                                                Main.arsaArrayList.get(j).setIsletmecalisansayisi(0);
                                                try {
                                                    Main.arsaArrayList.get(j).setIsletmelevel(1);
                                                } catch (SQLException ex) {
                                                    throw new RuntimeException(ex);
                                                }
                                            }else {
                                                JOptionPane.showMessageDialog(kullaniciframe,"Mağaza kurabilmeniz için 50 den fazla paranız olması gerek. Mevcut bakiyeniz:"+Main.kullaniciArrayList.get(i).para,"Bakiyeniz yetersiz ! ",JOptionPane.WARNING_MESSAGE);
                                            }

                                        }
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(kullaniciframe,"Bu arsada zaten bir işletme var.","İşletme Kuramazsınız ! ",JOptionPane.WARNING_MESSAGE);
                                    }

                                }else {
                                    JOptionPane.showMessageDialog(kullaniciframe,"Bu arsa size ait değil.","İşletme Kuramazsınız ! ",JOptionPane.WARNING_MESSAGE);
                                }

                            }
                        }

                    }
                }
            }
        });

        JButton isegirButton = new JButton("İşe gir");
        isegirButton.setBounds(210,75,150,30);
        isegirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int isegirmekistedigimizarsaID = Integer.parseInt(JOptionPane.showInputDialog(kullaniciframe, "İşe girmek istediği arsanın ID numarasını giriniz\n" +
                        "Eğer Herhangi bir arsada çalışmak istemiyorsanız '-1' yazınız"));
                for (int i = 0; i < Main.kullaniciArrayList.size(); i++) {
                    if(Main.kullaniciArrayList.get(i).IDkullanici==IDkullanici){//içinde bulunduğumuz kullanıcının indisini i değişkeni tutar

                        if(isegirmekistedigimizarsaID==-1){ // yöneticide veya boşta çalışmak istiyosak
                            String girmekistedigimizisletme=JOptionPane.showInputDialog(kullaniciframe, "Eğer Yöneticide çalışmak istiyorsanız, çalışmak istediğiniz işletmeyi yazınız\n Emlak : 'emlak' / Mağaza : 'magaza' / Market:'market'\n eger işten çıkmak istiyorsanız 'cikis' yazınız");
                            if (girmekistedigimizisletme.equals("cikis")){ // işten çıkmak istiyorsak
                                // en son burada kaldık - SQL hata verdi

                                if (Main.kullaniciArrayList.get(i).IDcalisilanarsa==-1) { // eğer bu kişi yöneticide veya boştaysa
                                    for (int j = 0; j < Main.yonetici.yoneticiCalisanlariArrayList.size(); j++) {
                                        if (Main.kullaniciArrayList.get(i).IDkullanici == Main.yonetici.yoneticiCalisanlariArrayList.get(j).kullaniciID) {// eğer bu kişi yöneticide çalışıyorsa j de tut
                                            Main.kullaniciArrayList.get(i).setMaas(Main.kullaniciArrayList.get(i).maas-Main.yonetici.yoneticiCalisanlariArrayList.get(j).maas); // maaşı düşür
                                            Main.yonetici.deleteYoneticiCalisanlari(Main.yonetici.yoneticiCalisanlariArrayList.get(j)); // çalisanlardan kaldır
                                            JOptionPane.showMessageDialog(kullaniciframe,"Artık yönetici için çalışmıyorsunuz","İşten Çıktınız ! ",JOptionPane.WARNING_MESSAGE);
                                            break;
                                        }
                                    }
                                }
                                else if (Main.kullaniciArrayList.get(i).IDcalisilanarsa>-1 && Main.kullaniciArrayList.get(i).IDcalisilanarsa<Main.arsaArrayList.size()){ // bir arsada çalışıyorsa
                                    for (int j = 0; j < Main.arsaArrayList.size(); j++) {
                                        if(Main.kullaniciArrayList.get(i).IDcalisilanarsa==Main.arsaArrayList.get(j).arsaID){ // j çalışılan arsayı tutar
                                            Main.kullaniciArrayList.get(i).setIDcalisilanarsa(-1);//çalışmadığını yazdık
                                            Main.kullaniciArrayList.get(i).setMaas(0);// maaştan çıkardık
                                            Main.arsaArrayList.get(j).setIsletmecalisansayisi(Main.arsaArrayList.get(j).isletmecalisansayisi-1);
                                            JOptionPane.showMessageDialog(kullaniciframe,"Artık çalışmıyorsunuz","İşten Çıktınız ! ",JOptionPane.WARNING_MESSAGE);
                                            break;
                                        }
                                    }
                                }
                            } else if (girmekistedigimizisletme.equals("emlak")) { // yoneticide emlak olarak çalışacaksak
                                if (Main.kullaniciArrayList.get(i).IDcalisilanarsa==-1){
                                    int eklenecekkullaniciyaverilecekmaas=Integer.parseInt(JOptionPane.showInputDialog(kullaniciframe, "Maaş giriniz"));
                                    Main.kullaniciArrayList.get(i).setMaas(eklenecekkullaniciyaverilecekmaas);
                                    Main.yonetici.addYoneticiCalisanlari(new YoneticiCalisanlari(Main.kullaniciArrayList.get(i).IDkullanici,"emlak",eklenecekkullaniciyaverilecekmaas));
                                    JOptionPane.showMessageDialog(kullaniciframe,"Artık Yöneticide Emlak olarak çalışıyorsunuz","İşe girdiniz ! ",JOptionPane.WARNING_MESSAGE);
                                }
                                else{
                                    JOptionPane.showMessageDialog(kullaniciframe,"Zaten çalışıyorsunuz","İşe giremezsiniz ! ",JOptionPane.WARNING_MESSAGE);
                                }
                            }else if (girmekistedigimizisletme.equals("magaza")) { // yoneticide magaza olarak çalışacaksak
                                if (Main.kullaniciArrayList.get(i).IDcalisilanarsa==-1){
                                    int eklenecekkullaniciyaverilecekmaas=Integer.parseInt(JOptionPane.showInputDialog(kullaniciframe, "Maaş giriniz"));
                                    Main.kullaniciArrayList.get(i).setMaas(eklenecekkullaniciyaverilecekmaas);
                                    Main.yonetici.addYoneticiCalisanlari(new YoneticiCalisanlari(Main.kullaniciArrayList.get(i).IDkullanici,"magaza",eklenecekkullaniciyaverilecekmaas));
                                    JOptionPane.showMessageDialog(kullaniciframe,"Artık Yöneticide Mağazada çalışıyorsunuz","İşe girdiniz ! ",JOptionPane.WARNING_MESSAGE);
                                }
                                else{
                                    JOptionPane.showMessageDialog(kullaniciframe,"Zaten çalışıyorsunuz","İşe giremezsiniz ! ",JOptionPane.WARNING_MESSAGE);
                                }
                            }else if (girmekistedigimizisletme.equals("market")) { // yoneticide market olarak çalışacaksak
                                if (Main.kullaniciArrayList.get(i).IDcalisilanarsa==-1){
                                    int eklenecekkullaniciyaverilecekmaas=Integer.parseInt(JOptionPane.showInputDialog(kullaniciframe, "Maaş giriniz"));
                                    Main.kullaniciArrayList.get(i).setMaas(eklenecekkullaniciyaverilecekmaas);
                                    Main.yonetici.addYoneticiCalisanlari(new YoneticiCalisanlari(Main.kullaniciArrayList.get(i).IDkullanici,"market",eklenecekkullaniciyaverilecekmaas));
                                    JOptionPane.showMessageDialog(kullaniciframe,"Artık Yöneticide Markette çalışıyorsunuz","İşe girdiniz ! ",JOptionPane.WARNING_MESSAGE);
                                }
                                else{
                                    JOptionPane.showMessageDialog(kullaniciframe,"Zaten çalışıyorsunuz","İşe giremezsiniz ! ",JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        } else if (isegirmekistedigimizarsaID>-1) { // eğer bir arsaya girmek istiyorsak

                            if (Main.kullaniciArrayList.get(i).IDcalisilanarsa==-1){// eğer arsada çalışmıyorsan
                                boolean yoneticidecalisiyormu=false;
                                for (int j = 0; j < Main.yonetici.yoneticiCalisanlariArrayList.size(); j++) {
                                    if(Main.kullaniciArrayList.get(i).IDkullanici==Main.yonetici.yoneticiCalisanlariArrayList.get(j).kullaniciID){
                                        yoneticidecalisiyormu=true;
                                        JOptionPane.showMessageDialog(kullaniciframe,"Zaten Yönetici için çalışıyorsunuz","İşe giremezsiniz ! ",JOptionPane.WARNING_MESSAGE);
                                        break;
                                    }
                                }
                                if (!yoneticidecalisiyormu){ // yönetici de dahil olmak üzere kesinlikle çalışmıyor işe alıcağız
                                    for (int j = 0; j < Main.arsaArrayList.size(); j++) {
                                        if(Main.arsaArrayList.get(j).arsaID==isegirmekistedigimizarsaID){ // işe girmek istediğimiz arsayı tutar
                                            if(Main.arsaArrayList.get(j).kapasite>Main.arsaArrayList.get(j).isletmecalisansayisi){ // eğer işletmede yer varsa
                                                int kullaniciyaverilecekmaas=Integer.parseInt(JOptionPane.showInputDialog(kullaniciframe, "Maaş giriniz"));
                                                Main.arsaArrayList.get(j).setIsletmecalisansayisi(Main.arsaArrayList.get(j).isletmecalisansayisi+1);
                                                Main.kullaniciArrayList.get(i).setIDcalisilanarsa(isegirmekistedigimizarsaID);
                                                Main.kullaniciArrayList.get(i).setMaas(kullaniciyaverilecekmaas);
                                                JOptionPane.showMessageDialog(kullaniciframe,"Artık çalışıyorsunuz","İşe girdiniz ! ",JOptionPane.WARNING_MESSAGE);
                                                break;
                                            }else {
                                                JOptionPane.showMessageDialog(kullaniciframe,"İşletmede yer yok","İşe giremezsiniz ! ",JOptionPane.WARNING_MESSAGE);
                                            }
                                        }
                                    }
                                }


                            }else{
                                JOptionPane.showMessageDialog(kullaniciframe,"Zaten Bir arsada çalışıyorsunuz","İşe giremezsiniz ! ",JOptionPane.WARNING_MESSAGE);
                            }
                        }

                    }
                }

            }
        });

        JButton urunsatinalButton = new JButton("Ürün satın al");
        urunsatinalButton.setBounds(210,110,150,30);
        urunsatinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int urunalinacakarsaID = Integer.parseInt(JOptionPane.showInputDialog(kullaniciframe, "Ürün almak istediğiniz arsanın ID sini giriniz"));
                for (int i = 0; i < Main.kullaniciArrayList.size(); i++) {
                    if(Main.kullaniciArrayList.get(i).IDkullanici==IDkullanici){ // i , içinde olduğumuz (ürünü satın alıcak) kullanıcının indisini tutar
                        for (int j = 0; j < Main.arsaArrayList.size(); j++) {
                            if(Main.arsaArrayList.get(j).arsaID==urunalinacakarsaID){// j , ürünü alacağımız arsanın indisini tutar
                                for (int k = 0; k < Main.kullaniciArrayList.size(); k++) {
                                    if(Main.kullaniciArrayList.get(k).IDkullanici==Main.arsaArrayList.get(j).kullaniciID) { // k , ürünü satacak kişinin indisini tutar
                                        if(Main.kullaniciArrayList.get(k).IDkullanici!=Main.kullaniciArrayList.get(i).IDkullanici){

                                        int kactanealican = Integer.parseInt(JOptionPane.showInputDialog(kullaniciframe, "kaç tane ürün almak istersiniz"));
                                        // satin alma işlemleri
                                        if (Main.kullaniciArrayList.get(i).para > (Main.arsaArrayList.get(j).urunfiyati * kactanealican)) { // eğer para yetiyorsa

                                            if (Main.arsaArrayList.get(j).isletmeturu.equals("emlak")) {
                                                JOptionPane.showMessageDialog(kullaniciframe, "Emlaktan ürün alamazsınız", "Satın Alım Başarısız! ", JOptionPane.WARNING_MESSAGE);
                                            }

                                            if (Main.arsaArrayList.get(j).isletmeturu.equals("bos")) {
                                                JOptionPane.showMessageDialog(kullaniciframe, "Bu arsada işletme yok", "Satın Alım Başarısız! ", JOptionPane.WARNING_MESSAGE);
                                            }

                                            if (Main.arsaArrayList.get(j).isletmeturu.equals("magaza")) {
                                                Main.kullaniciArrayList.get(i).setPara(Main.kullaniciArrayList.get(i).para - (Main.arsaArrayList.get(j).urunfiyati * kactanealican)); // parayı aldık
                                                Main.kullaniciArrayList.get(i).setEsyamiktari(Main.kullaniciArrayList.get(i).esyamiktari + kactanealican);
                                                Main.kullaniciArrayList.get(k).setPara(Main.kullaniciArrayList.get(k).para + (Main.arsaArrayList.get(j).urunfiyati * kactanealican)); // parayı verdik
                                                JOptionPane.showMessageDialog(kullaniciframe, kactanealican + " tane eşya aldınız. Alışveriş bedeli : " + (Main.arsaArrayList.get(j).urunfiyati * kactanealican) + " \n Kalan bakiyeniz : " + Main.kullaniciArrayList.get(i).para, "Satın Alım Başarılı! ", JOptionPane.WARNING_MESSAGE);
                                            }

                                            if (Main.arsaArrayList.get(j).isletmeturu.equals("market")) {
                                                Main.kullaniciArrayList.get(i).setPara(Main.kullaniciArrayList.get(i).para - (Main.arsaArrayList.get(j).urunfiyati * kactanealican)); // parayı aldık
                                                Main.kullaniciArrayList.get(i).setYiyecekmiktari(Main.kullaniciArrayList.get(i).yiyecekmiktari + kactanealican);
                                                Main.kullaniciArrayList.get(k).setPara(Main.kullaniciArrayList.get(k).para + (Main.arsaArrayList.get(j).urunfiyati * kactanealican)); // parayı verdik
                                                JOptionPane.showMessageDialog(kullaniciframe, kactanealican + " tane yiyecek aldınız. Alışveriş bedeli : " + (Main.arsaArrayList.get(j).urunfiyati * kactanealican) + " \n Kalan bakiyeniz : " + Main.kullaniciArrayList.get(i).para, "Satın Alım Başarılı! ", JOptionPane.WARNING_MESSAGE);
                                            }

                                        } else { // eğer para yetmiyorsa
                                            JOptionPane.showMessageDialog(kullaniciframe, "Bu üründen " + kactanealican + " tane alamazsınız. Bakiyeniz yetmiyor\n Toplam bakiyeniz : " + Main.kullaniciArrayList.get(i).para, "Satın alımı gerçekleştiremedin ! ", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }else { // alıcı ve satıcı aynı kişi ise
                                            JOptionPane.showMessageDialog(kullaniciframe, "Kendinizden ürün alamazsınız", "Satın Alım Başarısız! ", JOptionPane.WARNING_MESSAGE);
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        });


        kullaniciadilabel.setBounds(5,5,195,20);
        yiyecekmiktarilabel.setBounds(5,25,195,20);
        paralabel.setBounds(5,45,195,20);
        esyamiktarilabel.setBounds(5,65,195,20);
        gunlukkazanclabel.setBounds(5,85,195,20);
        gunsayisilabel.setBounds(5,105,195,20);
        IDcalisilanarsalabel.setBounds(5,125,195,20);
        maaslabel.setBounds(5,145,195,20);

        kullaniciframe.add(urunsatinalButton);
        kullaniciframe.add(isegirButton);
        kullaniciframe.add(isletmeKurButton);
        kullaniciframe.add(arsaAlButton);
        kullaniciframe.add(kullaniciadilabel);
        kullaniciframe.add(yiyecekmiktarilabel);
        kullaniciframe.add(paralabel);
        kullaniciframe.add(esyamiktarilabel);
        kullaniciframe.add(gunlukkazanclabel);
        kullaniciframe.add(gunsayisilabel);
        kullaniciframe.add(IDcalisilanarsalabel);
        kullaniciframe.add(maaslabel);


    }

    @Override
    public String toString() {
        return "IDkullanici: " + IDkullanici +
                "\nKullaniciadi: " + kullaniciadi +
                "\nKullanicisifre: " + kullanicisifre +
                "\nYiyecekmiktari: " + yiyecekmiktari +
                "\nPara: " + para +
                "\nEsyamiktari: " + esyamiktari +
                "\nGunlukkazanc: " + gunlukkazanc +
                "\nGunsayisi: " + gunsayisi +
                "\nIDcalisilanarsa: " + IDcalisilanarsa +
                "\nMaas: " + maas;
    }

    public void setIDkullanici(int IDkullanici) {
        //this.IDkullanici = IDkullanici;
    }

    public void setKullaniciadi(String kullaniciadi) {
        //this.kullaniciadi = kullaniciadi;
    }

    public void setKullanicisifre(String kullanicisifre) {
        //this.kullanicisifre = kullanicisifre;
    }

    public void setYiyecekmiktari(int yiyecekmiktari) {
        baglanti.guncelle("UPDATE kullanicilar SET yiyecekmiktari="+yiyecekmiktari+" WHERE idkullanicilar="+IDkullanici+";");
        yiyecekmiktarilabel.setText("Yiyecek miktarı :"+yiyecekmiktari);

        this.yiyecekmiktari = yiyecekmiktari;
    }

    public void setPara(int para) {
        baglanti.guncelle("UPDATE kullanicilar SET para="+para+" WHERE idkullanicilar="+IDkullanici+";");
        paralabel.setText("Para Miktarı :"+para);

        this.para = para;
    }

    public void setEsyamiktari(int esyamiktari) {
        baglanti.guncelle("UPDATE kullanicilar SET esya="+esyamiktari+" WHERE idkullanicilar="+IDkullanici+";");
        esyamiktarilabel.setText("Eşya miktarı :"+esyamiktari );

        this.esyamiktari = esyamiktari;
    }

    public void setGunlukkazanc(int gunlukkazanc) {
        baglanti.guncelle("UPDATE kullanicilar SET gunlukkazanc="+gunlukkazanc+" WHERE idkullanicilar="+IDkullanici+";");
        gunlukkazanclabel.setText("Günlük Kazanç : "+ gunlukkazanc);

        this.gunlukkazanc = gunlukkazanc;
    }

    public void setGunsayisi(int gunsayisi) {
        baglanti.guncelle("UPDATE kullanicilar SET gunsayisi="+gunsayisi+" WHERE idkullanicilar="+IDkullanici+";");
        gunsayisilabel.setText("Gün Sayısı : " +gunsayisi);

        this.gunsayisi = gunsayisi;
    }

    public void setIDcalisilanarsa(int IDcalisilanarsa) {
        baglanti.guncelle("UPDATE calisanlar SET calisilanarsaid="+IDcalisilanarsa+" WHERE idkullanici="+IDkullanici+";");
        if(IDcalisilanarsa==-1){
            IDcalisilanarsalabel.setText("Çalışılan arsa yok");
        }else {
            IDcalisilanarsalabel.setText("Çalışılan Arsa ID: " + IDcalisilanarsa);
        }

        this.IDcalisilanarsa = IDcalisilanarsa;
    }

    public void setMaas(int maas) {
        baglanti.guncelle("UPDATE calisanlar SET maas="+maas+" WHERE idkullanici="+IDkullanici+";");
        maaslabel.setText("Maaş :"+maas);

        this.maas = maas;
    }

    public void gunAtla(){
        for (int i = 0; i < Main.kullaniciArrayList.size(); i++) { // kullanıcıların gün atlama işlemleri
            if(Main.kullaniciArrayList.get(i).IDkullanici==IDkullanici){// bu kullanıcı Arraylistin i . indexindedir
                if(Main.kullaniciArrayList.get(i).para<=0||Main.kullaniciArrayList.get(i).esyamiktari<=0||Main.kullaniciArrayList.get(i).yiyecekmiktari<=0){//eğer kullanıcı ölürse
                    Main.kullaniciArrayList.get(i).kullaniciframe.setVisible(false); // kullanıcı ekranını kapat
                    Main.aktifkullanicilar.remove(Main.kullaniciArrayList.get(i));
                }
                //Her gün yapılacak işlemler
                Main.kullaniciArrayList.get(i).setEsyamiktari(Main.kullaniciArrayList.get(i).esyamiktari-1);
                Main.kullaniciArrayList.get(i).setYiyecekmiktari(Main.kullaniciArrayList.get(i).yiyecekmiktari-1);
                Main.kullaniciArrayList.get(i).setPara(Main.kullaniciArrayList.get(i).para+Main.kullaniciArrayList.get(i).gunlukkazanc+Main.kullaniciArrayList.get(i).maas-5);
                Main.kullaniciArrayList.get(i).setGunsayisi(Main.kullaniciArrayList.get(i).gunsayisi+1);

                for (int j = 0; j < Main.arsaArrayList.size(); j++) { // eğer bir arsada çalışıyorsa
                    if(Main.kullaniciArrayList.get(i).IDcalisilanarsa==Main.arsaArrayList.get(j).arsaID){// j indisi , kullanıcının çalıştığı arsayı tutar
                        if(Main.arsaArrayList.get(j).isletmeturu.equals("magaza")){
                            Main.kullaniciArrayList.get(i).setEsyamiktari(Main.kullaniciArrayList.get(i).esyamiktari+1);
                        }
                        if(Main.arsaArrayList.get(j).isletmeturu.equals("market")){
                            Main.kullaniciArrayList.get(i).setYiyecekmiktari(Main.kullaniciArrayList.get(i).yiyecekmiktari+1);
                        }
                        if(Main.arsaArrayList.get(j).isletmeturu.equals("emlak")){
                            Main.kullaniciArrayList.get(i).setPara(Main.kullaniciArrayList.get(i).para+5);
                        }
                        break;
                    }
                }
                for (int j = 0; j < Main.yonetici.yoneticiCalisanlariArrayList.size(); j++) { // eğer yöneticide çalışıyorsak
                    if(Main.yonetici.yoneticiCalisanlariArrayList.get(j).kullaniciID==Main.kullaniciArrayList.get(i).IDkullanici){ // çalışanı j ile tutuyoruz
                        if(Main.yonetici.yoneticiCalisanlariArrayList.get(j).isletmeturu.equals("magaza")){
                            Main.kullaniciArrayList.get(i).setEsyamiktari(Main.kullaniciArrayList.get(i).esyamiktari+1);
                        }
                        if(Main.yonetici.yoneticiCalisanlariArrayList.get(j).isletmeturu.equals("market")){
                            Main.kullaniciArrayList.get(i).setYiyecekmiktari(Main.kullaniciArrayList.get(i).yiyecekmiktari+1);
                        }
                        if(Main.yonetici.yoneticiCalisanlariArrayList.get(j).isletmeturu.equals("emlak")){
                            Main.kullaniciArrayList.get(i).setPara(Main.kullaniciArrayList.get(i).para+5);
                        }
                        break;
                    }
                }
                if(Main.kullaniciArrayList.get(i).para<=0||Main.kullaniciArrayList.get(i).esyamiktari<=0||Main.kullaniciArrayList.get(i).yiyecekmiktari<=0){//eğer kullanıcı ölürse
                    Main.kullaniciArrayList.get(i).kullaniciframe.setVisible(false); // kullanıcı ekranını kapat
                    Main.aktifkullanicilar.remove(Main.kullaniciArrayList.get(i));
                }
            }
        }

        for (int i = 0; i < Main.arsaArrayList.size(); i++) { // arsaların gün atlama işlemleri
            if(Main.arsaArrayList.get(i).isletmecalisansayisi >= Main.arsaArrayList.get(i).kapasite){ // eğer tam kapasite bir gün geçirmişse xp yi bir arttırdık
                Main.arsaArrayList.get(i).setIsletmexp(Main.arsaArrayList.get(i).isletmexp+1);
            }
            if (Main.arsaArrayList.get(i).isletmexp>=7){// eğer işletme tam kapasite olarak 1 hafta geçirmişse
                Main.arsaArrayList.get(i).setIsletmexp(Main.arsaArrayList.get(i).isletmexp-7); // xp yi 7 düşürdük
                try {
                    Main.arsaArrayList.get(i).setIsletmelevel(Main.arsaArrayList.get(i).isletmelevel+1); // işletme leveli ve kapasite güncellenir
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("YENI KAPASITE :"+Main.arsaArrayList.get(i).kapasite);
            }
        }

    }

}
class baglanti{
    static Connection myConn;
    static Statement myStat;

    static ResultSet baglantiyap(String baglantiSQLkod){
        ResultSet myRs;
        try {
            myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/prolab3denemesi","root","furkan254");
            myStat = myConn.createStatement();
            myRs = myStat.executeQuery(baglantiSQLkod);
            //myRs = myStat.executeQuery("SELECT * FROM prolab3denemesi.kullanicilar;");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myRs;
    }

    static void kayitekle(String sqlkodu){
        System.out.println(sqlkodu);
        try {
            myStat.executeUpdate(sqlkodu);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static void guncelle(String sqlkodu){
        System.out.println("GUNCELLEME KOD -> "+sqlkodu);
        try {
            myStat.executeUpdate(sqlkodu);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static void kayitsil(String sqlkodu){
        System.out.println("DELETE SQL KOD -> "+sqlkodu);
        try {
            myStat.executeUpdate(sqlkodu);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
public class Main {
    public static ArrayList<Kullanici> kullaniciArrayList;
    public static Yonetici yonetici;
    public static ArrayList<Arsa> arsaArrayList;
    public static ArrayList<Kullanici> aktifkullanicilar;
    public static void main(String[] args) throws SQLException {
        ResultSet myRs= baglanti.baglantiyap("SELECT * FROM prolab3denemesi.kullanicilar kullanici,prolab3denemesi.calisanlar calisan WHERE kullanici.idkullanicilar=calisan.idkullanici;");
         kullaniciArrayList = new ArrayList<>();
        while (myRs.next()){ // kullanıcıları bağlar
            kullaniciArrayList.add(new Kullanici(
                    myRs.getInt("idkullanicilar"), myRs.getString("kullaniciadi"),
                    myRs.getString("kullanicisifre"), myRs.getInt("yiyecekmiktari"),
                    myRs.getInt("para"), myRs.getInt("esya"),
                    myRs.getInt("gunlukkazanc"), myRs.getInt("gunsayisi"),
                    myRs.getInt("calisilanarsaid"), myRs.getInt("maas")));
        }


        // ARSALAR ALANI
        myRs= baglanti.baglantiyap("SELECT * FROM prolab3denemesi.arsalar,prolab3denemesi.isletme,prolab3denemesi.isletmeseviyetablosu where arsalar.idarsa=isletme.idarsa and isletme.isletmelevel=isletmeseviyetablosu.seviye order by arsalar.idarsa;");
        arsaArrayList = new ArrayList<>();
        while (myRs.next()){ // arsaları olusturur
            arsaArrayList.add(new Arsa(
                    myRs.getInt("idarsa"), myRs.getInt("idkullanici"),myRs.getInt("arsafiyat"),
                    myRs.getInt("isletmegelir"), myRs.getString("isletmeturu"),
                    myRs.getInt("urunfiyati"), myRs.getInt("isletmelevel"),
                    myRs.getInt("isletmexp"), myRs.getInt("kapasite"),myRs.getInt("isletmecalisansayisi")));
        }

        boolean yoneticigirisiyapildimi=false;

        while (!yoneticigirisiyapildimi) { // yönetici girişi yapmaya çalıştık
            int yoneticiidal = Integer.parseInt(JOptionPane.showInputDialog("yonetici ID giriniz"));
            myRs = baglanti.baglantiyap("SELECT * FROM prolab3denemesi.yonetici;");
            while (myRs.next()) {
                if (yoneticiidal == myRs.getInt("idyonetici")) { // eğer girilen ID tabloda varsa
                    String yoneticisifreal =JOptionPane.showInputDialog("yonetici sifre giriniz");
                    if(myRs.getString("yoneticisifresi").equals(yoneticisifreal)) { // aynı satırdaki şifre de aynıysa
                        yonetici = new Yonetici(myRs.getInt("idyonetici"), myRs.getString("yoneticiadi"), myRs.getString("yoneticisifresi"));
                        yoneticigirisiyapildimi = true;
                    }
                }
            }
        }
        /*if(yoneticigirisiyapildimi==true){
            myRs=baglanti.baglantiyap("SELECT * FROM prolab3denemesi.isletmeyonetici where isletmeyonetici.idyonetici="+yonetici.yoneticiID+";");//yonetici calisanlari ekle
            while (myRs.next()){
                yonetici.yoneticiCalisanlariArrayList.add( new YoneticiCalisanlari( myRs.getInt("idkullanici"), myRs.getString("isletmeturu"),myRs.getInt("maas")));
            }
            System.out.println("kac calisan var :"+yonetici.yoneticiCalisanlariArrayList.size());
            System.out.println(yonetici.yoneticiarsaArrayList.get(0).toString());
            System.out.println(yonetici.yoneticiarsaArrayList.get(1).toString());
            if(yonetici.yoneticiCalisanlariArrayList.size()>0){
                for (int i = 0; i < yonetici.yoneticiCalisanlariArrayList.size(); i++) {
                    System.out.println("YONETICI CALISANLARI "+i);
                    System.out.println(yonetici.yoneticiarsaArrayList.get(i).toString());
                }
            }
        }*/

        for (int i = 0; i < arsaArrayList.size(); i++) {
            System.out.println("ARSA NUMARA: "+i+"****");
            System.out.println(arsaArrayList.get(i).toString());
        }

        int oyunalanininIuzunlugu=0;
        do {
            oyunalanininIuzunlugu = Integer.parseInt(JOptionPane.showInputDialog("Oyun alanının kaç satır olacağını giriniz"));
        }while (!(oyunalanininIuzunlugu>0 && oyunalanininIuzunlugu<10));

        int oyunalanininJuzunlugu=0;
        do {
            oyunalanininJuzunlugu = Integer.parseInt(JOptionPane.showInputDialog("Oyun alanının kaç sutun olacağını giriniz"));
        }while (!(oyunalanininJuzunlugu>0 && oyunalanininJuzunlugu<10));

        if((oyunalanininIuzunlugu*oyunalanininJuzunlugu)>arsaArrayList.size()){ // eğer daha fazla arsa gerekiyorsa
            int eklenmesigerekenarsasayisi=(oyunalanininIuzunlugu*oyunalanininJuzunlugu)-arsaArrayList.size();
            System.out.println("EKLENMESI GEREKEN ARSA SAYISI:"+eklenmesigerekenarsasayisi);
            int eklenecekarsaIDsayaci=0;
            while (eklenmesigerekenarsasayisi>0){

                boolean IDarsaeklemeyemusait=true;

                for (int i = 0; i < arsaArrayList.size(); i++) {
                    if(eklenecekarsaIDsayaci==arsaArrayList.get(i).arsaID){
                        IDarsaeklemeyemusait=false;
                    }
                }
                if (IDarsaeklemeyemusait){//ID numarasına arsa ekleyebilirsin
                    //ARSA EKLEME KOMUTLARI

                    baglanti.kayitekle("INSERT INTO arsalar(idarsa,idkullanici,arsafiyat,isletmegelir)VALUES("+eklenecekarsaIDsayaci+","+yonetici.yoneticiID+",50,0);");
                    baglanti.kayitekle("INSERT INTO isletme(idarsa,isletmeturu,urunfiyati,isletmelevel,isletmexp,isletmecalisansayisi)VALUES("+eklenecekarsaIDsayaci+", 'bos',0,0,0,0);");
                    arsaArrayList.add(new Arsa(eklenecekarsaIDsayaci,yonetici.yoneticiID,50,0,"bos",0,0,0,0,0));
                    eklenecekarsaIDsayaci++;
                    eklenmesigerekenarsasayisi--;
                    System.out.println("EKLENMESI GEREKEN ARSA SAYISI:"+eklenmesigerekenarsasayisi);
                }
                else{//ID numarasına sahip arsa var
                    eklenecekarsaIDsayaci++;
                }

            }
        }

        JFrame oyunalaniFrame = new JFrame("ARSALAR");
        oyunalaniFrame.setLayout(new GridLayout(oyunalanininIuzunlugu,oyunalanininJuzunlugu));
        oyunalaniFrame.setSize(400, 400);
        int arsabutoneklemesayaci=0;
        for (int i = 0; i < oyunalanininIuzunlugu ; i++) {
            for (int j = 0; j < oyunalanininJuzunlugu; j++) {
                if ( (i+j) % 2 == 0) {
                    arsaArrayList.get(arsabutoneklemesayaci).arsabutton.setBackground(Color.CYAN);
                } else {
                    arsaArrayList.get(arsabutoneklemesayaci).arsabutton.setBackground(Color.BLUE);
                }
                oyunalaniFrame.add(arsaArrayList.get(arsabutoneklemesayaci).arsabutton);
                arsabutoneklemesayaci++;
            }
        }

        oyunalaniFrame.setVisible(true);

        for (int i = 0; i < kullaniciArrayList.size(); i++) { // kullanici arsa bağı
            for (int j = 0; j < arsaArrayList.size(); j++) {
                if(kullaniciArrayList.get(i).IDkullanici==arsaArrayList.get(j).kullaniciID){
                    kullaniciArrayList.get(i).sahipolunanarsa.add(arsaArrayList.get(j));
                }
            }
        }

        for (int i = 0; i < arsaArrayList.size(); i++) {
            if(yonetici.yoneticiID==arsaArrayList.get(i).kullaniciID){
                yonetici.yoneticiarsaArrayList.add(arsaArrayList.get(i));
            }

        }

        for (int i = 0; i < kullaniciArrayList.size(); i++) {
            System.out.println("+++KULLANICI "+i);
            for (int j = 0; j < kullaniciArrayList.get(i).sahipolunanarsa.size(); j++) {
                System.out.println("---ARSA "+j);
                System.out.println(kullaniciArrayList.get(i).sahipolunanarsa.get(j).toString());
            }
        }
        System.out.println("YONETİCİ ARSALARI");
        for (int i = 0; i < yonetici.yoneticiarsaArrayList.size(); i++) {
            System.out.println("ARSA :"+i);
            System.out.println(yonetici.yoneticiarsaArrayList.get(i).toString());
        }

        aktifkullanicilar = new ArrayList<>();
        JFrame yoneticiframe = new JFrame("Yönetici");
        yoneticiframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        yoneticiframe.setSize(600,600);

        JButton kullanicigirisibutton = new JButton("Kullanıcı Girişi");
        kullanicigirisibutton.setBounds(10,10,150,30);
        kullanicigirisibutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean yenikullanicieklendimi=false;
                int eklenenkullaniciID=Integer.parseInt(JOptionPane.showInputDialog("Oyuna eklenecek kullanıcının ID numarasını giriniz"));

                for (int i = 0; i < kullaniciArrayList.size(); i++) {
                    if(kullaniciArrayList.get(i).IDkullanici== eklenenkullaniciID){
                        String eklenenkullanicisifresi =JOptionPane.showInputDialog("Oyuna eklenecek kullanıcının şifresini giriniz");
                        if(kullaniciArrayList.get(i).kullanicisifre.equals(eklenenkullanicisifresi)) {
                            aktifkullanicilar.add(kullaniciArrayList.get(i));
                            yenikullanicieklendimi = true;
                            kullaniciArrayList.get(i).kullaniciframe.setVisible(true);//kullanıcının ekranını aç
                            JOptionPane.showMessageDialog(null, kullaniciArrayList.get(i).kullaniciadi+ " isimli Kullanıcı oyuna eklendi", "Kullanıcı Oyuna Eklendi", JOptionPane.WARNING_MESSAGE);
                            for (int j = 0; j < aktifkullanicilar.size(); j++) {
                                System.out.println(aktifkullanicilar.get(j).toString());
                            }
                            break;
                        }
                    }
                }
                if (!yenikullanicieklendimi){
                    JOptionPane.showMessageDialog(null, "Girmiş olduğunuz değerler Veri tabanında yer almıyor", "Kullanıcı Oyuna Eklenemedi", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton kullanicieklebutton = new JButton("Kullanıcı Ekle");
        kullanicieklebutton.setBounds(170,10,150,30);
        kullanicieklebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean girilenIDtekmi=true;
                int eklenecekkullaniciID=0;
                eklenecekkullaniciID=Integer.parseInt(JOptionPane.showInputDialog("Oyuna eklenecek kullanıcının ID numarasını giriniz"));
                for (int i = 0; i < kullaniciArrayList.size(); i++) {
                    if(kullaniciArrayList.get(i).IDkullanici==eklenecekkullaniciID){
                        JOptionPane.showMessageDialog(null, "Bu ID numarasına sahip kullanıcı var", "Kullanıcı Eklenemedi", JOptionPane.WARNING_MESSAGE);
                        girilenIDtekmi=false;
                    }
                }
                if(girilenIDtekmi){
                    String eklenecekkullaniciadi=JOptionPane.showInputDialog(yoneticiframe,"Oyuna eklenecek kullanıcının adını giriniz");
                    String eklenecekkullanicisifre=JOptionPane.showInputDialog(yoneticiframe,"Oyuna eklenecek kullanıcının şifresini giriniz");
                    kullaniciArrayList.add(new Kullanici(eklenecekkullaniciID,eklenecekkullaniciadi,eklenecekkullanicisifre,20,200,20,0,0,-1,0));
                    baglanti.kayitekle("INSERT INTO kullanicilar(idkullanicilar,kullaniciadi,kullanicisifre,yiyecekmiktari,para,esya,gunlukkazanc,gunsayisi) VALUES ("+eklenecekkullaniciID+", '"+eklenecekkullaniciadi+"', '"+eklenecekkullanicisifre+"', 20, 200, 20, 0, 0);");
                    baglanti.kayitekle("INSERT INTO calisanlar (idkullanici,calisilanarsaid,maas)VALUES("+eklenecekkullaniciID+", -1, 0);");
                    for (int i = 0; i < kullaniciArrayList.size(); i++) {
                        System.out.println(kullaniciArrayList.get(i).toString());
                    }
                }

            }
        });

        int arsaeklemekicinyoneticiid=yonetici.yoneticiID;
        JButton oyunalaniolusturbutton = new JButton("Oyun Alanı Oluştur");
        oyunalaniolusturbutton.setBounds(10,50,150,30);
        oyunalaniolusturbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                int oyunalanininIuzunlugu=0;
                do {
                    oyunalanininIuzunlugu = Integer.parseInt(JOptionPane.showInputDialog("Oyun alanının kaç satır olacağını giriniz"));
                }while (!(oyunalanininIuzunlugu>0 && oyunalanininIuzunlugu<10));

                int oyunalanininJuzunlugu=0;
                do {
                    oyunalanininJuzunlugu = Integer.parseInt(JOptionPane.showInputDialog("Oyun alanının kaç sutun olacağını giriniz"));
                }while (!(oyunalanininJuzunlugu>0 && oyunalanininJuzunlugu<10));

                if((oyunalanininIuzunlugu*oyunalanininJuzunlugu)>arsaArrayList.size()){ // Eğer arsa eklenmesi gerekiyorsa
                    int arsaIDsayaci=0;
                    System.out.println("Kac arsa eklenmesi gerekiyor :"+((oyunalanininIuzunlugu*oyunalanininJuzunlugu)-arsaArrayList.size()) );

                    for (int i = 0; i <(oyunalanininIuzunlugu*oyunalanininJuzunlugu)-arsaArrayList.size() ;) {//kaç kere arsa ekleme işlemi yapılacağını tutar
                        System.out.println(i+". arsa ekleniyor");
                        boolean yeniIDbulundumu=true;
                        for (int j = 0; j < arsaArrayList.size(); j++) {
                            if(arsaArrayList.get(j).arsaID==arsaIDsayaci){
                                yeniIDbulundumu=false;
                            }
                        }
                        if(yeniIDbulundumu){//eğer ID bulunduysa yeni arsa ekle
                         baglanti.kayitekle("INSERT INTO arsalar(idarsa,idkullanici,arsafiyat,isletmegelir)VALUES("+arsaIDsayaci+","+arsaeklemekicinyoneticiid+",50,0);");
                         baglanti.kayitekle("INSERT INTO isletme(idarsa,isletmeturu,urunfiyati,isletmelevel,isletmexp,isletmecalisansayisi)VALUES("+arsaIDsayaci+", 'bos',0,0,0,0);");
                         arsaArrayList.add(new Arsa(arsaIDsayaci,arsaeklemekicinyoneticiid,50,0,"bos",0,0,0,0,0));
                         i++;//for döngüsüne "arsa eklendi" der
                           // arsaIDsayaci++;
                        } // yeni arsa ID si arsaIDsayaci olmalı
                        else {
                            arsaIDsayaci++; //eğer ID müsait değilse arttırılıp tekrar denenir
                        }
                        arsaIDsayaci++;

                    }
                    for (int i = 0; i < arsaArrayList.size(); i++) {
                        System.out.println("ARSA "+i+"-----");
                        System.out.println(arsaArrayList.get(i).toString());
                    }
                }
                System.out.println("grid I uzunlugu :"+oyunalanininIuzunlugu);
                System.out.println("grid J uzunlugu :"+oyunalanininJuzunlugu);
                oyunalaniFrame.setLayout(null);
                oyunalaniFrame.setLayout(new GridLayout(oyunalanininJuzunlugu,oyunalanininIuzunlugu));
                oyunalaniFrame.setSize(400, 400);
                int arsabutoneklemesayaci=0;
                for (int i = 0; i < oyunalanininIuzunlugu ; i++) {
                    for (int j = 0; j < oyunalanininJuzunlugu; j++) {
                        if(arsaArrayList.size()>arsabutoneklemesayaci) {
                            System.out.println("arsabutoneklemesayaci:"+arsabutoneklemesayaci);
                            if ((i + j) % 2 == 0) {
                                arsaArrayList.get(arsabutoneklemesayaci).arsabutton.setBackground(Color.CYAN);
                            } else {
                                arsaArrayList.get(arsabutoneklemesayaci).arsabutton.setBackground(Color.BLUE);
                            }
                            oyunalaniFrame.add(arsaArrayList.get(arsabutoneklemesayaci).arsabutton);
                            arsabutoneklemesayaci++;
                        }
                    }
                }*
                 */
                oyunalaniFrame.setVisible(true);
            }
        });

        JButton gunatlabutton = new JButton("Gün atla");
        gunatlabutton.setBounds(330,10,100,30);
        gunatlabutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int kacgunatlancak=Integer.parseInt(JOptionPane.showInputDialog("Kaç gün atlansın"));
                if(kacgunatlancak>0){
                    for (int j = 0; j < kacgunatlancak; j++) {
                        for (int i = 0; i < aktifkullanicilar.size(); i++) {
                            aktifkullanicilar.get(i).gunAtla();
                        }
                    }
                }
            }
        });

        yoneticiframe.add(gunatlabutton);
        yoneticiframe.add(oyunalaniolusturbutton);
        yoneticiframe.add(kullanicigirisibutton);
        yoneticiframe.add(kullanicieklebutton);
        yoneticiframe.setLayout(null);
        yoneticiframe.setVisible(true);
        System.out.println("Yonetici****\n"+yonetici.toString());
        System.out.println("CALİSANLAR");
        for (int i = 0; i < yonetici.yoneticiCalisanlariArrayList.size(); i++) {
            System.out.println(yonetici.yoneticiCalisanlariArrayList.get(i).toString());
            System.out.println("---");
        }

        //YoneticiCalisanlari denemelikyoneticicalisanlari = new YoneticiCalisanlari(24,"halici",2000);
        //yonetici.addYoneticiCalisanlari(denemelikyoneticicalisanlari);
        /*kullaniciArrayList.get(0).setYiyecekmiktari(20);
        kullaniciArrayList.get(0).setPara(2000);
        kullaniciArrayList.get(1).setEsyamiktari(2000);
        kullaniciArrayList.get(0).setGunlukkazanc(1);
        kullaniciArrayList.get(0).setGunsayisi(31);
        kullaniciArrayList.get(0).setIDcalisilanarsa(29);
        kullaniciArrayList.get(2).setMaas(128);*/

        /*arsaArrayList.get(0).setUrunfiyati(5);
        arsaArrayList.get(1).setIsletmexp(0);
        arsaArrayList.get(2).setIsletmeturu("Pavyon Marketi");
        arsaArrayList.get(3).setIsletmecalisansayisi(310);*/
        /*System.out.println("UPDATE EDİLMEDEN ONCE KAPASITE ->"+ arsaArrayList.get(0).kapasite);
        arsaArrayList.get(0).setIsletmelevel(1);
        System.out.println("UPDATE EDİLMEDEN SONRA KAPASITE ->"+ arsaArrayList.get(0).kapasite);*/
    }
}//Metaland ilk denemelerimiz 28 Mayıs 23:00 Gonderildi