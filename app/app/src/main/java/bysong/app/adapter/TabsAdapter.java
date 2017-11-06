package bysong.app.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bysong.app.R;
import bysong.app.fragments.GenreFragment;
import bysong.app.fragments.NewsFragment;
import bysong.app.fragments.SearchFragment;
import bysong.app.fragments.ForYouFragment;
import bysong.app.fragments.TopWeekFragment;

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

        return 5;

    }

    // Título das páginas da viewPager (Tabs)
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {

            return context.getString(R.string.tabForYou);

        } else if (position == 1) {

            return context.getString(R.string.tabNews);

        } else if (position == 2) {

            return context.getString(R.string.tabTopWeek);

        } else if (position == 3) {

            return context.getString(R.string.tabGenre);

        }
        else {
            return context.getString(R.string.tabSearch);
        }

    }

    @Override
    public Fragment getItem(int position) {

        Fragment f = null;

        if (position == 0) {

            f = new ForYouFragment();

        } else if (position == 1) {

            f = new NewsFragment();

        } else if (position == 2){

            f = new TopWeekFragment();

        } else if (position == 3) {

            f = new GenreFragment();

        } else {

            f = new SearchFragment();

        }

        return f;

    }

}
