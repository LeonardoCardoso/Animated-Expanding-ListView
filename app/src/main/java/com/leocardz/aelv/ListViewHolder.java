package com.leocardz.aelv;

import android.widget.LinearLayout;
import android.widget.TextView;

public class ListViewHolder {
	private LinearLayout textViewWrap;
	private TextView textView;

	public ListViewHolder(LinearLayout textViewWrap, TextView textView) {
		super();
		this.textViewWrap = textViewWrap;
		this.textView = textView;
	}

	public TextView getTextView() {
		return textView;
	}

	public void setTextView(TextView textView) {
		this.textView = textView;
	}

	public LinearLayout getTextViewWrap() {
		return textViewWrap;
	}

	public void setTextViewWrap(LinearLayout textViewWrap) {
		this.textViewWrap = textViewWrap;
	}
}
