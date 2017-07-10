package com.example.abc.walkwithme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

    private TextView text_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        text_value = (TextView)findViewById(R.id.step_value);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle!=null){
            String j = (String) bundle.get("valueName");
            String k = (String) bundle.get("stepNumber");

            text_value.setText("You have taken " + k + " steps in "+ j + " Minutes");
        }


    }
}
