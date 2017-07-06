package com.example.szilsan.globerest;

import android.os.AsyncTask;
import android.util.Log;

import com.example.szilsan.globerest.dto.Greeting;
import com.example.szilsan.globerest.dto.PositionsDTO;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by szilsan on 06/07/2017.
 */

public class HttpRequestTaskGlobes extends AsyncTask<Void, Void, PositionsDTO> {
    @Override
    protected PositionsDTO doInBackground(Void... params) {
        try {
            final String url = "http://192.168.99.1:8080/positions";

            final RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            PositionsDTO ret = restTemplate.getForObject(url, PositionsDTO.class);
            Log.d("Ret:", "" + ret.getPositions().size());
            return ret;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(PositionsDTO positionsDTO) {
        /*
        TextView greetingIdText = (TextView) findViewById(R.id.id_value);
        TextView greetingContentText = (TextView) findViewById(R.id.content_value);
        greetingIdText.setText(greeting.getId());
        greetingContentText.setText(greeting.getContent());
        */
        if (positionsDTO != null && !positionsDTO.getPositions().isEmpty()) {
            Log.d("Size:", positionsDTO.getPositions().size() + "");
        }
    }
}
