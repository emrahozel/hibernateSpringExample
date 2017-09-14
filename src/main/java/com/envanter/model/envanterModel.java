package com.envanter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by emrahozel on 13.09.2017.
 */
@Entity
@Table(name = "envanter")
public class envanterModel {

    private int id;
    private String kullanici;
    private String birimi;
    private String malzemeAdi;
    private String marka;
    private String model;
    private String seriNo;
    private int adet;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "kullanici", unique = true, nullable = false)
    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    @Column(name = "birim", unique = true, nullable = false)
    public String getBirimi() {
        return birimi;
    }

    public void setBirimi(String birimi) {
        this.birimi = birimi;
    }

    @Column(name = "malzemeAdi", unique = true, nullable = false)
    public String getMalzemeAdi() {
        return malzemeAdi;
    }

    public void setMalzemeAdi(String malzemeAdi) {
        this.malzemeAdi = malzemeAdi;
    }

    @Column(name = "marka", unique = true, nullable = false)
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Column(name = "model", unique = true, nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "seriNo", unique = true, nullable = false)
    public String getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }

    @Column(name = "adet", unique = true, nullable = false)
    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }
}
