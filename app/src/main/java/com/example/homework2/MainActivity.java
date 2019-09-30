package com.example.homework2;
// Author: Alex Rogers, CS 301

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // find ID for face object
        Face myFace = findViewById(R.id.faceview);
        // new face controller
        FaceController myController = new FaceController(myFace);
        SeekBar seekRed = findViewById(R.id.redseek);// red seek bar
        SeekBar seekGreen = findViewById(R.id.greenseek);//green seek bar
        SeekBar seekBlue = findViewById(R.id.blueseek);// blue seek bar
        seekRed.setOnSeekBarChangeListener(myController);
        seekGreen.setOnSeekBarChangeListener(myController);
        seekBlue.setOnSeekBarChangeListener(myController);

        RadioGroup groupRadio = findViewById(R.id.radioGroup);//creating a listener for radio buttons
        groupRadio.setOnCheckedChangeListener(myController);
        Spinner spinner = findViewById(R.id.spinner) ;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,  R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner object
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(myController);;
        /*
        * September 30th, 2019
        * problem: implementing a spinner
        *
        * I got help from :
        * https://developer.android.com/guide/topics/ui/controls/spinner.html#java
        *
        *Solution: I used the format from this post to make a
        *resource file
        *
        * */

    }
}
