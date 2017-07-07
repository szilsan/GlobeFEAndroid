package com.example.szilsan.globerest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startButton = (Button)findViewById(R.id.buttonStart);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("hello","bello");
                new HttpRequestTaskGlobes(MainActivity.this).execute();
            }
        });

        //final WorkAreaView workAreaView = (WorkAreaView) findViewById(R.id.workAreaView);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
