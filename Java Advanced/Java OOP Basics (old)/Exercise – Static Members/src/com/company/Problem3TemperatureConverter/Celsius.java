package com.company.Problem3TemperatureConverter;

public class Celsius implements Temperature{

    private Integer celsius ;
    private double fahrenheit;

    public Celsius(Integer temperature) {
        this.setTemperature(temperature);
    }

    private void setTemperature(Integer temperature) {
        this.celsius = temperature;
    }

    @Override
    public void convert() {
        this.fahrenheit = ((this.celsius * 9) / 5) + 32;
        System.out.println(String.format("%.2f Fahrenheit", this.fahrenheit));
    }
}
