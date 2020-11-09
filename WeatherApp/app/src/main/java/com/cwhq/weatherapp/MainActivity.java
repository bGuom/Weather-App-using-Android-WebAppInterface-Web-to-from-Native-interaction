package com.cwhq.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

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

public class MainActivity extends AppCompatActivity {

    public WebView myWebView;
    public ProgressBar bar;
    public static String place = "NewYork";
    public static HashMap<String,LocationWeather> weatherHashMap = new HashMap<String, LocationWeather>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        bar = (ProgressBar)findViewById(R.id.pbr);
        bar.setVisibility(View.VISIBLE);

        myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        getWeatherByLatLng("40.7128","74.0060","NewYork");
        getWeatherByLatLng("51.5074","0.1278","London");
        getWeatherByLatLng("39.9042","116.4074","Beijing");
        getWeatherByLatLng("35.6762","139.6503","Tokyo");
        getWeatherByLatLng("55.7558","37.6173","Moscow");

    }


    public void getWeatherByLatLng(String Lat, String Lng, String location){
        String path = "https://api.darksky.net/forecast/"+ this.getString(R.string.API_KEY) +"/"+Lat+","+Lng+"?exclude=minutely,hourly,alerts,flags&units=si";
        new JSONTask().execute(path,location);
    }


    private int getDay(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:
                return 0;
            case Calendar.MONDAY:
                return 1;
            case Calendar.TUESDAY:
                return 2;
            case Calendar.WEDNESDAY:
                return 3;
            case Calendar.THURSDAY:
                return 4;
            case Calendar.FRIDAY:
                return 5;
            case Calendar.SATURDAY:
                return 6;
            default:
                return 0;
        }
    }

    private void showWeather(){
        bar.setVisibility(View.GONE);
        myWebView.addJavascriptInterface(new WebAppInterface(this,weatherHashMap), "Android");
        myWebView.loadUrl("file:///android_asset/index.html");
    }


    public class JSONTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(weatherHashMap.size()==5) {
                showWeather();
            }


        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        public String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                String finalJson = buffer.toString();
                Log.d("test",finalJson);

                JSONObject jsonResult = new JSONObject(finalJson);

                JSONObject current = jsonResult.getJSONObject("currently");
                WeatherData currentWeather = new WeatherData(
                        current.getString("icon"),
                        current.getString("summary"),
                        current.getString("temperature"),
                        "",
                        "",
                        "Today"
                );
                WeatherData currently =  currentWeather;

                ArrayList<WeatherData> daily = new ArrayList<WeatherData>();

                String[] WeekDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
                JSONObject dailyData = jsonResult.getJSONObject("daily");
                JSONArray forecasts = dailyData.getJSONArray("data");
                for(int indx=1; indx<forecasts.length(); indx++){
                    JSONObject forecast = forecasts.getJSONObject(indx);
                    WeatherData forceastWeather = new WeatherData(
                            forecast.getString("icon"),
                            forecast.getString("summary"),
                            "",
                            forecast.getString("temperatureLow"),
                            forecast.getString("temperatureHigh"),
                            WeekDays[(getDay()+indx-1)%7]
                    );
                    daily.add(forceastWeather);
                }


                LocationWeather locationWeather = new LocationWeather(currently,daily);
                weatherHashMap.put(params[1],locationWeather);



                return "found";




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return "error";

        }
    }


}
