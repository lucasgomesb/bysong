package bysong.app.domain;

/**
 * Created by Lucas on 14/08/2016.
 */
public class Artist {

    private String artistName;
    private int imageFileArtist;

    public Artist(String artistName, int imageFileArtist) {

        this.artistName = artistName;
        this.imageFileArtist = imageFileArtist;

    }

    public void setArtistName(String artistName) {

        this.artistName = artistName;

    }

    public String getArtistName() {

        return artistName;

    }

    public void setImageFileArtist(int imageFileArtist) {

        this.imageFileArtist = imageFileArtist;

    }

    public int getImageFileArtist() {

        return imageFileArtist;

    }

}

