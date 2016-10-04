package bysong.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

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
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;

import bysong.app.R;
import bysong.app.fragments.ConfiguracoesFragment;


/**
 * Created by Tiago on 17/08/2016.
 */
public class ConfiguracoesActivity extends BaseActivity {

    CallbackManager callbackManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);
        setUpToolbar();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.configuracoes_root, new ConfiguracoesFragment()).commit();
        }

        FacebookSdk.sdkInitialize(getApplication());
        AccessToken accessToken = AccessToken.getCurrentAccessToken();

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Profile profile = Profile.getCurrentProfile();
                        int i = 1;
                        i++;
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

        AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // Set the access token using
                // currentAccessToken when it's loaded or set.
                int i;
                i = 1;
            }
        };
        // If the access token is available already assign it.
        accessToken = AccessToken.getCurrentAccessToken();

        if (accessToken == null) {
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends", "email"));
        } else {
            Profile profile = Profile.getCurrentProfile();

            GraphRequestAsyncTask request = new GraphRequest(
                    AccessToken.getCurrentAccessToken(),
               //     "/" + profile.getId()+ "/friends",
                    "/me/friends",

                    null,
                    HttpMethod.GET,
                    new GraphRequest.Callback() {
                        public void onCompleted(GraphResponse graphResponse) {
                            try {
                                JSONArray rawName3 = graphResponse.getJSONObject().getJSONArray("data");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ).executeAsync();

            /*
            GraphRequest request = GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONArrayCallback() {
                @Override
                public void onCompleted(JSONArray jsonArray, GraphResponse graphResponse) {

                    try {
                        JSONArray rawName3 = graphResponse.getJSONObject().getJSONArray("data");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            Bundle param = new Bundle();
            //param.putString("fields", "friendlist", "members");
            param.putString("fields", "name");
           request.setParameters(param);
            request.executeAsync();*/
/*
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequest(
                    accessToken,
                    "/me/friends",
                    null,
                    HttpMethod.GET,
                    new GraphRequest.Callback() {
                        public void onCompleted(GraphResponse response) {
                            //Intent intent = new Intent(MainActivity.this,FriendsList.class);
                            try {
                                JSONArray rawName = response.getJSONObject().getJSONArray("data");
                                //intent.putExtra("jsondata", rawName.toString());
                                //startActivity(intent);
                                String jsondata = rawName.toString();
                                JSONArray friendslist;
                                ArrayList<String> friends = new ArrayList<String>();
                                try {
                                    friendslist = new JSONArray(jsondata);
                                    for (int l = 0; l < friendslist.length(); l++) {
                                        friends.add(friendslist.getJSONObject(l).getString("name"));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }).executeAsync();*/
        }
        //accessToken = AccessToken.getCurrentAccessToken();

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
        //Facebook login
        //    accessTokenTracker.stopTracking();
        // profileTracker.stopTracking();
    }


    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
