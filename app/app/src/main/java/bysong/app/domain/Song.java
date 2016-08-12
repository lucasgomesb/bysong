package bysong.app.domain;

import java.util.ArrayList;
import java.util.List;

import bysong.app.R;

/**
 * Created by Tiago on 11/08/2016.
 * Classe de domínio Song
 */
public class Song {

    private int imgArtist;
    private String nameArtist;

    public Song(int imgArtist, String nameArtist){

        this.imgArtist = imgArtist;
        this.nameArtist = nameArtist;

    }

    public int getImgArtist() {
        return imgArtist;
    }

    public void setImgArtist(int imgArtist) {
        this.imgArtist = imgArtist;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public static List<Song> getSongs() {

        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        songs.add(new Song(R.drawable.artist_circle_adele, "Adele - Hello"));
        return songs;

    }

}
