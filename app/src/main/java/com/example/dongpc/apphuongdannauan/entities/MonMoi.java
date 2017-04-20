package com.example.dongpc.apphuongdannauan.entities;

/**
 * Created by DongPC on 4/18/2017.
 */

public class MonMoi {
    private int maMon;
    private String tenMon;
    private String ngayLap;
    private String noiDung;
    private int maChuDe;

    public MonMoi(int maMon, String tenMon, String ngayLap, String noiDung, int maChuDe) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.ngayLap = ngayLap;
        this.noiDung = noiDung;
        this.maChuDe = maChuDe;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getMaChuDe() {
        return maChuDe;
    }

    public void setMaChuDe(int maChuDe) {
        this.maChuDe = maChuDe;
    }
}
