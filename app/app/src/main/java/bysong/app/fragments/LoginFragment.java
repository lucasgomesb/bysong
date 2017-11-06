package bysong.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.facebook.AccessToken;
import com.facebook.Profile;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bysong.app.R;
import bysong.app.activity.MainActivity;
import bysong.app.activity.MusicActivity;
import bysong.app.activity.PreferencesActivity;
import bysong.app.adapter.RankingAdapter;
import bysong.app.adapter.SearchAdapter;
import bysong.app.domain.Song;
import bysong.app.domain.User;
import bysong.app.service.BySongServiceManager;
import bysong.app.visualControls.FacebookLoginButton;
import bysong.app.visualControls.SimpleDividerItemDecoration;

/**
 * Created by Tiago on 17/08/2016.
 */
public class LoginFragment extends Fragment implements CallBackInterface  {

    FacebookLoginButton mbtFacebookLogin;
    Button mbtDontRegister;
    Button mbtLoginEmail;
    EditText medtEmail;
    EditText medtPassword;
    View mMainView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mMainView = inflater.inflate(R.layout.fragment_login, container, false);

        mbtDontRegister = (Button) mMainView.findViewById(R.id.btDontRegister);
        mbtDontRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });

        mbtLoginEmail = (Button) mMainView.findViewById(R.id.btLoginEmail);
        mbtLoginEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginWithEmail();
            }
        });

        medtEmail = (EditText) mMainView.findViewById(R.id.edtEmail);
        medtPassword = (EditText) mMainView.findViewById(R.id.edtPassword);

        mbtFacebookLogin = (FacebookLoginButton) mMainView.findViewById(R.id.btFacebookLogin);
        mbtFacebookLogin.initializeFacebookStatus();

        return mMainView;
    }

    private void loginWithEmail() {
        String email = medtEmail.getText().toString();
        String password = medtPassword.getText().toString();

        BySongServiceManager bySongServiceManager = new BySongServiceManager();
        bySongServiceManager.authenticateUser(this, email, password);

    }

    @Override
    public void executeCallBack(Object result, Type type) {

      //  User user = (User) result;

    }


}
