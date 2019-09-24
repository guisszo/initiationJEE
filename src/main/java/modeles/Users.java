package modeles;

public class Users {
    private String login;
    private  String password;

    public Users() {
    }

    public Users(String login, String password, String nomcomplet, String profile) {
        this.login = login;
        this.password = password;
        this.nomcomplet = nomcomplet;
        this.profile = profile;
    }

    private String nomcomplet;
    private String profile;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomcomplet() {
        return nomcomplet;
    }

    public void setNomcomplet(String nomcomplet) {
        this.nomcomplet = nomcomplet;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
