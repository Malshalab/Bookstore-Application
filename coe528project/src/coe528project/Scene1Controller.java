package coe528project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller extends Main implements Initializable {
    private boolean x = true;
    
    @FXML
    private TextField t1;
    @FXML
    private Label l1;
    @FXML
    private PasswordField p1;
    @FXML
    private Button b1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        setUser(new Owner());
        boolean loginOwner = getUser().verifyLogin(t1,p1);
        boolean loginCustomer = false;
        if (loginOwner) {
            Parent root2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            Stage window = (Stage)b1.getScene().getWindow();
            window.setScene(new Scene(root2));
        }
        else {
            for (Customers c : customers) {
                setUser(c);
                if (getUser().verifyLogin(t1,p1)) {
                    loginCustomer = true; l1.setText(""); break;
                }
            }
            l1.setText("Invalid username or password!");
            t1.setText("");
            p1.setText("");
        }
        if (loginCustomer) {
            Parent root3 = FXMLLoader.load(getClass().getResource("Scene5.fxml"));
            Stage window = (Stage)b1.getScene().getWindow();
            window.setScene(new Scene(root3));
        }
    }
    
}
