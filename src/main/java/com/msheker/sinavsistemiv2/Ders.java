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
public class Ders {
    private String ad;
    private int vizeNot;
    private int finalNot;
    
    // Constructor ekliyoruz
    public Ders() {
        this.vizeNot = 0;
        this.finalNot = 0;
    }
    
    // Parametreli constructor
    public Ders(String ad) {
        this.ad = ad;
        this.vizeNot = 0;
        this.finalNot = 0;
    }
    
    // Tüm parametreli constructor
    public Ders(String ad, int vizeNot, int finalNot) {
        this.ad = ad;
        setVizeNot(vizeNot);
        setFinalNot(finalNot);
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getVizeNot() {
        return vizeNot;
    }

    public void setVizeNot(int vizeNot) {
        if(vizeNot<0 || vizeNot>100){
            this.vizeNot = 0;
            System.out.println("Gecersiz Not Girildi. Not \"0\" olarak ayarlandi.");
        }else
            this.vizeNot = vizeNot;
    }

    public int getFinalNot() {
        return finalNot;
    }

    public void setFinalNot(int finalNot) {
        if(finalNot<0 || finalNot>100){
            this.finalNot=0;
            System.out.println("Gecersiz Not Girildi. Not \"0\" olarak ayarlandi");
        }else
            this.finalNot = finalNot;
    }
        
    public double getOrtalama(){
        return (this.finalNot*0.6 + this.vizeNot*0.4);
    }
    
    public static Ders dersBul(ArrayList<Ders> dersler, String dersAd) {
        for (int i = 0; i < dersler.size(); i++) {
            Ders ders = dersler.get(i);
            if (ders.getAd().equals(dersAd)) {
                return ders;
            }
        }
        return null; // Ders bulunamazsa null doner
    }

    public String toString() {
        return "Ders: " + ad + ", Vize: " + vizeNot + ", Final: " + finalNot + ", Ortalama: " + getOrtalama();
    }
}
