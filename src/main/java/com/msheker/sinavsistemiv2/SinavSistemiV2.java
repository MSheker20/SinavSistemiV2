/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.msheker.sinavsistemiv2;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author musta
 */
public class SinavSistemiV2 {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
        ArrayList<Ders> dersler = new ArrayList<>();
        
        boolean devam = true;
        
        while(devam){
            System.out.print("""
                
                1. Ogrenci Ekle
                2. Ders Ekle
                3. Ogrenci Listesi
                4. Ders Listesi
                5. Ogrenciye Ders Ekle
                6. Ogrenci Ortalama Hesapla
                7. 60'dan Kucuk Sinav Notlari
                0. Cikis

                Merhaba, lutfen yapmak istediginiz islemi seciniz:""");
            
            int secim = scanner.nextInt();
            scanner.nextLine(); //buffer temizleme
            
            switch(secim){
                case 1 -> { //ogrenci ekle
                    Ogrenci ogrenci = new Ogrenci();
                    
                    // Ogrenci adi aliniyor
                    System.out.print("Ogrenci Adi: ");
                    ogrenci.setAd(scanner.nextLine());
                    
                    // Ogrenci numarasi aliniyor
                    System.out.print("Ogrenci No: ");
                    ogrenci.setNo(scanner.nextInt());
                    scanner.nextLine(); // Buffer temizleme
                    
                    ogrenciler.add(ogrenci); //Ogrenciyi listeye ekleme
                    System.out.println("Ogrenci Eklendi: "+ ogrenci.getAd());
                }
                
                case 2 -> {  //ders ekle
                    Ders ders = new Ders();
                    System.out.print("Ders Adi: "); //Ders adi aliniyor
                    ders.setAd(scanner.nextLine());
                    
                    dersler.add(ders); //Dersi listeye ekleme
                    System.out.println("Ders Eklendi: "+ ders.getAd());
                }
                
                case 3 -> // Ogrenci Listesi
                    ogrenciDetayliBilgiGoster(ogrenciler);
                
                case 4 -> // Ders Listesi
                    dersListesiniGoster(dersler);

                case 5 -> // Ogrenciye Ders Ekle
                    ogrenciyeDersEkle(ogrenciler, dersler, scanner);
                
                case 6 -> { // Ogrenci Ortalama Hesapla
                    ogrenciListesiniGoster(ogrenciler);
                    System.out.println("Ortalama hesaplamak istediginiz ogrencinin numarasini giriniz: ");
                    int ogrenciNo2 = scanner.nextInt();
                    scanner.nextLine(); //buffer temizleme

                    Ogrenci seciliOgrenci = Ogrenci.ogrenciBul(ogrenciler, ogrenciNo2);
                    if (seciliOgrenci == null) {
                        System.out.println("Belirtilen numaraya sahip ogrenci bulunamadi!");
                        break;
                    }
                    System.out.println(seciliOgrenci.getAd() + " isimli ogrencinin ortalamasi: " + tumDersOrtalamaHesapla(seciliOgrenci));
                }
                
                case 7 -> { // 60'dan kucuk notları yazdırır
                    dersListesiniGoster(dersler);
                    System.out.println("Lutfen notlarini gormek istediginiz dersin adini giriniz: ");
                    String dersAdi = scanner.nextLine();
                    Ders seciliDers = Ders.dersBul(dersler, dersAdi);
                    if (seciliDers == null) {
                        System.out.println("Belirtilen isimde ders bulunamadi!");
                        break;
                    }else{
                        for(int i = 0; i < ogrenciler.size(); i++){
                            Ogrenci o = ogrenciler.get(i);
                            for(int j = 0; j < o.getDersler().size(); j++) {
                                Ders d = o.getDersler().get(j);
                                if(d.getAd().equals(seciliDers.getAd())) {
                                    if(d.getVizeNot() < 60) {
                                        System.out.println(d.getAd() + " dersinden vize notu 60'dan kucuk olan ogrenci: " + o.getAd() 
                                                          + ", Vize Notu: " + d.getVizeNot());
                                    }
                                    // Final notu için benzer kontrol
                                }
                            }
                        }
                    }
                }
                case 0 -> { // Cikis
                    devam = false;
                    System.out.println("Program sonlandiriliyor...");
                }
                
                default -> System.out.println("Gecersiz secim! Lutfen tekrar deneyin.");
            }

            System.out.println("Devam etmek icin Enter tusuna basin...");
            scanner.nextLine();
        }
        
