package bysong.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import bysong.app.R;
import bysong.app.activity.MainActivity;
import bysong.app.activity.PostSplashFirstAccessActivity;

/**
 * Created by Tiago on 11/08/2016.
 * Tela SplashScreen
 */
public class SplashFragment extends BaseFragment implements BaseFragment.OnExecuteTask {

    private ProgressBar mProgress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_splash_screen, container, false);
        mProgress = (ProgressBar) view.findViewById(R.id.splash_screen_progress_bar);


        executeTask(this);
        return view;

    }

    @Override
    public void execute(Object parameters) {

        try {

            for (int progress=0; progress<100; progress+=1) {
                Thread.sleep(20);
                mProgress.setProgress(progress);
            }
        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        cancelTask(this);

    }

    @Override
    public void updateView(Object result) {

        getActivity().finish();
        startActivity(new Intent(getContext(), PostSplashFirstAccessActivity.class));
      //  startActivity(new Intent(getContext(), MainActivity.class));

    }

}
