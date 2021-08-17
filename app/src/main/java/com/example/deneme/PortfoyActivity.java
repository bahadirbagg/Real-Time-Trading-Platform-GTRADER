package com.example.deneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PortfoyActivity extends AppCompatActivity {




    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfoy);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
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