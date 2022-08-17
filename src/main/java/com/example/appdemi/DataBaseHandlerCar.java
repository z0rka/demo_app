package com.example.appdemi;


import com.example.appdemi.Advetrisment;
import com.example.appdemi.Configs;
import com.example.appdemi.ConstCar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHandlerCar extends Configs {
    Connection db_connect;
    public Connection getDb_connect()
            throws ClassNotFoundException,SQLException{
        String connectString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        db_connect = DriverManager.getConnection(connectString,dbUser,dbPass);

        return db_connect;
    }

    public void signUpAdd(Advetrisment adv){
        String insert = "INSERT INTO " + ConstCar.ADVERTISMENT_TABLE +"("+ConstCar.CAR_MODEL+","+ConstCar.CAR_COLOR
                +","+ConstCar.CAR_ENGINE+","+ConstCar.ADDITIONAL_INFO+")"+
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDb_connect().prepareStatement(insert);
            prSt.setString(1,adv.getCar_model());
            prSt.setString(2,adv.getCar_color());
            prSt.setString(3,adv.getEngine());
            prSt.setString(4,adv.getAdditional_info());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}