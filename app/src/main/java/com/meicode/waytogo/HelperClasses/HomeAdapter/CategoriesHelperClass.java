package com.meicode.waytogo.HelperClasses.HomeAdapter;

import android.graphics.drawable.Drawable;

public class CategoriesHelperClass {

    int image;
    String title;



    public CategoriesHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitile() {
        return title;
    }


}
