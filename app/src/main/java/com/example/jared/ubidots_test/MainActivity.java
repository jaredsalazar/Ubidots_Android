package com.example.jared.ubidots_test;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ubidots.ApiClient;
import com.ubidots.Variable;

public class MainActivity extends Activity {
    private TextView etInput;
    private Button btSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (TextView) findViewById(R.id.etInput);
        btSend = (Button) findViewById(R.id.btSend);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Integer level = Integer.parseInt(etInput.getText().toString());
             new ApiUbidots().execute(level);
             etInput.setText("");
            }
        });


    }

    public class ApiUbidots extends AsyncTask<Integer, Void, Void> {
        private final String API_KEY = "229452d93e9cd774aed5b92bafd42dc3c56b5ef4";
        private final String VARIABLE_ID = "55239546762542544e244871";

        @Override
        protected Void doInBackground(Integer... params) {
            ApiClient apiClient = new ApiClient(API_KEY);
            Variable batteryLevel = apiClient.getVariable(VARIABLE_ID);

            batteryLevel.saveValue(params[0]);
            return null;
        }
    }
}
