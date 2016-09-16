package bysong.app.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import bysong.app.R;
import bysong.app.fragments.RankingFragment;

/**
 * Created by Tiago on 17/08/2016.
 */
public class RankingActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        setUpToolbar();
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().add(R.id.ranking_root, new RankingFragment()).commit();

        }

    }

}
