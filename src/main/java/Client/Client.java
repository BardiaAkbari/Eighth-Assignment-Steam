package Client;

import java.util.UUID;

public class Client {

    // Attributes
    private String iD;
    private String username;
    private String password;
    private String date;

    // Constructor
    public Client() {

    }
    // Constructor For login
    public Client(String iD, String username, String password, String date) {
        this.username = username;
        this.password = password;
        this.date = date;
        this.iD = iD;
    }
    // Constructor For Signing
    public Client(String username, String password, String date) {
        this.iD = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.date = date;
    }

    //Setter

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Getter

    public String getiD() {
        return iD;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }
}