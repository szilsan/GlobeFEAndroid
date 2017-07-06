package com.example.szilsan.globerest;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.szilsan.globerest.dto.Greeting;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by szilsan on 06/07/2017.
 */

public class HttpRequestTask extends AsyncTask<Void, Void, Greeting> {
    @Override
    protected Greeting doInBackground(Void... params) {
        try {
            final String url = "http://rest-service.guides.spring.io/greeting";
            final RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            return restTemplate.getForObject(url, Greeting.class);
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Greeting greeting) {
        /*
        TextView greetingIdText = (TextView) findViewById(R.id.id_value);
        TextView greetingContentText = (TextView) findViewById(R.id.content_value);
        greetingIdText.setText(greeting.getId());
        greetingContentText.setText(greeting.getContent());
        */
        if (greeting != null) {
            Log.d(greeting.getId(), greeting.getContent());
        }
    }
}
