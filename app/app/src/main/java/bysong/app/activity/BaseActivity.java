package bysong.app.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import bysong.app.R;

/**
 * Created by Tiago on 10/08/2016.
 * Classe Pai para todas as activities do app.
 * Contém métodos utilitários para a Activity
 */
public class BaseActivity extends AppCompatActivity {

    // Configura a toolbar
    protected void setUpToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {

            setSupportActionBar(toolbar);

        }

    }
    // Abre o fragment
    protected void replaceFragment(FragmentManager fm, int layout, Fragment frag) {

        FragmentTransaction ft = fm.beginTransaction().replace(layout, frag);
        ft.commit();

    }
    // Toast
    protected void toast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

}
