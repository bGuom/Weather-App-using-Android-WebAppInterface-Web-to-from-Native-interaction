package com.cwhq.weatherapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Switch;
import android.widget.Toast;

import com.cwhq.weatherapp.Models.LocationWeather;
import com.cwhq.weatherapp.Models.WeatherData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class WebAppInterface {
    Context mContext;
    HashMap<String,LocationWeather> weatherHashMap;


    /** Instantiate the interface and set the context */
    WebAppInterface(Context c, HashMap<String, LocationWeather> locationWeatherHashMap) {
        mContext = c;
        weatherHashMap =locationWeatherHashMap;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public String getWeatherCurrentIcon(String place) {
        Log.d("test",weatherHashMap.get(place).currently.icon);
        Toast.makeText(mContext,weatherHashMap.get(place).currently.getTemperature(),Toast.LENGTH_SHORT);
        return weatherHashMap.get(place).currently.icon;

    }

    @JavascriptInterface
    public String getWeatherCurrentSummary(String place) {
        return weatherHashMap.get(place).currently.summary;

    }

    @JavascriptInterface
    public String getWeatherCurrentTemp(String place) {
        return weatherHashMap.get(place).currently.temperature;

    }

    //========================================================
    @JavascriptInterface
    public String getWeatherDay1Icon(String place) {
        return weatherHashMap.get(place).daily[0].icon;
    }
    @JavascriptInterface
    public String getWeatherDay1(String place) {
        return weatherHashMap.get(place).daily[0].day;
    }
    @JavascriptInterface
    public String getWeatherDay1TempL(String place) {
        return weatherHashMap.get(place).daily[0].temperatureHigh;
    }
    @JavascriptInterface
    public String getWeatherDay1TempM(String place) {
        return weatherHashMap.get(place).daily[0].temperatureLow;
    }
    //==========================================================

    //========================================================
    @JavascriptInterface
    public String getWeatherDay2Icon(String place) {
        return weatherHashMap.get(place).daily[1].icon;
    }
    @JavascriptInterface
    public String getWeatherDay2(String place) {
        return weatherHashMap.get(place).daily[1].day;
    }
    @JavascriptInterface
    public String getWeatherDay2TempL(String place) {
        return weatherHashMap.get(place).daily[1].temperatureHigh;
    }
    @JavascriptInterface
    public String getWeatherDay2TempM(String place) {
        return weatherHashMap.get(place).daily[1].temperatureLow;
    }
    //==========================================================

    //========================================================
    @JavascriptInterface
    public String getWeatherDay3Icon(String place) {
        return weatherHashMap.get(place).daily[2].icon;
    }
    @JavascriptInterface
    public String getWeatherDay3(String place) {
        return weatherHashMap.get(place).daily[2].day;
    }
    @JavascriptInterface
    public String getWeatherDay3TempL(String place) {
        return weatherHashMap.get(place).daily[2].temperatureHigh;
    }
    @JavascriptInterface
    public String getWeatherDay3TempM(String place) {
        return weatherHashMap.get(place).daily[2].temperatureLow;
    }
    //==========================================================

    //========================================================
    @JavascriptInterface
    public String getWeatherDay4Icon(String place) {
        return weatherHashMap.get(place).daily[3].icon;
    }
    @JavascriptInterface
    public String getWeatherDay4(String place) {
        return weatherHashMap.get(place).daily[3].day;
    }
    @JavascriptInterface
    public String getWeatherDay4TempL(String place) {
        return weatherHashMap.get(place).daily[3].temperatureHigh;
    }
    @JavascriptInterface
    public String getWeatherDay4TempM(String place) {
        return weatherHashMap.get(place).daily[3].temperatureLow;
    }
    //==========================================================

    //========================================================
    @JavascriptInterface
    public String getWeatherDay5Icon(String place) {
        return weatherHashMap.get(place).daily[4].icon;
    }
    @JavascriptInterface
    public String getWeatherDay5(String place) {
        return weatherHashMap.get(place).daily[4].day;
    }
    @JavascriptInterface
    public String getWeatherDay5TempL(String place) {
        return weatherHashMap.get(place).daily[4].temperatureHigh;
    }
    @JavascriptInterface
    public String getWeatherDay5TempM(String place) {
        return weatherHashMap.get(place).daily[4].temperatureLow;
    }
    //==========================================================

    //========================================================
    @JavascriptInterface
    public String getWeatherDay6Icon(String place) {
        return weatherHashMap.get(place).daily[5].icon;
    }
    @JavascriptInterface
    public String getWeatherDay6(String place) {
        return weatherHashMap.get(place).daily[5].day;
    }
    @JavascriptInterface
    public String getWeatherDay6TempL(String place) {
        return weatherHashMap.get(place).daily[5].temperatureHigh;
    }
    @JavascriptInterface
    public String getWeatherDay6TempM(String place) {
        return weatherHashMap.get(place).daily[5].temperatureLow;
    }
    //==========================================================

    //========================================================
    @JavascriptInterface
    public String getWeatherDay7Icon(String place) {
        return weatherHashMap.get(place).daily[6].icon;
    }
    @JavascriptInterface
    public String getWeatherDay7(String place) {
        return weatherHashMap.get(place).daily[6].day;
    }
    @JavascriptInterface
    public String getWeatherDay7TempL(String place) {
        return weatherHashMap.get(place).daily[6].temperatureHigh;
    }
    @JavascriptInterface
    public String getWeatherDay7TempM(String place) {
        return weatherHashMap.get(place).daily[6].temperatureLow;
    }
    //==========================================================




}
