package bysong.app.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bysong.app.R;
import bysong.app.fragments.GeneroFragment;
import bysong.app.fragments.LancamentosFragment;
import bysong.app.fragments.PraVoceFragment;
import bysong.app.fragments.TopSemanalFragment;

/**
 * Created by Tiago on 10/08/2016.
 */
public class TabsAdapter extends FragmentPagerAdapter {

    private Context context;

    public TabsAdapter(Context context, FragmentManager fm){

        super(fm);
        this.context = context;

    }

    // Retorna o número de páginas do view pager(equivalente ao número de abas)
    @Override
    public int getCount() {

        return 4;

    }

    // Título das páginas da viewPager (Tabs)
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {

            return context.getString(R.string.pra_voce);

        } else if (position == 1) {

            return context.getString(R.string.lancamento);

        } else if (position == 2) {

            return context.getString(R.string.top_semanal);

        }

        return context.getString(R.string.genero);

    }

    @Override
    public Fragment getItem(int position) {

        Fragment f = null;

        if (position == 0) {

            f = new PraVoceFragment();

        } else if (position == 1) {

            f = new LancamentosFragment();

        } else if (position == 2){

            f = new TopSemanalFragment();

        } else {

            f = new GeneroFragment();

        }

        return f;

    }

}
