package com.example.deneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class HesapActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private NavigationView mNav;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    TextView textV;
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter adapter;


    BottomNavigationView bottomNavigationView;

    Fragment seciliCerceve = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap);

        ImageView backIcon = findViewById(R.id.backicon);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);


        textV = (TextView) findViewById(R.id.textVieww);

        tabLayout= findViewById(R.id.tab_layout);
        pager2= findViewById(R.id.view_pager2);



        mDrawer = (DrawerLayout) findViewById(R.id.hesap_activity_drawerLayout);
        mNav = (NavigationView) findViewById(R.id.hesap_activity_navigationView);
        mToolbar = (Toolbar) findViewById(R.id.hesap_activity_toolBar2);


        mToggle = new ActionBarDrawerToggle(this, mDrawer,mToolbar,R.string.nav_open,R.string.nav_close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();

        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())  {
                    case R.id.nav_menu_fragment1:
                        startActivity(new Intent(HesapActivity.this,EmirActivity.class));
                        return true;
                    case R.id.nav_menu_fragment2:
                        startActivity(new Intent(HesapActivity.this,EmirActivity.class));
                        return true;
                    case R.id.nav_menu_fragment3:
                        startActivity(new Intent(HesapActivity.this,PortfoyActivity.class));
                        return true;
                    case R.id.nav_menu_fragment5:
                        startActivity(new Intent(HesapActivity.this,PayActivity.class));
                        return true;
                    case R.id.nav_menu_fragment6:
                        startActivity(new Intent(HesapActivity.this,ViopActivity.class));
                        return true;

                    default:
                        return false;
                }




            }
        });
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HesapActivity.this,MainActivity.class));
            }
        });

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm,getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Nakit"));
        tabLayout.addTab(tabLayout.newTab().setText("Viop"));

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

                            startActivity(new Intent(HesapActivity.this,MainActivity.class));

                            break;
                        case R.id.nav_hesap:

                            startActivity(new Intent(HesapActivity.this,PortfoyActivity.class));

                            break;
                        case R.id.nav_emir:

                            startActivity(new Intent(HesapActivity.this,EmirActivity.class));


                            break;
                        case R.id.nav_piyasa:


                            break;
                    }
                        return false;
                }


            };
}