        scanner.close();
    }
    
    // Ogrenci listesini gosteren metod - sadece özet bilgi
    private static void ogrenciListesiniGoster(ArrayList<Ogrenci> ogrenciler) {
        if (ogrenciler.isEmpty()) {
            System.out.println("Henuz ogrenci eklenmemis!");
        } else {
            System.out.println("\n--- Ogrenci Listesi ---");
            for (int i = 0; i < ogrenciler.size(); i++) {
                Ogrenci o = ogrenciler.get(i);
                // Sadece özet bilgiyi göster
                System.out.println((i+1) + ". Ogrenci No: " + o.getNo() + ", Ad: " + o.getAd());
            }
            System.out.println("---------------------");
        }
    }

    // Ogrenci detayli bilgilerini gosteren metod
    private static void ogrenciDetayliBilgiGoster(ArrayList<Ogrenci> ogrenciler) {
        if (ogrenciler.isEmpty()) {
            System.out.println("Henuz ogrenci eklenmemis!");
        } else {
            System.out.println("\n--- Ogrenci Detayli Bilgiler ---");
            for (int i = 0; i < ogrenciler.size(); i++) {
                System.out.println((i+1) + ". " + ogrenciler.get(i).toString());
                System.out.println("-----------------------------");
            }
        }
    }

    // Ders listesini gosteren metod
    private static void dersListesiniGoster(ArrayList<Ders> dersler) {
        if (dersler.isEmpty()) {
            System.out.println("Henuz ders eklenmemis!");
        } else {
            System.out.println("\n--- Ders Listesi ---");
            for (int i = 0; i < dersler.size(); i++) {
                Ders d = dersler.get(i);
                System.out.println((i+1) + ". Ders Adi: " + d.getAd());
            }
            System.out.println("---------------------");
        }
    }
    
    // Ogrencinin tum derslerinin ortalamasini hesaplayan metod
    private static double tumDersOrtalamaHesapla(Ogrenci o){
        double toplam = 0;
        ArrayList<Ders> dersler = o.getDersler();
        
        if (dersler.isEmpty()) {
            return 0; // Ders yoksa ortalama 0
        }
        
        for (int i = 0; i < dersler.size(); i++) {
            toplam += dersler.get(i).getOrtalama();
        }
        return toplam / dersler.size();
    }
    
    // Ogrenciye ders ekleme metodu
    private static void ogrenciyeDersEkle(ArrayList<Ogrenci> ogrenciler, ArrayList<Ders> dersler, Scanner scanner) {
        ogrenciListesiniGoster(ogrenciler);
        System.out.println("Islem yapmak istediginiz ogrencinin numarasini giriniz: ");
        int ogrenciNo = scanner.nextInt();
        scanner.nextLine(); //buffer temizleme

        Ogrenci seciliOgrenci = Ogrenci.ogrenciBul(ogrenciler, ogrenciNo);
        if (seciliOgrenci == null) {
            System.out.println("Belirtilen numaraya sahip ogrenci bulunamadi!");
            return;
        }

        dersListesiniGoster(dersler);
        System.out.println("Ogrenciye eklemek istediginiz dersin adini giriniz: ");
        String dersAdi = scanner.nextLine();

        Ders seciliDers = Ders.dersBul(dersler, dersAdi);
        if (seciliDers == null) {
            System.out.println("Belirtilen isimde ders bulunamadi!");
            return;
        }

        boolean dersMevcut = false;
        for(int i = 0; i < seciliOgrenci.getDersler().size(); i++) {
            if(seciliOgrenci.getDersler().get(i).getAd().equals(seciliDers.getAd())) {
                dersMevcut = true;
                break;
            }
        }
        if(dersMevcut) {
            System.out.println("Bu ders ögrenciye zaten eklenmiş!");
            return;
        }

        //not girme
        System.out.println("Vize Notu: ");
        Ders ogrenciDersi = new Ders(seciliDers.getAd());
        ogrenciDersi.setVizeNot(scanner.nextInt());
        System.out.println("Final Notu: ");
        ogrenciDersi.setFinalNot(scanner.nextInt());
        seciliOgrenci.getDersler().add(ogrenciDersi);
        
        System.out.println("Ders ekleme işlemi tamamlandi.");
        System.out.println("Öğrenci bilgileri: \n" + seciliOgrenci.toString());
    }
}
