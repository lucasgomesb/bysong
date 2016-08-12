package bysong.app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bysong.app.R;
import bysong.app.adapter.SongsAdapter;
import bysong.app.domain.Song;

/**
 * Created by Tiago on 10/08/2016.
 */
public class PorGeneroFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Song> songs;
    private SongsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_por_genero, container, false);
        songs = Song.getSongs();
        recyclerView = (RecyclerView) view.findViewById(R.id.porGenero);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new SongsAdapter(getContext(), songs));
        return view;

    }

}
