package com.facebook.tabnavigation_f6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    /*TabNavigation  is often combined with the ability to swipe
    * childscreens Left to right  and right to left
    *
    * Displaying tabs is Tablayout in the android Design Suppot Library
    * It provides  a horizontal layout to dispaly tabs*/
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab1);
        viewPager = findViewById(R.id.viewpager1);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.add(new CallsFragment(),"Calls");
        adapter.add(new StatusFragment(),"Status");
        adapter.add(new CallsFragment(),"Calls");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}