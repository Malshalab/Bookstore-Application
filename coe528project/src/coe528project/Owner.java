package coe528project;

import static coe528project.Main.addBook;
import static coe528project.Main.addCustomer;
import static coe528project.Main.deleteBook;
import static coe528project.Main.deleteCustomer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Owner extends User {
    public Owner() {
        super("Admin", "Admin");
    }
    @Override
    public void addItem(Object o) {
        if (o instanceof Customers) {
            addCustomer((Customers)o);
        }
        if (o instanceof Books) {
            addBook((Books)o);
        }
    };
    @Override
    public void deleteItem(Object o, int i){
        if (o instanceof Customers) {
            deleteCustomer(i);
        }
        if (o instanceof Books) {
            deleteBook(i);
        }
    }
}
