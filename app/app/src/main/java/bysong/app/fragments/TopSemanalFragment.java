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

    private static final String TAG = "songplayer";
    private static RecyclerView recyclerView;
    private static List<Song> songs;
    private static PlayerMp3 playerMp3, previewMp3;

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
        //songs = Song.getSongs()
        // RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.top10);
        recyclerUp(getContext(), songs);
        setHasOptionsMenu(true);
        return view;

    }

    public void recyclerUp(Context context, List<Song> songs){

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new SongsAdapter(context, songs, onClickSongsMuisc()));

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menu_search);
        SearchView sv = new SearchView(getActivity());
        sv.setOnQueryTextListener(new MenuListener(getActivity()));
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
            //Toast.makeText(context, "Texto: " + query, Toast.LENGTH_SHORT).show();
            if (songs != null) {

                List<Song> songsResult = new ArrayList<Song>();
                for (Song song : songs) {

                    boolean contains = song.getArtist().getArtistName().toUpperCase().contains(query.toUpperCase());

                    if (contains) {

                        songsResult.add(song);

                    }

                }

                recyclerUp(getContext(),songsResult);
                AndroidUtils.closeVirtualKeyborad(getContext(), recyclerView);

            }

            return false;

        }

        @Override
        public boolean onQueryTextChange(String newText) {

            Log.i("livroandroid", "onQueryTextChange: " + newText);

            if ("".equals(newText)) {

                // Se vazio volta a lista original
                recyclerUp(getContext(),songs);

            }

            return false;

        }

    }

    private SongsAdapter.OnClickSongs onClickSongsMuisc() {

        return new SongsAdapter.OnClickSongs() {

            @Override
            public void onClickPlay(SongsAdapter.SongsViewHolder holder, int id) {

                Log.d(TAG, "onClickPlay()");
                playerMp3 = PlayerMp3.getInstance(TopSemanalFragment.this, TopSemanalFragment.this);
                playerMp3.start("https://albireo1.sscdn.co/palcomp3/c/9/e/8/bandatorpedooficial-banda-torpedo-pra-nao-morrer-de-paixao-audio-oficial-2016-9cff4a7d.mp3");
                holder.song_item_audio.setVisibility(View.GONE);
                holder.song_item_audio_pause.setVisibility(View.VISIBLE);

            }

            @Override
            public void onClickPause(SongsAdapter.SongsViewHolder holder, int id) {

                isPlaying = false;

                if (playerMp3 != null) {

                    Log.d(TAG, "onClickPause()");
                    playerMp3.pause();
                    holder.song_item_audio.setVisibility(View.VISIBLE);
                    holder.song_item_audio_pause.setVisibility(View.GONE);

                }

            }

            @Override
            public void onClickPlayPreview(SongsAdapter.SongsViewHolder holder, int id) {

                /*try {

                    previewMp3 = PlayerMp3.getInstance(TopSemanalFragment.this);
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

        Log.d(TAG, "onPause()");

        isPlaying = false;

        if (playerMp3 != null) {

            playerMp3.pause();

        }

    }

    @Override
    public void onDestroy() {

        super.onDestroy();

        Log.d(TAG, "onStop()");

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

        Log.d(TAG, "onCompletion()");
        playerMp3.stop();

    }
}
