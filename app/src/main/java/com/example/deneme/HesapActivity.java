package com.example.deneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HesapActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private NavigationView mNav;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    Button button1;
    Button button2;
    TextView textV;

    BottomNavigationView bottomNavigationView;

    Fragment seciliCerceve = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        button1 = (Button) findViewById(R.id.button_nakit);
        button2 = (Button) findViewById(R.id.button_viop);
        textV = (TextView) findViewById(R.id.textVieww);

        mDrawer = (DrawerLayout) findViewById(R.id.hesap_activity_drawerLayout);
        mNav = (NavigationView) findViewById(R.id.hesap_activity_navigationView);
        mToolbar = (Toolbar) findViewById(R.id.hesap_activity_toolBar);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setContentView(R.layout.hesap_viop);
            }
        });



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

                            startActivity(new Intent(HesapActivity.this,HesapActivity.class));

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