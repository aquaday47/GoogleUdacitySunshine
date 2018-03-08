package com.example.android.sunshine;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import android.support.v7.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
// TODO (4) Create SettingsFragment and extend PreferenceFragmentCompat
public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener{


    // TODO (8) Create a method called setPreferenceSummary that accepts a Preference and an Object and sets the summary of the preference
    private void setPreferenceSummary(Preference pref, Object o){
        String stringVal = o.toString();
        String key = pref.getKey();
        if ( pref instanceof ListPreference){
            ListPreference listPref = (ListPreference) pref;

            int prefIndex = listPref.findIndexOfValue(stringVal);
            if (prefIndex >=0){
                pref.setSummary(listPref.getEntries()[prefIndex]);
            }
            else{
                pref.setSummary(stringVal);
            }
        }

    }
    @Override
    // TODO //DONE/IT// (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource
    // Do step 9 within onCreatePreference
    // TODO (9) Set the preference summary on each preference that isn't a CheckBoxPreference
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_general);
        SharedPreferences sharedPrefs = getPreferenceScreen().getSharedPreferences();
        PreferenceScreen prefScreen = getPreferenceScreen();
        int count = prefScreen.getPreferenceCount();
        for (int i = 0; i<count; i++){
            Preference p = prefScreen.getPreference(i);
            if (!(p instanceof CheckBoxPreference)) {
                String val = sharedPrefs.getString(p.getKey(), "");
                setPreferenceSummary(p, val);
            }
        /*
        Map<String, ?> keys = sharedPrefs.getAll();
        for (Map.Entry<String, ?> entry : keys.entrySet()){
            if (entry.getValue() instanceof CheckBoxPreference){

            }
        */
        }
    }


    // Do steps 5 - 11 within SettingsFragment
    // TODO (10) Implement OnSharedPreferenceChangeListener from SettingsFragment
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Preference preference = findPreference(s);
        if (null != preference){
            if (!(preference instanceof  CheckBoxPreference)) {
                setPreferenceSummary(preference, sharedPreferences.getString(s, ""));
            }
        }
    }

    // TODO (13) Unregister SettingsFragment (this) as a SharedPreferenceChangedListener in onStop


    @Override
    public void onStop() {
        super.onStop();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    // TODO (12) Register SettingsFragment (this) as a SharedPreferenceChangedListener in onStart
    @Override
    public void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

}
