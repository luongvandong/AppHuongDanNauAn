package com.example.dongpc.apphuongdannauan.entities;

/**
 * Created by DongPC on 4/15/2017.
 */

public class Introduce {
    private int imageScreen;
    private String name;

    public Introduce(int imageScreen, String name) {
        this.imageScreen = imageScreen;
        this.name = name;
    }

    public int getImageScreen() {
        return imageScreen;
    }

    public void setImageScreen(int imageScreen) {
        this.imageScreen = imageScreen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
