package bysong.app.service;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import bysong.app.domain.User;
import bysong.app.fragments.CallBackInterface;

/**
 * Created by Lucas on 07/09/2016.
 */
public class BySongServiceManager implements CallBackInterface {

    private static final String ServiceNameUserFriends = "ListaUsuarios";
    private static final String ServiceURL = "http://bysong.com.br/BySongService/ServiceRESTFul.svc/";

    public BySongServiceManager() {

    }

    private CallBackInterface responseCallBack;

    public void getUserFriends(CallBackInterface responseCallBack) {

        String url = ServiceURL + ServiceNameUserFriends;
        JSONServiceManager jsonServiceManager = new JSONServiceManager();
        this.responseCallBack = responseCallBack;

        try {
            jsonServiceManager.setCallBack(this);
            jsonServiceManager.execute(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeCallBack(Object result) {

        Gson loGSon = new Gson();

        User[] usersArray = loGSon.fromJson(String.valueOf(result), User[].class);
        List<User> usersList = Arrays.asList(usersArray);

        responseCallBack.executeCallBack(usersList);
    }
}
