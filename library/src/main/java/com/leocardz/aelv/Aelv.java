package com.leocardz.aelv;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Aelv {

    private boolean accordion;
    private int duration;
    private ArrayList<?> listItems;
    private ListView listView;
    private ArrayAdapter<?> adapter;
    private AelvCustomAction aelvCustomAction;

    public Aelv(boolean accordion, int duration, ArrayList<?> listItems, ListView listView, ArrayAdapter<?> adapter) {
        this.accordion = accordion;
        this.duration = duration;
        this.listItems = listItems;
        this.listView = listView;
        this.adapter = adapter;
    }

    public Aelv(boolean accordion, int duration, ArrayList<?> listItems, ListView listView, ArrayAdapter<?> adapter, AelvCustomAction aelvCustomAction) {
        this.accordion = accordion;
        this.duration = duration;
        this.listItems = listItems;
        this.listView = listView;
        this.adapter = adapter;
        this.aelvCustomAction = aelvCustomAction;
    }

    public void toggle(View view, final int position) {
        AelvListItem listItem = (AelvListItem) listItems.get(position);
        listItem.getHolder().setViewWrap(view);

        int fromHeight = 0;
        int toHeight = 0;

        if (listItem.isOpen()) {
            fromHeight = listItem.getExpandedHeight();
            toHeight = listItem.getCollapsedHeight();
        } else {
            fromHeight = listItem.getCollapsedHeight();
            toHeight = listItem.getExpandedHeight();

            // This closes all item before the selected one opens
            if (isAccordion()) {
                closeAll();
            }
        }

        toggleAnimation(listItem, position, fromHeight, toHeight, true);
    }

    private void closeAll() {
        int i = 0;
        for (Object listItem : listItems) {
            AelvListItem aelvListItem = ((AelvListItem) listItem);
            if (aelvListItem.isOpen()) {
                toggleAnimation(aelvListItem, i, aelvListItem.getExpandedHeight(), aelvListItem.getCollapsedHeight(), false);
            }
            i++;
        }
    }

    private void toggleAnimation(final AelvListItem listItem, final int position,
                                 final int fromHeight, final int toHeight, final boolean scrollToItem) {

        AelvResizeAnimation resizeAnimation = new AelvResizeAnimation(getAdapter(), listItem, 0, fromHeight, 0, toHeight, getDuration());
        resizeAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                listItem.setOpen(!listItem.isOpen());

                if (getAelvCustomAction() != null) {
                    getAelvCustomAction().onEndAnimation(position);
                }

                listItem.setCurrentHeight(toHeight);
                getAdapter().notifyDataSetChanged();

                if (scrollToItem) {
                    scrollToItem(position);
                }

            }
        });

        listItem.getHolder().getViewWrap().startAnimation(resizeAnimation);
    }

    @SuppressLint("NewApi")
    private void scrollToItem(final int position) {
        getListView().post(new Runnable() {
            @Override
            public void run() {
                try {
                    getListView().smoothScrollToPosition(position);
                } catch (Exception e) {
                    getListView().setSelection(position);
                }
            }
        });
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isAccordion() {
        return accordion;
    }

    public void setAccordion(boolean accordion) {
        this.accordion = accordion;
    }

    public ArrayList<?> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<?> listItems) {
        this.listItems = listItems;
    }

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    public ArrayAdapter<?> getAdapter() {
        return adapter;
    }

    public void setAdapter(ArrayAdapter<?> adapter) {
        this.adapter = adapter;
    }

    public AelvCustomAction getAelvCustomAction() {
        return aelvCustomAction;
    }

    public void setAelvCustomAction(AelvCustomAction aelvCustomAction) {
        this.aelvCustomAction = aelvCustomAction;
    }
}
