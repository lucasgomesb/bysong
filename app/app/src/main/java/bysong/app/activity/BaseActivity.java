package bysong.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import bysong.app.R;

/**
 * Created by Tiago on 10/08/2016.
 * Classe Pai para todas as activities do app.
 * Contém métodos utilitários para a Activity
 */
public class BaseActivity extends AppCompatActivity {

    // Configura a toolbar
    public void setUpToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {

            setSupportActionBar(toolbar);

        }

    }


}
