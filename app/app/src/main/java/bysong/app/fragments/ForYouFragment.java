package bysong.app.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import bysong.app.R;
import bysong.app.adapter.ForYouAdapter;
import bysong.app.controller.SongLibrary;
import bysong.app.domain.PlayerMp3;
import bysong.app.domain.Song;

/**
 * Created by Tiago on 10/08/2016.
 */
public class ForYouFragment extends Fragment implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private static final String TAG = "songplayer";
    private RecyclerView recycler_pra_voce, recycler_seus_amigos, recycler_ultimas;
    private List<Song> songs;
    private PlayerMp3 playerMp3, previewMp3;

    private boolean isPlaying;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_for_you, container, false);
        songs = new SongLibrary().getSongList();

        getRecyclerPraVoce(view);
        getRecyclerSeusAmigos(view);
        getRecyclerUltimas(view);

        return view;

    }

    private void getRecyclerPraVoce(View view) {

        recycler_pra_voce = (RecyclerView) view.findViewById(R.id.recycler_pra_voce);
        recycler_pra_voce.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
        recycler_pra_voce.setItemAnimator(new DefaultItemAnimator());
        recycler_pra_voce.setAdapter(new ForYouAdapter(getContext(), songs, onClickSongsMusic()));

    }

    private void getRecyclerSeusAmigos(View view) {

        recycler_seus_amigos = (RecyclerView) view.findViewById(R.id.recycler_seus_amigos);
        recycler_seus_amigos.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
        recycler_seus_amigos.setItemAnimator(new DefaultItemAnimator());
        recycler_seus_amigos.setAdapter(new ForYouAdapter(getContext(), songs, onClickSongsMusic()));

    }

    private void getRecyclerUltimas(View view) {

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recycler_ultimas = (RecyclerView) view.findViewById(R.id.recycler_ultimas);
        recycler_ultimas.setLayoutManager(layoutManager);
        recycler_ultimas.setItemAnimator(new DefaultItemAnimator());
        recycler_ultimas.setAdapter(new ForYouAdapter(getContext(), songs, onClickSongsMusic()));


    }

    private ForYouAdapter.OnClickSongsCallback onClickSongsMusic() {

        return new ForYouAdapter.OnClickSongsCallback() {

            @Override
            public void onClickPlay(ForYouAdapter.SongsViewHolder holder, int id) {

                Toast.makeText(getContext(), "Tocar Música", Toast.LENGTH_SHORT).show();

            }

        };

    }


    @Override
    public void onPause() {

        super.onPause();

        isPlaying = false;

        if (playerMp3 != null) {

            playerMp3.pause();

        }

    }

    @Override
    public void onDestroy() {

        super.onDestroy();

        isPlaying = false;

        if (playerMp3 != null) {

            playerMp3.stop();
            playerMp3.killMyInstance();

        }

    }


    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

        Log.d(TAG, "onPrepared()");
        isPlaying = true;
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }
}