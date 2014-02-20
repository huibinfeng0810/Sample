package com.huibinfeng0810.Sample;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import font_shadow.FontShadowActivity;
import loader.ContactSearchFragment;
import menu.MenuForChange;
import popuwindow.PopuWindowActivity;
import search.SearchableActivity;
import service.ServiceActivity;
import slidingmenu.activity.SlidingTestActivity;
import spinner.SpinnerActivity;

import java.util.Arrays;
import java.util.List;

public class MyActivity extends ListActivity {
    /**
     * Called when the activity is first created.
     */
    private static final List<ActivityInfo> activityinfos = Arrays.asList(
            new ActivityInfo(SpinnerActivity.class, R.string.spinner),
            new ActivityInfo(ServiceActivity.class, R.string.service),
            new ActivityInfo(PopuWindowActivity.class, R.string.popu),
            new ActivityInfo(SlidingTestActivity.class, R.string.sliding),
            new ActivityInfo(MenuForChange.class, R.string.menu1),
            new ActivityInfo(SearchableActivity.class, R.string.search),
            new ActivityInfo(FontShadowActivity.class, R.string.font_shadow),
            new ActivityInfo(ContactSearchFragment.class, R.string.loader)
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String[] titles = getActivityTitles();
        setListAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, titles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Class<? extends Activity> class_ = activityinfos.get(position).class_;
        Intent intent = new Intent(this, class_);
        startActivity(intent);
    }

    private String[] getActivityTitles() {
        String[] result = new String[activityinfos.size()];
        int i = 0;
        for (ActivityInfo info : activityinfos) {
            result[i++] = getString(info.titleResourceId);
        }
        return result;
    }
}
