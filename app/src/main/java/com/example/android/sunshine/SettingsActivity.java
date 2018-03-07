package com.example.android.sunshine;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.preference.Preference;
import android.view.MenuItem;

/**
 * Created by aaron on 3/6/2018.
 */

public class SettingsActivity extends AppCompatActivity implements Preference.OnPreferenceChangeListener,
        SharedPreferences.OnSharedPreferenceChangeListener {

    // TODO (1) Add new Activity called SettingsActivity using Android Studio wizard
    // Do step 2 in SettingsActivity
    // TODO (2) Set setDisplayHomeAsUpEnabled to true on the support ActionBar
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        android.support.v7.app.ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newVal) {
        return true;
    }
}
