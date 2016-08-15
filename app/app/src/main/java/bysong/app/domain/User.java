package bysong.app.domain;

/**
 * Created by Lucas on 14/08/2016.
 */
public class User
{
    public String UserCode;
    public String FirstName;
    public String LastName;
    public int RankPosition;
    public int Score;
    public UserType UserType;
    public String ImageFileName;

    public User(String aoUserCode, String aoFirstName, String aoLastName, UserType aoUserType)
    {
        UserCode = aoUserCode;
        FirstName = aoFirstName;
        LastName = aoLastName;
        UserType = aoUserType;
    }


}

