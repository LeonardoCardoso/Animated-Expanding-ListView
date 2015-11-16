package com.leocardz.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.leocardz.aelv.library.Aelv;
import com.leocardz.aelv.library.AelvCustomAction;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list);

        listItems = new ArrayList<ListItem>();
        mockItems();

        ListAdapter adapter = new ListAdapter(this, R.layout.list_item, listItems);

        listView.setAdapter(adapter);

        // Setup
        // Aelv aelv = new Aelv(true, 200, listItems, listView, adapter);
        final Aelv aelv = new Aelv(true, 200, listItems, listView, adapter, new AelvCustomAction() {
            @Override
            public void onEndAnimation(int position) {
                listItems.get(position).setDrawable(listItems.get(position).isOpen() ? R.drawable.up : R.drawable.down);
            }
        });

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                aelv.toggle(view, position);
            }
        });
    }

    private void mockItems() {
        final int COLLAPSED_HEIGHT_1 = 150, COLLAPSED_HEIGHT_2 = 200, COLLAPSED_HEIGHT_3 = 250;
        final int EXPANDED_HEIGHT_1 = 250, EXPANDED_HEIGHT_2 = 300, EXPANDED_HEIGHT_3 = 350, EXPANDED_HEIGHT_4 = 400;

        ListItem listItem = new ListItem("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_1, EXPANDED_HEIGHT_1, false);
        listItems.add(listItem);

        listItem = new ListItem("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_2, EXPANDED_HEIGHT_2, false);
        listItems.add(listItem);

        listItem = new ListItem("Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_3, EXPANDED_HEIGHT_3, false);
        listItems.add(listItem);

        listItem = new ListItem("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_2, EXPANDED_HEIGHT_4, false);
        listItems.add(listItem);

        listItem = new ListItem("At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_1, EXPANDED_HEIGHT_4, false);
        listItems.add(listItem);

        listItem = new ListItem("Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_2, EXPANDED_HEIGHT_4, false);
        listItems.add(listItem);

        listItem = new ListItem("Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_3, EXPANDED_HEIGHT_3, false);
        listItems.add(listItem);

        listItem = new ListItem("Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_1, EXPANDED_HEIGHT_4, false);
        listItems.add(listItem);
    }

}
