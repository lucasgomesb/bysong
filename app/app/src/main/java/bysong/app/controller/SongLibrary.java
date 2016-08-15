package bysong.app.controller;

import java.util.ArrayList;
import java.util.List;

import bysong.app.domain.*;

/**
 * Created by Lucas on 14/08/2016.
 */
public class SongLibrary
{

    public SongLibrary()
    {

    }

    private void SetVersesListTest(Song aoSong) {

        List<Word> loWordsList = new ArrayList<Word>();
        loWordsList.add(new Word("i", Language.English));
        loWordsList.add(new Word("am", Language.English));
        loWordsList.add(new Word("a", Language.English));
        loWordsList.add(new Word("test", Language.English));


        aoSong.VersesList = new ArrayList<Verse>();
        aoSong.VersesList.add(new Verse(1, loWordsList, 1000, 10000));
        aoSong.VersesList.add(new Verse(2, loWordsList, 11000, 20000));
        aoSong.VersesList.add(new Verse(3, loWordsList, 21000, 30000));
        aoSong.VersesList.add(new Verse(4, loWordsList, 31000, 40000));
        aoSong.VersesList.add(new Verse(5, loWordsList, 41000, 50000));
        aoSong.VersesList.add(new Verse(6, loWordsList, 51000, 60000));
        aoSong.VersesList.add(new Verse(7, loWordsList, 61000, 70000));
        aoSong.VersesList.add(new Verse(8, loWordsList, 71000, 80000));
        aoSong.VersesList.add(new Verse(9, loWordsList, 81000, 90000));
        aoSong.VersesList.add(new Verse(10, loWordsList, 91000, 100000));
    }

    public List<Song> GetSongList()
    {
        List<Song> loSongList = new ArrayList<Song>();
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Adele", "artist_circle_adele.png"), "Hello", 128, SongRankStatus.Down));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Meghan Trainor", "artist_circle_meghan_trainor.png"), "NO", 5677, SongRankStatus.Down));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Maroon Five", "artist_circle_maroon_five.png"), "Sugar", 756, SongRankStatus.NoChanges));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("John Lennon", "artist_circle_john_lennon.png"), "Imagine", 26546, SongRankStatus.Up));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Nirvana", "artist_circle_nirvana.png"), "Come as you are", 982, SongRankStatus.NoChanges));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Guns N' Roses", "artist_circle_guns_n_roses.png"), "Patience",1892, SongRankStatus.Up));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Sia", "artist_circle_sia.png"), "Cheap Thrills",7817, SongRankStatus.Down));


        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Meghan Trainor", "artist_circle_meghan_trainor.png"), "NO", 5677, SongRankStatus.Down));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Maroon Five", "artist_circle_maroon_five.png"), "Sugar", 756, SongRankStatus.NoChanges));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("John Lennon", "artist_circle_john_lennon.png"), "Imagine", 26546, SongRankStatus.Up));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Nirvana", "artist_circle_nirvana.png"), "Come as you are", 982, SongRankStatus.NoChanges));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Guns N' Roses", "artist_circle_guns_n_roses.png"), "Patience", 1892, SongRankStatus.Up));
        loSongList.add(new Song("dangerous.mp3", "dangerous.mp3", new Artist("Sia", "artist_circle_sia.png"), "Cheap Thrills", 7817, SongRankStatus.Down));

        for(Song loSong : loSongList)
        {
            SetVersesListTest(loSong);
        }

        return loSongList;
    }


}




