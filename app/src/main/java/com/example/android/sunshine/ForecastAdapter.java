package com.example.android.sunshine;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import static java.security.AccessController.getContext;

/**
 * Created by aaron on 1/29/2018.
 */
// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
// DONE (15) Add a class file called ForecastAdapter
// DONE (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

// DONE (23) Create a private string array called mWeatherData




public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>{

    private String[] mWeatherData;

    // TODO (47) Create the default constructor (we will pass in parameters in a later lesson)
    public ForecastAdapter(){}


    // DONE (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    // DONE(32) After you save mWeatherData, call notifyDataSetChanged
    public void setWeatherData(String[] weatherData){
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
// DONE (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null
    @Override
    public int getItemCount() {
        if (mWeatherData == null) return 0;
        else return mWeatherData.length;
    }
    // DONE (24) Override onCreateViewHolder
    //Question is, should I do some throw of exceptions?
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // DONE (25) Within onCreateViewHolder, inflate the list item xml into a view
        //how to inflate xml into a view
        View view;
        boolean shouldAttachToParentImmediately = false;
        //AH HA!
        //I found you! (I think)
        //but I don't remember what to do with it
        // parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //what is the context?             getSystemService(Context.LAYOUT_INFLATER_SERVICE)   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.forecast_list_item, parent, shouldAttachToParentImmediately);
        // DONE(26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter
        return new ForecastAdapterViewHolder(view);
        }

    @Override
    // TODO (27) Override onBindViewHolder
    // TODO (28) Set the text of the TextView to the weather for this list item's position
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }
    // DONE (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // DONE (17) Extend RecyclerView.ViewHolder
    // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
    // DONE (18) Create a public final TextView variable called mWeatherTextView

    // DONE (19) Create a constructor for this class that accepts a View as a parameter
    // DONE (20) Call super(view) within the constructor for ForecastAdapterViewHolder
    // DONE (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
    // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{



        public final TextView mWeatherTextView;
        public ForecastAdapterViewHolder(View view){
            super(view);
            mWeatherTextView = (TextView)view.findViewById(R.id.tv_weather_data);
        }

    }
}
