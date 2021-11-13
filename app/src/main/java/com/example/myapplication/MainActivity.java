package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomnavigationview);
        viewPager=findViewById(R.id.viewpager);
        Mypage mypage=new Mypage(getSupportFragmentManager());
        viewPager.setAdapter(mypage);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item1:
                        viewPager.setCurrentItem(0);break;
                    case R.id.item2:
                        viewPager.setCurrentItem(1);break;
                    case R.id.item3:
                        viewPager.setCurrentItem(2);break;
                }



                return true;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "joxo", Toast.LENGTH_SHORT).show();
                        bottomNavigationView.getMenu().findItem(R.id.item1).setChecked(true);break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.item2).setChecked(true);break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.item3).setChecked(true);break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}