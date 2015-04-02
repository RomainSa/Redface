package com.ayuget.redface.ui.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.ayuget.redface.RedfaceApp;
import com.ayuget.redface.R;
import com.ayuget.redface.settings.SettingsConstants;
import com.ayuget.redface.ui.event.NestedPreferenceSelectedEvent;
import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public class HomePreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {
    private static final String LOG_TAG = HomePreferenceFragment.class.getSimpleName();

    @Inject
    Bus bus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Read fragment args from bundle
        FragmentArgs.inject(this);

        // Inject dependencies
        RedfaceApp app = RedfaceApp.get(getActivity());
        app.inject(this);

        addPreferencesFromResource(R.xml.home_preferences);

        Preference generalPreference = findPreference(SettingsConstants.KEY_GENERAL_PREFERENCES);
        if (generalPreference != null) {
            generalPreference.setOnPreferenceClickListener(this);
        }

        Preference appearancePreference = findPreference(SettingsConstants.KEY_APPEARANCE_PREFERENCES);
        appearancePreference.setOnPreferenceClickListener(this);

        Preference networkPreference = findPreference(SettingsConstants.KEY_NETWORK_PREFERENCES);
        networkPreference.setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        Log.d(LOG_TAG, String.format("Preference '%s' clicked", preference.getKey()));
        bus.post(new NestedPreferenceSelectedEvent(preference.getKey()));
        return false;
    }
}