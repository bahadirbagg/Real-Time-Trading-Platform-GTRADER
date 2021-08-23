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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class PortfoyActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private NavigationView mNav;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter3 adapter;



    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfoy);

        ImageView backIcon = findViewById(R.id.backicon);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);


        mDrawer = (DrawerLayout) findViewById(R.id.portfoy_activity_drawerLayout);
        mNav = (NavigationView) findViewById(R.id.portfoy_activity_navigationView);
        mToolbar = (Toolbar) findViewById(R.id.portfoy_activity_toolBar);

        tabLayout= findViewById(R.id.tab_layout);
        pager2= findViewById(R.id.view_pager2);

        mToggle = new ActionBarDrawerToggle(this,mDrawer,mToolbar,R.string.nav_open,R.string.nav_close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();

        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())  {
                    case R.id.nav_menu_fragment1:
                        startActivity(new Intent(PortfoyActivity.this,HesapActivity.class));
                        return true;
                    case R.id.nav_menu_fragment2:
                        startActivity(new Intent(PortfoyActivity.this,EmirActivity.class));
                        return true;
                    case R.id.nav_menu_fragment3:
                        startActivity(new Intent(PortfoyActivity.this,PortfoyActivity.class));
                        return true;
                    case R.id.nav_menu_fragment5:
                        startActivity(new Intent(PortfoyActivity.this,PayActivity.class));
                        return true;
                    case R.id.nav_menu_fragment6:
                        startActivity(new Intent(PortfoyActivity.this,ViopActivity.class));
                        return true;

                    default:
                        return false;
                }




            }
        });
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PortfoyActivity.this,MainActivity.class));
            }
        });
        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter3(fm,getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Pay"));
        tabLayout.addTab(tabLayout.newTab().setText("Vadeli"));

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


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId())
                    {
                        case R.id.nav_anasayfa:

                            startActivity(new Intent(PortfoyActivity.this,MainActivity.class));

                            break;
                        case R.id.nav_hesap:

                            startActivity(new Intent(PortfoyActivity.this,HesapActivity.class));

                            break;
                        case R.id.nav_emir:

                            startActivity(new Intent(PortfoyActivity.this,EmirActivity.class));


                            break;
                        case R.id.nav_piyasa:


                            break;
                    }
                    return false;
                }
            };
}