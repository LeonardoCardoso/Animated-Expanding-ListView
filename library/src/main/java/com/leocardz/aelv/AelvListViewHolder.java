package com.leocardz.aelv;

import android.view.View;

public class AelvListViewHolder {
    private View viewWrap;

    public AelvListViewHolder() {
    }

    public AelvListViewHolder(View viewWrap) {
        super();
        this.viewWrap = viewWrap;
    }

    public View getViewWrap() {
        return viewWrap;
    }

    public void setViewWrap(View viewWrap) {
        this.viewWrap = viewWrap;
    }
}
