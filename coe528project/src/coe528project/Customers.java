package coe528project;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.CheckBox;

public class Customers extends User{
    private int points;
    private CheckBox cb;
    private String status;
    public Customers(String username, String password, int points) {
        super(username, password);
        this.points = points;
        cb = new CheckBox();
    }
    public Customers(String username, String password) {
        super(username, password);
        points = 0;
        status = "Silver";
        cb = new CheckBox();
    }
    public int getPoints() {
        return points;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(){
        if (points >= 1000) status = "Gold";
        else status = "Silver";
    }
    public void setPoints(int p){
        points += p;
        if (points < 0) points = 0;
    }
    public CheckBox getCheckBox(){
        return cb;
    }
    @Override
    public String toString(){
        String s = username + " " + password + " " + points;
        return s;
    }
    
    @Override
    public void addItem(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItem(Object o, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
