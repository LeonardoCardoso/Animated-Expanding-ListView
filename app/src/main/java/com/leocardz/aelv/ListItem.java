package com.leocardz.aelv;

public class ListItem {

	private String text;
	private int collapsedHeight, currentHeight, expandedHeight;
	private boolean isOpen;
	private ListViewHolder holder;
	private int drawable;

	public ListItem(String text, int collapsedHeight, int currentHeight,
			int expandedHeight) {
		super();
		this.text = text;
		this.collapsedHeight = collapsedHeight;
		this.currentHeight = currentHeight;
		this.expandedHeight = expandedHeight;
		this.isOpen = false;
		this.drawable = R.drawable.down;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public ListViewHolder getHolder() {
		return holder;
	}

	public void setHolder(ListViewHolder holder) {
		this.holder = holder;
	}

	public int getDrawable() {
		return drawable;
	}

	public void setDrawable(int drawable) {
		this.drawable = drawable;
	}

}
