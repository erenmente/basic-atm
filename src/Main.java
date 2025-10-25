import java.sql.SQLOutput;
import java.util.Scanner;

class main{
    public static void main(String[] args){
        int bakiye=1000;
        int paraCekmeLimiti=500;
        int cekilecekTutar;
        int secim;
        boolean dongu=true;
        Scanner input=new Scanner(System.in);//Scanner sınıfı klavyeden veri alır.
        while(dongu){//while true olduğu sürece devam ettir.
            System.out.println("------------ERENBANK ATM'YE HOŞGELDİNİZ------------");

            System.out.println("Lütfen aşağıdan yapmak istediğiniz işlemi seçin.");
            System.out.println("1:Para çekmek");
            System.out.println("2:Para yatırmak");
            System.out.println("3:Çıkış");
            System.out.println("Mevcut bakiyeniz:"+bakiye+"TL");
            System.out.print("Yapmak istediğiniz işlemin numarasını yazınız(1-3):");
            if(input.hasNextInt()){//girilen değerin sayısal bir değer olup olmadığına bakar.
                secim=input.nextInt();
            }
            else{
                System.out.println("Lütfen geçerli bir değer girin.");
                input.next();
                continue;
            }
            switch(secim){
                case 1://Para çekme kısmı
                    System.out.print("Çekmek istediğiniz tutarı giriniz:");
                    if(input.hasNextInt()){
                        cekilecekTutar=input.nextInt();
                    else if(cekilecekTutar>bakiye){
                            System.out.println("yetersiz bakiye.");
                        }
                        else if(cekilecekTutar>paraCekmeLimiti){
                            System.out.println("Günlük limiti aştınız");
                        }
                    }
                    else{
                        System.out.println("Geçerli bir tutar giriniz.");
                        input.next();//aldığı değeri string olarak döndürdü ama değişken atanmadığı için yok sayılıyor.
                        continue;
                    }
                    if (cekilecekTutar<=0){
                        System.out.println("Lütfen pozitif bir sayı giriniz.");
                    }
                    else {
                        System.out.println("İşleminiz başarıyla gerçekleştirilmiştir");
                        bakiye=bakiye-cekilecekTutar;
                        paraCekmeLimiti=paraCekmeLimiti-cekilecekTutar;
                        System.out.println("Yeni bakiyeniz "+bakiye+" TL");
                    }
                    break;

                case 2://Para yatırma kısmı
                    System.out.print("Yatırmak istediğiniz tutarı gitiniz:");
                    if(input.hasNextInt()){
                        int yatirilacakTutar=input.nextInt();
                        bakiye=bakiye+yatirilacakTutar;
                        System.out.println("Yeni bakiyeniz "+bakiye+" TL");

                    }
                    else {
                        System.out.println("Sayısal bir değer giriniz.");
                    }
                    break;
                case 3://Çıkış yapma kısmı
                    System.out.println("İyi günler dileriz.");
                    input.close();//temzilik yapar.
                    return;//bulunduğu metoda son verir.
            }











            //            System.out.println("Başka bir isteğiniz var mı");
//            String musteriIstegi = input.nextLine();
//            musteriIstegi=musteriIstegi.toLowerCase();
//            if(musteriIstegi=="evet"){
//                System.out.print("İyi günler");
//                input.close();
//            }
//            else if(musteriIstegi=="hayır"){
//                dongu=false;
//            }

        }


    }
}