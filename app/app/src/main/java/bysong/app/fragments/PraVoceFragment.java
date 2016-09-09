package bysong.app.fragments;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import bysong.app.R;
import bysong.app.activity.MusicaActivity;
import bysong.app.adapter.SongsAdapter;
import bysong.app.controller.SongLibrary;
import bysong.app.domain.PlayerMp3;
import bysong.app.domain.Song;

/**
 * Created by Tiago on 10/08/2016.
 */
public class PraVoceFragment extends Fragment implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private static final String TAG = "songplayer";
    private RecyclerView recyclerView;
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

        View view = inflater.inflate(R.layout.fragment_por_genero, container, false);
        songs = new SongLibrary().getSongList();
        //songs = Song.getSongs();
        // RecyclerView
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

                playerMp3 = PlayerMp3.getInstance(PraVoceFragment.this, PraVoceFragment.this);
                playerMp3.start("https://albireo1.sscdn.co/palcomp3/c/9/e/8/bandatorpedooficial-banda-torpedo-pra-nao-morrer-de-paixao-audio-oficial-2016-9cff4a7d.mp3");
                holder.song_item_audio.setVisibility(View.GONE);
                holder.song_item_audio_pause.setVisibility(View.VISIBLE);

            }

            @Override
            public void onClickPause(SongsAdapter.SongsViewHolder holder, int id) {

                isPlaying = false;

                if (playerMp3 != null) {

                    playerMp3.pause();
                    holder.song_item_audio.setVisibility(View.VISIBLE);
                    holder.song_item_audio_pause.setVisibility(View.GONE);

                }

            }

            @Override
            public void onClickPlayPreview(SongsAdapter.SongsViewHolder holder, int id) {

                /*try {

                    previewMp3 = PlayerMp3.getInstance(PraVoceFragment.this);
                    AssetFileDescriptor asset = getActivity().getAssets().openFd("pra_nao_morrer_de_paixao_refrao.mp3");
                    previewMp3.start(asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength());

                } catch (IOException e) {

                    Log.e(TAG, e.getMessage(), e);

                }*/

            }

            @Override
            public void onClickTrecho(SongsAdapter.SongsViewHolder holder, int id) {

                startActivity(new Intent(getContext(), MusicaActivity.class));

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
