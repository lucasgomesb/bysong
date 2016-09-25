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
public class PraVoceAdapter extends RecyclerView.Adapter<PraVoceAdapter.SongsViewHolder> {

    private Context context;
    private List<Song> songs;
    private OnClickSongsCallback onClickSongsCallback; // Objeto da interface OnClickSongs para realizar Callback das ações nos itens da lista
    // Interface necessária para o Callback
    public interface OnClickSongsCallback {

        void onClickPlay(SongsViewHolder holder, int id);

    }

    public PraVoceAdapter(Context context, List<Song> songs, OnClickSongsCallback onClickSongsCallback) {

        this.context = context;
        this.songs = songs;
        this.onClickSongsCallback = onClickSongsCallback;

    }


    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.linha_lista_pra_voce, parent, false);
        SongsViewHolder holder = new SongsViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(final SongsViewHolder holder, final int position) {

        Song song = songs.get(position);
        holder.art_album.setImageResource(song.getArtist().getImageFileArtistID());

        if (onClickSongsCallback != null) {

            holder.media_play.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    onClickSongsCallback.onClickPlay(holder, position);

                }

            });

        }

    }

    @Override
    public int getItemCount() {

        return this.songs != null ? songs.size() : 0;

    }

    public static class SongsViewHolder extends RecyclerView.ViewHolder {

        public ImageView art_album, media_play;

        public SongsViewHolder(View itemView) {

            super(itemView);
            art_album = (ImageView) itemView.findViewById(R.id.art_album);
            media_play = (ImageView) itemView.findViewById(R.id.media_play);

        }

    }

}
