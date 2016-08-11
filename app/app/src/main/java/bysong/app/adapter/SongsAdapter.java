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

        void onClickSongs(SongsViewHolder holder, int id);

    }

    public SongsAdapter(Context context, List<Song> songs) {

        this.context = context;
        this.songs = songs;

    }


    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.linha_lista_song, parent, false);
        SongsViewHolder holder = new SongsViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(SongsViewHolder holder, int position) {

        Song song = songs.get(position);
        holder.img_artist.setImageResource(song.getImgArtist());
        holder.name_song_artist.setText(song.getNameArtist());
        holder.song_item_star_1.setImageResource(R.drawable.song_item_start_on);
        holder.song_item_star_2.setImageResource(R.drawable.song_item_start_on);
        holder.song_item_star_3.setImageResource(R.drawable.song_item_start_off);
        holder.song_item_audio.setImageResource(R.drawable.song_item_audio);

    }

    @Override
    public int getItemCount() {

        return this.songs != null ? songs.size() : 0;

    }

    public static class SongsViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_artist, song_item_star_1, song_item_star_2, song_item_star_3, song_item_audio;
        private TextView name_song_artist;

        public SongsViewHolder(View itemView) {

            super(itemView);
            img_artist = (ImageView) itemView.findViewById(R.id.img_artist);
            name_song_artist = (TextView) itemView.findViewById(R.id.name_song_artist);
            song_item_star_1 = (ImageView) itemView.findViewById(R.id.song_item_start_1);
            song_item_star_2 = (ImageView) itemView.findViewById(R.id.song_item_start_2);
            song_item_star_3 = (ImageView) itemView.findViewById(R.id.song_item_start_3);
            song_item_audio = (ImageView) itemView.findViewById(R.id.song_item_audio);

        }

    }

}
