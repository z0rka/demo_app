package com.example.appdemi;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Phone_number;

    @FXML
    private Button creation_of_acc;

    @FXML
    private TextField email1;

    @FXML
    private Button logIn_go;

    @FXML
    private TextField nickname;

    @FXML
    private PasswordField pass1;

    @FXML
    private TextField promo;

    @FXML
    void initialize() {

        logIn_go.setOnAction(actionEvent -> {
            logIn_go.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("signup.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        creation_of_acc.setOnAction(actionEvent -> {
            if (!(email1.getText() == "") && !(Phone_number.getText() == "") && !(nickname.getText() == "") && !(pass1.getText() == "")) {
                signUpNewUser();

                creation_of_acc.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("signup.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }
            else if (email1.getText() == "") {
                Shake user_email_wrong = new Shake(email1);
                user_email_wrong.PlayAnim();
            }
            else if (Phone_number.getText() == "") {
                Shake user_number_wrong = new Shake(Phone_number);

                user_number_wrong.PlayAnim();

            }
            else if (nickname.getText() == "") {
                Shake user_nick_wrong = new Shake(nickname);

                user_nick_wrong.PlayAnim();

            }
            else if (pass1.getText() == "") {
                Shake user_pass_wrong = new Shake(pass1);
                user_pass_wrong.PlayAnim();
            }
        });
    }
    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();

        String email = email1.getText();
        String phone = Phone_number.getText();
        String nick = nickname.getText();
        String password = pass1.getText();

        User user = new User(email,phone,nick,password);

        dbHandler.signUpUser(user);

    }
}