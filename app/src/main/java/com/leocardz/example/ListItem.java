package com.leocardz.example;

import com.leocardz.aelv.library.AelvListItem;

public class ListItem extends AelvListItem {

    private String text;
    private int drawable;

    public ListItem(String text) {
        super();
        this.text = text;
        this.drawable = R.drawable.down;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

}
