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
import bysong.app.controller.SongLibrary;
import bysong.app.domain.PlayerMp3;
import bysong.app.domain.Song;

/**
 * Created by Tiago on 10/08/2016.
 */
public class PraVoceFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Song> songs;
    private PlayerMp3 playerMp3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_por_genero, container, false);
        //songs = new SongLibrary().GetSongList();
        songs = Song.getSongs();
        playerMp3 = new PlayerMp3();
        recyclerView = (RecyclerView) view.findViewById(R.id.porGenero);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new SongsAdapter(getContext(), songs, onClickSongsMuisc()));
        return view;

    }

    private SongsAdapter.OnClickSongs onClickSongsMuisc() {

        return new SongsAdapter.OnClickSongs() {

            @Override
            public void onClickPlay(SongsAdapter.SongsViewHolder holder, int id) {

                playerMp3.start("/storage/emulated/0/Music/Hello.mp3");
                holder.song_item_audio.setVisibility(View.GONE);
                holder.song_item_audio_pause.setVisibility(View.VISIBLE);

            }

            @Override
            public void onClickPause(SongsAdapter.SongsViewHolder holder, int id) {

                playerMp3.pause();
                holder.song_item_audio.setVisibility(View.VISIBLE);
                holder.song_item_audio_pause.setVisibility(View.GONE);

            }

        };

    }

}
