package com.awesomekris.android.newsbox;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;

/**
 * Created by kris on 16/10/18.
 */
public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceClickListener,
        Preference.OnPreferenceChangeListener, SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        return false;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        return false;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

    }

    @Override
    protected void onDestroy() {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    //    private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
//        @Override
//        public boolean onPreferenceChange(Preference preference, Object newValue) {
//            String stringValue = newValue.toString();
//
//            if(preference instanceof CheckBoxPreference){
//                CheckBoxPreference checkBoxPreference = (CheckBoxPreference)preference;
//
//
//            }else {
//                preference.setSummary(stringValue);
//            }
//
//            return true;
//        }
//    };
//
//    private static Preference.OnPreferenceClickListener sBindPreferenceStateToValueListener = new Preference.OnPreferenceClickListener() {
//        @Override
//        public boolean onPreferenceClick(Preference preference) {
//
//            return true;
//        }
//    };
//
//    private static void bindPreferenceSummaryToValue(Preference preference) {
//        // Set the listener to watch for value changes.
//        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);
//        preference.setOnPreferenceClickListener(sBindPreferenceStateToValueListener);
//        // Trigger the listener immediately with the preference's
//        // current value.
//        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
//                PreferenceManager
//                        .getDefaultSharedPreferences(preference.getContext())
//                        .getString(preference.getKey(), ""));
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setupActionBar();
//        getFragmentManager().beginTransaction()
//                .replace(android.R.id.content, new GeneralPreferenceFragment())
//                .commit();
//    }
//
//    private void setupActionBar() {
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            // Show the Up button in the action bar.
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
//    }
//    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//    public static class GeneralPreferenceFragment extends PreferenceFragment {
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            addPreferencesFromResource(R.xml.pref_general);
//            setHasOptionsMenu(true);
//
//            bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_sort_key)));
//        }
//
//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            //int id = item.getItemId();
//            return super.onOptionsItemSelected(item);
//        }
//    }
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    @Override
//    public Intent getParentActivityIntent() {
//        return super.getParentActivityIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//    }

}
