package com.example.deneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class ViopActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private NavigationView mNav;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter4 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viop);

            ImageView backIcon = findViewById(R.id.backbutton);

            mDrawer = (DrawerLayout) findViewById(R.id.viop_activity_drawerLayout);
            mNav = (NavigationView) findViewById(R.id.viop_activity_navigationView);
            mToolbar = (Toolbar) findViewById(R.id.viop_activity_toolBar);

            tabLayout= findViewById(R.id.tab_layout);
            pager2= findViewById(R.id.view_pager2);

            mToggle = new ActionBarDrawerToggle(this,mDrawer,mToolbar,R.string.nav_open,R.string.nav_close);
            mDrawer.addDrawerListener(mToggle);
            mToggle.syncState();


        backIcon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(ViopActivity.this,MainActivity.class));
        }
    });
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())  {
                    case R.id.nav_menu_fragment1:
                        startActivity(new Intent(ViopActivity.this,HesapActivity.class));
                        return true;
                    case R.id.nav_menu_fragment2:
                        startActivity(new Intent(ViopActivity.this,EmirActivity.class));
                        return true;
                    case R.id.nav_menu_fragment3:
                        startActivity(new Intent(ViopActivity.this,PortfoyActivity.class));
                        return true;
                    case R.id.nav_menu_fragment5:
                        startActivity(new Intent(ViopActivity.this,PayActivity.class));
                        return true;
                    case R.id.nav_menu_fragment6:
                        startActivity(new Intent(ViopActivity.this,ViopActivity.class));
                        return true;

                    default:
                        return false;
                }




            }
        });
        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter4(fm,getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Emirler"));
        tabLayout.addTab(tabLayout.newTab().setText("Pozisyon"));
        tabLayout.addTab(tabLayout.newTab().setText("Bakiye"));
        tabLayout.addTab(tabLayout.newTab().setText("Grafik"));
        tabLayout.addTab(tabLayout.newTab().setText("Haber"));
        tabLayout.addTab(tabLayout.newTab().setText("Bilanço"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViopActivity.this,MainActivity.class));
            }
        });
}
}