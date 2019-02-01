package com.example.lockdown;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

public class ManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_management);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);

        bottom_nav_init();
    }

    // Set bottom navigation bar
    private void bottom_nav_init() {
        Intent intent_toMap = new Intent(ManageActivity.this, MapsActivity.class);
        BottomNavigationView bottomNV = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch ( menuItem.getItemId()) {
                    case R.id.navigation_map:
                        startActivity(intent_toMap);
                        return true;
                    case R.id.navigation_explore:
                        return true;
                    case R.id.navigation_yourfootprint:
                        return false;
                }
                return false;
            }
        });
        bottomNV.setSelectedItemId(R.id.navigation_yourfootprint);
    }
}
