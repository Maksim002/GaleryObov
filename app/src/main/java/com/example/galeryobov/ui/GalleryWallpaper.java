package com.example.galeryobov.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.galeryobov.R;
import com.example.galeryobov.ui.adapter.AdapterGalleryViewPager;
import com.example.galeryobov.ui.adapter.ViewPegerAdaptor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GalleryWallpaper extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_wallpaper);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        viewPager = findViewById(R.id.viewPager);

        setupViewPager();
        setupNavigationView();

    }
    private void setupNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.winter:
                                viewPager.setCurrentItem(0);
                                return true;
                            case R.id.nature:
                                viewPager.setCurrentItem(1);
                                return true;
                            case R.id.other:
                                viewPager.setCurrentItem(2);
                                return true;
                            case R.id.new_year:
                                viewPager.setCurrentItem(3);
                                return true;
                        }
                        return false;
                    }
                });
    }

    private void setupViewPager() {
        ViewPegerAdaptor adaptor = new ViewPegerAdaptor(getSupportFragmentManager());
        adaptor.addFragment(new Winter());
        adaptor.addFragment(new Nature());
        adaptor.addFragment(new Other());
        adaptor.addFragment(new NewYear());
        viewPager.setAdapter(adaptor);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.winter);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.nature);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.other);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.new_year);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }
}

