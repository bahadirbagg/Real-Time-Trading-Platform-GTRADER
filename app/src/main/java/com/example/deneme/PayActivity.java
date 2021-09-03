package com.example.deneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class PayActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private NavigationView mNav;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter4 adapter;

    private Button alışButton;
    private Button satışButton;
    private Button iletButton;
    private Button açığaButton;

    int minteger = 0;
    int minteger2 = 0;

    TextView sText;
    TextView sText2;
    int counter=0;
    int counter2=0;
    String[] stringText = new String[]{
            "LMT",
            "PYS",
            "PYL"
    };
    String[] stringTextLMT = new String[]{
            "Gün",
            "KIE",
            "IKG"
    };
    String[] stringTextPYS = new String[]{
            "KIE",
            "DENGE",
            "KIE"
    };
    String[] stringTextPYL = new String[]{
            "Gün",
            "KIE",
            "Gün"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        ImageView backIcon = findViewById(R.id.backbutton);

        sText = (TextView) findViewById(R.id.stext);
        sText2 = (TextView) findViewById(R.id.stext2);
        sText.setText(stringText[counter]);
        sText2.setText(stringTextLMT[counter2]);

        alışButton = (Button) findViewById(R.id.alış);
        satışButton = (Button) findViewById(R.id.satış);
        iletButton = (Button) findViewById(R.id.ilet);
        açığaButton = (Button) findViewById(R.id.açığa);

        mDrawer = (DrawerLayout) findViewById(R.id.pay_activity_drawerLayout);
        mNav = (NavigationView) findViewById(R.id.pay_activity_navigationView);
        mToolbar = (Toolbar) findViewById(R.id.pay_activity_toolBar);

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
                        startActivity(new Intent(PayActivity.this,HesapActivity.class));
                        return true;
                    case R.id.nav_menu_fragment2:
                        startActivity(new Intent(PayActivity.this,EmirActivity.class));
                        return true;
                    case R.id.nav_menu_fragment3:
                        startActivity(new Intent(PayActivity.this,PortfoyActivity.class));
                        return true;
                    case R.id.nav_menu_fragment5:
                        startActivity(new Intent(PayActivity.this,PayActivity.class));
                        return true;
                    case R.id.nav_menu_fragment6:
                        startActivity(new Intent(PayActivity.this,ViopActivity.class));
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
                satışButton.setBackgroundResource(R.drawable.btn_shape2);
                satışButton.setTextColor(getApplication().getResources().getColor(R.color.Red));
                açığaButton.setBackgroundResource(R.drawable.btn_shape4);
                açığaButton.setTextColor(getApplication().getResources().getColor(R.color.Yellow));

            }
        });
        satışButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                satışButton.setBackgroundResource(R.drawable.btn_shape22);
                satışButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                iletButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                iletButton.setBackgroundColor(getApplication().getResources().getColor(R.color.Red));
                alışButton.setBackgroundResource(R.drawable.btn_shape);
                alışButton.setTextColor(getApplication().getResources().getColor(R.color.Green));
                açığaButton.setBackgroundResource(R.drawable.btn_shape4);
                açığaButton.setTextColor(getApplication().getResources().getColor(R.color.Yellow));

            }
        });
        açığaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alışButton.setBackgroundResource(R.drawable.btn_shape);
                alışButton.setTextColor(getApplication().getResources().getColor(R.color.Green));
                iletButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                iletButton.setBackgroundColor(getApplication().getResources().getColor(R.color.Yellow));
                satışButton.setBackgroundResource(R.drawable.btn_shape2);
                satışButton.setTextColor(getApplication().getResources().getColor(R.color.Red));
                açığaButton.setBackgroundResource(R.drawable.btn_shape44);
                açığaButton.setTextColor(getApplication().getResources().getColor(R.color.white));

            }
        });
        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter4(fm,getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Emirler"));
        tabLayout.addTab(tabLayout.newTab().setText("Pozisyon"));
        tabLayout.addTab(tabLayout.newTab().setText("Bakiye"));


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
                startActivity(new Intent(PayActivity.this,MainActivity.class));
            }
        });


    }
    public  void next(View view){

        sText.setText(stringText[counter]);
        counter++;
        sText2.setText(stringTextPYL[0]);
        if(counter==3) {
            counter=0;
        }
        if (counter==2){
            sText2.setText(stringTextPYS[0]);
        }


    }
    public  void prev(View view){

        if (counter==0){
            counter=3;
        }
        counter--;
        sText.setText(stringText[counter]);
        sText2.setText(stringTextPYL[0]);
        if (counter==1){
            sText2.setText(stringTextPYS[0]);
        }

    }
    public  void next2(View view){
        if (stringText[counter]=="LMT") {
            sText2.setText(stringTextLMT[counter2]);
            counter2++;
        }
        if (stringText[counter]=="PYS") {
            sText2.setText(stringTextPYS[counter2]);
            counter2++;
        }
        if (stringText[counter]=="PYL") {
            sText2.setText(stringTextPYL[counter2]);
            counter2++;
        }
        if(counter2==3){
            counter2=0;
        }
    }
    public  void prev2(View view){


        if (stringText[counter]=="LMT") {
            sText2.setText(stringTextLMT[counter2]);
            counter2--;
        }
        if (stringText[counter]=="PYS") {
            sText2.setText(stringTextPYS[counter2]);
            counter2--;
        }
        if (stringText[counter]=="PYL") {
            sText2.setText(stringTextPYL[counter2]);
            counter2--;
        }
        if(counter2==-1){
            counter2=2;
        }

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
                R.id.lot);
        displayInteger.setText("" + number);

    }
    private void display2(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.fiyat);
        displayInteger.setText("" + number);

    }
    public void iletildi(View view) {
       openDialog();
    }

    private void openDialog() {
        Dialog exampleDialog = new Dialog();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");
        //exampleDialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_shape));


    }

}
