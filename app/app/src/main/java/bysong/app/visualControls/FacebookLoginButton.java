package bysong.app.visualControls;

import android.content.Context;
import android.content.Intent;

import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import bysong.app.R;

public class FacebookLoginButton extends com.facebook.login.widget.LoginButton {

    Context mContext;
    AccessToken facebookAccessToken;
    Profile facebookProfile;
    AccessTokenTracker facebookAccessTokenTracker;
    ProfileTracker facebookProfileTracker;
    CallbackManager facebookCallbackManager;
    TextView tvFacebookUser;
    ProfilePictureView facebookProfilePictureView;

    public FacebookLoginButton(Context context) {
        super(context);
        mContext = context;
    }

    public FacebookLoginButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public FacebookLoginButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    public void initializeFacebookStatus() {
        FacebookSdk.sdkInitialize(mContext);
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

        this.setReadPermissions("public_profile");
        this.setReadPermissions("email");
        this.setReadPermissions("user_friends");

        // Callback registration
        this.registerCallback(facebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // Se o usuário fez login com sucesso no Facebook
                facebookAccessToken = loginResult.getAccessToken();
                facebookProfile = Profile.getCurrentProfile();
                setFacebookProfile();
            }

            @Override
            public void onCancel() {
                toast("Login cancelado");
            }

            @Override
            public void onError(FacebookException exception) {
                String lsMessage = exception.getMessage();
                if (lsMessage != null)
                    toast("Falha ao tentar efetuar o login:" + lsMessage);
                else
                    toast("Falha ao tentar efetuar o login");
            }
        });

        this.setFacebookProfile();


    }

    private void toast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    private void setFacebookProfile() {
        if (facebookProfile != null) {
            if (facebookProfilePictureView != null) {
                facebookProfilePictureView.setProfileId(facebookProfile.getId());
            }
            if (tvFacebookUser != null) {
                tvFacebookUser.setText("Conectado como: " + facebookProfile.getName());
            }
        } else {
            if (facebookProfilePictureView != null) {
                facebookProfilePictureView.setProfileId(null);
            }
            if (tvFacebookUser != null) {
                tvFacebookUser.setText("Deslogado");
            }
        }
    }


    public void onDestroy() {

        facebookProfileTracker.stopTracking();
        facebookAccessTokenTracker.stopTracking();
    }


    protected void onActivityResult(final int requestCode, final int resultCode,
                                    final Intent data) {
        facebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}