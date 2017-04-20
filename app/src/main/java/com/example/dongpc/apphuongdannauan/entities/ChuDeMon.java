package com.example.dongpc.apphuongdannauan.entities;

/**
 * Created by DongPC on 4/15/2017.
 */

public class ChuDeMon {
    private int maChuDe;
    private String tenChuDe;
    private byte[] hinhAnhChuDe;

    public ChuDeMon() {
    }

    public ChuDeMon(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public ChuDeMon(int maChuDe, String tenChuDe, byte[] hinhAnhChuDe) {
        this.maChuDe = maChuDe;
        this.tenChuDe = tenChuDe;
        this.hinhAnhChuDe = hinhAnhChuDe;
    }

    public int getMaChuDe() {
        return maChuDe;
    }

    public void setMaChuDe(int maChuDe) {
        this.maChuDe = maChuDe;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public byte[] getHinhAnhChuDe() {
        return hinhAnhChuDe;
    }

    public void setHinhAnhChuDe(byte[] hinhAnhChuDe) {
        this.hinhAnhChuDe = hinhAnhChuDe;
    }

    @Override
    public String toString() {
        return "ChuDeMon{" +
                "maChuDe=" + maChuDe +
                ", tenChuDe='" + tenChuDe + '\'' +
                ", hinhAnhChuDe='" + hinhAnhChuDe + '\'' +
                '}';
    }
}
