package com.example.mdw.rxjavademo.navigation_drawer;

import android.graphics.drawable.Drawable;

/**
 * Created by mdw on 2016/3/4.
 */
public class NavigationItem {

    private String mText;
    private Drawable mDrawable;


    public NavigationItem(String text,Drawable drawable){
        mText = text;
        mDrawable= drawable;

    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public Drawable getDrawable() {
        return mDrawable;
    }

    public void setDrawable(Drawable mDrawable) {
        this.mDrawable = mDrawable;
    }
}
