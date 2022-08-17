package com.example.appdemi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CabinetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button adder;

    @FXML
    void initialize() {

       this.adder.setOnAction(actionEvent -> {
           this.adder.getScene().getWindow().hide();
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(this.getClass().getResource("add_edv.fxml"));

           try {
               loader.load();
           } catch (IOException var5) {
               throw new RuntimeException(var5);
           }

           Parent root = (Parent)loader.getRoot();
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.show();
       });
    }
}