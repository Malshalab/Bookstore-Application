package coe528project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Scene2Controller extends Main implements Initializable {

    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void bookButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        Stage window = (Stage)b1.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private void customerButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
        Stage window = (Stage)b2.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Stage window = (Stage)b3.getScene().getWindow();
        window.setScene(new Scene(root));
        logout();
    }
    
}
