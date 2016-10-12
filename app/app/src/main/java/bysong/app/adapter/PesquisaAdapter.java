package bysong.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bysong.app.R;
import bysong.app.domain.Song;

/**
 * Created by Tiago on 26/09/2016.
 */

public class PesquisaAdapter extends BaseAdapter {

    private Context context;
    private List<Song> songs;
    private UserViewHolder holder;

    public PesquisaAdapter(Context context, List<Song> songs) {

        this.context = context;
        this.songs = songs;

    }

    @Override
    public int getCount() {

        return songs.size();

    }

    @Override
    public Object getItem(int position) {

        return songs.get(position);

    }

    @Override
    public long getItemId(int position) {

        return 0;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Song song = songs.get(position);
        View view = LayoutInflater.from(context).inflate(R.layout.linha_lista_song, parent, false);
        holder = new UserViewHolder(view);
        //holder.img_artist.setImageResource(song.getArtist().getImageFileArtist());
        //holder.img_status.setImageResource(song.getSongRankingStatus());
        holder.name_song_artist.setText(song.getArtist().getArtistName() + " - " + song.getTitle());
        holder.visualizacoes.setText(String.valueOf(song.getAllViewsCount()) + " visualicações");

        return view;

    }

    class UserViewHolder {

        public ImageView img_artist, song_item_audio, song_item_audio_pause, img_status, preview;
        private TextView name_song_artist, visualizacoes;

        public UserViewHolder(View view) {

            img_artist = (ImageView) view.findViewById(R.id.img_artist);
            name_song_artist = (TextView) view.findViewById(R.id.name_song_artist);
            img_status = (ImageView) view.findViewById(R.id.img_status);
            //preview = (ImageView) view.findViewById(R.id.preview);
            visualizacoes = (TextView) view.findViewById(R.id.visualizacoes);
            //song_item_audio = (ImageView) view.findViewById(R.id.song_item_audio);
            //song_item_audio_pause = (ImageView) view.findViewById(R.id.song_item_audio_pause);

        }

    }

}
