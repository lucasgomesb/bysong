package bysong.app.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import bysong.app.R;
import bysong.app.fragments.PostSplashFirstAccessFragment;


/**
 * Created by Tiago on 17/08/2016.
 */
public class PostSplashFirstAccessActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_post_splash_first_access);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.post_splash_first_access_root, new PostSplashFirstAccessFragment()).commit();
        }

    }


}
