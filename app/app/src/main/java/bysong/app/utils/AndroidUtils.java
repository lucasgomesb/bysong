package bysong.app.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Tiago on 19/09/2016.
 */
public class AndroidUtils {

    public static boolean closeVirtualKeyborad(Context context, View view) {

        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {

            boolean b = imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            return b;

        }

        return false;

    }

}
