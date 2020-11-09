package com.cwhq.weatherapp.Models;

import java.util.ArrayList;

public class LocationWeather {
    public WeatherData currently;
    public WeatherData[] daily = new WeatherData[]{null,null,null,null,null,null,null};

    public LocationWeather(WeatherData currently, ArrayList<WeatherData> daily) {
        this.currently = currently;
        for(int i=0;i<daily.size();i++){
            this.daily[i] =daily.get(i);
        }
    }

    public WeatherData getCurrently() {
        return currently;
    }

    public void setCurrently(WeatherData currently) {
        this.currently = currently;
    }

    public WeatherData[] getDaily() {
        return daily;
    }

    public void setDaily( WeatherData[] data) {
        this.daily = daily;
    }
}
