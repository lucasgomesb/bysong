package bysong.app.controller;

import java.util.ArrayList;
import java.util.List;

import bysong.app.R;
import bysong.app.domain.*;

/**
 * Created by Lucas on 14/08/2016.
 */
public class SongLibrary {

    public SongLibrary() {

    }

    private void SetVersesListTest(Song aoSong) {

        List<Word> loWordsList = new ArrayList<Word>();
        loWordsList.add(new Word("i", Language.english));
        loWordsList.add(new Word("am", Language.english));
        loWordsList.add(new Word("a", Language.english));
        loWordsList.add(new Word("test", Language.english));


        aoSong.versesList = new ArrayList<Verse>();
        aoSong.versesList.add(new Verse(1, loWordsList, 1000, 10000));
        aoSong.versesList.add(new Verse(2, loWordsList, 11000, 20000));
        aoSong.versesList.add(new Verse(3, loWordsList, 21000, 30000));
        aoSong.versesList.add(new Verse(4, loWordsList, 31000, 40000));
        aoSong.versesList.add(new Verse(5, loWordsList, 41000, 50000));
        aoSong.versesList.add(new Verse(6, loWordsList, 51000, 60000));
        aoSong.versesList.add(new Verse(7, loWordsList, 61000, 70000));
        aoSong.versesList.add(new Verse(8, loWordsList, 71000, 80000));
        aoSong.versesList.add(new Verse(9, loWordsList, 81000, 90000));
        aoSong.versesList.add(new Verse(10, loWordsList, 91000, 100000));

    }

    public List<Song> getSongList() {

        List<Song> loSongList = new ArrayList<Song>();
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Hello", 128, null, new Artist("Adele", "artist_circle_adele"), SongRankStatus.getStatus(SongRankStatus.DOWN)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "NO", 5677, null, new Artist("Meghan Trainor", "artist_circle_meghan_trainor"), SongRankStatus.getStatus(SongRankStatus.DOWN)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Sugar", 756, null, new Artist("Maroon Five", "artist_circle_maroon_five"), SongRankStatus.getStatus(SongRankStatus.NO_CHANGES)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Imagine", 26546, null, new Artist("John Lennon", "artist_circle_john_lennon"), SongRankStatus.getStatus(SongRankStatus.UP)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Come as you are", 982, null, new Artist("Nirvana", "artist_circle_nirvana"), SongRankStatus.getStatus(SongRankStatus.NO_CHANGES)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Patience",1892, null, new Artist("Guns N' Roses", "artist_circle_guns_n_roses"), SongRankStatus.getStatus(SongRankStatus.UP)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Cheap Thrills",7817, null, new Artist("Sia", "artist_circle_sia"), SongRankStatus.getStatus(SongRankStatus.DOWN)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "NO", 5677, null, new Artist("Meghan Trainor", "artist_circle_meghan_trainor"), SongRankStatus.getStatus(SongRankStatus.DOWN)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Sugar", 756, null, new Artist("Maroon Five", "artist_circle_maroon_five"), SongRankStatus.getStatus(SongRankStatus.NO_CHANGES)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Imagine", 26546, null, new Artist("John Lennon", "artist_circle_john_lennon"), SongRankStatus.getStatus(SongRankStatus.UP)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Come as you are", 982, null, new Artist("Nirvana", "artist_circle_nirvana"), SongRankStatus.getStatus(SongRankStatus.NO_CHANGES)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Patience", 1892, null, new Artist("Guns N' Roses", "artist_circle_guns_n_roses"), SongRankStatus.getStatus(SongRankStatus.UP)));
        loSongList.add(new Song("0001", "http://bysong.com.br/BySongStreamingFiles/dream_girl.mp3", "Cheap Thrills", 7817, null, new Artist("Sia", "artist_circle_sia"), SongRankStatus.getStatus(SongRankStatus.DOWN)));

        for(Song loSong : loSongList) {

            SetVersesListTest(loSong);

        }

        return loSongList;

    }

}




