package com.leocardz.aelv;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	private ListView listView;
	private ArrayList<ListItem> listItems;
	private ListAdapter adapter;

	private final int COLLAPSED_HEIGHT_1 = 150, COLLAPSED_HEIGHT_2 = 200,
			COLLAPSED_HEIGHT_3 = 250;

	private final int EXPANDED_HEIGHT_1 = 250, EXPANDED_HEIGHT_2 = 300,
			EXPANDED_HEIGHT_3 = 350, EXPANDED_HEIGHT_4 = 400;

	private boolean accordion = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.list);

		listItems = new ArrayList<ListItem>();
		mockItems();

		adapter = new ListAdapter(this, R.layout.list_item, listItems);

		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				toggle(view, position);
			}
		});
	}

	private void toggle(View view, final int position) {
		ListItem listItem = listItems.get(position);
		listItem.getHolder().setTextViewWrap((LinearLayout) view);

		int fromHeight = 0;
		int toHeight = 0;

		if (listItem.isOpen()) {
			fromHeight = listItem.getExpandedHeight();
			toHeight = listItem.getCollapsedHeight();
		} else {
			fromHeight = listItem.getCollapsedHeight();
			toHeight = listItem.getExpandedHeight();

			// This closes all item before the selected one opens
			if (accordion) {
				closeAll();
			}
		}

		toggleAnimation(listItem, position, fromHeight, toHeight, true);
	}

	private void closeAll() {
		int i = 0;
		for (ListItem listItem : listItems) {
			if (listItem.isOpen()) {
				toggleAnimation(listItem, i, listItem.getExpandedHeight(),
						listItem.getCollapsedHeight(), false);
			}
			i++;
		}
	}

	private void toggleAnimation(final ListItem listItem, final int position,
			final int fromHeight, final int toHeight, final boolean goToItem) {

		ResizeAnimation resizeAnimation = new ResizeAnimation(adapter,
				listItem, 0, fromHeight, 0, toHeight);
		resizeAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				listItem.setOpen(!listItem.isOpen());
				listItem.setDrawable(listItem.isOpen() ? R.drawable.up
						: R.drawable.down);
				listItem.setCurrentHeight(toHeight);
				adapter.notifyDataSetChanged();

				if (goToItem)
					goToItem(position);
			}
		});

		listItem.getHolder().getTextViewWrap().startAnimation(resizeAnimation);
	}

	private void goToItem(final int position) {
		listView.post(new Runnable() {
			@Override
			public void run() {
				try {
					listView.smoothScrollToPosition(position);
				} catch (Exception e) {
					listView.setSelection(position);
				}
			}
		});
	}

	private void mockItems() {
		listItems
				.add(new ListItem(
						"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
						COLLAPSED_HEIGHT_1, COLLAPSED_HEIGHT_1,
						EXPANDED_HEIGHT_1));

		listItems
				.add(new ListItem(
						"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
						COLLAPSED_HEIGHT_2, COLLAPSED_HEIGHT_2,
						EXPANDED_HEIGHT_2));

		listItems
				.add(new ListItem(
						"Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
						COLLAPSED_HEIGHT_3, COLLAPSED_HEIGHT_3,
						EXPANDED_HEIGHT_3));

		listItems
				.add(new ListItem(
						"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.",
						COLLAPSED_HEIGHT_2, COLLAPSED_HEIGHT_2,
						EXPANDED_HEIGHT_4));

		listItems
				.add(new ListItem(
						"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga.",
						COLLAPSED_HEIGHT_1, COLLAPSED_HEIGHT_1,
						EXPANDED_HEIGHT_4));

		listItems
				.add(new ListItem(
						"Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus.",
						COLLAPSED_HEIGHT_2, COLLAPSED_HEIGHT_2,
						EXPANDED_HEIGHT_4));

		listItems
				.add(new ListItem(
						"Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae.",
						COLLAPSED_HEIGHT_3, COLLAPSED_HEIGHT_3,
						EXPANDED_HEIGHT_3));

		listItems
				.add(new ListItem(
						"Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.",
						COLLAPSED_HEIGHT_1, COLLAPSED_HEIGHT_1,
						EXPANDED_HEIGHT_4));

	}

}
