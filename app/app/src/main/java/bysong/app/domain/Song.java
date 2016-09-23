package bysong.app.domain;

import java.util.ArrayList;
import java.util.List;

import bysong.app.R;

/**
 * Created by Tiago on 11/08/2016.
 * Classe de domínio Song
 */
public class Song {

    private String songCode;
    private String fileNameMp3;
    private String title;
    private int allViewsCount;
    public List<Verse> versesList;
    private Artist artist;
    private int ioSongRankStatus; // Atributo ioSongRankStatus alterado de SongRankStatus para int

    /* Obs.: Sempre que um construtor for utilizado para inicializar os atributos é preciso criar
     * um outro construtor vazio, pois nem sempre vamos inicializar os atributos ao instanciar o mesmo. */
    public Song() {}

    public Song(String songCode, String fileNameMp3, String title, int allViewsCount,
                List<Verse> versesList, Artist artist, int ioSongRankStatus) {

        this.songCode = songCode;
        this.fileNameMp3 = fileNameMp3;
        this.title = title;
        this.allViewsCount = allViewsCount;
        this.versesList = versesList;
        this.artist = artist;
        this.ioSongRankStatus = ioSongRankStatus;

    }

    public String getSongCode() {
        return songCode;
    }

    public void setSongCode(String songCode) {
        this.songCode = songCode;
    }

    public String getFileNameMp3() {
        return fileNameMp3;
    }

    public void setFileNameMp3(String fileNameMp3) {
        this.fileNameMp3 = fileNameMp3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAllViewsCount() {
        return allViewsCount;
    }

    public void setAllViewsCount(int allViewsCount) {
        this.allViewsCount = allViewsCount;
    }

    public List<Verse> getVersesList() {
        return versesList;
    }

    public void setVersesList(List<Verse> versesList) {
        this.versesList = versesList;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getIoSongRankStatus() {
        return ioSongRankStatus;
    }

    public void setIoSongRankStatus(int ioSongRankStatus) {
        this.ioSongRankStatus = ioSongRankStatus;
    }

    // Método para teste
    public static List<Song> getSongs() {

        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.artist_circle_adele), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.artist_circle_adele), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.artist_circle_adele), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.artist_circle_adele), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.artist_circle_adele), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.artist_circle_adele), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.artist_circle_adele), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.artist_circle_adele), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.artist_circle_adele), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.artist_circle_adele), 0));
        return songs;

    }

    // Método para teste
    public static List<Song> getSongsArtist() {

        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.adele_hello_art), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.meghan_trainor_no_art), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.maroon_five_sugar_art), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.john_lennon_imagine_art), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.nirvana_come_as_you_are_art), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.guns_n_roses_patience_art), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.sia_cheap_thrills_art), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.adele_hello_art), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.meghan_trainor_no_art), 0));
        songs.add(new Song("", "", "Hello", 0, null, new Artist("Adele", R.drawable.maroon_five_sugar_art), 0));
        return songs;

    }

}
