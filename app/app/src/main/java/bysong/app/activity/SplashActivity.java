package bysong.app.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import bysong.app.R;
import bysong.app.fragments.SplashFragment;

/**
 * Created by Tiago on 11/08/2016.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        if (savedInstanceState == null) {

            replaceFragment(getSupportFragmentManager(), R.id.splash_root, new SplashFragment());

        }

    }

}
