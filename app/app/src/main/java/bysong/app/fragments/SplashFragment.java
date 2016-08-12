package bysong.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bysong.app.R;
import bysong.app.activity.MainActivity;

/**
 * Created by Tiago on 11/08/2016.
 * Tela SplashScreen
 */
public class SplashFragment extends BaseFragment implements BaseFragment.OnClickTask {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_splash_screen, container, false);
        executeTask(this);
        return view;

    }

    @Override
    public void execute() {

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        cancelTask(this);

    }

    @Override
    public void updateView() {

        getActivity().finish();
        startActivity(new Intent(getContext(), MainActivity.class));

    }

}
