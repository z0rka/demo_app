package com.example.appdemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DataBaseHandler extends Configs {
    Connection db_connect;

    public Connection getDb_connect()
            throws ClassNotFoundException,SQLException{
        String connectString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        db_connect = DriverManager.getConnection(connectString,dbUser,dbPass);

        return db_connect;
    }

    public void signUpUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE +"("+Const.USERS_EMAIL+","+Const.USERS_PHONE
                +","+Const.USERS_NICKNAME+","+Const.USERS_PASSWORD+")"+
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDb_connect().prepareStatement(insert);
            prSt.setString(1,user.getEmail());
            prSt.setString(2,user.getPhone());
            prSt.setString(3,user.getNickname());
            prSt.setString(4,user.getPassword());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet getUser(User user)  {
        ResultSet resSet = null;

        String select = " SELECT * FROM " + Const.USER_TABLE + " WHERE "+
                Const.USERS_EMAIL + " =? AND "+ Const.USERS_PASSWORD + " =? ";

        try {
            PreparedStatement prSt  = getDb_connect().prepareStatement(select);
            prSt.setString(1,user.getEmail());
            prSt.setString(2,user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}