package bysong.app.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.TextView;

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
import com.facebook.login.widget.ProfilePictureView;

import bysong.app.R;
import bysong.app.fragments.PreferencesFragment;

public class PreferencesActivity extends BaseActivity {

    AccessToken facebookAccessToken;
    Profile facebookProfile;
    AccessTokenTracker facebookAccessTokenTracker;
    ProfileTracker facebookProfileTracker;
    CallbackManager facebookCallbackManager;
    TextView tvFacebookUser;
    ProfilePictureView facebookProfilePictureView;
    LoginButton btFacebookLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        setUpToolbar();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().replace(R.id.preferences_root, new PreferencesFragment()).commit();
        }

        btFacebookLogin = (LoginButton) findViewById(R.id.btFacebookLogin);
        tvFacebookUser = (TextView) findViewById(R.id.tvFacebookUser);
        facebookProfilePictureView = (ProfilePictureView) findViewById(R.id.profilePicture);

        this.initializeFacebookStatus();

    }

    private void initializeFacebookStatus() {
        FacebookSdk.sdkInitialize(this.getApplication());
        facebookCallbackManager = CallbackManager.Factory.create();

        facebookProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                facebookProfile = currentProfile;
                setFacebookProfile();
            }
        };

        facebookAccessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // On AccessToken changes fetch the new profile which fires the event on
                // the ProfileTracker if the profile is different
                Profile.fetchProfileForCurrentAccessToken();
                // Se o usuário fez logout do Facebook
                if (currentAccessToken == null) {
                    // Se o usuário fez logout do Facebook
                    facebookAccessToken = null;
                    facebookProfile = null;
                    setFacebookProfile();
                }
            }
        };

        Profile.fetchProfileForCurrentAccessToken();

        facebookAccessToken = AccessToken.getCurrentAccessToken();
        facebookProfile = Profile.getCurrentProfile();

        btFacebookLogin.setReadPermissions("public_profile");
        btFacebookLogin.setReadPermissions("email");
        btFacebookLogin.setReadPermissions("user_friends");

        // Callback registration
        btFacebookLogin.registerCallback(facebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // Se o usuário fez login com sucesso no Facebook
                facebookAccessToken = loginResult.getAccessToken();
                facebookProfile = Profile.getCurrentProfile();
                setFacebookProfile();
            }

            @Override
            public void onCancel() {
                int i;
                i = 1;
            }

            @Override
            public void onError(FacebookException exception) {
                int i;
                i = 1;
            }
        });

        this.setFacebookProfile();

    }

    private void setFacebookProfile() {
        if (facebookProfile != null) {
            facebookProfilePictureView.setProfileId(facebookProfile.getId());
            tvFacebookUser.setText("Conectado como: " + facebookProfile.getName());
        } else {
            facebookProfilePictureView.setProfileId(null);
            tvFacebookUser.setText("Deslogado");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    protected void onStop() {
        super.onStop();
        facebookProfileTracker.stopTracking();
        facebookAccessTokenTracker.stopTracking();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        facebookProfileTracker.stopTracking();
        facebookAccessTokenTracker.stopTracking();
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        facebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}