package com.cwhq.weatherapp.Models;

public class WeatherData {

    public String icon;
    public String summary;
    public String temperature;
    public String temperatureLow;
    public String temperatureHigh;
    public String day;


    public WeatherData(String icon, String summary, String temperature, String temperatureLow, String temperatureHigh, String day) {
        this.icon = icon;
        this.summary = summary;
        this.temperature = temperature;
        this.temperatureLow = temperatureLow;
        this.temperatureHigh = temperatureHigh;
        this.day = day;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(String temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    public String getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(String temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
