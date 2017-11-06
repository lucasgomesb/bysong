package bysong.app.activity;

import android.Manifest;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import bysong.app.R;
import bysong.app.adapter.TabsAdapter;
import bysong.app.application.Application;
import bysong.app.domain.User;
import bysong.app.utils.PermissionUtils;
import bysong.app.utils.PrefUtils;


public class MainActivity extends BaseActivity {



    private String[] permissions = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        PermissionUtils.validate(this, 1, permissions);
        setUpViewPagerTabs();

        this.addNotification();

        // Não remover. Serve para capturar o key hasch, em caso de mudança. Deixar comentado
        //this.getKeyHashForFacebook();

        // Para testes. Simula um usuário logado
        Application.getInstance().setLoggedUser(new User("001", null, "Lucas", "Gomes Bittencourt", 9, 1000));
    }

   /* private void teste()
    {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.YEAR, 2013);
        calendar.set(Calendar.DAY_OF_MONTH, 13);

        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 48);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.AM_PM,Calendar.PM);

        Intent myIntent = new Intent(MainActivity.this, MyReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent,0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
    }*/
    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.artist_circle_adele)
                        .setContentTitle("Hora de treinar!")
                        .setContentText("Vamos aprender a letra de uma canção em inglês?")
                ;

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    private void getKeyHashForFacebook() {

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

    }

    private void setUpViewPagerTabs() {

        // ViewPager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        // Mantém duas tabs a mais do que a view pager está visualizando
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new TabsAdapter(this, getSupportFragmentManager()));
        // Tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        int cor = ContextCompat.getColor(this, R.color.white);
        // Cor branca no texto (o fundo azul foi definido no layout)
        tabLayout.setTabTextColors(cor, cor);
        int tabIdx = PrefUtils.getInteger(getBaseContext(), "tabIdx");
        viewPager.setCurrentItem(tabIdx);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                PrefUtils.setInteger(getBaseContext(), "tabIdx", viewPager.getCurrentItem());

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_ranking:
                startActivity(new Intent(this, RankingActivity.class));
                break;
            case R.id.action_settings:
                startActivity(new Intent(this, PreferencesActivity.class));
//                startActivity(new Intent(this, ConfiguracoesActivity.class));
                break;

        }

        return super.onOptionsItemSelected(item);

    }


}
