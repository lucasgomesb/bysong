package bysong.app.fragments;

import java.lang.reflect.Type;

import static android.R.attr.type;

/**
 * Created by Lucas on 11/09/2016.
 */
public interface CallBackInterface {
    void executeCallBack(Object result, Type type);
}
