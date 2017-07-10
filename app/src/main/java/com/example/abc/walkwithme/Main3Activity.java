package com.example.abc.walkwithme;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private TextView text_term;
    private Button btn_back;
    private String terms = "Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story Long Story ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Spinner spinner = (Spinner) findViewById(R.id.security_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.security_question_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        text_term = (TextView) findViewById(R.id.textView_terms);
        text_term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Main3Activity.this);
                alert.setTitle("Terms");
                alert.setMessage(terms);
                alert.setPositiveButton("OK", null);
                alert.show();
            }
        });


        btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
