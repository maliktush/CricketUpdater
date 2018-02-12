package com.tusharmalik.cricketupdater;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class News extends AppCompatActivity {
    WebView WebContents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        WebContents=findViewById(R.id.WebContents);
        new DownloadUrlTask().execute();
    }
    class DownloadUrlTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://www.cricbuzz.com/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                if (connection.getResponseCode() >= 200 && connection.getResponseCode() < 300 ) {
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(connection.getInputStream())
                    );
                    StringBuilder sb = new StringBuilder();
                    String buf = br.readLine();
                    while (buf != null) {
                        sb.append(buf);
                        buf = br.readLine();
                    }
                    return sb.toString();
                }
            }  catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            WebContents.loadUrl("http://www.cricbuzz.com/");

        }

    }
}
