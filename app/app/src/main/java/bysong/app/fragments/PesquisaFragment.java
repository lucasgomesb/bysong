package bysong.app.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bysong.app.R;
import bysong.app.domain.Song;
import bysong.app.utils.AndroidUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesquisaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pesquisa, container, false);
        setHasOptionsMenu(true);
        return view;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menu_search);
        SearchView sv = new SearchView(getActivity());
        sv.setOnQueryTextListener(new PesquisaFragment.MenuListener(getActivity()));
        //sv.setBackgroundColor(Color.WHITE);
        item.setActionView(sv);
        super.onCreateOptionsMenu(menu, inflater);

    }

    class MenuListener implements SearchView.OnQueryTextListener {

        private Context context;

        public MenuListener(Context context) {

            this.context = context;

        }

        @Override
        public boolean onQueryTextSubmit(String query) {

            Log.i("livroandroid", "onQueryTextSubmit: " + query);
            Toast.makeText(context, "Texto: " + query, Toast.LENGTH_SHORT).show();
            return false;

        }

        @Override
        public boolean onQueryTextChange(String newText) {

            Log.i("livroandroid", "onQueryTextChange: " + newText);
            return false;

        }

    }


}
