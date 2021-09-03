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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.util.Date;

public class ViopActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private NavigationView mNav;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter5 adapter;

    int minteger = 0;
    int minteger2 = 0;

    private Button alışButton;
    private Button satışButton;
    private Button iletButton;

    int counter=0;
    int counter2=0;
    int counter3=0;
    TextView sText;
    TextView sText2;
    TextView sText3;
    TextView sTarih;

    String[] stringText = new String[]{
            "LMT",
            "PYL"
    };
    String[] stringText2 = new String[]{
            "Gün",
            "IKG",
            "TAR"
    };
    String[] stringText3 = new String[]{
            "KPY",
            "KIE",
            "GIE"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viop);





            ImageView backIcon = findViewById(R.id.backbutton);

            alışButton = (Button) findViewById(R.id.alış);
            satışButton = (Button) findViewById(R.id.satış);
            iletButton = (Button) findViewById(R.id.ilet);

            mDrawer = (DrawerLayout) findViewById(R.id.viop_activity_drawerLayout);
            mNav = (NavigationView) findViewById(R.id.viop_activity_navigationView);
            mToolbar = (Toolbar) findViewById(R.id.viop_activity_toolBar);

            sText = (TextView) findViewById(R.id.stext);
            sText2 = (TextView) findViewById(R.id.stext2);
            sText3 = (TextView) findViewById(R.id.stext3);
            sTarih = (TextView) findViewById(R.id.tarih);
            sText.setText(stringText[counter]);
            sText2.setText(stringText2[counter2]);
            sText3.setText(stringText3[counter3]);
            counter++;
            counter2++;
            counter3++;

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
        alışButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alışButton.setBackgroundResource(R.drawable.btn_shape11);
                alışButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                iletButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                iletButton.setBackgroundColor(getApplication().getResources().getColor(R.color.Green));
                satışButton.setBackgroundResource(R.drawable.btn_shape3);
                satışButton.setTextColor(getApplication().getResources().getColor(R.color.Red));

            }
        });
        satışButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                satışButton.setBackgroundResource(R.drawable.btn_shape33);
                satışButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                iletButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                iletButton.setBackgroundColor(getApplication().getResources().getColor(R.color.Red));
                alışButton.setBackgroundResource(R.drawable.btn_shape);
                alışButton.setTextColor(getApplication().getResources().getColor(R.color.Green));

            }
        });

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter5(fm,getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Emirler"));
        tabLayout.addTab(tabLayout.newTab().setText("Pozisyon"));
        tabLayout.addTab(tabLayout.newTab().setText("Teminat"));


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
    public  void next(View view){

        sText.setText(stringText[counter]);
        counter++;
        if(counter==2) {
            counter=0;
        }


    }
    public  void prev(View view){

        if (counter==0){
            counter=2;
        }
        counter--;

    }
    public  void next2(View view){
        sText2.setText(stringText2[counter2]);
        counter2++;
        sTarih.setText(null);
        if(counter2==3) {
            counter2=0;
        }
        if (stringText2[counter2]=="Gün") {
            Calendar calendar = Calendar.getInstance();
            String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
            TextView textViewDate = findViewById(R.id.tarih);
            textViewDate.setText(currentDate);
            sTarih.setText(currentDate);
        }
    }
    public  void prev2(View view){


        if (counter2==0){
            counter2=3;
        }
        counter2--;
        sText2.setText(stringText2[counter2]);

    }
    public  void next3(View view){
        sText3.setText(stringText3[counter3]);
        counter3++;
        if(counter3==3) {
            counter3=0;
        }
    }
    public  void prev3(View view){


        if (counter3==0){
            counter3=3;
        }
        counter3--;
        sText3.setText(stringText3[counter3]);

    }
    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }
    public void increaseInteger2(View view) {
        minteger2 = minteger2 + 1;
        display2(minteger2);

    }public void decreaseInteger2(View view) {
        minteger2 = minteger2 - 1;
        display2(minteger2);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.fiyat);
        displayInteger.setText("" + number);

    }
    private void display2(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.miktar);
        displayInteger.setText("" + number);

    }
    public void iletildi(View view) {
        openDialog();
    }

    private void openDialog() {
        Dialog2 exampleDialog = new Dialog2();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");
        //exampleDialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_shape));


    }
}