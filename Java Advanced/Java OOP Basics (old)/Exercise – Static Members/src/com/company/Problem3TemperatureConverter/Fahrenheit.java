package com.company.Problem3TemperatureConverter;

public class Fahrenheit implements Temperature{

    private Integer fahrenheit;
    private double celsius;

    public Fahrenheit(Integer fahrenheit) {
        this.setFahrenheit(fahrenheit);
    }

    public void setFahrenheit(Integer fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @Override
    public void convert() {
        this.celsius = ((this.fahrenheit - 32) * 5) / 9;
        System.out.println(String.format("%.2f Celsius", this.celsius));
    }
}
