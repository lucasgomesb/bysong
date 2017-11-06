package bysong.app.activity;

import android.os.Bundle;

import bysong.app.R;
import bysong.app.fragments.MusicFragment;

/**
 * Created by Tiago on 09/09/2016.
 */
public class MusicActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        setUpToolbar();

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().add(R.id.musica_fragment, new MusicFragment()).commit();

        }

    }

}
