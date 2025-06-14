package models;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String inputUser, String inputPass) {
        return username.equals(inputUser) && password.equals(inputPass);
    }
}
