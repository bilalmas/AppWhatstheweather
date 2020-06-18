package com.example.appwhatstheweather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {

    EditText city;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city = (EditText) findViewById(R.id.editText);
        results = (TextView) findViewById(R.id.weather);
        //DownloadTask task = new DownloadTask();
        //task.execute("https://api.openweathermap.org/data/2.5/forecast?q=lahore&APPID=dc31b5af70b15eebcd73af4d546e1e1b");
        //task.execute("https://www.accuweather.com/en/pk/lahore/260622/hourly-weather-forecast/260622");


    }

    public class WeatherTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data != -1){

                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.i("Website content :",result);
            Log.i("Website content :",result);
            Log.i("Website content :",result);
        }
    }



    public void weathertell(View view){

        WeatherTask task = new WeatherTask();
        task.execute("http://api.openweathermap.org/data/2.5/weather?q=Lahore&appid=dc31b5af70b15eebcd73af4d546e1e1b");


     }


    }

