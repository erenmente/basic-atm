import java.util.Scanner;

class Atm{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);//Scanner sınıfı klavyeden veri alır.
        BankaHesabi benimHesabim=new BankaHesabi(1000,1500);
        int secim;
        boolean dongu=true;

        while(dongu){//while true olduğu sürece devam ettir.
            System.out.println("------------ERENBANK ATM'YE HOŞGELDİNİZ------------");

            System.out.println("Lütfen aşağıdan yapmak istediğiniz işlemi seçin.");
            System.out.println("1:Para çekmek");
            System.out.println("2:Para yatırmak");
            System.out.println("3:Çıkış");
            System.out.println("Mevcut bakiyeniz:"+benimHesabim.bakiye+"TL");
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
                    benimHesabim.paraCekme(input);
                    break;

                case 2://Para yatırma kısmı
                    benimHesabim.paraYatirma(input);
                    break;
                case 3://Çıkış yapma kısmı
                    System.out.println("İyi günler dileriz.");
                    input.close();//temzilik yapar.
                    dongu=false;//bulunduğu metoda son verir.
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 1-3 arası bir değer girin.");

            }
        }


    }
}