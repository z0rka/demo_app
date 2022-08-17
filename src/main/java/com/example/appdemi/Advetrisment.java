package com.example.appdemi;

public class Advetrisment {

    private String car_model;

    private String car_color;

    private String engine;

    private String additional_info;

    public Advetrisment(String car_model, String car_color, String engine, String additional_info) {
        this.car_model = car_model;
        this.car_color = car_color;
        this.engine = engine;
        this.additional_info = additional_info;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }
}
