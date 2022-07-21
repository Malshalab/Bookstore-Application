package coe528project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Scene3Controller extends Main implements Initializable {
    @FXML
    private Label l1;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private TableView<Books> tableview;
    @FXML
    private TableColumn<Books, CheckBox> colCheck;
    @FXML
    private TableColumn<Books, String> colTitle;
    @FXML
    private TableColumn<Books, Double> colPrice;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colCheck.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        
        tableview.setItems(ol); 
    }   
    
    ObservableList<Books> ol = FXCollections.observableList(books);    

    @FXML
    private void addBook(ActionEvent event) {
        String title = t1.getText().trim();
        double price;
        try {
            price = Double.parseDouble(t2.getText().trim());
            l1.setText("");
            if (!(title.equals(""))){
                getUser().addItem(new Books(title,price));
                tableview.refresh();
            }   
        }
        catch (Exception e) {
            l1.setText("Invalid price!");
        }
        finally {
            t1.setText("");
            t2.setText("");
        }
         
    }

    @FXML
    private void deleteBook(ActionEvent event) {
        for(int i = 0; i < books.size(); i++) {
            if (books.get(i).getCheckBox().isSelected()) {
                getUser().deleteItem(books.get(i), i);
                tableview.refresh();
            }
        }
        
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Stage window = (Stage)b1.getScene().getWindow();
        window.setScene(new Scene(root2));
    }  
    
}
