package bysong.app.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

import bysong.app.R;
import bysong.app.activity.PreferencesActivity;

/**
 * Created by Tiago on 17/08/2016.
 */
public class PreferencesFragment extends PreferenceFragment {
    public static final String KEY_PREFERENCE_DIFFICULTY = "preferenceDifficulty";
    public static final String PREFERENCE_DIFFICULTY_VALUE_EASY = "1";
    public static final String PREFERENCE_DIFFICULTY_VALUE_MEDIUM = "2";
    public static final String PREFERENCE_DIFFICULTY_VALUE_HARD = "3";

    ListPreference lpPreferenceDifficulty;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.fragment_preferences);

        this.initializePreferences();
    }


    private void initializePreferences()
    {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String preferenceDifficulty = sharedPref.getString(PreferencesFragment.KEY_PREFERENCE_DIFFICULTY, "");
        String preferenceDifficultySummary;

        switch (preferenceDifficulty)
        {
            case PREFERENCE_DIFFICULTY_VALUE_EASY:
                preferenceDifficultySummary = "Definir o nível de dificuldade. Atual: Iniciante";
                break;
            case PREFERENCE_DIFFICULTY_VALUE_MEDIUM:
                preferenceDifficultySummary = "Definir o nível de dificuldade. Atual: Intermediário";
                break;
            case PREFERENCE_DIFFICULTY_VALUE_HARD:
                preferenceDifficultySummary = "Definir o nível de dificuldade. Atual: Avançado";
                break;
            default:
                preferenceDifficultySummary = "Definir o nível de dificuldade.";
        }

        lpPreferenceDifficulty = (ListPreference) findPreference(PreferencesFragment.KEY_PREFERENCE_DIFFICULTY);
        lpPreferenceDifficulty.setSummary(preferenceDifficultySummary);

/*
        lpPreferenceDifficulty.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(ListPreference preference, Object newValue) {
                if (((String)newValue).equals("some_value")) {
                    preference.setSummary("my summary");
                }
            }
        });
*/
    }




}
