package com.cinemagic.controllers.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.cinemagic.R;
import com.cinemagic.controllers.fragments.HomeFragment;
import com.cinemagic.controllers.fragments.MarketFragment;
import com.cinemagic.controllers.fragments.ProfilFragment;
import com.cinemagic.controllers.fragments.RankFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    /**
     * Redirige vers le bon fragment
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.bottom_navigation_menu_home:
                            showFragment(new HomeFragment());
                            return true;
                        case R.id.bottom_navigation_menu_shop:
                            showFragment(new MarketFragment());
                            return true;
                        case R.id.bottom_navigation_menu_rank:
                            showFragment(new RankFragment());
                            return true;
                        case R.id.bottom_navigation_menu_profil:
                            showFragment(new ProfilFragment());
                            return true;
                    }
                    return false;
                }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showFragment(new HomeFragment());


    }


    /**
     * Affiche le bon fragment sur l'application
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }


}
