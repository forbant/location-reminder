package com.example.andrii.reminder;

public class ExampleItem {
    public int getImageResource() {
        return imageResource;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public ExampleItem(int resourceImage, String txt1, String txt2) {
        imageResource = resourceImage;
        text1 = txt1;
        text2 = txt2;
    }

    private int imageResource;
    private String text1;
    private String text2;
}
