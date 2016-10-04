package bysong.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bysong.app.R;
import bysong.app.activity.MainActivity;
import bysong.app.adapter.RankingAdapter;
import bysong.app.domain.User;
import bysong.app.service.BySongServiceManager;

import static android.R.attr.data;

/**
 * Created by Tiago on 17/08/2016.
 */
public class ConfiguracoesFragment extends Fragment {

    TextView tvFacebookUser;
    View view;
    CallbackManager callbackManager;
    LoginButton loginButton;
    Profile facebookProfile;
    AccessToken facebookAccessToken;
    ProfileTracker facebookprofileTracker;
    ProfilePictureView facebookProfilePictureView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_configuracoes, container, false);
        tvFacebookUser = (TextView) view.findViewById(R.id.tvFacebookUser);

        facebookProfilePictureView = (ProfilePictureView) view.findViewById(R.id.profilePicture);

        loginButton = (LoginButton) view.findViewById(R.id.login_button);

        loginButton.setReadPermissions("public_profile");
        loginButton.setReadPermissions("email");
        loginButton.setReadPermissions("user_friends");
        loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                facebookAccessToken = loginResult.getAccessToken();
                facebookProfile = Profile.getCurrentProfile();


            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException exception) {
            }
        });


        facebookAccessToken = AccessToken.getCurrentAccessToken();
        facebookProfile = Profile.getCurrentProfile();
        if (facebookProfile != null) {
            facebookProfilePictureView.setProfileId(facebookProfile.getId());
            tvFacebookUser.setText(facebookProfile.getName());
        } else {
            facebookProfilePictureView.setProfileId(null);
            tvFacebookUser.setText("Deslogado");
        }

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(this.getActivity().getApplicationContext());

        callbackManager = CallbackManager.Factory.create();

/*
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        facebookAccessToken = loginResult.getAccessToken();
                        facebookProfile = Profile.getCurrentProfile();
                    }

                    @Override
                    public void onCancel() {
                    }

                    @Override
                    public void onError(FacebookException exception) {

                    }
                });

        AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
                facebookAccessToken = newToken;
            }
        };

        facebookprofileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
            }
        };
        accessTokenTracker.startTracking();
        facebookprofileTracker.startTracking();
*/

    }


}
