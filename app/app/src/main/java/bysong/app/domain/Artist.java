package bysong.app.domain;

/**
 * Created by Lucas on 14/08/2016.
 */
public class Artist {

    private String isArtistName;
    private String isImageFileName;

    public Artist(String asArtistName, String asImageFileName)
    {
        isArtistName = asArtistName;
        isImageFileName = asImageFileName;
    }

    public void setArtistName(String asArtistName)
    {
        isArtistName = asArtistName;
    }

    public String getArtistName()
    {
        return isArtistName;
    }

    public void setImageFileName(String asImageFileName)
    {
        isImageFileName = asImageFileName;
    }

    public String getImageFileName()
    {
        return isImageFileName;
    }

}

