package com.example.deneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public ImageView hesapImage;
    public ImageView emirImage;
    public ImageView payImage;
    public ImageView viopImage;
    public ImageView portfoyImage;

    private DrawerLayout mDrawer;
    private NavigationView mNav;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawer = (DrawerLayout) findViewById(R.id.main_activity_drawerLayout);
        mNav = (NavigationView) findViewById(R.id.main_activity_navigationView);
        mToolbar = (Toolbar) findViewById(R.id.main_activity_toolBar);


        mToggle = new ActionBarDrawerToggle(this,mDrawer,mToolbar,R.string.nav_open,R.string.nav_close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();

        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())  {
                    case R.id.nav_menu_fragment1:
                    startActivity(new Intent(MainActivity.this,HesapActivity.class));
                    return true;
                    case R.id.nav_menu_fragment2:
                    startActivity(new Intent(MainActivity.this,EmirActivity.class));
                    return true;
                    case R.id.nav_menu_fragment3:
                    startActivity(new Intent(MainActivity.this,PortfoyActivity.class));
                    return true;
                    case R.id.nav_menu_fragment5:
                    startActivity(new Intent(MainActivity.this,PayActivity.class));
                    return true;
                    case R.id.nav_menu_fragment6:
                    startActivity(new Intent(MainActivity.this,ViopActivity.class));
                    return true;

                    default:
                    return false;
                }




            }
        });

        hesapImage= findViewById(R.id.hesabim);
        hesapImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent hesap = new Intent(MainActivity.this,HesapActivity.class);
                startActivity(hesap);

            }
        });

        emirImage= findViewById(R.id.emirlerim);
        emirImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emir = new Intent(MainActivity.this,EmirActivity.class);
                startActivity(emir);
            }
        });

        payImage= findViewById(R.id.pay);
        payImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay = new Intent(MainActivity.this,PayActivity.class);
                startActivity(pay);
            }
        });

        viopImage = findViewById(R.id.viop);
        viopImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viop = new Intent(MainActivity.this,ViopActivity.class);
                startActivity(viop);
            }
        });

        portfoyImage= findViewById(R.id.portföy);
        portfoyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent portf = new Intent(MainActivity.this,PortfoyActivity.class);
                startActivity(portf);

            }
        });

    }

}
