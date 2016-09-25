package bysong.app.service;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import bysong.app.domain.Song;
import bysong.app.domain.User;
import bysong.app.fragments.CallBackInterface;

/**
 * Created by Lucas on 07/09/2016.
 */
public class BySongServiceManager implements CallBackInterface {

    private static final String ServiceNameUserFriends = "User/Friends";
    private static final String ServiceNameSongList = "Song/All";
    private static final String ServiceURL = "http://bysong.com.br/BySongService/ServiceRESTFul.svc/";

    public BySongServiceManager() {

    }

    private CallBackInterface responseCallBack;
   // private Type resultType;

    public void getUserFriends(CallBackInterface responseCallBack) {

        String url = ServiceURL + ServiceNameUserFriends;
        JSONServiceManager jsonServiceManager = new JSONServiceManager();
        this.responseCallBack = responseCallBack;
      //  this.resultType = resultType;

        try {
            jsonServiceManager.setCallBack(this, User[].class );
            jsonServiceManager.execute(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSongList(CallBackInterface responseCallBack) {

        String url = ServiceURL + ServiceNameSongList;
        JSONServiceManager jsonServiceManager = new JSONServiceManager();
        this.responseCallBack = responseCallBack;

        try {
            jsonServiceManager.setCallBack(this, Song[].class);
            jsonServiceManager.execute(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeCallBack(Object result, Type type) {

        Gson loGSon = new Gson();
        Object resultObject = null;
        if (type == User[].class) {
            User[] usersArray = loGSon.fromJson(String.valueOf(result), type);
            List<User> usersList = Arrays.asList(usersArray);
            resultObject = usersList;
        }
        if (type == Song[].class) {
            Song[] usersArray = loGSon.fromJson(String.valueOf(result), type);
            List<Song> songList = Arrays.asList(usersArray);
            resultObject = songList;
        }

        responseCallBack.executeCallBack(resultObject, type);
    }
}
