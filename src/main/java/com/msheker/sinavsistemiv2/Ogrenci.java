/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msheker.sinavsistemiv2;

import java.util.ArrayList;

/**
 *
 * @author musta
 */
public class Ogrenci {
    private String ad;
    private int no;
    private ArrayList<Ders> dersler;

    public Ogrenci(String ad, int no) {
        this.ad = ad;
        this.no = no;
        this.dersler = new ArrayList<>();
    }

    public Ogrenci() {
        this.dersler = new ArrayList<>();
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }


    public int getNo() {
        return no;
    }


    public void setNo(int no) {
        this.no = no;
    }


    public ArrayList<Ders> getDersler() {
        return dersler;
    }


    public void setDersler(ArrayList<Ders> dersler) {
        this.dersler = dersler;
    }
    
    public double dersOrtalama(){
        double toplam = 0;
        for (int i = 0; i < dersler.size(); i++) {
            toplam += dersler.get(i).getOrtalama();
        }
        return toplam/dersler.size();
    }

    public static Ogrenci ogrenciBul(ArrayList<Ogrenci> ogrenciler, int ogrenciNo) {
        for (int i = 0; i < ogrenciler.size(); i++) {
            Ogrenci ogrenci = ogrenciler.get(i);
            if (ogrenci.getNo() == ogrenciNo) {
                return ogrenci;
            }
        }
        return null; // Ogrenci bulunamazsa null doner
    }
    @Override
    public String toString() {
        String result = "Ogrenci No: " + this.no + ", Ad: " + this.ad;
        
        if(this.dersler != null && this.dersler.size() > 0) {
            result += "\nAldigi Dersler:";
            for (int j = 0; j < dersler.size(); j++) {
                Ders d = dersler.get(j);
                result += "\n    Ders Adi: " + d.getAd() + 
                          ", Vize Notu: " + d.getVizeNot() + 
                          ", Final Notu: " + d.getFinalNot() + 
                          " Ders Ortalamasi: " + d.getOrtalama();
            }
        } else {
            result += "\n    Ogrenciye ait ders bulunmamaktadir.";
        }
        
        return result;
    }
}
