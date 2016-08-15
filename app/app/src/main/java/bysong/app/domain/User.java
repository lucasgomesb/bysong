package bysong.app.domain;

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

    public User(String userCode, String firstName, String lastName, UserType userType) {

        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userCode = userCode;

    }

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

