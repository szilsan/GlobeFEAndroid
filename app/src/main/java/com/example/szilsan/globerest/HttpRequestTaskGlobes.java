package com.example.szilsan.globerest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.szilsan.globerest.dto.GlobeDTO;
import com.example.szilsan.globerest.dto.Greeting;
import com.example.szilsan.globerest.dto.PositionsDTO;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by szilsan on 06/07/2017.
 */

public class HttpRequestTaskGlobes extends AsyncTask<Void, Void, PositionsDTO> {

    AppCompatActivity activity;

    public HttpRequestTaskGlobes(AppCompatActivity activity) {
        this.activity = activity;
    }

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

        if (positionsDTO != null && !positionsDTO.getPositions().isEmpty()) {
            String text = "Size: " + positionsDTO.getPositions().size() + "\n";
            if (positionsDTO.getPositions().size() > 0) {
                for (GlobeDTO gdto: positionsDTO.getPositions()) {
                    text = text + gdto.getSize() + "\n";
                }
            }
            Log.d("Valid response. Size:", positionsDTO.getPositions().size() + "");
            ((WorkAreaView)activity.findViewById(R.id.workAreaView)).setPositionsDTO(positionsDTO);
            activity.findViewById(R.id.workAreaView).invalidate();
        } else {
            Log.d("Invalid response", "");
        }
    }
}
