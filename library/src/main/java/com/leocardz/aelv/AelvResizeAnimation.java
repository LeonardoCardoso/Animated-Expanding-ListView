package com.leocardz.aelv;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;

public class AelvResizeAnimation extends Animation {
    private View mView;
    private float mToHeight;
    private float mFromHeight;

    private float mToWidth;
    private float mFromWidth;

    private ArrayAdapter<?> mListAdapter;
    private AelvListItem mAelvListItem;

    public AelvResizeAnimation(ArrayAdapter<?> listAdapter, AelvListItem aelvListItem,
                               float fromWidth, float fromHeight, float toWidth, float toHeight, int duration) {
        mToHeight = toHeight;
        mToWidth = toWidth;
        mFromHeight = fromHeight;
        mFromWidth = fromWidth;
        mView = aelvListItem.getHolder().getViewWrap();
        mListAdapter = listAdapter;
        mAelvListItem = aelvListItem;
        setDuration(duration);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float height = (mToHeight - mFromHeight) * interpolatedTime + mFromHeight;
        float width = (mToWidth - mFromWidth) * interpolatedTime + mFromWidth;
        LayoutParams p = (LayoutParams) mView.getLayoutParams();
        p.height = (int) height;
        p.width = (int) width;
        mAelvListItem.setCurrentHeight(p.height);
        mListAdapter.notifyDataSetChanged();
    }
}
