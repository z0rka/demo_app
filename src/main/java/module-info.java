module com.example.appdemi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.appdemi to javafx.fxml;
    exports com.example.appdemi;
}