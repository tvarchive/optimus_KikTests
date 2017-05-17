package entities;

public class User2 extends User {

    private String username;
    private String password;

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
