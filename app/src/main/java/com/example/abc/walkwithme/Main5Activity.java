package com.example.abc.walkwithme;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity implements SensorEventListener, StepListener {

    private TextView TvSteps;
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private Button BtnRestart, BtnStop, BtnPause;
    private static final String TEXT_NUM_STEPS = " ";
    private int numSteps;
    private Chronometer chrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        TvSteps = (TextView) findViewById(R.id.tv_steps);
        BtnStop = (Button) findViewById(R.id.button_stop);
        BtnPause = (Button) findViewById(R.id.button_pause);

        chrono =((Chronometer) findViewById(R.id.walkchrono));
        chrono.start();

        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

        numSteps = 0;
        sensorManager.registerListener(Main5Activity.this, accel, SensorManager.SENSOR_DELAY_FASTEST);



        BtnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String chrono_value;

                chrono_value = chrono.getText().toString();

                sensorManager.unregisterListener(Main5Activity.this);
                chrono.stop();


                Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
                intent.putExtra("valueName", chrono_value);  // pass your values and retrieve them in the other Activity using keyName
                intent.putExtra("stepNumber", TvSteps.getText().toString());  // pass your values and retrieve them in the other Activity using keyName
                startActivity(intent);

            }
        });


        BtnPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
            }
        });


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        TvSteps.setText(numSteps + TEXT_NUM_STEPS);

    }
}
