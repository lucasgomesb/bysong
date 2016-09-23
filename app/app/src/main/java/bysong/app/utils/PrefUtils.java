package bysong.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Tiago on 19/09/2016.
 */
public class PrefUtils {

    private static final String PREF_ID = "livroandroid";

    public static void setInteger(Context context, String chave, int valor) {

        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(chave, valor);
        editor.commit();

    }

    public static int getInteger(Context context, String chave) {

        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        int i = pref.getInt(chave, 2);
        return i;

    }

}
