package bysong.app.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import bysong.app.R;
import bysong.app.adapter.TabsAdapter;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpViewPagerTabs();

    }

    private void setUpViewPagerTabs() {

        // ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        // Mantém duas tabs a mais doque a view pager está visualizando
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new TabsAdapter(this, getSupportFragmentManager()));
        // Tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        int cor = ContextCompat.getColor(this, R.color.white);
        // Cor branca no texto (o fundo azul foi definido no layout)
        tabLayout.setTabTextColors(cor, cor);

    }

}
