package bysong.app.domain;

/**
 * Created by Lucas on 14/08/2016.
 */
public class Artist {

    private String artistName;
    private String imageFileArtist;
    //private int imageFileArtistID;

   /* public Artist(String artistName, int imageFileArtistID) {

        this.artistName = artistName;
        this.imageFileArtistID = imageFileArtistID;

    }*/
    public Artist(String artistName, String imageFileArtist) {

        this.artistName = artistName;
        this.imageFileArtist = imageFileArtist;

    }
    public void setArtistName(String artistName) {

        this.artistName = artistName;

    }

    public String getArtistName() {

        return artistName;

    }

    public void setImageFileArtist(String imageFileArtist) {

        this.imageFileArtist = imageFileArtist;

    }

    public String getImageFileArtist() {

        return imageFileArtist;

    }
   /* public int getImageFileArtistID() {

        return imageFileArtistID;

    }*/
}

