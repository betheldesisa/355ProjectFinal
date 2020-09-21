package com.example.a355project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /**************************** WORKING ON SLIDER BAR VALUE *********************/
    private static SeekBar seek_bar;
    private static TextView sliderValue;

    public void seekbar() {
        seek_bar = (SeekBar)findViewById(R.id.seekBar);
        sliderValue = (TextView)findViewById(R.id.sliderValue);
        sliderValue.setText(seek_bar.getProgress());

        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressValue;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressValue = progress;
                sliderValue.setText(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                sliderValue.setText(progressValue);
            }
        });
    }
    /********* SLIDER BAR VALUE STUFF ***********************************************************/



    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        /************** Need to fix this for slider bar value *********/
        //seekbar();
        /*********** Slider bar VALUE STUFF ************/

        button2 = (Button) findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openActivityMain();
            }
        });
    /*
    Spinner object creates the dropdown button for "Type of Food"
    */
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.TypeOfFood, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void openActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}