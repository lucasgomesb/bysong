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
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import bysong.app.R;
import bysong.app.adapter.PesquisaAdapter;
import bysong.app.domain.Song;
import bysong.app.service.BySongServiceManager;
import bysong.app.utils.AndroidUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesquisaFragment extends Fragment implements CallBackInterface {

    private ListView listaSongs;
    private List<Song> songs;
    private PesquisaAdapter adapter;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_pesquisa, container, false);
        setHasOptionsMenu(true);
        BySongServiceManager bySongServiceManager = new BySongServiceManager();
        bySongServiceManager.getSongList(this);
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

    @Override
    public void executeCallBack(Object result, Type type) {

        songs = (List<Song>) result;

        for (Song song : songs) {

            Log.d("songs", song.getTitle());

        }

        Log.d("pesquisa", "executeCallBack(): " + result);

        adapter = new PesquisaAdapter(getContext(), songs);
        listaSongs = (ListView) view.findViewById(R.id.listaMusicas);
        listaSongs.setAdapter(adapter);

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
