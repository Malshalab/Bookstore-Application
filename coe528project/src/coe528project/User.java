package coe528project;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public abstract class User {
    protected String username;
    protected String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean verifyLogin(TextField t1, PasswordField p1) {
        if (t1.getText().trim().equals(username) && p1.getText().trim().equals(password)) return true;
        else return false;
    }
    public abstract void addItem(Object o);
    public abstract void deleteItem(Object o, int i);
    
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    @Override
    public String toString(){
        String s = username + " " + password;
        return s;
    }
}
