
    // Name: Tran Le
    // AID - 1808
    // File name: MainActivity.java

package com.sunny.android.letran_ce04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

    private ArrayList<Review> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateData();

        // Calculate the whole listView height
        ReviewAdapter adapter = new ReviewAdapter(MainActivity.this, data);
        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);

        ListAdapter list_adapter = list.getAdapter();

        if (list_adapter == null) {
            return;
        }

        int totalHeight = 0;
        int lastItemHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, list);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
            lastItemHeight = listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = list.getLayoutParams();
        par.height = totalHeight + (list.getDividerHeight() * (adapter.getCount() - 1)) - (lastItemHeight/5 * 4);
        list.setLayoutParams(par);
        list.requestLayout();
    }

    // Function to populate data - 5 reviews
    private void populateData() {
        data.clear();
        data.add(new Review(R.string.review_name_1, R.string.date_1, R.drawable.pirate, R.string.review_title_1, R.string.review_1, 5));
        data.add(new Review(R.string.review_name_2, R.string.date_2, R.drawable.superhero, R.string.review_title_2, R.string.review_2, 5));
        data.add(new Review(R.string.review_name_3, R.string.date_3, R.drawable.man, R.string.review_title_3, R.string.review_3, 4));
        data.add(new Review(R.string.review_name_4, R.string.date_4, R.drawable.bride, R.string.review_title_4, R.string.review_4, 5));
        data.add(new Review(R.string.review_name_5, R.string.date_5, R.drawable.alien, R.string.review_title_5, R.string.review_5, 4));
    }
}
