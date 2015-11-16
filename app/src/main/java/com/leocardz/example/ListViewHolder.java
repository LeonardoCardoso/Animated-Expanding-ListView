package com.leocardz.example;

import android.widget.TextView;

import com.leocardz.aelv.library.AelvListViewHolder;


public class ListViewHolder extends AelvListViewHolder {
    private TextView textView;

    public ListViewHolder(TextView textView) {
        super();
        this.textView = textView;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
