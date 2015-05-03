package com.leocardz.aelv;

public class AelvListItem {

    private int collapsedHeight, currentHeight, expandedHeight;
    private boolean isOpen;
    private AelvListViewHolder holder;

    public AelvListItem() {
    }

    public void setUp(int collapsedHeight, int expandedHeight, boolean isOpen) {
        this.collapsedHeight = collapsedHeight;
        this.currentHeight = isOpen ? expandedHeight : collapsedHeight;
        this.expandedHeight = expandedHeight;
        this.isOpen = isOpen;
    }

    public int getCollapsedHeight() {
        return collapsedHeight;
    }

    public void setCollapsedHeight(int collapsedHeight) {
        this.collapsedHeight = collapsedHeight;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }

    public void setCurrentHeight(int currentHeight) {
        this.currentHeight = currentHeight;
    }

    public int getExpandedHeight() {
        return expandedHeight;
    }

    public void setExpandedHeight(int expandedHeight) {
        this.expandedHeight = expandedHeight;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public AelvListViewHolder getHolder() {
        return holder;
    }

    public void setHolder(AelvListViewHolder holder) {
        this.holder = holder;
    }

}
