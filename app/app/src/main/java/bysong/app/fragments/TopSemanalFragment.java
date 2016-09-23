package bysong.app.fragments;
 
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import bysong.app.activity.MusicaActivity;
import bysong.app.adapter.SongsAdapter;
import bysong.app.controller.SongLibrary;
import bysong.app.domain.PlayerMp3;
import bysong.app.domain.Song;
import bysong.app.utils.AndroidUtils;

/**
 * Created by Tiago on 10/08/2016.
 */
public class TopSemanalFragment extends Fragment implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private final String TAG = "songplayer";
    private RecyclerView recyclerView;
    private List<Song> songs;
<<<<<<< HEAD:app/app/src/main/java/bysong/app/fragments/Top100Fragment.java
    //private PlayerMp3 playerMp3;
    private PlayerMp3 playerPreview;
=======
    private PlayerMp3 playerMp3, previewMp3;
>>>>>>> origin/master:app/app/src/main/java/bysong/app/fragments/TopSemanalFragment.java

    private static boolean isPlaying;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_top_semanal, container, false);
        songs = new SongLibrary().getSongList();
<<<<<<< HEAD:app/app/src/main/java/bysong/app/fragments/Top100Fragment.java
        //songs = Song.getSongs();
        //playerMp3 = new PlayerMp3(getContext(), this);
        playerPreview = new PlayerMp3(getContext(), this);
=======
        //songs = Song.getSongs()
>>>>>>> origin/master:app/app/src/main/java/bysong/app/fragments/TopSemanalFragment.java
        // RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.top10);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new SongsAdapter(getContext(), songs, onClickSongsMuisc()));
        return view;

    }

    private SongsAdapter.OnClickSongs onClickSongsMuisc() {

        return new SongsAdapter.OnClickSongs() {

            @Override
            public void onClickPlay(SongsAdapter.SongsViewHolder holder, int id) {

<<<<<<< HEAD:app/app/src/main/java/bysong/app/fragments/Top100Fragment.java
                playerPreview.start("https://albireo1.sscdn.co/palcomp3/c/9/e/8/bandatorpedooficial-banda-torpedo-pra-nao-morrer-de-paixao-audio-oficial-2016-9cff4a7d.mp3");
=======
                Log.d(TAG, "onClickPlay()");
                playerMp3 = PlayerMp3.getInstance(TopSemanalFragment.this, TopSemanalFragment.this);
                playerMp3.start("https://albireo1.sscdn.co/palcomp3/c/9/e/8/bandatorpedooficial-banda-torpedo-pra-nao-morrer-de-paixao-audio-oficial-2016-9cff4a7d.mp3");
>>>>>>> origin/master:app/app/src/main/java/bysong/app/fragments/TopSemanalFragment.java
                holder.song_item_audio.setVisibility(View.GONE);
                holder.song_item_audio_pause.setVisibility(View.VISIBLE);

            }

            @Override
            public void onClickPause(SongsAdapter.SongsViewHolder holder, int id) {

                isPlaying = false;

              /*  if (playerMp3 != null) {

                    Log.d(TAG, "onClickPause()");
                    playerMp3.pause();
                    holder.song_item_audio.setVisibility(View.VISIBLE);
                    holder.song_item_audio_pause.setVisibility(View.GONE);

                }*/

            }

            @Override
            public void onClickPlayPreview(SongsAdapter.SongsViewHolder holder, int id) {

                /*try {

<<<<<<< HEAD:app/app/src/main/java/bysong/app/fragments/Top100Fragment.java
                    if (isPlaying) {
                        playerPreview.stop();
                        isPlaying = false;
                        //holder.song_item_audio.setVisibility(View.VISIBLE);
                        //holder.song_item_audio_pause.setVisibility(View.GONE);
                    } else {
                        AssetFileDescriptor asset = getActivity().getAssets().openFd("pra_nao_morrer_de_paixao_refrao.mp3");
                        playerPreview.start(asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength());
                    }
=======
                    previewMp3 = PlayerMp3.getInstance(TopSemanalFragment.this);
                    AssetFileDescriptor asset = getActivity().getAssets().openFd("pra_nao_morrer_de_paixao_refrao.mp3");
                    previewMp3.start(asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength());

>>>>>>> origin/master:app/app/src/main/java/bysong/app/fragments/TopSemanalFragment.java
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

        Log.d(TAG, "onPause()");

        isPlaying = false;

        if (playerPreview != null) {

            playerPreview.pause();

        }

    }

    @Override
    public void onDestroy() {

        super.onDestroy();

        Log.d(TAG, "onStop()");

        isPlaying = false;

        if (playerPreview != null) {

<<<<<<< HEAD:app/app/src/main/java/bysong/app/fragments/Top100Fragment.java
            playerPreview.stop();
=======
            playerMp3.stop();
            playerMp3.killMyInstance();
>>>>>>> origin/master:app/app/src/main/java/bysong/app/fragments/TopSemanalFragment.java

        }

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

        Log.d(TAG, "onPrepared()");
        isPlaying = true;
        mediaPlayer.start();
        //mediaPlayer.setLooping(true);

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

        Log.d(TAG, "onCompletion()");
        playerMp3.stop();

    }
}
