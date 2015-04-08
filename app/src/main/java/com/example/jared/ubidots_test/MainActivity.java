package com.example.jared.ubidots_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cloudsend.ApiUbidots;


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
}


