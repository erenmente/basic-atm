import java.util.Scanner;

public class BankaHesabi {

    int bakiye;
    int gunlukParaCekmeLimiti;

    public BankaHesabi(int baslangicBakiye,int gunlukLimit){
        this.gunlukParaCekmeLimiti=gunlukLimit;
        this.bakiye=baslangicBakiye;
    }
    public void paraCekme(Scanner sc){
        System.out.print("Cekmek istediğiniz bakiyeyi giriniz:");
        if (sc.hasNextInt()){
            int cekilecekTutar=sc.nextInt();
            if (cekilecekTutar>this.bakiye){
                System.out.println("Yetersiz bakiyeyi.");
            }
            else if(cekilecekTutar>this.gunlukParaCekmeLimiti){
                System.out.println("Günlük limiti aştınız. Kalan limitiniz:"+this.gunlukParaCekmeLimiti);
            } else if (cekilecekTutar<=0) {
                System.out.println("0'dan büyük değer giriniz.");
            }
            else {
                System.out.println("İşleminiz başarıyla gerçekleştirilmiştir.");
                this.bakiye=this.bakiye-cekilecekTutar;
                gunlukParaCekmeLimiti=gunlukParaCekmeLimiti-cekilecekTutar;
                System.out.println("Güncel bakiyeniz:"+this.bakiye);
                System.out.println("Güncel limitiniz:"+this.gunlukParaCekmeLimiti);
            }
        }
        else{
            System.out.println("Geçerli bir değer giriniz.");
            sc.next();
        }
    }
    public void paraYatirma(Scanner sc){
        System.out.print("Yatırmak istediğiniz tutarı giriniz:");

        if (sc.hasNextInt()){
            int yatirilacakTutar=sc.nextInt();
            if (yatirilacakTutar>0){
                this.bakiye=yatirilacakTutar+this.bakiye;
            }
            else {
                System.out.println("Lütfen pozitif bir değer giriniz.");
            }
        }
        else{
            System.out.println("Geçerli bir değer giriniz.");
            sc.next();
        }
    }
}
