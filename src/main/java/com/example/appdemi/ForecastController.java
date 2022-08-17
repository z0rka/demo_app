package com.example.appdemi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ForecastController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField city;

    @FXML
    private Label feels;

    @FXML
    private Button get_info;

    @FXML
    private Label max_t;

    @FXML
    private Label min_t;

    @FXML
    private Label pressure;

    @FXML
    private Label temp;

    @FXML
    void initialize() {
        get_info.setOnAction(actionEvent -> {
            String city = this.city.getText().trim();
            String input = getUrlInfo("https://api.openweathermap.org/data/2.5/weather?q=\"+city + \",uk&callback=test&appid=\" + \"9b408ce91997fe302dec226744d2ebbf");

            System.out.println(input);
        });
    }

    private static String getUrlInfo(String urlAdress){
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);

            URLConnection urlConn = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine())!= null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }
}
