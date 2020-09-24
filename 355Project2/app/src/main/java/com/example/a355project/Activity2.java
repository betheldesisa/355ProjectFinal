package com.example.a355project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.security.keystore.StrongBoxUnavailableException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

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



    //intialized buttons
    private Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        /************** Need to fix this for slider bar value *********/
        //seekbar();
        /*********** Slider bar VALUE STUFF ************/

        button3 = (Button) findViewById(R.id.button12);
        Uri address = Uri.parse("geo:0,0 ?q=Canes+VCU"); //canes on campus for testing functionality
        final Intent openMaps = new Intent(Intent.ACTION_VIEW, address);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(openMaps.resolveActivity(getPackageManager()) != null) { //checks if there is an app installed that can handle gps
                    startActivity(openMaps);

                }
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

    //opens the mainActivity when the button is clicked
    public void openActivityMain(View view){
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