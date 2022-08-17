package com.example.appdemi;

import Animations.Shake;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button creation_of_account;
    @FXML
    private TextField email;
    @FXML
    private PasswordField pass;
    @FXML
    private Button sign_in;

    public SignUpController() {
    }

    @FXML
    void initialize() {
        this.creation_of_account.setOnAction((actionEvent) -> {
            this.creation_of_account.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("registration.fxml"));

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

        this.sign_in.setOnAction((actionEvent) -> {
            loginUser(email.getText(),pass.getText());
            this.sign_in.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("authorised.fxml"));

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

    private void loginUser(String login_text, String login_pass) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        User user = new User();
        user.setEmail(login_text);
        user.setPassword(login_pass);
        ResultSet result = dbHandler.getUser(user);
        int counter = 0;

        while(true) {
            try {
                if (!result.next()) {
                    break;
                }
            } catch (SQLException var9) {
                throw new RuntimeException(var9);
            }

            ++counter;
        }

        if (counter < 1) {
            Shake user_wrong_log = new Shake(this.email);
            Shake user_wrong_pass = new Shake(this.pass);
            user_wrong_log.PlayAnim();
            user_wrong_pass.PlayAnim();
        }

    }
}
