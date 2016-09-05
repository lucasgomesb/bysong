package bysong.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bysong.app.R;
import bysong.app.domain.Song;

/**
 * Created by Tiago on 11/08/2016.
 * Classe SongsAdapter que herda de RecyclerView.Adapter para tratar as ações nos itens da lista
 * por não possuir métodos de interação (listener) é necessário implementar uma interface de callback
 */
public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {

    private Context context;
    private List<Song> songs;
    private OnClickSongs onClickSongs; // Objeto da interface OnClickSongs para realizar Callback das ações nos itens da lista
    // Interface necessária para o Callback
    public interface OnClickSongs {

        void onClickPlay(SongsViewHolder holder, int id);
        void onClickPause(SongsViewHolder holder, int id);
        void onClickPlayPreview(SongsViewHolder holder, int id);

    }

    public SongsAdapter(Context context, List<Song> songs, OnClickSongs onClickSongs) {

        this.context = context;
        this.songs = songs;
        this.onClickSongs = onClickSongs;

    }


    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.linha_lista_song, parent, false);
        SongsViewHolder holder = new SongsViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(final SongsViewHolder holder, final int position) {

        Song song = songs.get(position);
        holder.img_artist.setImageResource(song.getArtist().getImageFileArtist());
        holder.img_status.setImageResource(song.getIoSongRankStatus());
        holder.name_song_artist.setText(song.getArtist().getArtistName() + " - " + song.getTitle());
        holder.visualizacoes.setText(String.valueOf(song.getAllViewsCount()) + " visualicações");

        if (onClickSongs != null) {

            holder.song_item_audio.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    onClickSongs.onClickPlay(holder, position);

                }

            });

            holder.song_item_audio_pause.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    onClickSongs.onClickPause(holder, position);

                }

            });

            holder.preview.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    onClickSongs.onClickPlayPreview(holder, position);

                }

            });

        }

    }

    @Override
    public int getItemCount() {

        return this.songs != null ? songs.size() : 0;

    }

    public static class SongsViewHolder extends RecyclerView.ViewHolder {

        public ImageView img_artist, song_item_audio, song_item_audio_pause, img_status, preview;
        private TextView name_song_artist, visualizacoes;

        public SongsViewHolder(View itemView) {

            super(itemView);
            img_artist = (ImageView) itemView.findViewById(R.id.img_artist);
            name_song_artist = (TextView) itemView.findViewById(R.id.name_song_artist);
            img_status = (ImageView) itemView.findViewById(R.id.img_status);
            preview = (ImageView) itemView.findViewById(R.id.preview);
            visualizacoes = (TextView) itemView.findViewById(R.id.visualizacoes);
            song_item_audio = (ImageView) itemView.findViewById(R.id.song_item_audio);
            song_item_audio_pause = (ImageView) itemView.findViewById(R.id.song_item_audio_pause);

        }

    }

}
