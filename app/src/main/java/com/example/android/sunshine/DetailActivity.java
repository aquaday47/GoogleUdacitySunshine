package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.net.Inet4Address;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private String mForecast;
    private TextView detailsWeather_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // TODO (2) Display the weather forecast that was passed from MainActivity
        detailsWeather_tv = (TextView) findViewById(R.id.details_TV);
        Intent intentToStartThis = getIntent();
        if (intentToStartThis!=null){
            if (intentToStartThis.hasExtra(Intent.EXTRA_TEXT)){
                mForecast = getIntent().getStringExtra(Intent.EXTRA_TEXT);
                detailsWeather_tv.setText(mForecast);

            }
        }

    }
}