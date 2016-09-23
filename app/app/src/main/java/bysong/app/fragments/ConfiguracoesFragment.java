package bysong.app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bysong.app.R;
import bysong.app.adapter.RankingAdapter;
import bysong.app.domain.User;
import bysong.app.service.BySongServiceManager;

/**
 * Created by Tiago on 17/08/2016.
 */
public class ConfiguracoesFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<User> usersList;
    private RankingAdapter adapter;
    View view;
    CallbackManager callbackManager;
    LoginButton loginButton;
    private ProfileTracker profileTracker;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_configuracoes, container, false);

        Profile profile = Profile.getCurrentProfile();

        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        loginButton.setReadPermissions("user_friends");
        // If using in a fragment
        loginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Profile profile = Profile.getCurrentProfile();
                int i = 1;
                i++;
            }

            @Override
            public void onCancel() {
                int i = 1;
                i++;
            }

            @Override
            public void onError(FacebookException exception) {
                int i = 1;
                i++;
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(this.getActivity().getApplicationContext());

        callbackManager = CallbackManager.Factory.create();


        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        AccessToken accessToken = loginResult.getAccessToken();

                        Profile profile = Profile.getCurrentProfile();
                        int i = 1;
                        i++;
                    }

                    @Override
                    public void onCancel() {
                        int i = 1;
                        i++;
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        int i = 1;
                        i++;
                    }
                });

        AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
                int i = 1;
                i++;
            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                //nextActivity(newProfile);
                int i = 1;
                i++;
            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        Profile profile = Profile.getCurrentProfile();
    }


}
