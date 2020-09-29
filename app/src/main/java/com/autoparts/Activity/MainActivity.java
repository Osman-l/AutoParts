package com.autoparts.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.autoparts.Fragment.FragmentMarka;
import com.autoparts.Fragment.FragmentInfo;
import com.autoparts.Fragment.FragmentSearch;
import com.autoparts.Fragment.FragmentStar;
import com.autoparts.R;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new FragmentMarka();
        bottomNavigation = (BottomNavigationView)findViewById(R.id.navigation);
        //bottomNavigation.inflateMenu(R.menu.menu_navigation);
        fragmentManager = getSupportFragmentManager();
        fragment = new FragmentMarka();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment).commit();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.navigation_catalogs:
                        fragment = new FragmentMarka();
                        break;
                    case R.id.navigation_serch:
                        fragment = new FragmentSearch();
                        break;
                   /* case R.id.navigation_star:
                        fragment = new FragmentStar();
                        break;*/
                    case R.id.navigation_info:
                        fragment = new FragmentInfo();
                        break;
                }
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });

    }
}
