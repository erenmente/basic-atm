import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ATM atm = new ATM();
        Scanner input = new Scanner(System.in);
        int secim;
        boolean dongu = true;

        while (dongu) {//while true olduğu sürece devam ettir.
            System.out.println("------------ERENBANK ATM'YE HOŞGELDİNİZ------------");
            System.out.println("Lütfen aşağıdan yapmak istediğiniz işlemi seçin.");
            System.out.println("1:Para çekmek");
            System.out.println("2:Para yatırmak");
            System.out.println("3:Çıkış");
            System.out.println("Mevcut bakiyeniz:" + atm.bakiye + "TL");
            System.out.print("Yapmak istediğiniz işlemin numarasını yazınız(1-3):");

            if (input.hasNextInt()) {//girilen değerin sayısal bir değer olup olmadığına bakar.
                secim = input.nextInt();
            } else {
                System.out.println("Lütfen geçerli bir değer girin.");
                input.next();
                continue;
            }
            switch (secim) {
                case 1://Para çekme kısmı
                    System.out.print("Cekmek istediğiniz bakiyeyi giriniz:");
                    if (input.hasNextInt()) {
                        int cekilecekTutar = input.nextInt();
                        atm.paraCekme(cekilecekTutar);
                    } else {
                        System.out.println("Lütfen geçerli bir değer girin.");
                        input.next();
                        continue;
                    }
                    break;

                case 2://Para yatırma kısmı
                    System.out.print("Yatırmak istediğiniz bakiyeyi giriniz:");
                    if (input.hasNextInt()) {
                        int yatirilacakTutar = input.nextInt();
                        atm.paraYatirma(yatirilacakTutar);
                    } else {
                        System.out.println("Lütfen geçerli bir değer girin.");
                        input.next();
                        continue;
                    }
                    break;
                case 3://Çıkış yapma kısmı
                    System.out.println("İyi günler dileriz.");
                    input.close();//temzilik yapar.
                    dongu = false;//bulunduğu metoda son verir.
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 1-3 arası bir değer girin.");

            }
        }
    }
}

class ATM {

    int bakiye = 1000;
    int gunlukParaCekmeLimiti=1000;

    public void paraCekme(int miktar) {



        if (miktar > bakiye) {
            System.out.println("Yetersiz bakiyeyi.");
        } else if (miktar > gunlukParaCekmeLimiti) {
            System.out.println("Günlük limiti aştınız. Kalan limitiniz:" + gunlukParaCekmeLimiti);
        } else if (miktar <= 0) {
            System.out.println("0'dan büyük değer giriniz.");
        } else {
            System.out.println("İşleminiz başarıyla gerçekleştirilmiştir.");
            bakiye = bakiye - miktar;
            gunlukParaCekmeLimiti = gunlukParaCekmeLimiti - miktar;
            System.out.println("Güncel bakiyeniz:" + bakiye);
            System.out.println("Güncel limitiniz:" + gunlukParaCekmeLimiti);
        }

    }

    public void paraYatirma(int miktar) {

        if (miktar > 0) {
            bakiye = miktar + bakiye;
            System.out.println("İşlem başarılı. Yeni bakiyeniz: " + bakiye + " TL");
        } else {
            System.out.println("Lütfen pozitif bir değer giriniz.");
        }

    }
}


