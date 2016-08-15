package bysong.app.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiago on 15/08/2016.
 * Apartir do android 6.0 algumas permissões tem que ser ativadas pelo usuário
 * em tempo de execução e para isso é necessãrio verificar quas permissões não foram aplicadas.
 * Esta classe PermissionUtils tem essa responsabilidade
 */
public class PermissionUtils {

    public static boolean validate(Activity activity, int requestCode, String... permissions) {

        List<String> list = new ArrayList<String>();

        for (String permission : permissions) {

            boolean ok = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;

            if (!ok) {

                list.add(permission);

            }

        }

        if (list.isEmpty()) {

            // Tudo ok, retorna true
            return true;

        }

        // Lista de permissões que faltam acesso
        String[] newPermissons = new String[list.size()];
        list.toArray(newPermissons);
        // Solicita permissão
        ActivityCompat.requestPermissions(activity, newPermissons, requestCode);
        return false;

    }

}
