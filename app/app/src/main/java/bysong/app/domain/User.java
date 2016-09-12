package bysong.app.domain;

import java.util.ArrayList;
import java.util.List;

import bysong.app.R;

/**
 * Created by Lucas on 14/08/2016.
 */
public class User {

    private String userCode;
    private String firstName;
    private String lastName;
    private int rankPosition;
    private int score;
    private String imageFileName;
    private UserType userType;

    /* Obs.: Sempre que um construtor for utilizado para inicializar os atributos é preciso criar
     * um outro construtor vazio, pois nem sempre vamos inicializar os atributos ao instanciar o mesmo */
    public User() {}

    public User(String userCode, String imageFileName, String firstName, String lastName,
                int rankPosition, int score) {

        this.userCode = userCode;
        this.imageFileName = imageFileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rankPosition = rankPosition;
        this.score = score;

    }

    /*
    public static List<User> getUser() {

        List<User> users = new ArrayList<User>();
        users.add(new User("0001", R.drawable.artist_circle_john_lennon, "Tiago Vieira", "Tiago Vieira", 1, 9000));
        users.add(new User("0010", R.drawable.artist_circle_guns_n_roses, "Lucas Gomes", "Lucas Gomes", 2, 8000));
        users.add(new User("0100", R.drawable.artist_circle_nirvana, "Jair Bolsonaro", "Jair Bolsonaro", 3, 7000));
        users.add(new User("1000", R.drawable.artist_circle_john_lennon, "Tiago Vieira", "Tiago Vieira", 4, 6000));
        users.add(new User("0011", R.drawable.artist_circle_guns_n_roses, "Lucas Gomes", "Lucas Gomes", 5, 5000));
        users.add(new User("0111", R.drawable.artist_circle_nirvana, "Jair Bolsonaro", "Jair Bolsonaro", 6, 4000));
        users.add(new User("1111", R.drawable.artist_circle_john_lennon, "Tiago Vieira", "Tiago Vieira", 7, 3000));
        users.add(new User("0002", R.drawable.artist_circle_guns_n_roses, "Lucas Gomes", "Lucas Gomes", 8, 2000));
        users.add(new User("0020", R.drawable.artist_circle_nirvana, "Jair Bolsonaro", "Jair Bolsonaro", 9, 1000));
        return users;

    }*/


    public String getUserCode() {

        return userCode;

    }

    public void setUserCode(String userCode) {

        this.userCode = userCode;

    }

    public String getFirstName() {

        return firstName;

    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;

    }

    public String getLastName() {

        return lastName;

    }

    public void setLastName(String lastName) {

        this.lastName = lastName;

    }

    public int getRankPosition() {

        return rankPosition;

    }

    public void setRankPosition(int rankPosition) {

        this.rankPosition = rankPosition;

    }

    public int getScore() {

        return score;

    }

    public void setScore(int score) {

        this.score = score;

    }

    public String getImageFileName() {

        return imageFileName;

    }

    public void setImageFileName(String imageFileName) {

        this.imageFileName = imageFileName;

    }

    public UserType getUserType() {

        return userType;

    }

    public void setUserType(UserType userType) {

        this.userType = userType;

    }

}

