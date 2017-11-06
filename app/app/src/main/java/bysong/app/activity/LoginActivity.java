package bysong.app.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.Window;

import bysong.app.R;
import bysong.app.fragments.LoginFragment;
import bysong.app.fragments.RankingFragment;

/**
 * Created by Tiago on 17/08/2016.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.frame_login, new LoginFragment()).commit();
        }


    }



}
