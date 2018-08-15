package com.geekhouze.qwikbuy.item;

import android.graphics.Outline;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageButton;

import com.geekhouze.qwikbuy.ItemsAdapter;
import com.geekhouze.qwikbuy.R;
import com.geekhouze.qwikbuy.cardview.Album;
import com.geekhouze.qwikbuy.item.Fragment.FragmentItemDescription;
import com.geekhouze.qwikbuy.item.Fragment.FragmentItemInfo;
import com.geekhouze.qwikbuy.item.Fragment.FragmentItemReviews;
import com.geekhouze.qwikbuy.item.ItemViewPagerAdapter;
import com.synnapps.carouselview.CarouselView;

import java.util.ArrayList;
import java.util.List;

public class ItemsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerView2;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.Adapter mAdapter2;
    private RecyclerView.Adapter mAdapter3;
    private ArrayList<String> mDataset;
    private CarouselView carouselView;

    private TabLayout itemTabLayout;
    private ViewPager itemViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemTabLayout = (TabLayout) findViewById(R.id.itemTabLayout_id);
        itemViewPager = (ViewPager) findViewById(R.id.itemViewPager_id);

        mDataset = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mDataset.add("New Title # " + i);
        }

        mRecyclerView2 = (RecyclerView) findViewById(R.id.items_recyclerview);
        mRecyclerView2.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView2.setLayoutManager(mLayoutManager);
        mAdapter2 = new ItemsAdapter(mDataset);
        mRecyclerView2.setAdapter(mAdapter2);

        // Add Fragments to the ItemViewPager
        ItemViewPagerAdapter itemViewPagerAdapter = new ItemViewPagerAdapter(getSupportFragmentManager());
        itemViewPagerAdapter.addFragment(new FragmentItemDescription(), "Description");
        itemViewPagerAdapter.addFragment(new FragmentItemInfo(), "Info");
        itemViewPagerAdapter.addFragment(new FragmentItemReviews(), "Reviews");

        // Adapter Setup
        itemViewPager.setAdapter(itemViewPagerAdapter);
        itemTabLayout.setupWithViewPager(itemViewPager);


    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id =item.getItemId();

        if(id == android.R.id.home){
            //
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
